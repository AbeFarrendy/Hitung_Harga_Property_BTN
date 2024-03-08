import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Case_Num 1-5 = positive case
// Case_Num 6 = negative case, Income < Expense
// Case_Num 7 = negative case, Income = Expense

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.btnproperti.co.id/tools/hitung-harga-properti')

WebUI.setText(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/input_Hitung Harga Properti Maksimal_floati_bf0ef7'), 
    var_Income)

WebUI.setText(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/input_Per Bulan_floating-label-field'), 
    var_Expense)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/select_Jangka Waktu1 Tahun2 Tahun3 Tahun4 T_cf4447'), 
    var_Years, true)

System.out.println('Income (IDR): ' + var_Income)

System.out.println('Expense (IDR): ' + var_Expense)

System.out.println('Years: ' + var_Years)

WebUI.delay(3)

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/button_Hitung'))
	
WebUI.click(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/button_Hitung'))
	
WebUI.delay(3)
	
String var_Result_Price = WebUI.getText(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/h3_harga_hasil'))
System.out.println('Result Price (IDR): ' + var_Result_Price)

String str_Result_Price = var_Result_Price.replaceAll("[^0-9]", "")
System.out.println('str_Result_Price: ' + str_Result_Price)

// VERIFY RESULT WITH FORMULA
// (var_Income - var_Expense) * (var_Years * 12) : 3

def db_Income = Double.parseDouble(var_Income)
def db_Expense = Double.parseDouble(var_Expense)
def db_Years = Double.parseDouble(var_Years)

def var_Balance = db_Income - db_Expense
def var_Months = 12 * db_Years
def var_Result_Calc = var_Balance * var_Months / 3
System.out.println('Calculated Result Price (IDR): ' + var_Result_Calc)

String str_Result_Calc = String.format ("%.0f", var_Result_Calc)
System.out.println('STR Result Calculated: ' + str_Result_Calc)

WebUI.verifyEqual(str_Result_Price, str_Result_Calc)

WebUI.takeScreenshot()

WebUI.delay(3)

WebUI.closeBrowser()




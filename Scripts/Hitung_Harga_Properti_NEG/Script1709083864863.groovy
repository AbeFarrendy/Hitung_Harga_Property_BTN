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

WebUI.verifyElementNotClickable(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/button_Hitung'))
	
//WebUI.click(findTestObject('Object Repository/Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/button_Hitung'))
	
WebUI.delay(3)
	
String var_Alert_Msg = WebUI.getText(findTestObject('Page_Hitung Harga Properti Maksimal  BTN Pr_37bba6/p_alert_invalidvalue'))
	
System.out.println('Error Message: ' + var_Alert_Msg)

WebUI.takeScreenshot()

WebUI.delay(3)

WebUI.closeBrowser()




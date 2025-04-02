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

Mobile.startApplication(version, true)

Mobile.tap(findTestObject('Object Repository/TestUTN_Clase25Abr/Boton Contador de tenis'), 0)

'El jugador 2 gana los primeros 5 GAMES'
for (def indexGame : (0..4)) {
    for (def indexPunto : (0..3)) {
        Mobile.tap(findTestObject('Object Repository/TestUTN_Clase25Abr/Boton Jugador 2'), 0)
    }
    
    Mobile.verifyElementText(findTestObject('Object Repository/TestUTN_Clase25Abr/Texto GAME o SET'), 'Game Jugador 2')
}

'El jugador 1 gana 6 GAMES seguidos, no debería de hacer SET porque debe ganar por dos GAMEs de diferencia.'
for (def indexGame : (0..5)) {
    for (def indexPunto : (0..3)) {
        Mobile.tap(findTestObject('Object Repository/TestUTN_Clase25Abr/Boton Jugador 1'), 0)
    }
}

Mobile.verifyElementText(findTestObject('Object Repository/TestUTN_Clase25Abr/Texto GAME o SET'), 'Game Jugador 1')

'El jugador 1 gana 1 GAME mas y se verifica que haya ganado el SET'
for (def indexPunto : (0..3)) {
    Mobile.tap(findTestObject('Object Repository/TestUTN_Clase25Abr/Boton Jugador 1'), 0)
}

Mobile.verifyElementText(findTestObject('Object Repository/TestUTN_Clase25Abr/Texto GAME o SET'), ' SET Jugador 1')

Mobile.closeApplication()


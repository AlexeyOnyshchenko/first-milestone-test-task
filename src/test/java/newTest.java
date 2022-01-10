import io.github.alexeyonyshchenko.JsonSchemaPage;
import io.github.alexeyonyshchenko.MainPage;
import io.github.alexeyonyshchenko.RawDataPage;
import io.github.sskorol.core.DataSupplier;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;


public class newTest {

    private RawDataPage rawDataPage = new RawDataPage();
    private MainPage mainPage = new MainPage();
    private JsonSchemaPage jsonSchemaPage = new JsonSchemaPage();


      @DataSupplier
      public List<String> jsonFieldNames() {
        return List.of(
                "Test1");

    }

    @DataSupplier
    public List<String> rawDataLabels() {
        return List.of(
                "Name",
                "Email",
                "Avatar",
                "Username",
                "Password",
                "Job title",
                "Phone",
                "Bitcoin address",
                "Company",
                "Zip",
                "Address",
                "Date",
                "City");

    }

//    @BeforeSuite
//    public void setup() {
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        Configuration.driverManagerEnabled = false;
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities = capabilities;
//    }

    @Test(dataProvider = "jsonFieldNames")
    @Issue("1")
    @Severity(SeverityLevel.NORMAL)
    public void addNewField(String jsonFieldName) throws InterruptedException {
        open("http://localhost:8262/fake-data-generator");
        mainPage.clickOnJsonSchemaTab();
        assertEquals(jsonSchemaPage.addNewJSONfield(jsonFieldName), jsonFieldName);


    }


    @Test(dataProvider = "rawDataLabels")
    @Issue("2")
    @Severity(SeverityLevel.MINOR)
    public void verifyThatAllFieldLabelsAreVisible(String fieldLabel) throws InterruptedException {
        open("http://localhost:8262/fake-data-generator");
        assertTrue(rawDataPage.checkIfElementWitLabelIsDisplayed(fieldLabel), fieldLabel + " field label is displayed");
    }


    @Test(dataProvider = "rawDataLabels")
    @Issue("3")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyThatGeneratedValuesAreNotEmpty(String rawDataField) throws InterruptedException {
        open("http://localhost:8262/fake-data-generator");
        assertNotEquals(rawDataPage.getGeneratedFieldaTextValue(rawDataField), "", " generated data for field " + rawDataField + " is not empty" );


    }
    @Test(dataProvider = "jsonFieldNames")
    @Issue("4")
    @Severity(SeverityLevel.NORMAL)
    public void verifyThatJsonFieldIsDeleted(String jsonFieldName) throws InterruptedException {
        open("http://localhost:8262/fake-data-generator");
        jsonSchemaPage.addNewJSONfield(jsonFieldName);
        jsonSchemaPage.removeJSONfield(jsonFieldName);
        assertFalse(jsonSchemaPage.verifyIfFieldIsDisplayed(jsonFieldName), jsonFieldName + " JSON field is displayed");
    }
    @Test
    @Issue("5")
    @Severity(SeverityLevel.NORMAL)
    public void verifyCopyingToClipboardFunctionality() throws InterruptedException {
        open("http://localhost:8262/fake-data-generator");
        mainPage.clickOnJsonSchemaTab();
        assertNotEquals(jsonSchemaPage.verifyCopyToClipboard(), "", " no data is copied to clipboard");

    }









//    @Test(dataProvider = "fieldNames")
//    @Issue("1")
//    @Severity(SeverityLevel.MINOR)
//    public void verifyThatRegenerateButtonGeneratesNewData() throws InterruptedException {
//        open("http://localhost:8262/fake-data-generator");
//        assertThat($x("//button[text()='Regenerate']").
//
//    }

//assertNotEquals(Selenide.clipboard().getText(), "", " generated data for field " + fieldLable + " is not empty" ); -






//
//    @Test(dataProvider = "fieldNames")
//    @Issue("1")
//    @Severity(SeverityLevel.MINOR)
//    public void addNewField(String fieldName) throws InterruptedException {
//        open("http://localhost:8262/fake-data-generator");
//        $x("//button[text()='Regenerate']").click();
//        $x("//button[text()='JSON Schema']").click();
//        //$x("//button[text()='Raw data']").click();
//        $x("//button[text()='+ Add field']").click();
//        $x("//input[@value='']").sendKeys(fieldName);
//        $x("//button[text()='+ Add field']").click();
//        String actualFieldName = $x("//input[@value='" + fieldName + "']").getAttribute("value");
//        assertThat(actualFieldName).isEqualTo(fieldName);
//
//    }

}


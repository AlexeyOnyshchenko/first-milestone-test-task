import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Configuration;
import io.github.sskorol.core.DataSupplier;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class newTest {

    @Issue("1")
    @Severity(SeverityLevel.MINOR)

      @DataSupplier
      public List<String> fieldNames() {
        return List.of(
                "Test1",
                "Test2");
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

    @Test(dataProvider = "fieldNames")
    public void addNewField(String fieldName) throws InterruptedException {
        open("http://localhost:8262/fake-data-generator");
        $x("//button[text()='Regenerate']").click();
        $x("//button[text()='JSON Schema']").click();
        //$x("//button[text()='Raw data']").click();
        $x("//button[text()='+ Add field']").click();
        $x("//input[@value='']").sendKeys(fieldName);
        $x("//button[text()='+ Add field']").click();

    }



}



//public class newTest {
//    @DataSupplier
//    public List<String> colors() {
//        return List.of(
//                "#D0021B",
//                "#F5A623",
//                "#F8E71C",
//                "#8B572A",
//                "#7ED321",
//                "#417505",
//                "#BD10E0",
//                "#9013FE",
//                "#4A90E2",
//                "#50E3C2",
//                "#B8E986",
//                "#000000",
//                "#4A4A4A",
//                "#9B9B9B",
//                "#FFFFFF");
//    }
//
//    @Test(dataProvider = "colors")
//    public void shouldChangeHeartColor(String expectedColor) {
//        open("http://localhost:3000");
//        $("#heart").click();
//        $(".flexbox-fix div[title='" + expectedColor + "']").click();
//        String actualColor = $("#heart>path").getAttribute("fill");
//
//        assertThat(actualColor).isEqualToIgnoringCase(expectedColor);
//    }
//
//
//
//}
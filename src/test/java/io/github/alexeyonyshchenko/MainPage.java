package io.github.alexeyonyshchenko;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;


public class MainPage {

    SelenideElement jsonSchemaButton = $x("//button[text()='JSON Schema']");
    SelenideElement rawDataButton = $x("//button[text()='Raw Data']");
    SelenideElement regenerateButton = $x("//button[text()='Regenerate']");

    public void clickOnJsonSchemaTab() {
        jsonSchemaButton.click();
    }

    public void clickOnRawDataTab() {
        rawDataButton.click();
    }

    public void clickOnRegenerateButton() {
        regenerateButton.click();
    }


}

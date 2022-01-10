package io.github.alexeyonyshchenko;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class JsonSchemaPage {

    SelenideElement addFieldButton = $x("//button[text()='+ Add field']");
    SelenideElement emptyNameInput = $x("//input[@value='']");
    SelenideElement copyToClipboardButton = $x("//button[text()='Copy to clipboard']");


    @Step("Add a new JSON field")
    public String addNewJSONfield(String jsonFieldName) {
        addFieldButton.click();
        emptyNameInput.sendKeys(jsonFieldName);
        addFieldButton.click();
        String actualFieldName = $x("//input[@value='" + jsonFieldName + "']").getAttribute("value");
        return actualFieldName;
    }



    @Step ("Click on the Remove button for the selected field")
    public void removeJSONfield(String jsonFieldName) {
        $x("//input[@value='" + jsonFieldName + "']/parent::div/following-sibling::button").click();

    }
    @Step ("Verify that removed field is displayed")
    public boolean verifyIfFieldIsDisplayed(String jsonFieldName) {
        return $x("//input[@value='" + jsonFieldName + "']").isDisplayed();

    }

    @Step ("Verify that Copy to clipboard button is clicked and text is copied")
    public String verifyCopyToClipboard() {
        copyToClipboardButton.click();
        return Selenide.clipboard().getText();
    }


    //SelenideElement dropDown = $x("//button[text()=']");
    //    public void selectSchemaFieldType(String typeName) {
//        dropDown.selectOptionContainingText(typeName);
//    }

}


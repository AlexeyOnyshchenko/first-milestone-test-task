package io.github.alexeyonyshchenko;


import static com.codeborne.selenide.Selenide.$x;

public class RawDataPage {


    public boolean checkIfElementWitLabelIsDisplayed(String label) {
        return $x("//div[text()='" + label + "']").isDisplayed();
    }

    public String getGeneratedFieldaTextValue(String rawDataField) {
        return $x("//div[text()='" + rawDataField + "']/following-sibling::div").getText();
}







}

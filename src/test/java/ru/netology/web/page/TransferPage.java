package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Страница перевода")
public class TransferPage extends AkitaPage {
    @FindBy(css = ".money-input .input__control")
    private SelenideElement fieldSumma;
    @FindBy(css = "[data-test-id='from'] .input__control")
    private SelenideElement fieldCardFrom;
    @FindBy(css = "[data-test-id='action-transfer'] .button__text")
    private SelenideElement buttonReplenish;
    @FindBy(css = "[data-test-id='action-cancel'] .button__text")
    private SelenideElement buttonCancel;


    public DashboardPage transferMoney(String transferSumma, String transferFrom) {
        fieldSumma.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, transferSumma.trim());
        fieldCardFrom.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE, transferFrom.trim());
        buttonReplenish.click();
        return Selenide.page(DashboardPage.class);
    }
}




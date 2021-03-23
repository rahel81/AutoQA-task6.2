package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Страница перевода")
public class TransferPage extends AkitaPage {
    @FindBy(css = "[data-test-id='amount'].input__control")
    private SelenideElement fieldSumma;
    @FindBy(css = "[data-test-id='from'] .input__control")
    private SelenideElement fieldCardFrom;
    @FindBy(css = "[data-test-id='action-transfer'] .button__text")
    private SelenideElement buttonReplenish;
    @FindBy(css = "[data-test-id='action-cancel'] .button__text")
    private SelenideElement buttonCancel;
    @FindBy(css = "[data-test-id= 'error-notification'] .button__text")
    private SelenideElement messageError;

    public DashboardPage transferMoney(String transferSumma, String transferFrom) {
        fieldSumma.setValue(transferSumma);
        fieldCardFrom.setValue(transferFrom);
        buttonReplenish.click();
        return new DashboardPage();
    }

    public void transferMoneyError() {
        messageError.shouldBe(Condition.visible);
    }
}

package ru.netology.web.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.CharMatcher;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

@Name("Дашбоард")
public class DashboardPage extends AkitaPage {
    private String dataTestId;
    @FindBy(css = "[data-test-id=dashboard]")
    private SelenideElement heading;
    @FindBy(css = "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text")
    private SelenideElement firstCard;
    @FindBy(css = "[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text")
    private SelenideElement secondCard;

    public TransferPage transferMoney(String number) {
        $$(".list__item").find(text(number.substring(15, 19))).$("button").click();
        return Selenide.page(TransferPage.class);
    }

    public String getCardBalance(String number) {
        return (CharMatcher.inRange('0', '9').retainFrom($$(".list__item").find(text(number.substring(15, 19))).$("div").getOwnText().substring(20)));
    }
}

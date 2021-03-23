package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

@Name("Дашбоард")
public class DashboardPage extends AkitaPage {
    private String text;
    @FindBy(css = "[data-test-id=dashboard]")
    private SelenideElement heading;
    @FindBy(css = "[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] .button__text")
    private SelenideElement firstCard;
    @FindBy(css = "[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] .button__text")
    private SelenideElement secondCard;

    private  ElementsCollection cards = $$(".list__item");
    private  final String balanceStart = "баланс: ";
    private  final String balanceFinish = " р.";

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public TransferPage transferMoney(String number) {
        $$(".list__item").find(text(number.substring(15, 19))).$("button").click();
        return new TransferPage();
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getCardBalance(String number) {
        val text = cards.find(text(number.substring(15, 19))).getText();
        return extractBalance(text);
    }
}


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

class MoneyTransferTest {

    String transferAmount = "1000";
    String secondCardNumber = "5559 0000 0000 0002";


    private int transfermoney (String transferAmount) {
        return Integer.parseInt(transferAmount);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCards() {

        open("http://localhost:9999");
       val loginPage = new LoginPage();
       val authInfo = User.getAuthInfo();
       val verificationPage = loginPage.validLogin(authInfo);
       val verificationCode = User.getVerificationCodeFor(authInfo);
       verificationPage.validVerify(verificationCode);

        $(withText("Ваши карты")).waitUntil(visible, 5000);
        val balance = new LoginPage.ExtraBalance();
        val balanceOne = balance.getFirstCardBalance();
        SelenideElement actionForFirstCard = $(".list__item").find("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").find("[data-test-id='action-deposit']");
        actionForFirstCard.click();
        $(withText("Пополнение карты")).waitUntil(visible, 5000);
        $("[data-test-id=amount] input").setValue(transferAmount);
        $("[data-test-id=from] input").setValue(secondCardNumber);
        $$("button").find(exactText("Пополнить")).click();
        val balanceOneFinish = balanceOne - transfermoney(transferAmount) ;
        val finishBalance = Integer.toString(balanceOneFinish);
        $(withText("баланс")).find(String.valueOf(exactText(finishBalance)));

    }

}



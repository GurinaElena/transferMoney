import com.codeborne.selenide.SelenideElement;
import lombok.val;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferMoneyBetweenCards {

    private static String transferAmount = "1000";
    private static String firstCardNumber = "5559 0000 0000 0001";
    private static String secondCardNumber = "5559 0000 0000 0002";


    private static int transfermoney (String transferAmount) {
        return Integer.parseInt(transferAmount);
    }

    private static SelenideElement actionForFirstCard = $(".list__item").find("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").find("[data-test-id='action-deposit']");
    private static SelenideElement actionForSecondCard =$("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").find("[data-test-id='action-deposit']");

    public static void TransferBetweenFirstAndSecondCard() {

        val balance = new ExtraBalanceForFirstCard();
        val balanceOne = balance.getFirstCardBalance();
        actionForFirstCard.click();
        $(withText("Пополнение карты")).waitUntil(visible, 5000);
        $("[data-test-id=amount] input").setValue(transferAmount);
        $("[data-test-id=from] input").setValue(secondCardNumber);
        $$("button").find(exactText("Пополнить")).click();
        val balanceOneFinish = balanceOne + transfermoney(transferAmount) ;
        val finishBalance = Integer.toString(balanceOneFinish);
        val balanceOneSt = Integer.toString(balance.getFirstCardBalance());
        Assertions.assertEquals(finishBalance, balanceOneSt);


    }

    public static void TransferBetweenSecondAndFirstCards(){
        val balance = new ExtraBalanceSecondCard();
        val balanceTwo = balance.getSecondCardBalance();
        SelenideElement actionForSecondCard =$("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").find("[data-test-id='action-deposit']");
        actionForSecondCard.click();
        $(withText("Пополнение карты")).waitUntil(visible, 5000);
        $("[data-test-id=amount] input").setValue(transferAmount);
        $("[data-test-id=from] input").setValue(firstCardNumber);
        $$("button").find(exactText("Пополнить")).click();
        val balanceTwoFinish = balanceTwo + transfermoney(transferAmount) ;
        val finishBalance = Integer.toString(balanceTwoFinish);
        val balanceTwoSt = Integer.toString(balance.getSecondCardBalance());
        Assertions.assertEquals(finishBalance, balanceTwoSt);

    }

}


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(User.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public static class ExtraBalance {
        // к сожалению, разработчики не дали нам удобного селектора, поэтому так
        private SelenideElement cardOne = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";

        public ExtraBalance() {
        }

        public int getFirstCardBalance() {
            val text = cardOne.text();
            return extractBalance(text);
        }

        private int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }

    }

    public static class ExtraBalanceSecondCard {
        // к сожалению, разработчики не дали нам удобного селектора, поэтому так
        private SelenideElement cardTwo = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";

        public ExtraBalanceSecondCard() {
        }

        public int getSecondCardBalance() {
            val text = cardTwo.text();
            return extractBalance(text);
        }

        private int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }

    }
}






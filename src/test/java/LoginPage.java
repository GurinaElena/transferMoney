
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
        private ElementsCollection cards = $$(".list__item");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";

        public ExtraBalance() {
        }

        public int getFirstCardBalance() {
            val text = cards.first().text();
            return extractBalance(text);
        }

        private int extractBalance(String text) {
            val start = text.indexOf(balanceStart);
            val finish = text.indexOf(balanceFinish);
            val value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }

        private int transfermoney(String transferAmount) {
            val transferForCard = Integer.parseInt(transferAmount);
             return Integer.parseInt(transferAmount);
        }
    }





    }






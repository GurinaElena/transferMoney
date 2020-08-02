import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;

    public class ExtraBalanceForFirstCard {
        // к сожалению, разработчики не дали нам удобного селектора, поэтому так
        private SelenideElement cardOne = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";

        public ExtraBalanceForFirstCard() {
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

import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;

    public class ExtraBalanceSecondCard {
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

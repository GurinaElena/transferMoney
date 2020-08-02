
import lombok.val;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

class TestForTransferMoneyBetweenCards {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {

        open("http://localhost:9999");
       val loginPage = new LoginPage();
       val authInfo = User.getAuthInfo();
       val verificationPage = loginPage.validLogin(authInfo);
       val verificationCode = User.getVerificationCodeFor(authInfo);
       verificationPage.validVerify(verificationCode);
       CorrectPage.correctPages();
       TransferMoneyBetweenCards.TransferBetweenFirstAndSecondCard();

    }

    @Test
        void TransferMoneyBetweenSecondAndFirstCards(){

        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = User.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = User.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        CorrectPage.correctPages();
        TransferMoneyBetweenCards.TransferBetweenSecondAndFirstCards();

    }
}



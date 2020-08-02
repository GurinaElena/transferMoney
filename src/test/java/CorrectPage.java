import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class CorrectPage {

    private static SelenideElement TruePage = $(withText("Ваши карты"));

    public static void correctPages() {
        TruePage.shouldBe(visible);
    }

}


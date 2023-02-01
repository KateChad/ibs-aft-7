package framework.pages;

import framework.managers.PageManager;
import framework.pages.blocks.BaseMenuBlock;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class СontributionsPage extends BasePage {
    private BaseMenuBlock baseMenuBlock = new BaseMenuBlock();
    @FindBy(xpath = "//div[@class='page-container']")
    WebElement page;
    //    @FindBy(xpath = "//div[contains(@class,'GridVertical')]//button")
//    WebElement confirmCityButton;
    @FindBy(xpath = "//div[@id='deposit_search_form']//button")
    WebElement calculation;
    @FindBy(xpath = "//div[@data-test='button-round-title']")
    List<WebElement> buttonsInCalculationFormList;
    @FindBy(xpath = "//div[@data-test='search-results']//div[contains(@class,'SearchResultsItem')]")
    List<WebElement> bockBanksInContributionPageList;
    @FindBy(xpath = "//div[contains(@class,'Modal')]/div")
    WebElement modalWindow;
    @FindBy(xpath = "//div[@data-test='search-results']")
    WebElement resultSearch;

    public СontributionsPage checkDownloadPage() {
        Assertions.assertTrue(waitUntilElementToBeVisible(page).isDisplayed(),
                "Контент сранички не прогрузился не прогрузился");
        return this;
    }

//    @Step("Подтвердить город")
//    public СontributionsPage confirmCity() {
//        waitUntilElementToBeClicable(confirmCityButton).click();
//        return this;
//    }

    public СontributionsPage clickCalculation() {
        waitUntilElementToBeClicable(calculation).click();
        return this;
    }

    public CalculationFormPage checkCalculation() {
        for (WebElement button : buttonsInCalculationFormList) {
            if (waitUntilElementToBeClicable(button).getText().contains("Вклады")) {
                return pageManager.getPage(CalculationFormPage.class);
            }
        }
        Assertions.fail("Форма калькулятора не прогрузилась");
        return pageManager.getPage(CalculationFormPage.class);
    }

    public СontributionsPage closeModalWindow() {
        if (!resultSearch.isDisplayed()) {
            clickWithOffset(modalWindow, 250, 0);
        }
        return this;
    }


    public СontributionsPage checkSearchResult(String countDeposit) {
        waitStabilityPage(5000, 200);
        Assertions.assertTrue(resultSearch.getText().contains(countDeposit), "Количество вкладов не равно "
                + countDeposit);
        return this;
    }

    public СontributionsPage checkСontribution(String nameOfBank, String
            bid, String term, String income) {
        for (WebElement deposit : bockBanksInContributionPageList) {
            if (waitUntilElementToBeVisible(deposit)
                    .getText().contains(nameOfBank)) {
                Assertions.assertEquals(bid, deposit.findElement
                                (By.xpath(".//div[contains(text()[2],'%')]")).getText()
                        .replaceAll("[^0-9,]", ""), "Процент не равен " + bid);
                Assertions.assertEquals(term, deposit.findElement
                                (By.xpath(".//div[contains(text()[2],'дн.')]")).getText()
                        .replaceAll("[^0-9]", ""), "Срок не равен " + term);
                Assertions.assertEquals(income, deposit.findElement
                                (By.xpath(".//div[contains(text(),'₽')]")).getText()
                        .replaceAll("[^0-9]", ""), "Доход не равен " + income);
                return this;
            }
        }
        Assertions.fail("Предложение по вкладу не найдено");
        return this;
    }

    public BaseMenuBlock getBaseMenuBlock() {
        return baseMenuBlock;
    }

}

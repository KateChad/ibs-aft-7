package framework.steps;

import framework.managers.PageManager;
import framework.pages.СontributionsPage;
import io.cucumber.java.bg.И;

public class ContributionsPageStep {
    PageManager pageManager = PageManager.getInstance();
    @И("проверка прогрузилась ли страничка")
    public void checkDownloadPage(){
        pageManager.getPage(СontributionsPage.class).checkDownloadPage();
    }

    @И("переход в калькулятор")
    public void clickCalculation(){
        pageManager.getPage(СontributionsPage.class).clickCalculation();
    }

    @И("проверка открытия окна калькулятора вкладов")
    public void checkCalculation(){
        pageManager.getPage(СontributionsPage.class).checkCalculation();
    }

    @И("закрытие модального окна")
    public void closeModalWindow(){
        pageManager.getPage(СontributionsPage.class).closeModalWindow();
    }

    @И("^проверка количества вкладов \"([^\"]*)\"$")
    public void checkSearchResult(String countDeposit){
        pageManager.getPage(СontributionsPage.class).checkSearchResult(countDeposit);
    }

    @И("^проверка предложений банка \"([^\"]*)\" процентная ставка \"([^\"]*)\" срок \"([^\"]*)\" доходность \"([^\"]*)\"$")
    public void checkСontribution(String nameOfBank, String bid, String term, String income){
        pageManager.getPage(СontributionsPage.class). checkСontribution(nameOfBank, bid, term, income);
    }
}

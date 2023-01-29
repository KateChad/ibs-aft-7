package framework.steps;

import framework.managers.PageManager;
import framework.pages.CalculationFormPage;
import framework.pages.СontributionsPage;
import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.DataTable;
import io.cucumber.java.bg.И;
import io.cucumber.java.ru.Дано;

import java.util.List;

public class CalculationFormPageStep {
    PageManager pageManager = PageManager.getInstance();

    @И("^ввод суммы вклада\"([^\"]*)\"$")
    public void inputDepositAmount(String depositAmount){
        pageManager.getPage(CalculationFormPage.class).inputDepositAmount(depositAmount);
    }

    @И("^проверка ввод суммы вклада\"([^\"]*)\"$")
    public void checkDepositAmount(String depositAmount){
        pageManager.getPage(CalculationFormPage.class).checkDepositAmount(depositAmount);
    }

    @И("^выбрать в поле \"([^\"]*)\" параметр \"([^\"]*)\"$")
    public void selectParameterFromDropDownList(String nameOfDropDown, String selectParameter){
        pageManager.getPage(CalculationFormPage.class).selectParameterFromDropDownList(nameOfDropDown, selectParameter);
    }

    @И("^проверка выбора в поле \"([^\"]*)\" параметра \"([^\"]*)\"$")
    public void checkParametrFromDropDownList(String nameOfDropDown, String selectParameter){
        pageManager.getPage(CalculationFormPage.class).checkParametrFromDropDownList(nameOfDropDown, selectParameter);
    }

    @Дано("^выбор банков:$")
    public void selectBanks(io.cucumber.datatable.DataTable dataTable){
        List<String> banks = dataTable.asList(String.class);
        pageManager.getPage(CalculationFormPage.class).selectBanks(banks);

    }

    @Дано("^проверка выбора банка:$")
    public void checkBanks(io.cucumber.datatable.DataTable dataTable){
        List<String> banks = dataTable.asList(String.class);
        pageManager.getPage(CalculationFormPage.class).checkBanks(banks);
    }

    @Дано("^выбор дополнительных параметров:$")
    public void selectParameters(io.cucumber.datatable.DataTable dataTable){
        List<String> parameters = dataTable.asList(String.class);
        pageManager.getPage(CalculationFormPage.class).selectParameters(parameters);
    }

    @И("^проверка количества вкладов указанных на кнопке \"([^\"]*)\"$")
    public void checkCountDepositsInButton(String countDeposits){
        pageManager.getPage(CalculationFormPage.class).checkCountDepositsInButton(countDeposits);
    }

    @И("клик по кнопке показать результат")
    public void showResult(){
        pageManager.getPage(CalculationFormPage.class).showResult();
    }

}
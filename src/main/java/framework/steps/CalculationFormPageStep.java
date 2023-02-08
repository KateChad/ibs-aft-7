package framework.steps;

import framework.managers.PageManager;
import framework.pages.CalculationFormPage;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.bg.И;

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

    @И("^выбор банков:$")
    public void selectBanks(DataTable dataTable){
        List<String> banks = dataTable.asList(String.class);
        pageManager.getPage(CalculationFormPage.class).selectBanks(banks);
    }

    @И("^проверка выбора банка:$")
    public void checkBanks(DataTable dataTable){
        List<String> banks = dataTable.asList(String.class);
        pageManager.getPage(CalculationFormPage.class).checkBanks(banks);
    }

    @И("^выбор дополнительных параметров:$")
    public void selectParameters(DataTable dataTable){
        List<String> parameters = dataTable.asList(String.class);
        pageManager.getPage(CalculationFormPage.class).selectParameters(parameters);
    }

    @И("^проверка выбора дополнительных параметров:$")
    public void checkSelectParameters(DataTable dataTable){
        List<String> parameters = dataTable.asList(String.class);
        pageManager.getPage(CalculationFormPage.class).checkSelectParameters(parameters);
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

package framework.steps;

import framework.managers.PageManager;
import framework.pages.CalculationFormPage;
import framework.pages.blocks.BaseMenuBlock;
import io.cucumber.java.bg.И;

public class BaseMenuBlockStep {
    PageManager pageManager = PageManager.getInstance();
    @И("проврка прогрузилось ли верхнее меню")
    public void checkHeaderMenuBlock(){
        pageManager.getPage(BaseMenuBlock.class).checkHeaderMenuBlock();
    }

    @И("перейти в меню \"([^\"]*)\"$")
    public void clickOnHeaderMenuList(String nameOfMenuList){
        pageManager.getPage(BaseMenuBlock.class).clickOnHeaderMenuList(nameOfMenuList);
    }
}

package framework.hooks;

import framework.managers.DriverManager;
import framework.managers.InitManager;
import framework.managers.PageManager;
import framework.managers.TestPropManager;
import framework.utils.PropsConst;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    private DriverManager driverManager = DriverManager.getInstance();
    private TestPropManager propManager = TestPropManager.getInstance();
    protected PageManager pageManager = PageManager.getInstance();
    @Before
    public void before(){
        InitManager.initFramework();
        driverManager.getDriver().get(propManager.getProperty(PropsConst.BASE_URL));
    }

    @After
    public void after(){
        InitManager.quitFramework();
        pageManager.clearPages();
    }
}

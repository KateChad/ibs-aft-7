package runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/scenario"},
        glue = {"framework/steps","framework/hooks"},
        tags = {"@regress"}
//        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class CucumberRunner {
}

package orangehrm.cucumber.runner.runLogin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/orangehrm/cucumber/features/login",
        glue = "orangehrm.cucumber.stepDef.stepLogin",
        plugin = {"html:target/HTML_report.html"},
        tags = "@Negative"
)

public class runLogin {
}

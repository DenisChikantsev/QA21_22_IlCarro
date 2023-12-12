package manager;

import org.openqa.selenium.WebDriver;

import java.time.temporal.WeekFields;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;
import utils.DriverManager;

public class FooterTest extends BaseTest {

    @Test
    public void verifyFooterLinks() {

        // 🔥 Scroll to bottom of page
        ((JavascriptExecutor) DriverManager.getDriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // 🔥 Sections to validate
        String[] sections = {"TEAM", "ABOUT", "GUIDELINES", "CONTACT"};

        for (String section : sections) {

            List<WebElement> links = DriverManager.getDriver().findElements(
                    By.xpath("//footer//*[contains(text(),'" + section + "')]/ancestor::div//a")
            );

            System.out.println(section + " links count: " + links.size());

            Assert.assertTrue(
                    links.size() > 0,
                    section + " section has no links"
            );
        }
    }
}
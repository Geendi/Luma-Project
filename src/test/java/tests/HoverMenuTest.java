package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverMenuPage;
import utilities.LoadProperties;

public class HoverMenuTest extends TestBase{
    HoverMenuPage hoverMenuPage;

    String men = LoadProperties.data.getProperty("men");
    String woman = LoadProperties.data.getProperty("woman");
    String gear = LoadProperties.data.getProperty("gear");

    @Test
    public void hoverOverMen(){
        hoverMenuPage = new HoverMenuPage(driver);
        hoverMenuPage.hoverMen();
        Assert.assertTrue(hoverMenuPage.assertion().contains(men));

    }

    @Test(priority = 1)
    public void hoverOverWomen(){
        hoverMenuPage.hoverWomen();
        Assert.assertTrue(hoverMenuPage.assertion().contains(woman));
    }

    @Test(priority = 2)
    public void hoverOverGear(){
        hoverMenuPage.hoverGear();
        Assert.assertTrue(hoverMenuPage.assertion().contains(gear));
    }
}

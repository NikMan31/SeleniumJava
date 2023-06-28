import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CheckShortedTableByUsingJavaStream {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //First I will go to the website
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Then click on the table 1st row
        Thread.sleep(3000);
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Then retrieve all the elements from the  1st column means this will be original list
        List<WebElement> elementsFor1stColumn= driver.findElements(By.xpath("//tr/td[1]"));
        List<String> orinialList=elementsFor1stColumn.stream().map(element->element.getText()).collect(toList());

        //Then do sort means this will be sorted list
        List<String> sortedList= orinialList.stream().sorted().collect(toList());

        //Then check weather sorted and original list is equal or not
        Assert.assertTrue(orinialList.equals(sortedList));
        System.out.println("All done ");

        //Now my requirement is to get price of beans after sorted
        List<String> price=elementsFor1stColumn.stream().filter(name->name.getText().contains("Beans")).map(priceForVeggie->getPrice(priceForVeggie)).collect(Collectors.toList());
        //Here getPrice() is customised or user defined function means its not pre built function
        price.forEach(price1-> System.out.println(price1));
    }

    private static String getPrice(WebElement price) {
        String priceValue=price.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
        return priceValue;
    }

}

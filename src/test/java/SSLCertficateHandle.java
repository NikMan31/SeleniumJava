//For handle expired SSL certificate, you need to use 2 selenium class 1) DesireCapability 2)ChromeOption
//Usally You handle SSL before launching website, you need to defined code before drive=new ChromeDriver() line

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SSLCertficateHandle {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();

        DesiredCapabilities dc=new DesiredCapabilities();
        //dc.setAcceptInsecureCerts(true); //You can use this line as well
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        //dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        ChromeOptions coptions=new ChromeOptions();
        coptions.merge(dc);

        WebDriver driver=new ChromeDriver(coptions); //Here, I am passing one argument because, jyare apne kay pass nata karta tyare default chrome open thatu hatu paan have apne default chrome open naay karvanu
                                            // Apne upper configurre karelu chrome open karavu che that's why I am passing one argument
        driver.get("https://expired.badssl.com/");
    }
}

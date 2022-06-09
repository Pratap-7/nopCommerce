package nopCommerce.Base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class DriverInstance extends AbstractTestNGCucumberTests {

	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();

	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));

	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) {
		switch (browser) {
		case "chrome":
			remoteWebDriver.set(new ChromeDriver());
		case "firefox":
			remoteWebDriver.set(new FirefoxDriver());
		case "edge":
			remoteWebDriver.set(new EdgeDriver());
		default:
			break;
		}
	}

	public RemoteWebDriver getDriver() {
		return remoteWebDriver.get();
	}
}

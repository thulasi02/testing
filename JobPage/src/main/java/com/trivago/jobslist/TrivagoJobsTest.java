package com.trivago.jobslist;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TrivagoJobsTest {

	private final String URL = "https://company.trivago.com/open-positions/";
	private WebDriver driver = null;
	WebDriverWait wait = null;
	SoftAssert softassert = null;
	private static Logger log = Logger.getLogger(TrivagoJobsTest.class);
	List<WebElement> Elements = new ArrayList<>();
	ArrayList<String> tabs = new ArrayList<>();
	String[] split = new String[2];

	@BeforeClass
	public void setProperties() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		softassert = new SoftAssert();
		wait = new WebDriverWait(driver, 20000);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@AfterTest
	public void clearData() {
		Elements.clear();
		tabs.clear();
	
		
		
	}

	//@Test
	public void verifyTitle() {

		Elements = (ArrayList<WebElement>) driver.findElements(ObjectsRepo.jobUrls);
		System.out.println("All Job Urls are dynamically retrieved");
		for (WebElement webelement : Elements) {

			try {

				getJobs(webelement);

				WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(ObjectsRepo.jobTitle));
				if (until.isDisplayed()) {
					log.info("Title is displayed in h1 tag for job url" + split[1]);
					softassert.assertTrue(true, "Title is displayed in h1 tag for job url" + split[1]);
				} else {
					softassert.assertTrue(false, "Title is not displayed in h1 tag for job url" + split[1]);

				}

			}

			catch (Exception e) {
				softassert.assertTrue(false, "title Element not diplayed or doesnt have h1 tag");
				log.error("Element not visible" + e.getMessage());

			} finally {
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
		softassert.assertAll();
	}

	//@Test
	public void verifyJobFamily() {
		Elements = (ArrayList<WebElement>) driver.findElements(ObjectsRepo.jobUrls);
		System.out.println("All Job Urls are dynamically retrieved");

		for (WebElement webelement : Elements) {
			try {
				getJobs(webelement);
				if (!driver.findElement(ObjectsRepo.jobFamily).getText().isEmpty()) {

					softassert.assertTrue(true, "JobFamily has value is displayed in h1 tag for job url" + split[1]);

				} else {
					softassert.assertTrue(false, "JobFamily is not  displayed in h1 tag for job url" + split[1]);
				}

			}

			catch (Exception e) {
				softassert.assertTrue(false,
						"Jobfamily failed due to exception" + e.getMessage() + "in job url" + split[1]);
			} finally {
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
		softassert.assertAll();
	}

	//@Test
	public void verifyJobExperience() {

		Elements = (ArrayList<WebElement>) driver.findElements(ObjectsRepo.jobUrls);
		System.out.println("All Job Urls are dynamically retrieved");
		for (WebElement webelement : Elements) {
			try {
				getJobs(webelement);

				if (!driver.findElement(ObjectsRepo.jobExperience).getText().isEmpty()) {

					softassert.assertTrue(true, "JobExperience has value for job url" + split[1]);

				} else {
					softassert.assertTrue(false, "JobExperience  value is not displayed in  job url" + split[1]);
				}

			} catch (Exception e) {
				softassert.assertTrue(false,
						"Job experience failed due to exception" + e.getMessage() + "in job url" + split[1]);
				driver.close();
				driver.switchTo().window(tabs.get(0));

			}

			finally {
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
		softassert.assertAll();
	}

	//@Test
	public void verifyJobLocation() {

		Elements = (ArrayList<WebElement>) driver.findElements(ObjectsRepo.jobUrls);
		System.out.println("All Job Urls are dynamically retrieved");

		for (WebElement webelement : Elements) {
			try {
				getJobs(webelement);

				if (!driver.findElement(ObjectsRepo.jobExperience).getText().isEmpty()) {

					softassert.assertTrue(true, "JobLocation has value is displayed for job url" + split[1]);

				} else {
					softassert.assertTrue(false, "JobLocation has no value is displayed for job url" + split[1]);
				}

			} catch (Exception e) {
				softassert.assertTrue(false,
						"Job location failed due to exception" + e.getMessage() + "in job url" + split[1]);
			} finally {
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
		softassert.assertAll();
	}

	//@Test
	public void verifyApplyButton() {

		Elements = (ArrayList<WebElement>) driver.findElements(ObjectsRepo.jobUrls);
		System.out.println("All Job Urls are dynamically retrieved");
		for (WebElement webelement : Elements) {
			try {
				getJobs(webelement);
				if (driver.findElement(ObjectsRepo.applyButton).isDisplayed()) {

					softassert.assertTrue(true, "Apply button is displayed for job url" + split[1]);

				} else {
					softassert.assertTrue(false, "Apply button is not displayed for job url" + split[1]);
				}

			} catch (Exception e) {
				softassert.assertTrue(false,
						"Verify apply button failed due to exception" + e.getMessage() + "in job url" + split[1]);
			} finally {
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
		softassert.assertAll();
	}
	@Test
	public void verifyTag() {

		Elements = (ArrayList<WebElement>) driver.findElements(ObjectsRepo.jobUrls);
		System.out.println("All Job Urls are dynamically retrieved");
		By[] data = new By[] { ObjectsRepo.verifyTag_whatwedefneed, ObjectsRepo.verifyTag_whatwelove,
				ObjectsRepo.verifyTag_whatyouwilldo };

		for (WebElement webelement : Elements) {
			try {
				getJobs(webelement);
				for (By value : data) 
				{
					try {	
						if (driver.findElement(value).isDisplayed()) {

							softassert.assertTrue(true,
									"value is displayed in defined tag " + value + "for job url " + split[1]);

						} else {
							softassert.assertTrue(false,
									"value is not displayed in defined tag " + value + "for job url " + split[1]);
						}
					}catch(Exception e){
						softassert.assertTrue(false,
								"value is not displayed in defined tag " + value + "for job url " + split[1]);

					}
				}
			}

			catch (Exception e) {
				e.printStackTrace();
				softassert.assertTrue(false, "failed due to exception" + e.getMessage()
				+ " as value is not displayed in defined tag  for job url " + split[1]);
			} finally {
				driver.close();
				driver.switchTo().window(tabs.get(0));
			}
		}
		softassert.assertAll();
	}

	public void getJobs(WebElement webelement) {

		try {
			String attribute = webelement.getAttribute("onclick");

			split = attribute.split("window.location = ");

			((JavascriptExecutor) driver).executeScript("window.open()");
			tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(split[1].trim().replaceAll("'", ""));

			WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(ObjectsRepo.jobTitle));
		} catch (Exception e) {
			softassert.assertTrue(false, "failed in fecthing the jobs data" + e.getMessage());
		}

	}
}

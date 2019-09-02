package com.trivago.jobslist;

import org.openqa.selenium.By;

public class ObjectsRepo {

	public static By jobUrls=By.xpath("//div[@id='list-jobs']//tr[@onclick]"); 
	public static By jobTitle=By.xpath("//div[@id='content']//section[2]//h1");
	public static By jobFamily=By.xpath("//span[@id='job_family']");
	public static By jobExperience=By.xpath("//b[contains(text(),'Experience Level')]//following::span[1]");
	public static By jobLocation=By.xpath("//b[contains(text(),'Location')]//following::span[1]");
	public static By applyButton=By.xpath("(//button[contains(text(),'Apply')])[1] | (//button[contains(text(),'Apply')])[2]");
	public static By verifyTag_whatyouwilldo=By.xpath("//b[contains(text(),\"What you\'ll do:\")]");
	public static By verifyTag_whatwedefneed=By.xpath("//b[contains(text(),\"What you\'ll definitely need:\")]");
	public static By verifyTag_whatwelove=By.xpath("//b[contains(text(),\"What we'd love you to have:\")]");
}


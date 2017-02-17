package admin.portal;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Settings extends Driver{
	
	String item = null;
	
	String title = null;
	
	SoftAssert ss;
	
	 public void addItem(String item) throws Exception{
		 
		 ss = new SoftAssert();
		 
		  this.item = item;
		 
		  String title1 = driver.findElement(By.xpath("//*[@id='body']/div/div[1]/div/ol/li[2]/span")).getText();
		  ss.assertEquals(title1, this.title);
		  Reporter.log(title1 + " page successfully loaded.");
		  
		  //click on button to add
		  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[1]/div/div/div/span/button")).click();
		  
		  Thread.sleep(2000);
		  
		  String title2 = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[1]/p")).getText();
		  Reporter.log(title2 + " panel to add new item successfully loaded.");
		  
		  Thread.sleep(1000);
		  
		  //input on name              
		  if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(item);
		  }else {
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(item);
		  }
		  
		  Thread.sleep(2000);		 
		  
		  //click on save button       
		  if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/span[1]/button")).click();
		  }else {
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[1]/div/div/div/span[1]/button")).click();
		  }		  
		  
		  Thread.sleep(1000);
		  
		  String msg1 = driver.findElement(By.xpath("//*[@id='message-body']")).getText();
		  
		  if(this.title.equalsIgnoreCase("Ship Via") || this.title.equalsIgnoreCase("Sales Term")){
			  ss.assertEquals(msg1, item+" has been added");
		  }else{
			  ss.assertEquals(msg1, item+" has been created.");
		  }
		  
		  Reporter.log("Add new " +this.title+ ": " +msg1);
		  
		  Thread.sleep(2000);
		  
		  //close the message box
		  driver.findElement(By.xpath("//*[@id='dna-messagebox']/a")).click();
		  
		  Thread.sleep(1000);
		  
		  //click on save & close button
		  if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/span[2]/button")).click();
		  }else {
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[1]/div/div/div/span[2]/button")).click();
		  }
		  
		  Thread.sleep(1000);
		  
		  String msg2 = driver.findElement(By.xpath("//*[@id='message-body']")).getText();
		  
		  if(this.title.equalsIgnoreCase("Branch")){
			  ss.assertEquals(msg2, item+" already exist");
		  }else if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  ss.assertEquals(msg2, "Reason already exists.");
		  }else if(this.title.equalsIgnoreCase("PO Status")){
			  ss.assertEquals(msg2, "PO Status is already exist");
		  }else{
			  ss.assertEquals(msg2, item+" already exists");
		  }
		  
		  Reporter.log("Duplicate " +this.title+ ": " +msg2);
		  
		  Thread.sleep(3000);
		  
		  if(this.title.equalsIgnoreCase("Branch") || this.title.equalsIgnoreCase("Job Title") || this.title.equalsIgnoreCase("Ship Via") || this.title.equalsIgnoreCase("Sales Term")){
			  //click on close button
			  driver.findElement(By.xpath("//*[@id='fs-panel-modal']/div/div[1]/a")).click();
		  }
		  
		  Thread.sleep(1000);
		  
		  ss.assertAll();
		
		  Thread.sleep(2000);
	  }
	  
   public void editItem() throws Exception{
		  
		  ss = new SoftAssert();
		  
		  searchItem();
		  
		  Thread.sleep(1000);
		  
		  //click the edit button     
		  if(this.title.equalsIgnoreCase("PO Status")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[3]/button[1]")).click();
		  }else{
			  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[2]/button[1]")).click();
		  }
			  
		  Thread.sleep(3000);
		  
		  String title = driver.findElement(By.xpath("//*[@id='body']/div/div[1]/div/ol/li[2]/span")).getText();
		  ss.assertEquals(title, this.title);
		  
		  Reporter.log(title + " panel to edit an item successfully loaded.");
		  
		  this.item += " edited";
		  
		  //input on fabric color
		  if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).clear();
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(" ");
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(Keys.BACK_SPACE);
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(this.item);
		  }else {
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).clear();
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(" ");
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(Keys.BACK_SPACE);
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[1]/div/input")).sendKeys(this.item);
		  }
		  
		  Thread.sleep(1000);
		  
		  // check the box to  be default
		  if(this.title.equalsIgnoreCase("PO Status")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div/div/div/div/div[2]/div/label/span[1]")).click();
		  }
		  
		  Thread.sleep(1000);
		  
		  //click on save & close button
		  if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/span[2]/button")).click();
		  }else {
			  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div/div[1]/div/div/div/span[2]/button")).click();
		  }

		  Thread.sleep(1000);
		  
		  String msg1 = driver.findElement(By.xpath("//*[@id='message-body']")).getText();
		  
		  if(this.title.equalsIgnoreCase("Ship Via") || this.title.equalsIgnoreCase("Sales Term")){
			  ss.assertEquals(msg1, this.item+" has been updated");
		  }else if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  ss.assertEquals(msg1, this.item+" has been edited.");
		  }else{
			  ss.assertEquals(msg1, this.item+" has been updated.");
		  }
		  
		  Reporter.log("Edit " +this.title+ ": " +msg1);
		  
		  Thread.sleep(3000);
		  
		  // check the new edit is the default status
		  if(this.title.equalsIgnoreCase("PO Status")){
			  String defaultStatus = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[2]")).getText();
			  ss.assertEquals(defaultStatus, "DEFAULT");
		  }
		  
		  ss.assertAll();
		
		  Thread.sleep(1000);	  
	  }
	  
	  public void deleteItem() throws Exception{
		  
		  ss = new SoftAssert();
		  
		  searchItem();
		  
		  Thread.sleep(1000);
		  
		  //click on deleted button
		  if(this.title.equalsIgnoreCase("PO Status")){
			  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[3]/button[2]")).click();
		  }else{
			  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[2]/button[2]")).click();
		  }
		 
		  Thread.sleep(2000);

		  String msg1 = driver.findElement(By.xpath("html/body/div[5]/div[2]/form/div[1]")).getText();
		  
		  if(this.title.equalsIgnoreCase("Branch")){
			  ss.assertEquals(msg1, "Proceed to delete " +this.item+ " ?");
		  }else if(this.title.equalsIgnoreCase("PO Status")){
			  ss.assertEquals(msg1, "Are you sure you want to delete " + this.item + " status ?" );
		  }else{
			  ss.assertEquals(msg1, "Proceed to delete?");
		  }
		  
		  Reporter.log("Confirmation message: " +msg1);
		  
		  Thread.sleep(1000);
		  
		  //click on OK
		  driver.findElement(By.xpath("html/body/div[5]/div[2]/form/div[3]/button[1]")).click();
		  
		  Thread.sleep(1000);
		  
		  String msg2 = driver.findElement(By.xpath("//*[@id='message-body']")).getText();
		  if(this.title.equalsIgnoreCase("Reasons for Visits")){
			  ss.assertEquals(msg2, "Successfully deleted "+this.item);
		  }else if(this.title.equalsIgnoreCase("PO Status")){
			  ss.assertEquals(msg2, "Status has been deleted." );
		  }else{
			  ss.assertEquals(msg2, this.item+" has been deleted");
		  }

		  
		  Reporter.log(this.title + " " + msg2);
		  
		  Thread.sleep(2000);
		  
		  ss.assertAll();
		  
		  Thread.sleep(1000);	  
	  }
	  
	  public void login() throws Exception{
		  
		  driver.get("http://csr.devvm.drumbi.com:3000/login");
		  
		  waitForPageToBeReady();
		  
		  Reporter.log("Asher Admin Portal launch sauccessfully!");
		  
		  driver.findElement(By.xpath("//*[@id='emailaddress']")).sendKeys("admin@email.com");
		  
		  Thread.sleep(1000);
		  
		  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password123");
		  
		  Thread.sleep(1000);
		  
		  //click the login button with valid credentials
		  driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		  
		  wait = new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='body']/div/div/div[1]/ol/li/span"), "Home"));
		  
		  Reporter.log("User login successfully!");
		  
		  Thread.sleep(1000);
	  }
	  
	  public void searchItem() throws Exception{
		  //search for specific item
		  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/label/input")).clear();
		  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/label/input")).sendKeys(this.item);
		  
		  //wait = new WebDriverWait(driver, 15);
		  //wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='sync_staus_tbl_info']"), "Showing 1 to 1 of 1 entries"));
		  Thread.sleep(5000);
		  //check if search result is correct
		  String itemV = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[1]")).getText();
		  ss.assertEquals(itemV, this.item);
		  
		  //log to the status to console
		  if(itemV.equalsIgnoreCase(this.item)){
			  Reporter.log("Searching for "+ this.item + " successfully found.");
		  }else{
			  Reporter.log("Searching for "+ this.item + " not found.");
		  }
	  }
	  
	  public void selectSubMenu(int i) throws Exception{
		  
		  //select Setting and click on Fabric submenu
		  Actions action = new Actions(driver);
		  WebElement we = driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div[1]/div/div/div/div/div/ul/li[8]/a"));
		  action.moveToElement(we).moveToElement(driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div[1]/div/div/div/div/div/ul/li[8]/ul/li["+i+"]/a"))).click().build().perform();
		  
		  switch(i){
		  case 1: this.title = "Fabric Color"; break;
		  case 2: this.title = "Yarn Color"; break;
		  case 3: this.title = "Branch"; break;
		  case 4: this.title = "Job Title"; break;
		  case 5: this.title = "Ship Via"; break;
		  case 6: this.title = "Sales Term"; break;
		  case 7: this.title = "Reasons for Visits"; break;
		  case 8: this.title = "PO Status"; break;
		  }
		  
		  Thread.sleep(3000);
	  }
}

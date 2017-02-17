package admin.portal;

import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Orders extends Driver{
	String mpm = "MPMTest1";
	String customerPO = "14344";
	String poNo = null;
	String poDate = null;
	String salesPerson = null;
	String shipVia = null;
	String salesTerm = null;
	String soldTo = null;
	String shipTo = null;
	String poStatus = null;

	String style[] = new String[3];
	String color[] = new String[3];

	String notes = "The quick brown fox jumps over the lazy dog.";
	
	String print[] = new String[3];
	String swatch[] = new String[3];
	String yards[] = new String[3];
	String remark[] = new String[3];
	
	SoftAssert ss;
	Settings login = new Settings();
	
  @Test(priority=1)
  public void NewOrder() throws Exception{
	  
	  // initialize styles
	  init();
	 
	  ss = new SoftAssert();
	  
	  //login
	  login.login();
	  
	  Thread.sleep(1000);
	  
	  //click on orders menu
	  driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div/div[1]/div/div/div/div/div/ul/li[6]/a/span[1]")).click();
	  
	  Thread.sleep(3000);
	  
	  String title = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[1]/h3")).getText();
	  ss.assertEquals(title, "Order List");
	  
	  Reporter.log(title + " page successfully loaded.");
	  
	  //click on new order button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[1]/div/div/div/span/button")).click();
	  
	  Thread.sleep(1000);
	  
	  // wait till save button is clickable
	  wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/div/div/div/span[1]/button")));
	  
	  String panelTitle = driver.findElement(By.xpath("//*[@id='fs-panel-modal']/div/div[1]/p")).getText();
	  ss.assertEquals(panelTitle, "New Order");
	  
	  Reporter.log(panelTitle + " panel successfully loaded.");
	  
	  Thread.sleep(1000);
	  
	  //get the po#                       
	  this.poNo = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[1]/div/div/span")).getText();
	  Reporter.log("PO#: " + this.poNo);
	  
	  //get the po date
	  this.poDate = formatDate(driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[2]/div[1]/div/div/div/input")).getAttribute("value"));
	  Reporter.log("Date: " + this.poDate);
	  
	  //input on MPM#
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[2]/div/div/div/input")).sendKeys(this.mpm);
	  Reporter.log("Input MPM#: " + this.mpm);
	  
	  Thread.sleep(1000);
	
	  //select POstatus
	  Select poStatus = new Select(driver.findElement(By.xpath("//*[@id='postatus']")));
	  poStatus.selectByIndex(1);
	  
	  Thread.sleep(1000);
	 
	  this.poStatus = driver.findElement(By.xpath("//*[@id='postatus']/option[2]")).getText();
	  Reporter.log("Select PO Status: " + this.poStatus);
	  
	  //input on Customer PO#
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[3]/div/div/div/input")).sendKeys(this.customerPO);
	  Reporter.log("Input Customer PO#: " + this.customerPO);
	  
	  Thread.sleep(1000);
	 
	  //select salesperson
	  Select salesperson = new Select(driver.findElement(By.xpath("//*[@id='sales_person']")));
	  salesperson.selectByIndex(1);
	  
	  Thread.sleep(1000);
	  
	  this.salesPerson = driver.findElement(By.xpath("//*[@id='sales_person']/option[2]")).getText();
	  Reporter.log("Select Sales Person: " + this.salesPerson);
	  
	  //select shipVia
	  Select shipvia = new Select(driver.findElement(By.xpath("//*[@id='purchase_order_ship_via']")));
	  shipvia.selectByIndex(1);
	  
	  Thread.sleep(1000);
	  
	  this.shipVia = driver.findElement(By.xpath("//*[@id='purchase_order_ship_via']/option[2]")).getText();
	  Reporter.log("Select Ship Via: " + this.shipVia);
	  
	  //select salesTerm
	  Select salesterm = new Select(driver.findElement(By.xpath("//*[@id='purchase_order_sales_term']")));
	  salesterm.selectByIndex(1);
	  
	  Thread.sleep(1000);
	  
	  this.salesTerm = driver.findElement(By.xpath("//*[@id='purchase_order_sales_term']/option[2]")).getText();
	  Reporter.log("Select Sales Term: " + this.salesTerm);
	  
	  //click on soldTo            
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[5]/div/div/div/div/div")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[5]/div/div/div/div/div[2]/div[1]/div/input")).sendKeys("amalia");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[5]/div/div/div/div/div[2]/div[2]/ul/li/div/p")).click();
	  
	  Thread.sleep(2000);
	  
	  this.soldTo = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[5]/div/div/div/div/div/div/p")).getText();
	  Reporter.log("Select Sold To: " + this.soldTo);
	  
	  //click on shipTo
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[2]/div[5]/div/div/div/div/div/div/p")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[2]/div[5]/div/div/div/div/div[2]/div[1]/div/input")).sendKeys("zoe");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[2]/div[5]/div/div/div/div/div[2]/div[2]/ul/li[1]/div/p")).click();
	  
	  Thread.sleep(2000);
	  
	  this.shipTo = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[2]/div[5]/div/div/div/div/div/div/p")).getText();
	  Reporter.log("Select Ship To: " + this.shipTo);
	  
	  //input on Notes
	  driver.findElement(By.xpath("//*[@id='order-form']/div/div[2]/div/textarea")).sendKeys(this.notes);
	  Reporter.log("Input Notes: " + this.notes);
	  
	  Thread.sleep(1000);
	  
	  // scroll down
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr[3]/td[1]/div/div/input")));

	  //click on syle1
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr[1]/td[1]/div/div/input")).click();
	  Thread.sleep(2000);  
	  driver.findElement(By.xpath("//*[@id='list0']/div[1]")).click();
	  writeStyle(1);
	  
	  Thread.sleep(2000);
	  
	  copyStyle(1);
	  
	  //click on syle2
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr[2]/td[1]/div/div/input")).click();
	  Thread.sleep(2000);  
	  driver.findElement(By.xpath("//*[@id='list1']/div[2]")).click();
	  writeStyle(2);
	  
	  Thread.sleep(1000);
	  
	  copyStyle(2);
	  
	  //click on syle3
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr[3]/td[1]/div/div/input")).click();
	  Thread.sleep(2000);  
	  driver.findElement(By.xpath("//*[@id='list2']/div[3]")).click();
	  writeStyle(3);
	  
	  Thread.sleep(1000);
	  
	  copyStyle(3);
	  
	  //click on save & close button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/div/div/div/span[2]/button")).click();
	  
	  Thread.sleep(2000);
	  
	  String msg = driver.findElement(By.xpath("html/body/div[1]/div/p")).getText();
	  ss.assertEquals("Successfully saved", msg);
	  
	  ss.assertAll();
	  
	  Reporter.log("New Order has been added successfully");
	  
	  Thread.sleep(2000);
  }
  
  @Test(priority=2)
  public void EditOrder() throws Exception{
	  
	  ss = new SoftAssert();
	  
	  // search PO#
	  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/label/input")).sendKeys(this.poNo);
	  
	  wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='orders_table_info']"), "Showing 1 to 1 of 1 entries"));
	  
	  Thread.sleep(1000);
	  
	  /**********  check if all the details from the table are correct ************/
	                                            
	  String poNo = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[1]")).getText();
	  ss.assertEquals(poNo, this.poNo);
	  
	  String mpm = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[2]")).getText();
	  ss.assertEquals(mpm, this.mpm);
	  
	  String customerPO = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[3]")).getText();
	  ss.assertEquals(customerPO, this.customerPO);
	  
	  String poDate = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[4]")).getText();
	  ss.assertEquals(poDate, this.poDate);
	  
	  String salesPerson = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[5]")).getText();
	  ss.assertEquals(this.salesPerson, salesPerson);
	  
	  //String soldTo = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[6]")).getText();
	  //ss.assertEquals(this.soldTo, soldTo);
	  
	  String poStatus = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[7]")).getText();
	  ss.assertEquals(poStatus, this.poStatus);
	  
	  /************** end of check *************************/
	  
	  //click on Edit button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[8]/button[1]")).click();
	  
	  Thread.sleep(1000);
	  
	  wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/div/div/div/span[2]/button")));
	  
	  Thread.sleep(1000);
	  
	  /****** check the details inside edit order *************/
	  
	  String title = driver.findElement(By.xpath("//*[@id='fs-panel-modal']/div/div[1]/p")).getText();
	  ss.assertEquals("Edit Order", title);
	  Reporter.log(title + " panel successfully loaded.");
	  
	  String poNoV = driver.findElement(By.xpath("//*[@id='order-form']/div/div[1]/div[1]/div[1]/div/div/span")).getText();
	  ss.assertEquals(poNoV, this.poNo);
	  	  
	  String poDateV = formatDate(driver.findElement(By.xpath("//*[@id='order-form']/div/div[1]/div[2]/div[1]/div/div/div/input")).getAttribute("value"));
	  ss.assertEquals(poDateV, this.poDate);

	  String mpmV = driver.findElement(By.xpath("//*[@id='purchase_order_mpm_number']")).getAttribute("value");
	  ss.assertEquals(mpmV, this.mpm);
	  
	  Select selectedValue = new Select(driver.findElement(By.xpath("//*[@id='postatus']")));
	  String poStatusV = selectedValue.getFirstSelectedOption().getText();
	  ss.assertEquals(poStatusV, this.poStatus);
	  
	  String customerPOV = driver.findElement(By.xpath("//*[@id='po_number']")).getAttribute("value");
	  ss.assertEquals(customerPOV, this.customerPO);
	  
	  selectedValue = new Select(driver.findElement(By.xpath("//*[@id='sales_person']")));
	  String salesPersonV = selectedValue.getFirstSelectedOption().getText();
	  ss.assertEquals(salesPersonV, this.salesPerson);
	  
	  selectedValue = new Select(driver.findElement(By.xpath("//*[@id='purchase_order_ship_via']")));
	  String shipViaV = selectedValue.getFirstSelectedOption().getText();
	  ss.assertEquals(shipViaV, this.shipVia);
	  
	  selectedValue = new Select(driver.findElement(By.xpath("//*[@id='purchase_order_sales_term']")));
	  String salesTermV = selectedValue.getFirstSelectedOption().getText();
	  ss.assertEquals(salesTermV, this.salesTerm);
	  
	  String soldToV = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div[5]/div/div/div/div/div/div/p")).getText();
	  ss.assertEquals(soldToV, this.soldTo);
	  
	  String shipToV = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[1]/div[2]/div[5]/div/div/div/div/div/div/p")).getText();
	  ss.assertEquals(shipToV, this.shipTo);
	  
	  String notesV = driver.findElement(By.xpath("//*[@id='order-form']/div/div[2]/div/textarea")).getText();
	  ss.assertEquals(notesV, this.notes);
	  
	  /*********** end of check ***********/
	  
	  Thread.sleep(1000);
	  
	  // delete mpm#
	  driver.findElement(By.xpath("//*[@id='purchase_order_mpm_number']")).clear();
	  
	  Thread.sleep(1000);
	  Reporter.log("MPM# successfull deleted.");
	  
	  //scroll down
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//*[@id='order-form']/div/div[4]/div/table/tbody/tr[3]/td[1]/div/div/input")));
	  
	  Thread.sleep(1000);
	  
	  checkStyle(1);
	  checkStyle(2);
	  checkStyle(3);
	  
	  Thread.sleep(1000);
	  
	  //click on save & close button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/div/div/div/span[2]/button")).click();
	  
	  Thread.sleep(2000);
	  
	  String msg = driver.findElement(By.xpath("html/body/div[1]/div/p")).getText();
	  ss.assertEquals(msg, "Successfully edited");
	  
	  ss.assertAll();
	  
	  Reporter.log(title + " successfully updated.");
	  
	  Thread.sleep(3000);
  }
  
  @Test(priority=3)
  public void Distribute() throws Exception{
	  
	  ss = new SoftAssert();
	  
	  // search PO#
	  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/label/input")).sendKeys(this.poNo);
	  
	  wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='orders_table_info']"), "Showing 1 to 1 of 1 entries"));
	  
	  Thread.sleep(1000);
	  
	  //click on Edit button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[8]/button[1]")).click();
	  
	  Thread.sleep(1000);
	  
	  //wait for the distribute button to be clickable
	  wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/span[3]/button")));
	  
	  Thread.sleep(1000);
	  
	  //click the distribute button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div[1]/div[1]/div/div/div/div/div/div/span[3]/button")).click();
	  
	  Thread.sleep(2000);
	  
	  //search a user
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div[2]/div/div[2]/div/div/input")).sendKeys("ajurado@dnamicro.com");
	  
	  Thread.sleep(1000);
	  
	  String checked = driver.findElement(By.xpath("//*[@id='ms-panel-modal']/div/div[3]/div/ul/li/input")).getAttribute("checked");
	  
	  if(checked == null){
	  	  //click the 1st search result
		  driver.findElement(By.xpath("//*[@id='ms-panel-modal']/div/div[3]/div/ul/li/input")).click();
	  }
	  
	  Thread.sleep(1000);
	  
	  //click send button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div[2]/div/div[2]/div/div/div/span/button")).click();
	  
	  Thread.sleep(2000);
	  
	  String msg = driver.findElement(By.xpath("//*[@id='message-body']")).getText();
	  ss.assertEquals(msg, "Successfully Sent");
	  
	  Thread.sleep(1000);
	  
	  //click close button of alert message
	  driver.findElement(By.xpath("//*[@id='dna-messagebox']/a/i")).click();
	  /*
	  Thread.sleep(1000);
	  
	  //click close button of distribute modal
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div[2]/div/div[1]/a")).click();
	  */
	  Thread.sleep(3000);
	  
	  //click close button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[1]/a")).click();
	  
	  ss.assertAll();
	  
	  Thread.sleep(2000);
  }
  
  @Test(priority=4)
  public void ViewOrder() throws Exception{
	  
	  ss = new SoftAssert();
	  
	  // search PO#
	  //driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/label/input")).sendKeys(this.poNo);
	  
	  //wait = new WebDriverWait(driver, 20);
	  //wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='orders_table_info']"), "Showing 1 to 1 of 1 entries"));
	  
	  Thread.sleep(1000);
	  
	  // check if mpm is now null                  
	  String mpmN = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[2]")).getText();
	  ss.assertTrue(mpmN.isEmpty());
	  
	  //click on View button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[8]/button[2]")).click();
	  
	  Thread.sleep(1000);
	  
	  wait = new WebDriverWait(driver, 15);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[1]/div/div/div/div/div/div/span/button")));
	  
	  Thread.sleep(1000);
	  
	  /********************* Check all the details to be print ****************************/
	  
	  String title = driver.findElement(By.xpath("//*[@id='fs-panel-modal']/div/div[1]/p")).getText();
	  ss.assertEquals(title, "Print Order");
	  Reporter.log(title + " panel successfully loaded.");
	  
	  String asherAddress = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[1]/div[2]/div[1]")).getText();
	  ss.assertEquals(asherAddress, "950 S. BOYLE AVE. LOS ANGELES, CA 90023");
	  Reporter.log("Asher Address: " + asherAddress);
	  
	  String asherContact = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[1]/div[2]/div[2]")).getText();
	  ss.assertEquals(asherContact, "Voice: (323) 268-1218, FAX: (323) 268-2737");
	  Reporter.log("Asher Contact: " + asherContact);
	  
	  String poDate = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[1]/div[3]/div[2]")).getText();
	  ss.assertEquals(poDate, this.poDate);
	  Reporter.log("Date Order: " + poDate);
	  
	  String poNo = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[1]")).getText();
	  ss.assertEquals(poNo, this.poNo);
	  Reporter.log("PO#: " + poNo);
	  
	  String mpm = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[2]")).getText();
	  ss.assertTrue(mpm.isEmpty());
	  Reporter.log("MPM#: " + mpm);
	  
	  String customerPO = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[3]")).getText();
	  ss.assertEquals(customerPO, this.customerPO);
	  Reporter.log("Customer PO#: " + customerPO);
	  
	  String poStatus = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[2]/table/tbody/tr[2]/td[4]")).getText();
	  ss.assertEquals(poStatus, this.poStatus);
	  Reporter.log("PO Status: " + poStatus);
	  
	  String soldTo = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[3]/div[1]/div[2]/span")).getText();
	  ss.assertEquals(soldTo, "Amalia");
	  Reporter.log("Sold To: " + poStatus);
	  
	  String shipTo = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[3]/div[3]/div[2]/span")).getText();
	  ss.assertEquals(shipTo, "ZOE LATTA");
	  Reporter.log("Ship To: " + shipTo);
	  
	  String salesPerson = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[4]/table/tbody/tr[2]/td[1]")).getText();
	  ss.assertEquals(salesPerson, this.salesPerson);
	  Reporter.log("Sales Person: " + salesPerson);
	  
	  String salesTerm = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[4]/table/tbody/tr[2]/td[2]")).getText();
	  ss.assertEquals(salesTerm, this.salesTerm);
	  Reporter.log("Sales Term: " + salesTerm);
	  
	  String shipVia = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[4]/table/tbody/tr[2]/td[3]")).getText();
	  ss.assertEquals(shipVia, this.shipVia);
	  Reporter.log("Ship Via: " + shipVia);
	  
	  Thread.sleep(1000);
	  
	  //scroll down
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[5]/table/tbody/tr[3]/td[1]")));
	  
	  Thread.sleep(1000);
	  
	  /******  style 1 ************/
	  checkStyleView(1);
	  
	  /******  style 2 ************/
	  checkStyleView(2);
	  
	  /******  style 3 ************/
	  checkStyleView(3);
	  
	  Thread.sleep(2000);
	  
	  //click on close
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[1]/a")).click();
	  
	  Reporter.log(title + " viewed successfully.");
	  
	  ss.assertAll();
	  
	  Thread.sleep(3000);
  }
  
  @Test(priority=5)
  public void DeleteOrder() throws Exception{
	  
	  ss = new SoftAssert();
	  
	  //click on delete button
	  driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr/td[8]/button[3]")).click();
	  
	  Thread.sleep(2000);
	  
	  String msg1 = driver.findElement(By.xpath("html/body/div[5]/div[2]/form/div[1]")).getText();
	  ss.assertEquals("Are you sure you want to delete this order ?", msg1);
	  Reporter.log(msg1);
	  
	  Thread.sleep(1000);
	  
	  //click on YES
	  driver.findElement(By.xpath("html/body/div[5]/div[2]/form/div[3]/button[1]")).click();
	  
	  Thread.sleep(1000);
	  
	  String msg2 = driver.findElement(By.xpath("//*[@id='message-body']")).getText();
	  ss.assertEquals("PO# "+this.poNo+" has been deleted.", msg2);
	  
	  ss.assertAll();
	  
	  Reporter.log("Purchase Order successfully deleted!");
	  
	  Thread.sleep(2000);
  }
  
  public String formatDate(String date){
	  	String fDate = null;
	  	String split[] = new String[3];
		
		StringTokenizer tok = new StringTokenizer(date, "-");
		split[0] = tok.nextToken();
		split[1] = tok.nextToken();
		split[2] = tok.nextToken();
		
		
		switch(split[0]){
		case "January": split[0] = "01"; break;
		case "February": split[0] = "02"; break;
		case "March": split[0] = "03"; break;
		case "April": split[0] = "04"; break;
		case "May": split[0] = "05"; break;
		case "June": split[0] = "06"; break;
		case "July": split[0] = "07"; break;
		case "August": split[0] = "08"; break;
		case "September": split[0] = "09"; break;
		case "October": split[0] = "10"; break;
		case "November": split[0] = "11"; break;
		case "December": split[0] = "12"; break;
		}
		
		fDate = split[1]+"/"+split[2]+"/"+split[0];
	  
	  return fDate;
  }
  
  public int searchPO(String totalRow){
	  int rowNo=0;
	  String split[] = new String[7];
	  
	  StringTokenizer tok = new StringTokenizer(totalRow, " ");
	  split[0] = tok.nextToken();
	  split[1] = tok.nextToken();
	  split[2] = tok.nextToken();
	  split[3] = tok.nextToken();
	  split[4] = tok.nextToken();
	  split[5] = tok.nextToken();
	  split[6] = tok.nextToken();
	  
	  int totalR = Integer.parseInt(split[5]);
	  
	  for(int i=1; i<totalR; i++){
		  String str = driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[2]/div/div/div[2]/div/div/div[3]/div[2]/table/tbody/tr["+i+"]/td[1]")).getText();
		  if(poNo.equalsIgnoreCase(str)){
			  rowNo = i;
			  break;
		  }
	  }
	  
	  
	  return rowNo;
  }
  
  public void checkStyle(int i){
  
	  String style1V = driver.findElement(By.xpath("//*[@id='order-form']/div/div[4]/div/table/tbody/tr["+i+"]/td[1]/div/div/input")).getAttribute("value");
	  ss.assertEquals(style[i-1], style1V);
	  
	  String color1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[2]/div/input")).getAttribute("value");
	  ss.assertEquals(color[i-1], color1V);
	  
	  String print1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[3]/div/input")).getAttribute("value");
	  ss.assertEquals(print[i-1], print1V);
	  
	  String swatch1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[4]/div/input")).getAttribute("value");
	  ss.assertEquals(swatch[i-1], swatch1V);
	  
	  String yards1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[5]/div/input")).getAttribute("value");
	  ss.assertEquals(yards[i-1], yards1V);
	  
	  String remark1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[6]/div/input")).getAttribute("value");
	  ss.assertEquals(remark[i-1], remark1V);	  
  }
  
  public void checkStyleView(int i){
	  
	  String style1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[5]/table/tbody/tr["+i+"]/td[1]")).getText();
	  ss.assertEquals(style[i-1], style1V);
	  
	  String color1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[5]/table/tbody/tr["+i+"]/td[2]")).getText();
	  ss.assertEquals(color[i-1], color1V);
	  
	  String print1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[5]/table/tbody/tr["+i+"]/td[3]")).getText();
	  ss.assertEquals(print[i-1], print1V);
	  
	  String swatch1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[5]/table/tbody/tr["+i+"]/td[4]")).getText();
	  ss.assertEquals(swatch[i-1], swatch1V);
	  
	  String yards1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[5]/table/tbody/tr["+i+"]/td[5]")).getText();
	  ss.assertEquals(yards[i-1], yards1V);
	  
	  String remark1V = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/form/div/div[5]/table/tbody/tr["+i+"]/td[6]")).getText();
	  ss.assertEquals(remark[i-1], remark1V);
  }
  
  public void writeStyle(int i){
	  
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[3]/div/input")).sendKeys(this.print[i-1]);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[4]/div/input")).sendKeys(this.swatch[i-1]);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[5]/div/input")).sendKeys(this.yards[i-1]);
	  driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[6]/div/input")).sendKeys(this.remark[i-1]);
  }
  
  public void copyStyle(int i){
	  
	  style[i-1] = driver.findElement(By.xpath("//*[@id='order-form']/div/div[4]/div/table/tbody/tr["+i+"]/td[1]/div/div/input")).getAttribute("value");
	  color[i-1] = driver.findElement(By.xpath("html/body/div[2]/div/div[5]/div/div[2]/div/div[2]/form/div/div[4]/div/table/tbody/tr["+i+"]/td[2]/div/input")).getAttribute("value");
	  Reporter.log("Select Style #: " + i + " = " + style[i-1] + ", Color: " + color[i-1] + ", Print: " + this.print[i-1] + 
			       ", Swatch: " + this.swatch[i-1] + ", Yards: " + this.yards[i-1] + ", Remark: " + this.remark[i-1]);
  }
  
  public void init(){

	  for(int i=0; i<3; i++){
		  this.style[i] = null;
		  this.color[i] = null;
		  this.print[i] = "Print"+(i+1);
		  this.swatch[i] = "Swatch"+(i+1);
		  this.yards[i] = "1."+i;
		  this.remark[i] = "Remark"+(i+1);
	  }
 }
}

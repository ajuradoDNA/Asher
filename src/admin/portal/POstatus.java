package admin.portal;

import org.testng.annotations.Test;

public class POstatus extends Driver{
  
	String item = "POstatus Automation Test";
	Settings poStatus = new Settings();
	
	@Test(priority=1)
	public void AddPOstatus() throws Exception{
		
		poStatus.login();
		
		poStatus.selectSubMenu(8);

		poStatus.addItem(item);
	}
	
	@Test(priority=2)
	public void EditPOstatusn() throws Exception{

		poStatus.editItem();
	}
	
	@Test(priority=3)
	public void DeletePOstatus() throws Exception{

		poStatus.deleteItem();
	}
}

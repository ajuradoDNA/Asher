package admin.portal;

import org.testng.annotations.Test;

public class ReasonForVisit extends Driver{
	
	String item = "ReasonForVisit Automation Test";
	Settings reason = new Settings();
	
	@Test(priority=1)
	public void AddReason() throws Exception{
		
		reason.login();
		
		reason.selectSubMenu(7);

		reason.addItem(item);
	}
	
	@Test(priority=2)
	public void EditReason() throws Exception{

		reason.editItem();
	}
	
	@Test(priority=3)
	public void DeleteReason() throws Exception{

		reason.deleteItem();
	}
}

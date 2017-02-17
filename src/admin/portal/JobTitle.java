package admin.portal;

import org.testng.annotations.Test;

public class JobTitle extends Driver{

	String item = "JobTitle Automation Test";
	Settings jobTitle = new Settings();
	
	@Test(priority=1)
	public void AddJobTitle() throws Exception{
		
		jobTitle.login();
		
		jobTitle.selectSubMenu(4);

		jobTitle.addItem(item);
	}
	
	@Test(priority=2)
	public void EditJobTitle() throws Exception{

		jobTitle.editItem();
	}
	
	@Test(priority=3)
	public void DeleteJobTitle() throws Exception{

		jobTitle.deleteItem();
	}

}
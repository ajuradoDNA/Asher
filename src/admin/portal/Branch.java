package admin.portal;

import org.testng.annotations.Test;

public class Branch extends Driver{

	String item = "Branch Automation Test";
	Settings branch = new Settings();
	
	@Test(priority=1)
	public void AddBranch() throws Exception{
		
		//login from site
		branch.login();
		
		//select branch sub menu
		branch.selectSubMenu(3);

		//call add item to add branch name
		branch.addItem(item);
		
	}
	
	@Test(priority=2)
	public void EditBranch() throws Exception{
		
		//call edit item to edit branch name
		branch.editItem();
	}
	
	@Test(priority=3)
	public void DeleteBranch() throws Exception{

		//call edit item to edit branch name
		branch.deleteItem();
	}

}

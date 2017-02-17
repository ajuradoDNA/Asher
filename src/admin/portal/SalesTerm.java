package admin.portal;

import org.testng.annotations.Test;

public class SalesTerm extends Driver{

	String item = "SalesTerm Automation Test";
	Settings salesTerm = new Settings();
	
	@Test(priority=1)
	public void AddSalesTerm() throws Exception{
		
		salesTerm.login();
		
		salesTerm.selectSubMenu(6);

		salesTerm.addItem(item);
	}
	
	@Test(priority=2)
	public void EditSalesTerm() throws Exception{

		salesTerm.editItem();
	}
	
	@Test(priority=3)
	public void DeleteSalesTerm() throws Exception{

		salesTerm.deleteItem();
	}

}
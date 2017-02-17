package admin.portal;

import org.testng.annotations.Test;

public class ShipVia extends Driver{

	String item = "ShipVia Automation Test";
	Settings shipVia = new Settings();
	
	@Test(priority=1)
	public void AddShipVia() throws Exception{
		
		shipVia.login();
		
		shipVia.selectSubMenu(5);

		shipVia.addItem(item);
	}
	
	@Test(priority=2)
	public void EditShipVia() throws Exception{

		shipVia.editItem();
	}
	
	@Test(priority=3)
	public void DeleteShipVia() throws Exception{

		shipVia.deleteItem();
	}

}
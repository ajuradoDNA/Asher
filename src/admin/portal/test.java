package admin.portal;

import java.util.StringTokenizer;

class test{
	public static void main(String[] args){
		/*String fDate = null;
		String date = "August 29, 2016";
		String split[] = new String[3];
		
		StringTokenizer tok = new StringTokenizer(date, ", ");
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
		
		fDate = split[0]+"/"+split[1]+"/"+split[2];
		System.out.println("Month: "+split[0]);
		System.out.println("Day: "+split[1]);
		System.out.println("Year: "+split[2]);
		System.out.println(fDate);
		
		String a = "2";
		//char a = '2';
		String c = "swatch1";
		//String b = Integer.toString(a);
		System.out.println(c.substring(0,6)+a+c.substring(7));*/
		
		//SoftAssert ss = new SoftAssert();
		//ss.assertEquals("s", "ss");
		
		
			String s = "36.1";
			double ss = Double.parseDouble(s.replaceAll(",", ""));
			double sss = ss - 1.02;
			System.out.println("aw "+sss);

		
	}
}
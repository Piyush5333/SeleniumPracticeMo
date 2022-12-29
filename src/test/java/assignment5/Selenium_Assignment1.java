package assignment5;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium_Assignment1 
{

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(5000);
		
		List<String> Social_media_list = Get_Social_Media_Icons();  
		
        Verify_Current_URL(Get_Current_URL());

		Verify_Title(Get_Title());

		Verify_Logo(Get_Logo());
		
		Verify_Social_Media_Icons(Social_media_list);

		Set_URL_Links(Social_media_list);
		
	    Get_Youtube_Link(Social_media_list);	
		
	    driver.close();

	}

//This method fetch current URL	
	
	public static String Get_Current_URL() 
	{
		String CurrentURL = driver.getCurrentUrl();
		return CurrentURL;
	}

//This method fetch title	
	
	public static String Get_Title() 
	{
		String Title = driver.getTitle();

		return Title;
	}

//This method fetch logo's  
	
	public static List<WebElement> Get_Logo() 
	{
		List<WebElement> Logo_List = driver.findElements(By.xpath("//*[contains(@src,'ohrm_logo')]"));
		return Logo_List;
	}

//This method fetch socialmedia icons	
	
	public static List<String> Get_Social_Media_Icons() 
	{

		List<String> finallist = new ArrayList<String>();

		List<WebElement> fetched_List = driver.findElements(By.xpath("//a[@href]"));

		for (WebElement temp_list : fetched_List) 
		{

			String Str = temp_list.getAttribute("href");

			if (Str.contains("linked") || Str.contains("facebook") || Str.contains("twitter")|| Str.contains("youtube")) {

				finallist.add(Str);

			}
		}

		return finallist;
	}

//This method verifies title contains HRM
	
	public static void Verify_Title(String title)
	{
		if (title.contains("HRM")) 
		{
			System.out.println(title + " : title contains HRM");
		} 
		else 
		{
			System.out.println("Application title does not contain HRM");

		}
	}

//This method verifies Cuurent URL contains "login","demo"	
	
	public static void Verify_Current_URL(String CurrentURL) 
	{
		if (CurrentURL.endsWith("login")) 
		{
			System.out.println("Current URL contains login ");
		} 
		else 
		{
			System.out.println("Current URL is not login URL");

		}

		if (CurrentURL.contains("demo")) 
		{
			System.out.println("Current URl contains demo");
		} 
		else 
		{
			System.out.println("Current URl does not contain demo");
		}

	}

//This method verifies logo is present on page	
	
	public static void Verify_Logo(List<WebElement> List) 
	{
		if (List.size() != 0) 
		{
			System.out.println("Logo is Present");

		} 
		else 
		{
			System.out.println("Logo is not present");
		}
	}

//This method verifies social method icons are present on page	
	
	public static void Verify_Social_Media_Icons(List<String> finallist) 
	{
		if (finallist.size() != 0) 
		{
			System.out.println("Following Social media icons are Present :");
		
			for ( String printlist : finallist) 
			{
				System.out.println(printlist);

			}
		}

		else 
		{
			System.out.println("Social media icons are not present");
		}

	}
	
//This method maps Social media URL links	
	
	public static void Set_URL_Links(List<String> finallist)
	{
		Map<String, String> MapURL = new LinkedHashMap<String, String>();
		
		for(String maplist:finallist)
		{
			    if(maplist.contains("linked"))
			    {
			    	MapURL.put("Linked", maplist);
			    }	
			    else if(maplist.contains("facebook"))
			    {
			    	MapURL.put("Facebook", maplist);
			    }
			    else if(maplist.contains("twitter"))
			    {
			    	MapURL.put("Twitter", maplist);
			    }
			    else if(maplist.contains("youtube"))
			    {
			    	MapURL.put("Youtube", maplist);
			    }
			    
			    
		}	
		
		System.out.println(MapURL);
		
	}
//This method is used to break loop at youtube record 	

	public static void Get_Youtube_Link(List<String> finallist)
	{
		 for(String List : finallist)
		 {
			 if(List.contains("youtube"))
		     {
			     System.out.println("Youtube :"+List);	 
			     break;
		     } 
		 }	 
	}
}

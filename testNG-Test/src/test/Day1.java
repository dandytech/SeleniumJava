package test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Day1 {

	@Test
		public void demo1()
	{
		System.out.println("Hello Day1 Test 1");
	}
	
	
	@BeforeSuite	//this must run first in the entire package
	public void demo2()
	{
		System.out.println("Hello Day1 Test 2");
	}
	
	@Test(groups = {"third"}) 
	public void demo3()
	{
		System.out.println("Hello Day1 Test 3");
	}
	
	@Test(enabled=false) //you can use (disabled = true) to stop execution
	public void demo4()
	{
		System.out.println("Hello Day1 Test 3");
	}
	
	@Test(enabled=false)
	
	@Parameters ({"urllink"}) //call up parameter, global variable created in xml file
	
	public void demo5(String link)
	{
		System.out.println("Hello Day1 Test 3");
		
		System.out.println(link);
	}
	

	@Parameters ({"URL"}) //call up parameter, global variable created in xml file 
	
	@Test
	
	public void demo6(String link)
	{
		System.out.println("Hello Day1 Test 3");
		
		System.out.println(link);
	}
}

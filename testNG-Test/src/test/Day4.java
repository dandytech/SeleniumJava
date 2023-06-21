package test;

import org.testng.annotations.Test;

public class Day4 {

	@Test
		public void demo1()
	{
		System.out.println("Hello Day4 Test 1");
	}
	
	
	@Test
	public void demo2()
	{
		System.out.println("Hello Day4 Test 2");
	}
	
	@Test(groups = {"third"}) 
	public void demo3()
	{
		System.out.println("Hello Day4 Test 3");
	}

}

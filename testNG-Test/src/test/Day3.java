package test;

import org.testng.annotations.Test;

public class Day3 {

	@Test
		public void demo1()
	{
		System.out.println("Hello Day3 Test 1");
	}
	
	
	@Test
	public void demo2()
	{
		System.out.println("Hello Day3 Test 2");
	}
	
	@Test(groups = {"third"}) 
	public void demo3() 
	{
		System.out.println("Hello Day3 Test 3");
	}
	
	@Test(timeOut=400) //wait for 4sec before you fail if you must fail
	public void demo4()
{
	System.out.println("Hello Day3 Test 1");
}
}

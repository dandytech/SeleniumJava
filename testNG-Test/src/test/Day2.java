package test;

import org.testng.annotations.Test;

public class Day2 {

	@Test(dependsOnMethods = {"demo4"}) //demo3 must execute before demo1
		public void demo1()
	{
		System.out.println("Hello Day2 Test 1");
	}
	
	
	@Test
	public void demo2()
	{
		System.out.println("Hello Day2 Test 2");
	}
	
	@Test(groups = {"third"}) 
	public void demo3()
	{
		System.out.println("Hello Day2 Test 3");
	}
	
	@Test
	public void demo4()
	{
		System.out.println("Hello Day2 Test 4");
	}

}

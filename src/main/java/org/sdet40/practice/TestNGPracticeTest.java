package org.sdet40.practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
	@Test(priority=2)
	public void createCustomerTest() {
		System.out.println("execute HDFC creaeCustomerTest");
	}
	
	@Test(priority=-1)
	public void modifyCustomerTest (){
		System.out.println("execute HDFC modifyCustomerTest");
	}
	@Test(priority=1)
	public void deleteCustomerTest() {
		System.out.println("execute HDFC deleteCustomerTest");
	}
	
	@Test(invocationCount=4)
	public void sendAmount() {
		System.out.println("execute send amount 5k");
	}

}

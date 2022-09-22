package org.sdet40.practice;

import org.testng.annotations.Test;

public class GroupTestNgExcecution {
	@Test(groups={"smoke"})
	public void test1() {
		System.out.println("test case 1");
	}
	@Test(groups={"smoke","sanity"})
	public void test2() {
		System.out.println("test case 2");
	}
	
	@Test(groups={"smoke","regression"})
	public void test3() {
		System.out.println("test case 3");
	}
	
	@Test(groups={"sanity","integretion"})
	public void test4() {
		System.out.println("test case 4");
	}

}

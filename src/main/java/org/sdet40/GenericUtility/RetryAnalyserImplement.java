package org.sdet40.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplement implements IRetryAnalyzer {
	int count=0;
	int retryLimit=4;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}

}

package greenmouse.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count = 0;

	int maxTry = 1; // try rerun once again

	@Override
	public boolean retry(ITestResult result) {

		if (count < maxTry) {
			
			count ++;
			
			return true; //rerun if count is not max

		}
		return false;
	}

}

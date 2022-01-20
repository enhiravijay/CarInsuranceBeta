package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestNgListners  implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test is successfull" + " "+ result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("***** Error "+result.getName()+" test has failed *****");
		}


	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test onTestSkipped" + " "+ result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite started!");

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test onFinish" + " "+ context.getName());
		Reporter.log("Test is finished:" + context.getName());
	}



}

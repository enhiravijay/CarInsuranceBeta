package testCase001;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest {
	
	
	@Test
	public void retrylogictest() {
		Assert.assertTrue(false);
	}

	@Test
	public void casetwo() {
		Assert.assertTrue(true);
	}
}

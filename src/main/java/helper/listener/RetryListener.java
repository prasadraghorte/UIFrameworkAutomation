package helper.listener;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

public class RetryListener implements IAnnotationTransformer{

	/**
	 * Method for actually retry to happen.
	 */
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//IRetryAnalyzer is the interface which retryHelper has implemented
		IRetryAnalyzer retry = annotation.getRetryAnalyzer();
		if(retry == null)
			annotation.setRetryAnalyzer(RetryHelper.class);	
	}

}

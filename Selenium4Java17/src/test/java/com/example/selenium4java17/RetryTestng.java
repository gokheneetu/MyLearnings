package com.example.selenium4java17;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
public class RetryTestng implements IAnnotationTransformer {

    //Overriding the transform method to set the RetryAnalyzer
    public void transform(ITestAnnotation testAnnotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        Class<? extends IRetryAnalyzer> retry = testAnnotation.getRetryAnalyzerClass();
        if (retry == null)
            testAnnotation.setRetryAnalyzer(IRetryAnalyzer.class);
    }
}

package com.JunitTest.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	HomePageTest.class,
	Office365PageTest.class
})
public class JunitTestSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite(JunitTestSuite.class.getName());
		return suite;
	}
	/*public static Test suite() {
		TestSuite suite = new TestSuite();  
		suite.addTest(new JUnit4TestAdapter(Test1.class));  
		suite.addTest(new JUnit4TestAdapter(Test2.class));   
		suite.addTest(new JUnit4TestAdapter(Test3.class));  
		  
		suite.addTest(new JUnit4TestAdapter(TestSuite2.class));  
		return suite; 

	}*/

}

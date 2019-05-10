package tests.utilities;

import org.testng.*;
import org.testng.xml.XmlSuite;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestNGCustomReportClass implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String s) {
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> resultMap = suite.getResults();
            Set<String> key = resultMap.keySet();
            for (String k : key) {
                ITestContext testContext = resultMap.get(k).getTestContext();
                System.out.println("Suite Name- " + testContext.getName()
                        + "\n Report Directory- " + testContext.getOutputDirectory()
                        + "\n Test Suite Name- " + testContext.getSuite().getName()
                        + "\n Start Date and Time of Execution- " + testContext.getStartDate()
                        + "\n End Date and Time of Execution- " + testContext.getEndDate());
                Reporter.log("Suite Name- " + testContext.getName()
                        + "\n Report Directory- " + testContext.getOutputDirectory()
                        + "\n Test Suite Name- " + testContext.getSuite().getName()
                        + "\n Start Date and Time of Execution- " + testContext.getStartDate()
                        + "\n End Date and Time of Execution- " + testContext.getEndDate());
                IResultMap failedTest = testContext.getFailedTests();
                System.out.println("The no of Failed TestCases are" +failedTest);
                Reporter.log("The no of Failed TestCases are" +failedTest);
                IResultMap passedTest = testContext.getPassedTests();
                System.out.println("The no of Passed TestCases are" +passedTest);
                Reporter.log("The no of Failed TestCases are" +failedTest);
            }
        }
    }
}
package org.random.test.utils;

import org.random.test.tests.AbstractTest;
import org.reflections.Reflections;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestNgGenerator {

    private static final Reflections REFLECTIONS = new Reflections("org.random.test");

    public TestNG getTestNg() {
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(getSuites());
        return testNG;
    }

    private List<XmlSuite> getSuites() {
        return Collections.singletonList(getSuite());
    }

    private XmlSuite getSuite() {
        XmlSuite suite = new XmlSuite();
        suite.setName("Default Suite");
        List<XmlTest> tests = getXmlTests();
        tests.forEach(test -> test.setXmlSuite(suite));
        suite.setTests(tests);
        return suite;
    }

    private List<XmlTest> getXmlTests() {
        return REFLECTIONS.getSubTypesOf(AbstractTest.class).stream().map(XmlClass::new).map(this::createTest).collect(Collectors.toList());
    }

    private XmlTest createTest(XmlClass cls) {
        XmlTest test = new XmlTest();
        test.setName(cls.getName());
        test.setClasses(Collections.singletonList(cls));
        return test;
    }
}

package org.random.test;

import org.random.test.utils.TestNgGenerator;

public class TestExecutor {

    public static void main(String[] args) {
        new TestNgGenerator().getTestNg().run();
    }

}

package org.random.test.tests.numbers;

import org.random.test.pages.numbers.IntegerNumbersPage;
import org.random.test.tests.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class IntegersGenerationTest extends AbstractTest {

    @Test(dataProvider = "integerGenerationRequest")
    public void testIntegersGeneration(int rowSize, int min, int max, int resultsCount) {
        IntegerNumbersPage integerNumbersPage = new IntegerNumbersPage().get()
                .getIntegers(resultsCount, min, max, rowSize);

        verifyResults(integerNumbersPage.getResults(), rowSize, min, max, resultsCount);
    }

    @DataProvider
    private static Object[][] integerGenerationRequest() {
        return new Object[][] {
                {3, 1, 10, 30},
                {1, -10, -1, 15},
                {15, -10, 10, 100},
                {30, -10, 10, 10},
        };
    }

    private void verifyResults(List<List<Integer>> results, int rowSize, int min, int max, int resultsCount) {
        List<Integer> rowSizes = results.stream().map(List::size).collect(Collectors.toList());
        Integer[] sizes = new Integer[(resultsCount / rowSize) + (resultsCount % rowSize == 0 ? 0 : 1)];
        Arrays.fill(sizes, rowSize);
        sizes[sizes.length - 1] = resultsCount % rowSize == 0 ? rowSize : resultsCount % rowSize;
        List<Integer> expectedRowSizes = Arrays.asList(sizes);
        Assert.assertEquals(rowSizes, expectedRowSizes, "Incorrect row size in results: " + results);
        List<Integer> inlineResults = results.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<Integer> outOfBoundsValues = inlineResults.stream()
                .filter(value -> !(value <= max && value >= min))
                .collect(Collectors.toList());
        Assert.assertTrue(
                outOfBoundsValues.isEmpty(),
                String.format("Values out of bounds found: %s in results: %s", outOfBoundsValues, results));
        Assert.assertEquals(inlineResults.size(), resultsCount, "Incorrect results count");
    }


}

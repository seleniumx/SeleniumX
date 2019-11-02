package org.seleniumx.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataReaderTest {
    @Test
    public void testDataReader() {
        DataReader.reads().setFilePath("src/test/resources/Testdata.xlsx");
        String[] x = DataReader.reads().getData(1, 1);
        String[] result = {"Winterallee 3",
                "Musterstrasse 45",
                "Blaufeldweg 123B",
                "Am Bächle 23",
                "Auf der Vogelwiese 23 b",
                "4, rue de la revolution",
                "200 Broadway Av",
                "Calle Aduana, 29",
                "Calle 39 No 1540"};
        for (int i = 0; i < result.length; i++) {
            Assert.assertEquals(result[i], x[i]);
        }
    }
}

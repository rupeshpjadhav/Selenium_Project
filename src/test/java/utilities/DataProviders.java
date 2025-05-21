package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {


    @DataProvider(name="LoginData")
    public String[][] getData() throws IOException {
        String path = ".\\testData\\LoginTestData.xlsx";
        ExcelUtility xlutil = new ExcelUtility(path);
        int row_cnt = xlutil.getRowCount("LoginTestData");
        int col_cnt = xlutil.getCellCount("LoginTestData", 1);

        String[][] cellData = new String[row_cnt][col_cnt];

        for (int r = 1; r <= row_cnt; r++) {
            for (int c = 0; c < col_cnt; c++) {
                cellData[r - 1][c] = xlutil.getCellData("LoginTestData", r, c);
            }
        }

        return cellData;


    }
}


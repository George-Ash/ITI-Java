import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;

public class TablesawTitanic {
    static Table titanicData;
    static Table maritaldata;

    {
        try {
            maritaldata = Table.read().csv("src/main/resources/titanicmarital status.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String path = "src/main/resources/titanic.csv";

    public TablesawTitanic() {
    }

    public static void main(String[] args) {
        TablesawTitanic tt = new TablesawTitanic();

        try {
            tt.titanicData = tt.loadDataFromCVS(tt.path);
            String structure = tt.getDataInfoStructure(tt.titanicData);
            System.out.println(structure);
            System.in.read();
            String summary = tt.getDataSummary(tt.titanicData);
            System.out.println(summary);
            System.in.read();
            Table dataWithDate = tt.addDateColumnToData(tt.titanicData);
            System.out.println("=====================================================================================");
            System.out.println(dataWithDate.structure());
            System.in.read();
            Table sortedData = dataWithDate.sortAscendingOn(new String[]{"Fake Date"});
            System.out.println("Printing the first rows of the table");
            System.in.read();
            Table firstTenRows = sortedData.first(50);
            System.out.println(firstTenRows);
            System.in.read();
            Table mappedData = tt.mapTextColumnToNumber(tt.titanicData);
            Table firstFiveRows = mappedData.first(5);
            System.out.println("=====================================================================================");
            System.out.println(firstFiveRows);

            Table TotalData=titanicData.append(maritaldata);


        } catch (IOException var9) {
            var9.printStackTrace();
        }

    }

    public Table loadDataFromCVS(String path) throws IOException {
        Table titanicData = Table.read().csv(path);
        return titanicData;
    }

    public String getDataInfoStructure(Table data) {
        Table dataStructure = data.structure();
        return dataStructure.toString();
    }

    public String getDataSummary(Table data) {
        Table summary = data.summary();
        return summary.toString();
    }

    public Table addDateColumnToData(Table data) {
        int rowCount = data.rowCount();
        List<LocalDate> dateList = new ArrayList();

        for(int i = 0; i < rowCount; ++i) {
            dateList.add(LocalDate.of(2021, 3, i % 31 == 0 ? 1 : i % 31));
        }

        DateColumn dateColumn = DateColumn.create("Fake Date", dateList);
        data.insertColumn(data.columnCount(), dateColumn);
        return data;
    }

    public Table mapTextColumnToNumber(Table data) {
        NumberColumn mappedGenderColumn = null;
        StringColumn gender = (StringColumn)data.column("Sex");
        List<Number> mappedGenderValues = new ArrayList();
        Iterator var5 = gender.iterator();

        while(true) {
            while(var5.hasNext()) {
                String v = (String)var5.next();
                if (v != null && v.equals("female")) {
                    mappedGenderValues.add(new Double(1.0D));
                } else {
                    mappedGenderValues.add(new Double(0.0D));
                }
            }

            mappedGenderColumn = DoubleColumn.create("gender", mappedGenderValues);
            data.addColumns(new Column[]{mappedGenderColumn});
            return data;
        }
    }
}
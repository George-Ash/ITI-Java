import java.io.IOException;
import java.io.PrintStream;
import java.util.ListIterator;
import java.util.Objects;
import joinery.DataFrame;

public class JoineryExample {
    public JoineryExample() {
    }

    public static void main(String[] args) {
        try {
            DataFrame<Object> df = DataFrame.readCsv("src/main/resources/titanic.csv").retain(new Object[]{"pclass", "survived", "name", "sex","age","sibsp","parch","ticket","fare","cabin","embarked","boat","body","home.dest"});
            DataFrame<Object> describe =df.describe();
            System.out.println(describe.toString());
            df.iterrows().forEachRemaining( System.out::println);
            System.out.println("=========================================================================================");
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }
}
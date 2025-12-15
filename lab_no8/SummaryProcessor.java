package lab_no8;
import java.util.List;

@DataProcessor
public class SummaryProcessor implements Processor {

    @Override
    public List<String> process(List<String> data) {
        long count = data.size();
        long unique = data.stream().distinct().count();

        return List.of(
                "SUMMARY",
                "LINES: " + count,
                "UNIQUE: " + unique
        );
    }
}
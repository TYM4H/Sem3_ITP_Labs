package lab_no8;
import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class UpperCaseProcessor implements Processor {

    @Override
    public List<String> process(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
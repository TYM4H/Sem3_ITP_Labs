package lab_no8;
import java.util.List;
import java.util.stream.Collectors;

@DataProcessor
public class FilterShortLines implements Processor {

    @Override
    public List<String> process(List<String> data) {
        return data.stream()
                .map(String::trim)
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
    }
}
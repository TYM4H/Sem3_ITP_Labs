package lab_no8;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class DataManager {

    private final List<String> data = new ArrayList<>();
    private final List<Processor> processors = new ArrayList<>();
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public void registerDataProcessor(Processor p) {
        if (!p.getClass().isAnnotationPresent(DataProcessor.class)) {
            throw new IllegalArgumentException("Класс " + p.getClass().getName() + " не помечен @DataProcessor");
        }
        processors.add(p);
    }

    public void loadData(String source) throws IOException {
        data.clear();
        data.addAll(Files.readAllLines(Path.of(source)));
        System.out.println("Загружено строк: " + data.size());
    }

    public void processData() {
        if (processors.isEmpty()) {
            System.out.println("Нет обработчиков!");
            return;
        }

        List<Future<List<String>>> results = processors.stream()
                .map(p -> executor.submit(() -> p.process(new ArrayList<>(data))))
                .collect(Collectors.toList());

        // собираем всё в новый список, НЕ ЗАТИРАЯ ИСХОДНЫЕ данные раньше времени
        List<String> combined = new ArrayList<>();

        for (Future<List<String>> f : results) {
            try {
                combined.addAll(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        data.clear();
        data.addAll(combined);

        System.out.println("После обработки строк: " + data.size());
    }

    public void saveData(String dest) throws IOException {
        Files.write(Path.of(dest), data);
        System.out.println("Сохранено в файл: " + dest);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
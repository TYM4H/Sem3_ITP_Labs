package lab_no8;
public class Main {
    public static void main(String[] args) throws Exception {

        DataManager dm = new DataManager();

        dm.registerDataProcessor(new FilterShortLines());
        dm.registerDataProcessor(new UpperCaseProcessor());
        dm.registerDataProcessor(new SummaryProcessor());

        dm.loadData("input.txt");
        dm.processData();
        dm.saveData("output.txt");

        dm.shutdown();
    }
}

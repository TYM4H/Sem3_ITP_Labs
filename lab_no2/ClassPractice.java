package lab_no2;

public class ClassPractice {
    public static void main(String[] args) {

        System.out.println("Создано объектов до: " + HouseholdAppliances.getCounter());

        Refrigerator r = new Refrigerator();
        DishWasher d = new DishWasher("Bosch", "DW100", 1800, true, "eco", 60);
        VacuumCleaner v = new VacuumCleaner("Dyson", "V11", 500, false, false, "turbo");

        System.out.println("Создано объектов после: " + HouseholdAppliances.getCounter());
        System.out.println("----");

        //холодильник
        r.printInfo();
        r.selfTest();
        r.defrost();
        r.superFreeze();
        System.out.println("-----");

        //посудомойка
        d.printInfo();
        d.selfTest();
        d.changeProgram("intensive");
        System.out.println("-----");

        //пылесос
        v.printInfo();
        v.selfTest();
        v.cleanContainer();
        v.setCleaningMode("silent");
        System.out.println("-----");
    }
}

abstract class HouseholdAppliances {
    private String brand;
    private String model;
    private int power;
    private boolean isOn;
    private static int counter = 0;

    public HouseholdAppliances() {
        this.brand = "Неизвестный бренд";
        this.model = "Модель неизвестна";
        this.power = 0;
        this.isOn = false;
        counter++;
    }
    public HouseholdAppliances(String brand, String model, int power, boolean isOn) {
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.isOn = isOn;
        counter++;
    }

    //геттеры
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }

    //обычные методы
    public void turnOn() {
        isOn = true;
    }
    public void turnOff() {
        isOn = false;
    }

    public abstract void selfTest();

    public void printInfo() {
        System.out.println("Бренд: " + getBrand());
        System.out.println("Модель: " + getModel());
        System.out.println("Мощность: " + getPower() + " Вт");
        System.out.println("Состояние: " + (isOn() ? "Включено" : "Выключено"));
    }

    public static int getCounter() {
        return counter;
    }
}


class Refrigerator extends HouseholdAppliances {
    private int temperature;
    private int volume;
    private boolean hasFreezer;
    
    public Refrigerator() {
        super();
        this.temperature = 4;
        this.volume = 300;
        this.hasFreezer = false;
    }
    public Refrigerator(String model, String brand, int power, boolean isOn, int temperature, int volume, boolean hasFreezer) {
    super(brand, model, power, isOn);
    this.temperature = temperature;
    this.volume = volume;
    this.hasFreezer = hasFreezer;
    }

    public int getTemperature() {
        return temperature;
    }
    public int getVolume() {
        return volume;
    }
    public boolean havingFreezer() {
        return hasFreezer;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void defrost() {
        if (isOn()) {
            System.out.println("Начинается разморозка холодильника...");
            this.setTemperature(10);
            this.turnOff();
            System.out.println("Холодильник разморожен, включите его снова после уборки воды.");
        } else {
            System.out.println("Холодильник уже выключен.");
        }
    }

    public void superFreeze() {
        if (isOn()) {
            this.setTemperature(-18);
            System.out.println("Включен режим суперзаморозки");
        } else {
            System.out.println("Нельзя сменить режим - холодильник выключен");
        }
    }

    @Override
    public void selfTest() {
        System.out.println("Запуск диагностики холодильника");
        if (temperature > -30 && temperature < 10 && isOn()) {
            System.out.println("Холодильник в порядке");
        } else {
            System.out.println("Датчик температуры неисправен или холодильник выключен");
        }
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Температура: " + temperature + "C");
        System.out.println("Объём: " + volume + " л");
        System.out.println("Морозильная камера: " + (hasFreezer ? "есть" : "нет"));
    }
}


class DishWasher extends HouseholdAppliances {
    private String program;
    private int volume;

    public DishWasher() {
        super();
        this.program = "auto";
        this.volume = 75;
    }
    public DishWasher(String model, String brand, int power, boolean isOn, String program, int volume) {
        super(brand, model, power, isOn);
        this.program = program;
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
    public String getProgram() {
        return program;
    }

    public void changeProgram(String program) {
        this.program = program;
        System.out.println("Программа изменена на " + getProgram());
    }

    @Override
    public void selfTest() {
        System.out.println("Проведена системная диагностика");
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Программа: " + program);
        System.out.println("Вместимость: " + volume + " л");
    }
    
}

class VacuumCleaner extends HouseholdAppliances {
    private boolean isEmpty;
    private String cleaningMode;

    public VacuumCleaner() {
        super();
        isEmpty = true;
        cleaningMode = "normal";
    }
    public VacuumCleaner(String brand, String model, int power, boolean isOn, boolean isEmpty, String cleaningMode) {
        super(brand, model, power, isOn);
        this.isEmpty = isEmpty;
        this.cleaningMode = cleaningMode;
    }

    public String getCleaningMode() {
        return cleaningMode;
    }

    public void cleanContainer() {
        this.isEmpty = true;
        System.out.println("Контейнер очищен");
    }

    public void setCleaningMode(String cleaningMode) {
        this.cleaningMode = cleaningMode;
        System.out.println("Режим изменен на " + getCleaningMode());
    }

    @Override
    public void selfTest() {
        cleanContainer();
        setCleaningMode("auto");
        System.out.println("Проведена диагостика, очищен контейнер, режим изменен на " + getCleaningMode());
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Режим уборки: " + cleaningMode);
        System.out.println("Контейнер пуст: " + (isEmpty ? "да" : "нет"));
    }
}

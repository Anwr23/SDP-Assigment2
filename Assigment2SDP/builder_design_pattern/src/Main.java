package builder_design_pattern;

// Класс Vehicle - это класс, который мы собираем с помощью паттерна "Строитель".
class Vehicle {
    private String engine;
    private int wheel;
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    // Приватный конструктор класса Vehicle, который принимает объект VehicleBuilder для построения экземпляра класса Vehicle.
    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    // Статический внутренний класс VehicleBuilder используется для построения экземпляров класса Vehicle.
    public static class VehicleBuilder {
        private String engine;
        private int wheel;
        private int airbags;

        // Конструктор VehicleBuilder принимает обязательные параметры для создания экземпляра класса Vehicle.
        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        // Метод setAirbags используется для установки дополнительных параметров (по умолчанию 0).
        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        // Метод build создает экземпляр класса Vehicle на основе текущего состояния VehicleBuilder.
        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // Создание экземпляров класса Vehicle с использованием паттерна "Строитель".
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        // Вывод информации о созданных транспортных средствах.
        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}

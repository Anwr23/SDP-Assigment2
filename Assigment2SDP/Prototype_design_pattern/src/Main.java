class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        // Заполняем список vehicleList некоторыми данными.
        vehicleList.add("Honda amaze");
        vehicleList add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // Реализация метода clone для создания глубокой копии объекта Vehicle.
        List<String> tempList = new ArrayList<String>();

        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Создание и заполнение исходного объекта Vehicle.
        Vehicle a = new Vehicle();
        a.insertData();

        // Создание копии объекта Vehicle.
        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze");

        // Вывод данных из исходного объекта и его копии.
        System.out.println(a.getVehicleList());
        System.out.println(list);

        // Удаление элемента из копии и проверка, что это не влияет на исходный объект.
        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList());
    }
}

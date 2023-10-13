package observer_design_pattern;

// Интерфейс Subject определяет методы для регистрации, отмены регистрации и уведомления наблюдателей.
interface Subject {
    void register(Observer obj);
    void unregister(Observer obj);
    void notifyObservers();
}

// Класс DeliveryData реализует интерфейс Subject и представляет субъект, о котором наблюдают.
class DeliveryData implements Subject {
    private List<Observer> observers;
    private String location;

    public DeliveryData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update(location);
        }
    }

    public void locationChanged() {
        this.location = getLocation();
        notifyObservers();
    }

    public String getLocation() {
        return "YPlace";
    }
}

// Интерфейс Observer определяет метод для обновления наблюдателей.
interface Observer {
    void update(String location);
}

// Класс Seller реализует интерфейс Observer и представляет наблюдателя "Продавец".
class Seller implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Seller - Current Location: " + location);
    }
}

// Класс User также реализует интерфейс Observer и представляет наблюдателя "Пользователь".
class User implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at User - Current Location: " + location);
    }
}

// Класс DeliveryWarehouseCenter также реализует интерфейс Observer и представляет наблюдателя "Центр по доставке".
class DeliveryWarehouseCenter implements Observer {
    private String location;

    @Override
    public void update(String location) {
        this.location = location;
        showLocation();
    }

    public void showLocation() {
        System.out.println("Notification at Warehouse - Current Location: " + location);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        // Создание субъекта DeliveryData и наблюдателей Seller, User и DeliveryWarehouseCenter.
        DeliveryData topic = new DeliveryData();

        Observer obj1 = new Seller();
        Observer obj2 = new User();
        Observer obj3 = new DeliveryWarehouseCenter();

        // Регистрация наблюдателей у субъекта.
        topic.register(obj1);
        topic.register(obj2);
        topic.register(obj3);

        // Изменение местоположения субъекта и уведомление наблюдателей.
        topic.locationChanged();
        topic.unregister(obj3);

        System.out.println();
        topic.locationChanged();
    }
}

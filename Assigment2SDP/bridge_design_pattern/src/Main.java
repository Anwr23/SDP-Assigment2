package bridge_design_pattern;

// Абстрактный класс TV, который связан с объектом Remote.
abstract class TV {
    Remote remote;

    TV(Remote r) {
        this.remote = r;
    }

    abstract void on();
    abstract void off();
}

// Класс Sony, наследующийся от TV и ассоциированный с конкретным объектом Remote.
class Sony extends TV {
    Remote remoteType;

    Sony(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Sony TV ON: ");
        remoteType.on();
    }

    public void off() {
        System.out.print("Sony TV OFF: ");
        remoteType.off();
    }
}

// Класс Philips, также наследующийся от TV и ассоциированный с конкретным объектом Remote.
class Philips extends TV {
    Remote remoteType;

    Philips(Remote r) {
        super(r);
        this.remoteType = r;
    }

    public void on() {
        System.out.print("Philips TV ON: ");
        remoteType.on();
    }

    public off() {
        System.out.print("Philips TV OFF: ");
        remoteType.off();
    }
}

// Интерфейс Remote с методами on() и off().
interface Remote {
    public void on();
    public void off();
}

// Класс OldRemote, реализующий интерфейс Remote и определяющий старый способ включения и выключения.
class OldRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with Old Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with Old Remote");
    }
}

// Класс NewRemote, также реализующий интерфейс Remote и определяющий новый способ включения и выключения.
class NewRemote implements Remote {
    @Override
    public void on() {
        System.out.println("ON with New Remote");
    }

    @Override
    public void off() {
        System.out.println("OFF with New Remote");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        // Создаем экземпляры TV с разными комбинациями брендов (Sony, Philips) и пультов (OldRemote, NewRemote).
        TV sonyOldRemote = new Sony(new OldRemote());
        sonyOldRemote.on();
        sonyOldRemote.off();
        System.out.println();

        TV sonyNewRemote = new Sony(new NewRemote());
        sonyNewRemote.on();
        sonyNewRemote.off();
        System.out.println();

        TV philipsOldRemote = new Philips(new OldRemote());
        philipsOldRemote.on();
        philipsOldRemote.off();
        System.out.println();

        TV philipsNewRemote = new Philips(new NewRemote());
        philipsNewRemote.on();
        philipsNewRemote.off();
    }
}

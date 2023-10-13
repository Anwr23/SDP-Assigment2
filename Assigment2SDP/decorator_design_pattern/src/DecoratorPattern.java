package decorator_design_pattern;

// интерфейс Dress для определения функции assemble
interface Dress {
    public void assemble();
}

// класс BasicDress, который реализует интерфейс Dress и определяет базовые характеристики одежды
class BasicDress implements Dress {
    @Override
    public void assemble() {
        System.out.println("Basic Dress Features");
    }
}

// абстрактный класс DressDecorator, реализует интерфейс Dress.
class DressDecorator implements Dress {
    protected Dress dress;

    // rонструктор класса DressDecorator, принимает другой объект Dress в качестве параметра.
    public DressDecorator(Dress c) {
        this.dress = c;
    }

    @Override
    public void assemble() {
        this.dress.assemble();
    }
}

// класс CasualDress, который наследуется от DressDecorator и добавляет к базовой одежде характеристики casual
class CasualDress extends DressDecorator {
    public CasualDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Casual Dress Features");
    }
}

// класс SportyDress, который наследует DressDecorator и добавляется к базовой спортивной одежде
class SportyDress extends DressDecorator {
    public SportyDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Sporty Dress Features");
    }
}

// класс FancyDress, который наследуется от DressDecorator и добавляет к базовой одежде характеристики элегантной одежды.
class FancyDress extends DressDecorator {
    public FancyDress(Dress c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("Adding Fancy Dress Features");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // создаем экземпляры различных видов одежды и демонстрируем использование паттерна декоратора
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        System.out.println();

        Dress fancyDress = new FancyDress(new BasicDress());
        fancyDress.assemble();
        System.out.println();

        Dress casualDress = new CasualDress(new BasicDress());
        casualDress.assemble();
        System.out.println();

        Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyFancyDress.assemble();
        System.out.println();

        Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
        casualFancyDress.assemble();
    }
}

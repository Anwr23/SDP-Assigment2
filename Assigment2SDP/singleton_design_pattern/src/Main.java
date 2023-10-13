package singleton_design_pattern;


// SingletonEagar это реализация паттерна Singleton, где экземпляр объекта создается немедленно при загрузке класса
class SingletonEagar
{
    private static SingletonEagar instance = new SingletonEagar();
    private SingletonEagar()
    {

    }
    public static SingletonEagar getInstance()
    {
        return instance;
    }
}



//  это реализация Singleton с отложенной инициализацией
//  Экземпляр объекта создается только при первом вызове метода getInstance
class Singleton
{
    private static Singleton instance;
    private Singleton()
    {

    }
    public static Singleton getInstance()
    {
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
}



// это реализация Singleton с отложенной инициализацией, где метод getInstance синхронизирован
class SingletonSynchronizedMethod
{
    private static SingletonSynchronizedMethod instance;
    private SingletonSynchronizedMethod()
    {

    }
    public static synchronized SingletonSynchronizedMethod getInstance()
    {
        if(instance == null)
        {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}


// SingletonSynchronized реализация Singleton с отложенной инициализацией и двойной проверкой блокировки
class SingletonSynchronized
{
    private static SingletonSynchronized instance;
    private SingletonSynchronized()
    {

    }
    public static SingletonSynchronized getInstance()
    {
        if(instance == null)
        {
            synchronized (SingletonSynchronized.class)
            {
                if(instance == null)
                {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}


// создается объект Singleton с использованием метода getInstance, и его идентификатор выводится на консоль
public class SingletonPattern
{
    public static void main(String[] args)
    {
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance);
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1);
    }
}
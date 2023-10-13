package adapter_design_pattern;

// интерфейс WebDriver с методами для получения элемента и выбора элемента
interface WebDriver
{
    public void getElement();
    public void selectElement();
}

// класс ChromeDriver, который реализует интерфейс WebDriver и определяет методы для работы с элементами в Chrome
class ChromeDriver implements WebDriver
{
    @Override
    public void getElement()
    {
        System.out.println("Get element from ChromeDriver");
    }

    @Override
    public void selectElement()
    {
        System.out.println("Select element from ChromeDriver");
    }
}

// класс IEDriver, который предоставляет свои собственные методы для работы с элементами в Internet Explorer
class IEDriver
{
    public void findElement()
    {
        System.out.println("Find element from IEDriver");
    }

    public void clickElement()
    {
        System.out.println("Click element from IEDriver");
    }
}

// класс WebDriverAdapter, который реализует интерфейс WebDriver и адаптирует IEDriver, чтобы он соответствовал интерфейсу WebDriver
class WebDriverAdapter implements WebDriver
{
    IEDriver ieDriver;

    // Конструктор класса, который принимает экземпляр IEDriver в качестве параметр
    public WebDriverAdapter(IEDriver ieDriver)
    {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement()
    {
        // Метод getElement адаптирует IEDriver, вызывая его метод findElement
        ieDriver.findElement();
    }

    @Override
    public void selectElement()
    {
        // Метод selectElement адаптирует IEDriver, вызывая его метод clickElement.
        ieDriver.clickElement();
    }
}

public class AdapterPattern
{
    public static void main(String[] args)
    {
        // Создаем экземпляр ChromeDriver и демонстрируем его функциональность
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();

        // Создаем экземпляр IEDriver и демонстрируем его функциональность.
        IEDriver e = new IEDriver();
        e.findElement();
        e.clickElement();

        // Создаем адаптер WebDriverAdapter для IEDriver и демонстрируем его функциональность
        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement();
        wID.selectElement();
    }
}

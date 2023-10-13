package proxy_design_pattern;

// Интерфейс DatabaseExecuter определяет метод executeDatabase
interface DatabaseExecuter
{
    public void executeDatabase(String query) throws Exception;
}

// Класс DatabaseExecuterImpl реализует интерфейс DatabaseExecuter и предоставляет реализацию метода executeDatabase
class DatabaseExecuterImpl implements DatabaseExecuter
{
    @Override
    public void executeDatabase(String query) throws Exception
    {
        System.out.println("Going to execute Query: " + query);
    }
}


// Класс DatabaseExecuterProxy является прокси для выполнения запросов к базе
// данных. Он проверяет, является ли пользователь администратором, и в зависимости
// от этого либо выполняет запрос, либо выдает исключение, если запрос "DELETE" и
// пользователь не администратор.
class DatabaseExecuterProxy implements DatabaseExecuter
{
    boolean ifAdmin;
    DatabaseExecuterImpl dbExecuter;

    public DatabaseExecuterProxy(String name, String passwd)
    {
        if(name == "Admin" && passwd == "Admin@123")
        {
            ifAdmin = true;
        }
        dbExecuter = new DatabaseExecuterImpl();
    }

    @Override
    public void executeDatabase(String query) throws Exception
    {
        if(ifAdmin)
        {
            dbExecuter.executeDatabase(query);
        }
        else
        {
            if(query.equals("DELETE"))
            {
                throw new Exception("DELETE not allowed for non-admin user");
            }
            else
            {
                dbExecuter.executeDatabase(query);
            }
        }
    }
}


// В методе main создаются различные объекты прокси DatabaseExecuterProxy и пытаются выполнить запросы к базе данных
public class ProxyPattern
{
    public static void main(String[] args) throws Exception
    {
        DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuter.executeDatabase("DELEE");

        DatabaseExecuter nonAdminExecuterDELETE = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
        nonAdminExecuterDELETE.executeDatabase("DELETE");

        DatabaseExecuter adminExecuter = new DatabaseExecuterProxy("Admin", "Admin@123");
        adminExecuter.executeDatabase("DELETE");
    }
}
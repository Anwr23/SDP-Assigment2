package flyweight_design_pattern;

// Интерфейс Employee определяет методы, которые будут реализованы разными типами сотрудников.
interface Employee {
    public void assignSkill(String skill);
    public void task();
}

// Класс Developer реализует интерфейс Employee и представляет сотрудника-разработчика.
class Developer implements Employee {
    private final String JOB;
    private String skill;

    public Developer() {
        JOB = "Fix the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }
}

// Класс Tester также реализует интерфейс Employee и представляет сотрудника-тестировщика.
class Tester implements Employee {
    private final String JOB;
    private String skill;

    public Tester() {
        JOB = "Test the issue";
    }

    @Override
    public void assignSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }
}

// Класс EmployeeFactory отвечает за создание сотрудников с учетом их типов и повторного использования.
class EmployeeFactory {
    private static HashMap<String, Employee> m = new HashMap<String, Employee>();

    public static Employee getEmployee(String type) {
        Employee p = null;
        if (m.get(type) != null) {
            p = m.get(type);
        } else {
            switch (type) {
                case "Developer":
                    System.out.println("Developer Created");
                    p = new Developer();
                    break;
                case "Tester":
                    System.out.println("Tester Created");
                    p = new Tester();
                    break;
                default:
                    System.out.println("No Such Employee");
            }

            m.put(type, p);
        }
        return p;
    }
}

public class FlyweightPattern {
    // Определение массивов с типами сотрудников и навыками.
    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args) {
        // Главный метод, который будет выполняться при запуске программы.
        for (int i = 0; i < 10; i++) {
            // В цикле создаются и используются объекты сотрудников.
            Employee e = EmployeeFactory.getEmployee(getRandEmployee());
            // Присваивание случайного навыка каждому сотруднику.
            e.assignSkill(getRandSkill());
            // Выполнение задачи сотрудника.
            e.task();
        }
    }

    // Метод для получения случайного типа сотрудника.
    public static String getRandEmployee() {
        Random r = new Random();
        int randInt = r.nextInt(employeeType.length);
        return employeeType[randInt];
    }

    // Метод для получения случайного навыка.
    public static String getRandSkill() {
        Random r = new Random();
        int randInt = r.nextInt(skills.length);
        return skills[randInt];
    }
}

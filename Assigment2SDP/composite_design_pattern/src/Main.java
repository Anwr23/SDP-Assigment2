package composite_design_pattern;

// Абстрактный класс Account, который будет использоваться для всех видов счетов.
abstract class Account {
    public abstract float getBalance();
}

// Класс DepositeAccount, наследуемый от Account, представляет счет с фиксированным депозитом.
class DepositeAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public DepositeAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

// Класс SavingAccount, также наследуемый от Account, представляет сберегательный счет.
class SavingAccount extends Account {
    private String accountNo;
    private float accountBalance;

    public SavingAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

// Класс CompositeAccount, также наследуется от Account, представляет композитный (составной) счет, который объединяет несколько счетов.
class CompositeAccount extends Account {
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance() {
        totalBalance = 0;
        for (Account acc : accountList) {
            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account acc) {
        accountList.add(acc);
    }

    public void removeAccount(Account acc) {
        accountList.add(acc);
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        // Создаем композитный счет и добавляем несколько субсчетов.
        CompositeAccount composite = new CompositeAccount();
        composite.addAccount(new DepositeAccount("DA001", 100));
        composite.addAccount(new DepositeAccount("DA002", 150));
        composite.addAccount(new SavingAccount("SA001", 200));

        // Получаем общий баланс композитного счета и выводим его.
        float totalBalance = composite.getBalance();
        System.out.println("Total Balance : " + totalBalance);
    }
}

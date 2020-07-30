import java.util.concurrent.Semaphore;

public class PerfectRobbery {
    private Semaphore bankAccount = new Semaphore(-42);

    public static void main(String[] args) {
        PerfectRobbery perfectRobbery = new PerfectRobbery();
        perfectRobbery.takeAllMoney();
        perfectRobbery.checkBalance();
    }
    public void takeAllMoney() {
        bankAccount.drainPermits();
    }
    public void checkBalance() {
        System.out.println(bankAccount.availablePermits());
    }
}


/*Каков будет результат выполнения данного кода
Варианты ответов
a) IllegalArgumentException - Semaphore не может выть создан с отрицательным балансом
b) UnsupportedOperationException - нельзя снимать при отрицательном балансе
c) 0
d) -42



Правильный ответ c.
drainPermits - возвращает все available permits, и он может быть отрицательным
с учетом того что available permits - отрицательное значение, следовательно доступно 0,
потому что доступно отрицательное значение не может быть.
После открытия Bug JDK8169272 было принято решение ничего не менять :)

 */


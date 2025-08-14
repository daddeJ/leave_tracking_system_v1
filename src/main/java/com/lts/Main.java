import domain.models.Employee;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Dexter Morgan", "Foreignsic", "dexter@morgan.com");
        System.out.println(employee1);
    }
}

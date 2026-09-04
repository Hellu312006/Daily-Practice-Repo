package Day_16;

class Employee {
    void work() {
        System.out.println("Employee is working on assigned tasks.");
    }
}

class Manager extends Employee {
    @Override
    void work() {
        System.out.println("Manager is managing projects and leading the team.");
    }
}

public class practical_169 {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.work();

        Manager mgr = new Manager();
        mgr.work();
    }
}

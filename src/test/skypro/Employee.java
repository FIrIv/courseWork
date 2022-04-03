package test.skypro;

public class Employee {
    private static int countOfEmployees;
    private String firstName;
    private String secondName;
    private String surname;
    private int department; // значения отделов - от 1 до 5
    private int salary;
    private int id;

    public Employee (String surname1, String firstName1, String secondName1, int department1, int salary1) {
        countOfEmployees++;
        this.id = countOfEmployees;
        this.firstName = firstName1;
        this.secondName = secondName1;
        this.surname = surname1;
        if (department1 >=1 && department1 <= 5) this.department = department1;
        else this.department = 0;
        this.salary = salary1;
    }

    public static int getCountOfEmployees () {
        return countOfEmployees;
    }

    public String getName () {
        return this.surname + " " + this.firstName + " " + this.secondName;
    }

    public int getDepartment () {
        return this.department;
    }

    public int getSalary () {
        return this.salary;
    }

    public int getId () {
        return this.id;
    }

    public void setDepartment (int department1) {
        if (department1 >=1 && department1 <= 5) this.department = department1;
        else this.department = 0;
    }

    public void setSalary (int salary1) {
        this.salary = salary1;
    }

    @Override
    public String toString () {
        return this.getId() + ". " + this.getName() + ", отдел №" + this.getDepartment() + ", оклад " + this.getSalary() + " руб.";
    }
}

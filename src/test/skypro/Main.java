package test.skypro;

public class Main {

    public static int generateFromToRandom (int min, int max) {
        java.util.Random random = new java.util.Random();
        int elem;
        elem = random.nextInt(max-min+1) + min;
        return elem;
    }

    public static void printAllAboutEmployees (Employee [] emps) {
        for (int i=0; i<emps.length; i++) {
            System.out.println(emps[i].toString());
        }
    }

    public static int countSalaries (Employee [] emps) {
        int salary = 0;
        for (int i=0; i<emps.length; i++) {
            salary += emps[i].getSalary();
        }
        return salary;
    }

    public static Employee findMinSalaryEmployee (Employee [] emps) {
        int minSalary = 0;
        int index = -1;
        if (Employee.getCountOfEmployees() > 0) {
            minSalary = emps[0].getSalary();
            index = 0;
        }
        else return null;
        for (int i=1; i<emps.length; i++) {
            if (emps[i].getSalary() < minSalary) {
                minSalary = emps[i].getSalary();
                index = i;
            }
        }
        return emps[index];
    }

    public static Employee findMaxSalaryEmployee (Employee [] emps) {
        int maxSalary = 0;
        int index = -1;
        if (Employee.getCountOfEmployees() > 0) {
            maxSalary = emps[0].getSalary();
            index = 0;
        }
        else return null;
        for (int i=1; i<emps.length; i++) {
            if (emps[i].getSalary() > maxSalary) {
                maxSalary = emps[i].getSalary();
                index = i;
            }
        }
        return emps[index];
    }

    public static float countAverageSalary (Employee[] emps) {
        return (float) countSalaries(emps) / (float) emps.length;
    }

    public static void printNamesOfEmployees (Employee [] emps) {
        for (int i=0; i<emps.length; i++) {
            System.out.println(emps[i].getName());
        }
    }

    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Амагаев","Дмитрий","Анатольевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[1] = new Employee("Белобородова","Елена","Александровна",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[2] = new Employee("Волков","Андрей","Михайлович",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[3] = new Employee("Губин","Андрей","Николаевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[4] = new Employee("Донской","Артем","Витальевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[5] = new Employee("Ефимова","Екатерина","Александровна",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[6] = new Employee("Жанчипов","Алексадр","Евгеньевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[7] = new Employee("Зяблов","Александрр","Александрович",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[8] = new Employee("Иванов","Сергей","Миронович",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));
        employees[9] = new Employee("Кукушина","Анна","Владимировна",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000));

        // список сотрудников (вся информация)
        System.out.println("Информация о сотрудниках: ");
        printAllAboutEmployees(employees);
        System.out.println();

        // сумма всех зарплат
        System.out.println("Сумма всех зарплат за месяц: " + countSalaries(employees) + " руб. ");
        System.out.println();

        // сотрудник с мин. зп
        Employee temp = findMinSalaryEmployee(employees);
        System.out.println("Минимальная зарплата: " + temp.getSalary() + " руб. ");
        System.out.println("Сотрудник с минимальной зарплатой: " + temp.getName());
        System.out.println();

        // сотрудник с макс. зп
        temp = findMaxSalaryEmployee(employees);
        System.out.println("Максимальная зарплата: " + temp.getSalary() + " руб. ");
        System.out.println("Сотрудник с максимальной зарплатой: " + temp.getName());
        System.out.println();

        // средняя зп
        System.out.println("Средняя зарплата: " + countAverageSalary(employees) + " руб. ");
        System.out.println();

        // список Ф.И.О. сотрудников
        System.out.println("Сотрудники: ");
        printNamesOfEmployees(employees);
        System.out.println();
    }
}

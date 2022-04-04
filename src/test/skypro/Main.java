package test.skypro;

public class Main {

    public static int generateFromToRandom (int min, int max) {
        java.util.Random random = new java.util.Random();
        int elem;
        elem = random.nextInt(max-min+1) + min;
        return elem;
    }

    public static void main(String[] args) {
        EmployeeBook empBook = new EmployeeBook(10);
        empBook.addEmployee(new Employee("Амагаев","Дмитрий","Анатольевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Белобородова","Елена","Александровна",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Волков","Андрей","Михайлович",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Губин","Андрей","Николаевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Донской","Артем","Витальевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Ефимова","Екатерина","Александровна",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Жанчипов","Александр","Евгеньевич",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Зяблов","Александр","Александрович",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Иванов","Сергей","Миронович",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));
        empBook.addEmployee(new Employee("Кукушина","Анна","Владимировна",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));

        // список сотрудников (вся информация)
        System.out.println("Информация о сотрудниках: ");
        empBook.printAllAboutEmployees();
        System.out.println();

        // сумма всех зарплат
        System.out.println("Сумма всех зарплат за месяц: " + empBook.countSalaries() + " руб. ");
        System.out.println();

        // сотрудник с мин. зп
        Employee temp = empBook.findMinSalaryEmployee();
        if (temp != null) {
            System.out.println("Минимальная зарплата: " + temp.getSalary() + " руб. ");
            System.out.println("Сотрудник с минимальной зарплатой: " + temp.getName());
            System.out.println();
        }

        // сотрудник с макс. зп
        temp = empBook.findMaxSalaryEmployee();
        if (temp != null) {
            System.out.println("Максимальная зарплата: " + temp.getSalary() + " руб. ");
            System.out.println("Сотрудник с максимальной зарплатой: " + temp.getName());
            System.out.println();
        }

        // средняя зп
        System.out.println("Средняя зарплата: " + empBook.countAverageSalary() + " руб. ");
        System.out.println();

        // список Ф.И.О. сотрудников
        System.out.println("Сотрудники: ");
        empBook.printNamesOfEmployees();
        System.out.println();

        // индексация зарплаты на 5%
        float index = 0.05f;
        empBook.indexSalary(index);
        System.out.println("Информация о зарплатах после индексации на " + (index*100) + "% : ");
        empBook.printAllAboutEmployees();
        System.out.println();

        // по отделу!!!
        int department2 = 3;
        if (empBook.countEmployees(department2) == 0) {
            System.out.println("Отдел №" + department2 + " : сотрудники не найдены. ");
        } else {
            // список сотрудников (вся информация)
            System.out.println("Информация о сотрудниках отдела №" + department2 + " : ");
            empBook.printAllAboutEmployees(department2);
            System.out.println();

            // сумма всех зарплат
            System.out.println("Сумма всех зарплат за месяц отдела №" + department2 + " : " + empBook.countSalaries(department2) + " руб. ");
            System.out.println();

            // сотрудник с мин. зп
            temp = empBook.findMinSalaryEmployee(department2);
            System.out.println("Минимальная зарплата отдела №" + department2 + " : " + temp.getSalary() + " руб. ");
            System.out.println("Сотрудник с минимальной зарплатой отдела №" + department2 + " : " + temp.getName());
            System.out.println();

            // сотрудник с макс. зп
            temp = empBook.findMaxSalaryEmployee(department2);
            System.out.println("Максимальная зарплата отдела №" + department2 + " : " + temp.getSalary() + " руб. ");
            System.out.println("Сотрудник с максимальной зарплатой отдела №" + department2 + " : " + temp.getName());
            System.out.println();

            // средняя зп
            System.out.println("Средняя зарплата отдела №" + department2 + " : " + empBook.countAverageSalary(department2) + " руб. ");
            System.out.println();

            // индексация зарплаты на 5%
            index = 0.08f;
            empBook.indexSalary(index, department2);
            System.out.println("Информация о зарплатах отдела №" + department2 + " после индексации на " + (index*100) + "% : ");
            empBook.printAllAboutEmployees(department2);
            System.out.println();

            // сотрудники отдела с зп < ...
            int testSalary = 75_000;
            System.out.println("Сотрудники отдела №" + department2 + " с зарплатой ниже " + testSalary+ " руб. : ");
            empBook.printEmployeesWithSalaryBelow(testSalary, department2);
            System.out.println();

            // сотрудники отдела с зп >= ...
            System.out.println("Сотрудники отдела №" + department2 + " с зарплатой выше или равной " + testSalary+ " руб. : ");
            empBook.printEmployeesWithSalaryAboveOrEqual(testSalary, department2);
            System.out.println();
        }

        // удаление сотрудника
        // по фио
        String fioToFind = "Волков Андрей Михайлович";
        System.out.print("Удалить сотрудника : " + fioToFind + " : ");
        empBook.removeEmployee(fioToFind);

        // по фио и id
        fioToFind = "Амагаев Дмитрий Анатольевич";
        int idToFind = 1;
        System.out.print("Удалить сотрудника : " + fioToFind + ", id "+ idToFind + " : ");
        empBook.removeEmployee(fioToFind, idToFind);

        // по id
        idToFind = 0;
        System.out.print("Удалить сотрудника : id "+ idToFind + " : ");
        empBook.removeEmployee(idToFind);
        idToFind = 1;
        System.out.print("Удалить сотрудника : id "+ idToFind + " : ");
        empBook.removeEmployee(idToFind);
        idToFind = 9;
        System.out.print("Удалить сотрудника : id "+ idToFind + " : ");
        empBook.removeEmployee(idToFind);

        // добавление сотрудника, чтобы он сел в первое попавшееся место EmployeeBook
        empBook.addEmployee(new Employee("Савченко","Алеся","Игоревна",generateFromToRandom(1,5),generateFromToRandom(50_000,100_000)));

        // изменение зарплаты сотрудника по фио
        fioToFind = "Зяблов Александр Александрович";
        System.out.print("Изменить зарплату сотрудника : " + fioToFind + " : ");
        empBook.editEmployeeSalary(fioToFind, 110_000);

        // изменение отдела сотрудника по фио
        fioToFind = "Савченко Алеся Игоревна";
        System.out.print("Изменить отдел сотрудника : " + fioToFind + " : ");
        empBook.editEmployeeDepartment(fioToFind, 4);

        // информация о сотрудниках после всех изменений
        System.out.println();
        System.out.println("Обновленная информация о сотрудниках : ");
        empBook.printAllAboutEmployees();
        System.out.println();

        // список сотрудников по отделам
        System.out.println();
        System.out.println("Список сотрудников по отделам. ");
        empBook.printEmployeesByDepartment();
    }
}

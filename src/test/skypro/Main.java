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

    public static void printAllAboutEmployees (Employee [] emps, int dep) {
        for (int i=0; i<emps.length; i++) {
            if (emps[i].getDepartment() == dep) {
                System.out.println(emps[i].getId() + ". " + emps[i].getName() + ", оклад " + emps[i].getSalary() + " руб.");
            }
        }
    }

    public static int countSalaries (Employee [] emps) {
        int salary = 0;
        for (int i=0; i<emps.length; i++) {
            salary += emps[i].getSalary();
        }
        return salary;
    }

    public static int countSalaries (Employee [] emps, int dep) {
        int salary = 0;
        for (int i=0; i<emps.length; i++) {
            if (emps[i].getDepartment() == dep)
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

    public static Employee findMinSalaryEmployee (Employee [] emps, int dep) {
        int minSalary = 0;
        int index = -1;
        for (int i=0; i<emps.length; i++) {
            if (emps[i].getDepartment() == dep) {
                minSalary = emps[i].getSalary();
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        for (int i=index+1; i<emps.length; i++) {
            if (emps[i].getDepartment() == dep) {
                if (emps[i].getSalary() < minSalary) {
                    minSalary = emps[i].getSalary();
                    index = i;
                }
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

    public static Employee findMaxSalaryEmployee (Employee [] emps, int dep) {
        int maxSalary = 0;
        int index = -1;
        for (int i=0; i<emps.length; i++) {
            if (emps[i].getDepartment() == dep) {
                maxSalary = emps[i].getSalary();
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        for (int i=index+1; i<emps.length; i++) {
            if (emps[i].getDepartment() == dep) {
                if (emps[i].getSalary() > maxSalary) {
                    maxSalary = emps[i].getSalary();
                    index = i;
                }
            }
        }
        return emps[index];
    }

    public static float countAverageSalary (Employee[] emps) {
        return (float) countSalaries(emps) / (float) emps.length;
    }

    public static float countAverageSalary (Employee[] emps, int dep) {
        int countInDep = countEmployeesInDep(emps, dep);
        if (countInDep == 0) return 0;
        else return (float) countSalaries(emps, dep) / (float) countInDep;
    }

    public static void printNamesOfEmployees (Employee [] emps) {
        for (int i=0; i<emps.length; i++) {
            System.out.println(emps[i].getName());
        }
    }

    public static void indexSalary (Employee [] emps, float index) {
        for (int i=0; i<emps.length; i++) {
            emps[i].setSalary((int)(emps[i].getSalary() * (1.0+index)));
        }
    }

    public static void indexSalary (Employee [] emps, float index, int dep) {
        for (int i=0; i<emps.length; i++) {
            if (emps[i].getDepartment() == dep)
            emps[i].setSalary((int)(emps[i].getSalary() * (1.0+index)));
        }
    }

    public static int countEmployeesInDep (Employee [] emps, int dep) {
        int countInDep = 0;
        for (int i=0; i< emps.length; i++) {
            if (emps[i].getDepartment() == dep) countInDep += 1;
        }
        return countInDep;
    }

    public static void printEmployeesWithSalaryBelow (Employee [] emps, int salaryMax, int dep) {
        for (int i=0; i< emps.length; i++) {
            if (emps[i].getDepartment() == dep && emps[i].getSalary()<salaryMax) {
                System.out.println(emps[i].getId() + ". " + emps[i].getName() + ", оклад " + emps[i].getSalary() + " руб.");
            }
        }
    }

    public static void printEmployeesWithSalaryAboveOrEqual (Employee [] emps, int salaryMin, int dep) {
        for (int i=0; i< emps.length; i++) {
            if (emps[i].getDepartment() == dep && emps[i].getSalary()>=salaryMin) {
                System.out.println(emps[i].getId() + ". " + emps[i].getName() + ", оклад " + emps[i].getSalary() + " руб.");
            }
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

        // индексация зарплаты на 5%
        float index = 0.05f;
        indexSalary(employees, index);
        System.out.println("Информация о зарплатах после индексации на " + (index*100) + "% : ");
        printAllAboutEmployees(employees);
        System.out.println();

        // по отделу!!!
        int department2 = 3;
        if (countEmployeesInDep(employees, department2) == 0) {
            System.out.println("Отдел №" + department2 + " : сотрудники не найдены. ");
        } else {
            // список сотрудников (вся информация)
            System.out.println("Информация о сотрудниках отдела №" + department2 + " : ");
            printAllAboutEmployees(employees, department2);
            System.out.println();

            // сумма всех зарплат
            System.out.println("Сумма всех зарплат за месяц отдела №" + department2 + " : " + countSalaries(employees, department2) + " руб. ");
            System.out.println();

            // сотрудник с мин. зп
            temp = findMinSalaryEmployee(employees, department2);
            System.out.println("Минимальная зарплата отдела №" + department2 + " : " + temp.getSalary() + " руб. ");
            System.out.println("Сотрудник с минимальной зарплатой отдела №" + department2 + " : " + temp.getName());
            System.out.println();

            // сотрудник с макс. зп
            temp = findMaxSalaryEmployee(employees, department2);
            System.out.println("Максимальная зарплата отдела №" + department2 + " : " + temp.getSalary() + " руб. ");
            System.out.println("Сотрудник с максимальной зарплатой отдела №" + department2 + " : " + temp.getName());
            System.out.println();

            // средняя зп
            System.out.println("Средняя зарплата отдела №" + department2 + " : " + countAverageSalary(employees, department2) + " руб. ");
            System.out.println();

            // индексация зарплаты на 5%
            index = 0.08f;
            indexSalary(employees, index, department2);
            System.out.println("Информация о зарплатах отдела №" + department2 + " после индексации на " + (index*100) + "% : ");
            printAllAboutEmployees(employees, department2);
            System.out.println();

            // сотрудники отдела с зп < ...
            int testSalary = 75_000;
            System.out.println("Сотрудники отдела №" + department2 + " с зарплатой ниже " + testSalary+ " руб. : ");
            printEmployeesWithSalaryBelow(employees, testSalary, department2);
            System.out.println();

            // сотрудники отдела с зп >= ...
            System.out.println("Сотрудники отдела №" + department2 + " с зарплатой выше или равной " + testSalary+ " руб. : ");
            printEmployeesWithSalaryAboveOrEqual(employees, testSalary, department2);
            System.out.println();
        }
    }
}

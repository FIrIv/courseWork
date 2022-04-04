package test.skypro;

public class EmployeeBook {
    private Employee[] employees;
    private int maxSize;

    public EmployeeBook (int size) {
        this.maxSize = size;
        employees = new Employee[this.maxSize];
    }

    public void addEmployee (Employee person) {
        for (int i=0; i<this.maxSize; i++) {
            if (this.employees[i] == null) {
                this.employees[i] = person;
                return;
            }
        }
        System.out.println("Нет места в EmployeeBook! ");
    }

    public void removeEmployee (String fio) {
        for (int i=0; i<this.maxSize; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getName().equalsIgnoreCase(fio)) {
                    System.out.println("Сотрудник удален из EmployeeBook! ");
                    this.employees[i] = null;
                    return;
                }
            }
        }
        System.out.println("Сотрудник не найден в EmployeeBook! ");
    }

    public void removeEmployee (String fio, int id) {
        for (int i=0; i<this.maxSize; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getName().equalsIgnoreCase(fio) && this.employees[i].getId() == id) {
                    this.employees[i] = null;
                    System.out.println("Сотрудник удален из EmployeeBook! ");
                    return;
                }
            }
        }
        System.out.println("Сотрудник не найден в EmployeeBook! ");
    }

    public void removeEmployee (int id) {
        for (int i=0; i<this.maxSize; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getId() == id) {
                    System.out.print(this.employees[i].getName() + " : ");
                    this.employees[i] = null;
                    System.out.println("Сотрудник удален из EmployeeBook! ");
                    return;
                }
            }
        }
        System.out.println("Сотрудник не найден в EmployeeBook! ");
    }

    public void editEmployeeDepartment (String fio, int newDep) {
        if (newDep <1 || newDep >5) {
            System.out.println("Номера отделов должны быть от 1 до 5. Отдел не изменен. ");
        }
        for (int i=0; i<this.maxSize; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getName().equalsIgnoreCase(fio)) {
                    System.out.println("Номер отдела изменен с " + this.employees[i].getDepartment() + " на " + newDep);
                    this.employees[i].setDepartment(newDep);
                    return;
                }
            }
        }
        System.out.println("Сотрудник не найден в EmployeeBook! ");
    }

    public void editEmployeeSalary (String fio, int newSalary) {
        for (int i=0; i<this.maxSize; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getName().equalsIgnoreCase(fio)) {
                    System.out.println("Зарплата изменена c " + this.employees[i].getSalary() + " руб. на " + newSalary + " руб. ");
                    this.employees[i].setSalary(newSalary);
                    return;
                }
            }
        }
        System.out.println("Сотрудник не найден в EmployeeBook! ");
    }

    public void printEmployeesByDepartment () {
        for (int i=1;i<=5;i++) {
            System.out.println("Отдел №" + i + " : ");
            for (int j=0; j<this.maxSize; j++) {
                if (this.employees[j] == null) continue;
                if (this.employees[j].getDepartment() == i) System.out.println(this.employees[j].getName());
            }
        }
    }

    public int getMaxSize () {
        return maxSize;
    }

    public Employee [] getEmployees () {
        return employees;
    }

    public void printAllAboutEmployees () {
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                System.out.println(this.employees[i].toString());
            }
        }
    }

    public void printAllAboutEmployees (int dep) {
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getDepartment() == dep) {
                    System.out.println(this.employees[i].getId() + ". " + this.employees[i].getName() + ", оклад " + this.employees[i].getSalary() + " руб.");
                }
            }
        }
    }

    public int countSalaries () {
        int salary = 0;
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                salary += this.employees[i].getSalary();
            }
        }
        return salary;
    }

    public int countSalaries (int dep) {
        int salary = 0;
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getDepartment() == dep)
                    salary += this.employees[i].getSalary();
            }
        }
        return salary;
    }

    public Employee findMinSalaryEmployee () {
        int minSalary = 0;
        int index = -1;
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                minSalary = this.employees[i].getSalary();
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        for (int i=index+1; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getSalary() < minSalary) {
                    minSalary = this.employees[i].getSalary();
                    index = i;
                }
            }
        }
        return this.employees[index];
    }

    public Employee findMinSalaryEmployee (int dep) {
        int minSalary = 0;
        int index = -1;
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getDepartment() == dep) {
                    minSalary = this.employees[i].getSalary();
                    index = i;
                    break;
                }
            }
        }
        if (index == -1) return null;
        for (int i=index+1; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                if (this.employees[i].getDepartment() == dep) {
                    if (this.employees[i].getSalary() < minSalary) {
                        minSalary = this.employees[i].getSalary();
                        index = i;
                    }
                }
            }
        }
        return this.employees[index];
    }

    public Employee findMaxSalaryEmployee () {
        int maxSalary = 0;
        int index = -1;
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null) {
                maxSalary = this.employees[i].getSalary();
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        for (int i=1; i<this.employees.length; i++) {
            if (this.employees[i].getSalary() > maxSalary) {
                maxSalary = this.employees[i].getSalary();
                index = i;
            }
        }
        return this.employees[index];
    }

    public Employee findMaxSalaryEmployee (int dep) {
        int maxSalary = 0;
        int index = -1;
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null ) {
                if (this.employees[i].getDepartment() == dep) {
                    maxSalary = this.employees[i].getSalary();
                    index = i;
                    break;
                }
            }
        }
        if (index == -1) return null;
        for (int i=index+1; i<this.employees.length; i++) {
            if (this.employees[i] != null ) {
                if (this.employees[i].getDepartment() == dep) {
                    if (this.employees[i].getSalary() > maxSalary) {
                        maxSalary = this.employees[i].getSalary();
                        index = i;
                    }
                }
            }
        }
        return this.employees[index];
    }

    public float countAverageSalary () {
        int count = countEmployees();
        if (count == 0) return 0;
        return (float) this.countSalaries() / (float) count;
    }

    public float countAverageSalary (int dep) {
        int countInDep = countEmployees(dep);
        if (countInDep == 0) return 0;
        else return (float) this.countSalaries(dep) / (float) countInDep;
    }

    public void printNamesOfEmployees () {
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null ) {
                System.out.println(this.employees[i].getName());
            }
        }
    }

    public void indexSalary (float index) {
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null ) {
                this.employees[i].setSalary((int) (this.employees[i].getSalary() * (1.0 + index)));
            }
        }
    }

    public void indexSalary (float index, int dep) {
        for (int i=0; i<this.employees.length; i++) {
            if (this.employees[i] != null ) {
                if (this.employees[i].getDepartment() == dep)
                    this.employees[i].setSalary((int) (this.employees[i].getSalary() * (1.0 + index)));
            }
        }
    }

    public int countEmployees () {
        int count = 0;
        for (int i=0; i< this.employees.length; i++) {
            if (this.employees[i] != null) count++;
        }
        return count;
    }

    public int countEmployees (int dep) {
        int countInDep = 0;
        for (int i=0; i< this.employees.length; i++) {
            if (this.employees[i] != null ) {
                if (this.employees[i].getDepartment() == dep) countInDep += 1;
            }
        }
        return countInDep;
    }

    public void printEmployeesWithSalaryBelow (int salaryMax, int dep) {
        for (int i=0; i< this.employees.length; i++) {
            if (this.employees[i] != null ) {
                if (this.employees[i].getDepartment() == dep && this.employees[i].getSalary() < salaryMax) {
                    System.out.println(this.employees[i].getId() + ". " + this.employees[i].getName() + ", оклад " + this.employees[i].getSalary() + " руб.");
                }
            }
        }
    }

    public void printEmployeesWithSalaryAboveOrEqual (int salaryMin, int dep) {
        for (int i=0; i< this.employees.length; i++) {
            if (this.employees[i] != null ) {
                if (this.employees[i].getDepartment() == dep && this.employees[i].getSalary() >= salaryMin) {
                    System.out.println(this.employees[i].getId() + ". " + this.employees[i].getName() + ", оклад " + this.employees[i].getSalary() + " руб.");
                }
            }
        }
    }

}

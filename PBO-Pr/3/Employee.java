class Employee {
    public Employee(String n, double s, int day, int month, int year) {
        name = n;
        salary = s;
        hireday = day;
        hiremonth = month;
        hireyear = year;
    }

    public void print() {
        System.out.println(name + " " + salary + " " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100;
    }

    public int hireYear() {
        return hireyear;
    }

    private String name;
    private double salary;
    private int hireday;
    private int hiremonth;
    private int hireyear;
}

abstract class Sortable {
    public abstract int compare(Sortable b);

    public static void shell_sort(Sortable[] a) {
        // Shell sort body
    }}

    When Sortable
    extended to Employee class,
    the method
    compare will
    be implemented.

    class Employee extends Sortable {
        /* another methods */
        public int compare(Sortable b) {
            Employee eb = (Employee) b;
            if (salary < eb.salary)
                return -1;
            if (salary > eb.salary)
                return +1;
            return 0;
        }
}
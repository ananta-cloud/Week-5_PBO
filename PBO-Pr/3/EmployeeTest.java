// public class EmployeeTest {
//     public static void main(String[] args) {
//         Employee[] staff = new Employee[3];
//         staff[0] = new Employee(
//             "Antonio Rossi", 2000000, 1, 10, 1989);
//         staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
//         staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
//         int i;
//         for (i = 0; i < 3; i++)
//             staff[i].raiseSalary(5);
//         for (i = 0; i < 3; i++)
//             staff[i].print();
//     }
// }


public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Calling compare() directly 
        // Output 1, dan -1
        System.out.println("\nPanggil method compare()");
        
        int result1 = staff[0].compare(staff[1]); 
        System.out.println("staff[0].compare(staff[1]): " + result1);
        int result2 = staff[2].compare(staff[1]); 
        System.out.println("staff[2].compare(staff[1]): " + result2);

        // --- Using shell_sort() ---
        System.out.println("\nSorting dengan shell_sort()");
        System.out.println("Sebelum sorting:");
        for (Employee e : staff) {
            e.print();
        }

        // The shell_sort method uses the compare() method internally to sort
        Sortable.shell_sort(staff);

        System.out.println("\nAfter sorting (by salary) :");
        for (Employee e : staff) {
            e.print();
        }
    }
}
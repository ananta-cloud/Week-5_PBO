public class Manager_test {
    public static void main(String[] args) {
        Manager[] staff = new Manager[3];
        staff[0] = new Manager("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Manager("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Manager("Isabel Vidal", 3000000, 1, 11, 1993);
        int i;
        for (i = 0; i < 3; i++)
            staff[i].raiseSalary(5);
        for (i = 0; i < 3; i++)
            staff[i].print();
        
        System.out.println("\nSebelum diurutkan");
        for (Manager m : staff) {
            m.print();
        }
        
        // Memanggil shell_sort dengan array Manager, 
        // ini bisa dilakukan karena Manager adalah turunan dari Sortable
        Sortable.shell_sort(staff);

        System.out.println("\nSetelah diurutkan (berdasarkan gaji)");
        for (Manager m : staff) {
            m.print();
        }
    }
}
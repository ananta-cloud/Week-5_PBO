public class Main {
    public static void main(String[] args) {
        // Create instances of each class
        Food apple = new Food("Red Apple", 1.50, 95);
        Toy lego = new Toy("Lego Starship", 49.99, 8);
        Book javaBook = new Book("Head First Java", 35.75, "Kathy Sierra");

        System.out.println("\n--- Item 1: Food ---");
        apple.display();
        System.out.println("Tax         : Food is not taxable.");
        System.out.println("--------------------------\n");

        System.out.println("--- Item 2: Toy ---");
        lego.display();
        System.out.printf("Tax         : $%.2f%n", lego.calculateTax());
        System.out.println("------------------------\n");


        System.out.println("--- Item 3: Book ---");
        javaBook.display();
        System.out.printf("Tax         : $%.2f%n", javaBook.calculateTax());
        System.out.println("------------------------\n");
    }
}
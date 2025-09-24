public class Book extends Goods implements Taxable {
    private String author;

    public Book(String description, double price, String author) {
        super(description, price);
        this.author = author;
    }

    // Getter and Setter
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Implementasi Method dari interface Taxable
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    // Override Method
    @Override
    public void display() {
        super.display();

        System.out.println("Author      : " + this.author);
    }
}
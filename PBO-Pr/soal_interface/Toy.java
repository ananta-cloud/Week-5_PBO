public class Toy extends Goods implements Taxable {
    private int minimumAge;

    public Toy(String description, double price, int minimumAge) {
        super(description, price);
        this.minimumAge = minimumAge;
    }

    // Getter and Setter
    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    // Implementasi Method dari interface Taxable
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    // Overridden Method
    @Override
    public void display() {
        super.display();
        System.out.println("Minimum Age : " + this.minimumAge);
    }
}
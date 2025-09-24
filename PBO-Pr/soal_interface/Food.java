public class Food extends Goods {
    private double calories;

    public Food(String description, double price, double calories) {
        super(description, price); // Panggil constructor parent class dengan super()
        this.calories = calories;
    }

    // Getter and Setter
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    // Override Method 
    @Override
    public void display() {
        super.display();
        System.out.println("Calories    : " + this.calories);
    }
}
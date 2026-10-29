import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RectangleArea rectangle = new RectangleArea();
        rectangle.getData();
        rectangle.computeField();
        rectangle.fieldDisplay();
    }
}

class RectangleArea {
    private double sideA;
    private double sideB;
    private double area;

    public void getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first side length: ");
        sideA = scanner.nextDouble();
        System.out.print("Enter the second side length: ");
        sideB = scanner.nextDouble();
    }

    public void computeField() {
        area = sideA * sideB;
    }

    public void fieldDisplay() {
        System.out.println("Rectangle sides: " + sideA + " and " + sideB);
        System.out.println("Rectangle area: " + area);
    }
}

class Car {
    private String model;
    private String brand;
    private int year;
    private double price;
    private String color;
    private int quantity;

    public Car(String model, String brand, int year, double price,
               String color, int quantity) {
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void delivery() {
        quantity++;
    }

    public void sell() {
        if (quantity > 0) {
            quantity--;
        } else {
            System.out.println("No cars in stock.");
        }
    }

    @Override
    public String toString() {
        return "Car{model='" + model + "', brand='" + brand
                + "', year=" + year + ", price=" + price
                + ", color='" + color + "', quantity=" + quantity + "}";
    }
}

class CarDemo {
    public static void main(String[] args) {
        Car car = new Car("Corolla", "Toyota", 2024, 95000.0, "Silver", 3);
        System.out.println("Initial car: " + car.toString());

        car.sell();
        System.out.println("\nAfter selling one car (using getters):");
        System.out.println("Model: " + car.getModel());
        System.out.println("Brand: " + car.getBrand());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price: " + car.getPrice());
        System.out.println("Color: " + car.getColor());
        System.out.println("Quantity: " + car.getQuantity());

        car.setModel("Civic");
        car.setBrand("Honda");
        car.setYear(2025);
        car.setPrice(105000.0);
        car.setColor("Blue");
        car.setQuantity(5);
        System.out.println("\nAfter changes using setters: " + car.toString());

        car.delivery();
        System.out.println("After delivery of one car: " + car.toString());
    }
}

class NumberSystemConverter {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choice;

        do {
            System.out.println("\nChoose an operation:");
            System.out.println("A. Convert to decimal");
            System.out.println("B. Convert from decimal");
            System.out.println("C. Add two numbers");
            System.out.println("D. Subtract two numbers");
            System.out.println("E. Multiply two numbers");
            System.out.println("F. Divide two numbers");
            System.out.println("W. Exit");
            System.out.print("Your choice: ");
            choice = scanner.next().toUpperCase();

            try {
                switch (choice) {
                    case "A":
                        int number = readNumber();
                        System.out.println("Decimal result: " + number);
                        break;
                    case "B":
                        System.out.print("Enter a decimal integer: ");
                        int decimal = Integer.parseInt(scanner.next());
                        int base = readBase();
                        System.out.println("Result: " + Integer.toString(decimal, base));
                        break;
                    case "C":
                    case "D":
                    case "E":
                    case "F":
                        System.out.println("First number:");
                        int first = readNumber();
                        System.out.println("Second number:");
                        int second = readNumber();
                        System.out.println("Choose the result base:");
                        int resultBase = readBase();
                        int result;

                        if (choice.equals("C")) {
                            result = first + second;
                        } else if (choice.equals("D")) {
                            result = first - second;
                        } else if (choice.equals("E")) {
                            result = first * second;
                        } else {
                            if (second == 0) {
                                System.out.println("Cannot divide by zero.");
                                break;
                            }
                            result = first / second;
                            System.out.println("Remainder: "
                                    + Integer.toString(first % second, resultBase));
                        }

                        System.out.println("Result: " + Integer.toString(result, resultBase));
                        break;
                    case "W":
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again from the menu.");
            }
        } while (!choice.equals("W"));
    }

    static int readBase() {
        int base;
        do {
            System.out.print("Enter a base (2, 3, 4, 5, 6, 8, 9, 10, 16): ");
            base = Integer.parseInt(scanner.next());
        } while (base != 2 && base != 3 && base != 4 && base != 5
                && base != 6 && base != 8 && base != 9 && base != 10 && base != 16);
        return base;
    }

    static int readNumber() {
        int base = readBase();
        System.out.print("Enter the number: ");
        String number = scanner.next();
        return Integer.parseInt(number, base);
    }
}

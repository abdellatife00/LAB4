package lomboktask;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CarDemoWithLombok {
    public static void main(String[] args) {
        CarWithLombok car1 = new CarWithLombok("320i", "BMW", 2021, 120000, "blue", 4);
        CarWithLombok car2 = new CarWithLombok("X3", "BMW", 2024, 220000, "gray", 2);

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car1.getColor());

        System.out.println(car1.getYear());
        car1.setColor("red");

        System.out.println("Are these objects equal? " + car1.equals(car2));
        System.out.println("The HashCode of this object is: " + car1.hashCode());
        System.out.println("The HashCode of this object is: " + car2.hashCode());
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString(exclude = "quantity")
@EqualsAndHashCode(of = "brand")
class CarWithLombok {
    private String model;
    private String brand;
    private int year;
    private int price;
    private String color;
    private int quantity;
}

package CafeProject.cafe.project;

public class Menu {

    private String[] coffees = {"Espresso", "Latte", "Cappuccino", "Mocha", "Americano"};
    private String[] bakedGoods = {"Croissant", "Bagel", "Muffin", "Brownie", "Cookie"};

    public void Coffees() {
        System.out.println("Coffees:");
        for (String coffee : coffees) {
            System.out.println(coffee);
        }
    }
    public void BakedGoods() {
        System.out.println("Baked goods:");
        for (String bakedGood : bakedGoods) {
            System.out.println(bakedGood);
        }
    }
}

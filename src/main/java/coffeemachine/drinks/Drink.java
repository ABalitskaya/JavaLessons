package coffeemachine.drinks;

public enum Drink implements Drinkable {
    ESPRESSO(2, Volume.SMALL),
    AMERICANO(2.6, Volume.MIDDLE),
    CAPPUCCINO(4.2, Volume.MIDDLE),
    LATTE(4.5, Volume.LARGE);

    private double price;
    private Volume volume;

    Drink(double price, Volume volume) {
        this.price = price;
        this.volume = volume;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public Volume getVolume() {
        return volume;
    }
}

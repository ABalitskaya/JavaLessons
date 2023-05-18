package coffeemachine.drinks;

public enum DrinkGasStation implements Drinkable {

    ESPRESSO(2.5, Volume.SMALL),
    AMERICANO(3.1, Volume.MIDDLE),
    CAPPUCCINO(4.7, Volume.MIDDLE),
    LATTE(5, Volume.LARGE);

    private double price;
    private Volume volume;

    DrinkGasStation(double price, Volume volume) {
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

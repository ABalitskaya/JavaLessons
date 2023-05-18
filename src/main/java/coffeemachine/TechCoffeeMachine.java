package coffeemachine;

import coffeemachine.drinks.Drink;
import coffeemachine.drinks.Drinkable;
import coffeemachine.drinks.Volume;

import java.util.Scanner;

public abstract class TechCoffeeMachine {

    protected Scanner sc = new Scanner(System.in);
    protected Drinkable drinkChoice;
    protected int subprocessCount = 1;

    public void makeEspresso(boolean subprocess) {
        if (subprocess)
            // subprocessCount = вначале обратится к переменной, после произойдёт update
            // todo String -> StringBuilder
            System.out.println("\t" + subprocessCount++ + ". Adding an espresso (" + Volume.SMALL.getMl() + " ml)");
        else
            System.out.println("Making an espresso");
    }

    public void makeAmericano() {
        makeEspresso(true);
        addSomeWater();
    }

    public void makeCappuccino() {
        makeEspresso(true);
        addSomeFrothedMilk();
    }

    public void makeLatte() {
        addSomeFrothedMilk();
        makeEspresso(true);
    }

    public void addSomeWater() {
        // todo String -> StringBuilder
        // subprocessCount = вначале обратится к переменной, после произойдёт update
        System.out.println("\t" + subprocessCount++ + ". Adding some water (" + (Volume.MIDDLE.getMl() - Volume.SMALL.getMl()) + " ml)");
    }

    public void addSomeFrothedMilk() {
        // todo String -> StringBuilder
        System.out.println("\t" + subprocessCount++ + ". Adding some frothed milk (" + (drinkChoice.getVolume().getMl() - Volume.SMALL.getMl()) + " ml)");
    }
}

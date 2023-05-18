package coffeemachine;

import coffeemachine.drinks.Drink;

public class CoffeeMachine extends TechCoffeeMachine {

    public CoffeeMachine() {

        boolean isSelected = false;

        while (!isSelected) {
            System.out.println("Pls push the button which drink you would like to drink");
            System.out.println("1 - espresso; 2 - americano; 3 - cappuccino; 4 - latte");

            int choice = sc.nextInt();
            StringBuilder selectedString = new StringBuilder();
            selectedString.append("You've selected ");

            switch (choice) {
                case 1 -> {
                    drinkChoice = Drink.ESPRESSO;
                    selectedString.append(drinkChoice).append(" ");
                    selectedString.append(drinkChoice.getVolume().toString().toLowerCase());
                    selectedString.append(" (").append(drinkChoice.getVolume().getMl()).append(" ml)");
                    System.out.println(selectedString);
                    makeEspresso(false);
                    isSelected = true;
                }
                case 2 -> {
                    drinkChoice = Drink.AMERICANO;
                    selectedString.append(drinkChoice).append(" ");
                    selectedString.append(drinkChoice.getVolume().toString().toLowerCase());
                    selectedString.append(" (").append(drinkChoice.getVolume().getMl()).append(" ml)");
                    System.out.println(selectedString);
                    makeAmericano();
                    isSelected = true;
                }
                case 3 -> {
                    drinkChoice = Drink.CAPPUCCINO;
                    selectedString.append(drinkChoice).append(" ");
                    selectedString.append(drinkChoice.getVolume().toString().toLowerCase());
                    selectedString.append(" (").append(drinkChoice.getVolume().getMl()).append(" ml)");
                    System.out.println(selectedString);
                    makeCappuccino();
                    isSelected = true;
                }
                case 4 -> {
                    drinkChoice = Drink.LATTE;
                    selectedString.append(drinkChoice).append(" ");
                    selectedString.append(drinkChoice.getVolume().toString().toLowerCase());
                    selectedString.append(" (").append(drinkChoice.getVolume().getMl()).append(" ml)");
                    System.out.println(selectedString);
                    makeLatte();
                    isSelected = true;
                }
                default -> System.out.println("Pls push the button correctly");
                // todo add another question more than 1 drink
            }
        }

        System.out.println("\nYour drink is ready. Please pay " + drinkChoice.getPrice() + " Euro");

        sc.close();
    }


}

package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example11 {
    public static void main(String[] args) {

        Animal animal = new Animal();
        Dog dog = new Dog();
        BigDog bigDog = new BigDog();
        Shepard shepard = new Shepard();

        animal = bigDog;
//        dog = animal; // not ok

        List<Dog> dogList = new ArrayList<>();
        Collections.addAll(dogList, new Dog(), new Dog());
        Dog dog1 = dogList.get(0); // ok
        Animal dog2 = dogList.get(0); // ok
//        BigDog dog3 = dogList.get(0); // not ok

        List<BigDog> bigDogList = new ArrayList<>();
        Collections.addAll(bigDogList, new BigDog(), new BigDog());

//        dogList = bigDogList;
//        bigDogList = dogList;

        System.out.println(dogList.getClass());
        System.out.println(bigDogList.getClass());


    }
}

class Animal {
    public int getHeight() {
        return 130;
    }
}

class Dog extends Animal {
    @Override
    public int getHeight() {
        return 45;
    }
}

class BigDog extends Dog {
    @Override
    public int getHeight() {
        return 70;
    }
}

class Shepard extends BigDog {
    @Override
    public int getHeight() {
        return 60;
    }
}
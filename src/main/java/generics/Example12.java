package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example12 {
    public static void main(String[] args) {

        // личный зачёт
        EarthShip earthShip = new EarthShip(100);
        MarsShip marsShip = new MarsShip(200);

        System.out.println(competition(earthShip, marsShip));

        // командный зачёт
        List<EarthShip> earthTeam = new ArrayList<>();
        Collections.addAll(earthTeam, new EarthShip(100), new EarthShip(200), new EarthShip(300));

        List<MarsShip> marsTeam = new ArrayList<>();
        Collections.addAll(marsTeam, new MarsShip(230), new MarsShip(80), new MarsShip(287));

        System.out.println(competition(earthTeam, marsTeam));
        System.out.println(competitionAlt(earthTeam, marsTeam));
    }

    public static String competition(SpaceShip e1, SpaceShip m1) {
        return e1.getSpeed() > m1.getSpeed() ? "first win" : "second win";
    }

    public static String competition(List<? extends SpaceShip> list1, List<? extends SpaceShip> list2) {
        double total1 = list1.stream().map(SpaceShip::getSpeed).reduce(Integer::sum).get();
        double total2 = list2.stream().map(SpaceShip::getSpeed).reduce(Integer::sum).get();

        return total1 > total2 ? "first team won" : "second team won";
    }

    public static String competitionAlt(List<?> list1, List<?> list2) {
        double total1 = list1.stream().map(x -> (SpaceShip) x).map(SpaceShip::getSpeed).reduce(Integer::sum).get();
        double total2 = list2.stream().map(x -> (SpaceShip) x).map(SpaceShip::getSpeed).reduce(Integer::sum).get();

        return total1 > total2 ? "first team won" : "second team won";
    }
}

class SpaceShip {
    private int speed;

    public SpaceShip(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "{Ship speed = " + speed + "}";
    }
}

class EarthShip extends SpaceShip {
    public EarthShip(int speed) {
        super(speed);
    }
}

class MarsShip extends SpaceShip {
    public MarsShip(int speed) {
        super(speed);
    }
}
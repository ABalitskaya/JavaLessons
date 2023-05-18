package coffeemachine.drinks;

public enum Volume {
    SMALL(50),
    MIDDLE(120),
    LARGE(200);

    private int ml;

    Volume(int ml) {
        this.ml = ml;
    }

    public int getMl() {
        return ml;
    }
}

package enumarations;

public enum Orientation {
    DROITE("D"), GAUCHE("G"), AVANCE("A");

    private String name;

    Orientation(String e) {
        this.name = e;
    }

    public String getName() {
        return name;
    }
}

package enumarations;

public enum Coordonnee {
    NORD("N"), EST("E"), WEST("W"), SUD("S");

    private String name;

    Coordonnee(String e) {
        this.name = e;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

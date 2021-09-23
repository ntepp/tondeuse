package beans;

public class Position {
    private int x;
    private int y;
    private String coordonnee;

    public Position(int x, int y, String coordonnee) {
        this.x = x;
        this.y = y;
        this.coordonnee = coordonnee;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(String coordonnee) {
        this.coordonnee = coordonnee;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj.getClass() != this.getClass()){
            return false;
        }
        if(obj == this) {
            return true;
        }
        Position p = (Position) obj;
        return this.x == p.getX() && this.y == p.getY() && this.coordonnee.equals(p.getCoordonnee());
    }

    public Position clone() {
        return new Position(x, y, coordonnee);
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                ", coordonnee='" + coordonnee + '\'' +
                '}';
    }
}

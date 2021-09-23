package services;

import beans.Position;

public class PositionService {

    public Position moveUp(Position p){
        p.setX(0);
        p.setY(0);
        return p;
    }

    public Position moveDown(Position p){
        p.setX(0);
        p.setY(0);
        return p;
    }

    public Position moveLeft(Position p){
        p.setX(0);
        p.setY(0);
        return p;
    }

    public Position moveRight(Position p){
        p.setX(0);
        p.setY(0);
        return p;
    }
    public Boolean canMove(Position p, String orientation, int x, int y){
        return true;
    }

    public Position move(Position p) {
        p.setX(0);
        p.setY(0);
        return p;
    }

    public Position getPosition(String move, Position p, int Xn, int Yn) {
        p.setX(0);
        p.setY(0);
        return p;
    }
}

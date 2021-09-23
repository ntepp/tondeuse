package services;

import beans.Position;
import enumarations.Coordonnee;
import enumarations.Orientation;

public class PositionService {

    public Position moveUp(Position p){
        p.setY(p.getY()+1);
        return p;
    }

    public Position moveDown(Position p){
        p.setY(p.getY()-1);
        return p;
    }

    public Position moveLeft(Position p){
        p.setX(p.getX()-1);
        return p;
    }

    public Position moveRight(Position p){
        p.setX(p.getX()+1);
        return p;
    }
    public Boolean canMove(Position p, String orientation, int x, int y){
        if(orientation.equals(Orientation.AVANCE.getName())) {
            move(p);
        }

        return p.getX()>=0 && p.getY()>=0 && p.getX() <= x && p.getY() <= y;
    }

    public Position move(Position p) {
        if(p.getCoordonnee().equals(Coordonnee.NORD.getName())){
            p = moveUp(p);
        }else if(p.getCoordonnee().equals(Coordonnee.WEST.getName())) {
            p = moveLeft(p);
        }else if(p.getCoordonnee().equals(Coordonnee.EST.getName())) {
            p = moveRight(p);
        }else if(p.getCoordonnee().equals(Coordonnee.SUD.getName())) {
            p = moveDown(p);
        }

        return p;
    }

    public Position getPosition(String move, Position p, int Xn, int Yn) {
        for(int m = 0; m < move.length(); m++){
            String orientation = ""+ move.charAt(m);
            if(Orientation.AVANCE.getName().equals(orientation) && canMove(new Position(p.getX(), p.getY(), p.getCoordonnee()),orientation, Xn, Yn)){
                p = move(p);
            }else if(Orientation.DROITE.getName().equals(orientation)) {
                if(p.getCoordonnee().equals(Coordonnee.NORD.getName())) {
                    p.setCoordonnee(Coordonnee.EST.getName());
                }else if(p.getCoordonnee().equals(Coordonnee.EST.getName())) {
                    p.setCoordonnee(Coordonnee.SUD.getName());
                }else if (p.getCoordonnee().equals(Coordonnee.SUD.getName())) {
                    p.setCoordonnee(Coordonnee.EST.getName());
                }else if (p.getCoordonnee().equals(Coordonnee.WEST.getName())) {
                    p.setCoordonnee(Coordonnee.NORD.getName());
                }
            } else if(Orientation.GAUCHE.getName().equals(orientation)) {
                if(p.getCoordonnee().equals(Coordonnee.NORD.getName())) {
                    p.setCoordonnee(Coordonnee.WEST.getName());
                }else if(p.getCoordonnee().equals(Coordonnee.WEST.getName())) {
                    p.setCoordonnee(Coordonnee.SUD.getName());
                }else if (p.getCoordonnee().equals(Coordonnee.SUD.getName())) {
                    p.setCoordonnee(Coordonnee.EST.getName());
                }else if (p.getCoordonnee().equals(Coordonnee.EST.getName())) {
                    p.setCoordonnee(Coordonnee.NORD.getName());
                }

            }
        }
        return p;
    }
}

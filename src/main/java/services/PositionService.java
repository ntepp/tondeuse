package services;

import beans.Position;
import enumarations.Coordonnee;
import enumarations.Orientation;
import utils.FileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            }else {
                setCoordooneeByOrientation(p, orientation);
            }
        }
        return p;
    }

    private void setCoordooneeByOrientation(Position p, String orientation) {
        if(Orientation.DROITE.getName().equals(orientation)) {
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

    public List<Position> getAllFinalPositionFromFile() throws IOException {
        PositionService moveService = new PositionService();
        List<Position> finalPositionList = new ArrayList<>();

        FileUtils fileUtils = new FileUtils();
        List<String> input = fileUtils.readFile();

        if(!input.isEmpty()){
            int Xn = Integer.parseInt(input.get(0).split(" ")[0]);
            int Yn = Integer.parseInt(input.get(0).split(" ")[0]);

            for (int i = 1; i < input.size() - 1; i=i+2) {
                String position = input.get(i);
                String move = input.get(i+1);

                int x = Integer.parseInt(position.split(" ")[0]);
                int y = Integer.parseInt(position.split(" ")[1]);
                String cardinal = position.split(" ")[2];

                Position p = new Position(x, y, cardinal);
                moveService.getPosition(move, p, Xn, Yn);
                finalPositionList.add(p);
            }
        }

        return finalPositionList;
    }
}

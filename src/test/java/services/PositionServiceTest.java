package services;

import beans.Position;
import enumarations.Coordonnee;
import enumarations.Orientation;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionServiceTest {

    public static final int MAX_X = 5;
    public static final int MAX_Y = 5;

    @Test
    void moveUp() {
        PositionService positionService = new PositionService();
        Position oldPosition = new Position(1, 2, Coordonnee.NORD.getName());
        Position newPosition = positionService.moveUp(oldPosition.copy());
        Position expectedPosition = new Position(1, 3, Coordonnee.NORD.getName());
        assertEquals(expectedPosition, newPosition, "Doit modifier la position actuelle en increment y+1 sans changer d'orientation");
    }

    @Test
    void moveDown() {
        PositionService positionService = new PositionService();
        Position oldPosition = new Position(1, 2, Coordonnee.NORD.getName());
        Position newPosition = positionService.moveDown(oldPosition.copy());
        Position expectedPosition = new Position(1, 1, Coordonnee.NORD.getName());
        assertEquals(expectedPosition, newPosition, "Doit modifier la position actuelle en decrementer y-1 sans changer d'orientation");
    }

    @Test
    void moveLeft() {
        PositionService positionService = new PositionService();
        Position oldPosition = new Position(3, 2, Coordonnee.SUD.getName());
        Position newPosition = positionService.moveLeft(oldPosition.copy());
        Position expectedPosition = new Position(2, 2, Coordonnee.SUD.getName());
        assertEquals(expectedPosition, newPosition, "Doit modifier la position actuelle en decrementer x-1 sans changer d'orientation");
    }

    @Test
    void moveRight() {
        PositionService positionService = new PositionService();
        Position oldPosition = new Position(1, 2, Coordonnee.SUD.getName());
        Position newPosition = positionService.moveRight(oldPosition.copy());
        Position expectedPosition = new Position(2, 2, Coordonnee.SUD.getName());
        assertEquals(expectedPosition, newPosition, "Doit modifier la position actuelle en decrementer x+1 sans changer d'orientation");
    }

    @Test
    void canMove() {
        PositionService positionService = new PositionService();
        Position oldPosition = new Position(0, 0, Coordonnee.SUD.getName());
        assertFalse(positionService.canMove(oldPosition, Orientation.AVANCE.getName(), MAX_X, MAX_Y));
    }

    @Test
    void move() {
        PositionService positionService = new PositionService();
        Position oldPosition = new Position(2, 3, Coordonnee.SUD.getName());
        Position newPosition = positionService.move(oldPosition.copy());
        Position expectedPosition = new Position(2, 2, Coordonnee.SUD.getName());
        assertEquals(expectedPosition,newPosition, "Doit modifier la position actuelle en decrementer y-1 sans changer d'orientation");
    }

    @Test
    void getPosition() {
        PositionService positionService = new PositionService();
        Position oldPosition = new Position(1, 2, Coordonnee.NORD.getName());
        String movement = "GAGAGAGAA";
        positionService.getPosition(movement, oldPosition, MAX_X, MAX_Y);
        Position expectedPosition = new Position(1, 3, Coordonnee.NORD.getName());
        assertEquals(expectedPosition,oldPosition);
    }

    @Test
    void getAllFinalPositionFromFile() throws IOException {
        Position expectedPosition1 = new Position(1, 3, Coordonnee.NORD.getName());
        Position expectedPosition2 = new Position(5, 1, Coordonnee.EST.getName());
        PositionService positionService = new PositionService();
        List<Position> finalPositionList = positionService.getAllFinalPositionFromFile();
        assertTrue(!finalPositionList.isEmpty(), "La liste des positions finale des tondeuses ne peux etre vide");
        assertEquals(expectedPosition1, finalPositionList.get(0), "Le resultat attendue est 1 3 N");
        assertEquals(expectedPosition2, finalPositionList.get(1), "Le resultat attendue est 5 1 E");
    }
}
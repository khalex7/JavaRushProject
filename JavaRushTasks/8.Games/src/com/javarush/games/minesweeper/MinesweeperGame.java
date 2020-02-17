package com.javarush.games.minesweeper;
import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    //set side

    private static final int MINEPROBABILITY = 10;
    //set probability of mine. it is 1/MINEPROBABILITY

    private static final String MINE = "\uD83D\uDCA3";
    //mine symbol

    private static final String FLAG = "\uD83D\uDEA9";

    private int countMinesOnField = 0;
    //mines counter

    private int countFlags;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        //Set number of cells in width and height
        createGame();
        //create game
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        openTile(x, y);
    }

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    private void createGame() {
        for (int y = 0; y < gameField.length; y++) {
            for(int x = 0; x < gameField.length; x++) {
                boolean isMine = (getRandomNumber(MINEPROBABILITY) == 7);
                //set mine or not
                if(isMine)
                    countMinesOnField++;
                gameField[y][x] = new GameObject(x, y, isMine);
                //set array by new objects
                setCellColor(x, y, Color.AQUAMARINE);
                //set color for every cell
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        //count neighbors mines for every not mines cell
    }
    
    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
    //find neighbor cells

    private void countMineNeighbors() {
        for (int y = 0; y < gameField.length; y++) {
            for (int x = 0; x < gameField.length; x++) {
                if(!gameField[y][x].isMine) {
                    List<GameObject> neighborCells = getNeighbors(gameField[y][x]);
                    int countMines = 0;
                    for (GameObject object : neighborCells) {
                        if (object.isMine) {
                            countMines++;
                        }
                    }
                    //count neighbor mines for cell
                    gameField[y][x].countMineNeighbors = countMines;
                }
                else {
                    countMinesOnField++;
                }
            }
        }
    }
    //that counts neighbor mines

    private void openTile(int x, int y) {
        if (gameField[y][x].isMine) {
            setCellValue(x, y, MINE);
            setCellColor(x, y, Color.RED);
            gameField[y][x].isOpen = true;
        }
        //set mine opened
        else {
            setCellColor(x, y, Color.LIGHTGREEN);
            gameField[y][x].isOpen = true;

            if(gameField[y][x].countMineNeighbors == 0) {
                List<GameObject> nullMineNeighbors = getNeighbors(gameField[y][x]);
                for (GameObject object : nullMineNeighbors) {
                    if (object.isOpen == false) {
                        openTile(object.x, object.y);
                    }
                }
            }
            //open neighbor cells if this == 0
            else {
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            }
            //set number of neighbors for opened
        }
        //set free cell opened
    }
}

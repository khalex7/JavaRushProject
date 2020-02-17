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
    //how many flags gamer can set

    private boolean isGameStopped;
    //set true when game stopped

    private int countClosedTiles = SIDE*SIDE;
    //set number of not opened cells

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

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = (getRandomNumber(MINEPROBABILITY) == 0);
                //set mine or not
                gameField[y][x] = new GameObject(x, y, isMine);
                //set array by new objects
                setCellColor(x, y, Color.AQUAMARINE);
                //set color for every cell
                if (gameField[y][x].isMine == true)
                    countMinesOnField++;
                System.out.println(x + " " + y + "  " + isMine + " " + countMinesOnField);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        //count neighbors mines for every not mines cell
        isGameStopped = false;
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
                    //countMinesOnField++;
                }
            }
        }
    }
    //that counts neighbor mines

    private void openTile(int x, int y) {
        if (isGameStopped == false && gameField[y][x].isFlag == false && gameField[y][x].isOpen == false) {
            if (gameField[y][x].isMine) {
                setCellValueEx(x, y, Color.RED, MINE);
                gameOver();
                return;
            }
            //set mine opened
            else {
                setCellColor(x, y, Color.LIGHTGREEN);
            }

            gameField[y][x].isOpen = true;
            countClosedTiles--;
            //set free cell opened

            System.out.println(countClosedTiles + " " + countMinesOnField);

            if(countClosedTiles == countMinesOnField) {
                win();
            }
            //check for win

            if (gameField[y][x].isMine == false) {
                if (gameField[y][x].countMineNeighbors == 0) {
                    List<GameObject> nullMineNeighbors = getNeighbors(gameField[y][x]);
                    for (GameObject object : nullMineNeighbors) {
                        if (object.isOpen == false) {
                            openTile(object.x, object.y);
                        }
                    }
                    setCellValue(x, y, "");
                }
                //open neighbor cells if this == 0
                else {
                    setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                }
                //set number of neighbors for opened
            }
        }
    }

    private void markTile(int x, int y) {
        if(gameField[y][x].isOpen == false && isGameStopped == false) {
            if(!gameField[y][x].isFlag && countFlags > 0) {
                gameField[y][x].isFlag = !gameField[y][x].isFlag;
                setCellValue(x, y, FLAG);
                setCellColor(x, y, Color.AQUA);
                countFlags--;
            }
            //set flag
            else if(gameField[y][x].isFlag){
                gameField[y][x].isFlag = !gameField[y][x].isFlag;
                setCellValue(x, y, "");
                setCellColor(x, y, Color.AQUAMARINE);
                countFlags++;
            }
            //unset flag
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "GAME OVER", Color.BLACK, 50);
    }
    //gameover method

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "YOU WIN!!!", Color.GOLD, 50);
    }
    //win method


}

package com.javarush.games.minesweeper;

public class GameObject {
    public int x;
    public int y;
    //coordinates
    public boolean isMine;
    //is mine?
    public int countMineNeighbors;
    //number of mines in neighbors cells
    public boolean isOpen = false;
    //is cell opened or not
    public boolean isFlag = false;
    //has cell the flag or not

    public GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }
}

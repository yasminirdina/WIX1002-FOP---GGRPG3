package ggrpg3.worlds;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;

public class MapsBasic {

    private int size;
    private char[][] tile;
    private char[] symbolList = new char[10];
    private int tileChosen;
    private int noOfEnemy;
    // private TileType type;

    public MapsBasic() {
        Random rand = new Random();
        this.size = rand.nextInt(6) + 10; //max no. of rows of whole map = 15
        this.tile = new char[size][size];
        // this.type = new TileType();
        this.symbolList = new char[]{'@', 'Y', 'X', ';', '`', '.', ',', '^', '#', '*', '='};
        this.tileChosen = 0;
        this.noOfEnemy = 1; //random no. of enemy follows no. of rows
    }

    public int getSize() //accessor 1
    {
        return size;
    }

    
    public char[] getSymbolList() //accessor 3
    {
        return symbolList;
    }
    
    public char[][] getTiles()
    {
        return tile;
    }

    public void generateDisplayRandomSymbols() //generate and display symbols for tiles but excluding wall symbol
    {
        
        Random rand = new Random();
        /*
        int randEnemy_i = rand.nextInt(size - 3) + 1; //random enemy position from 1 to max size-2(2nd last column/row)
        int randEnemy_j = rand.nextInt(size - 3) + 1;
        int randNpc_i = rand.nextInt(size - 3) + 1;
        int randNpc_j = rand.nextInt(size - 3) + 1;

        while (randEnemy_i == randNpc_i || randEnemy_i == 2 || randNpc_i == 2 || randEnemy_i - 2 < 4) {
            //check if x-coord of enemy = npc OR any x == 2 OR distance between enemy & player < 4, if same, generate BOTH new
            randEnemy_i = rand.nextInt(size - 3) + 1;
            randNpc_i = rand.nextInt(size - 3) + 1;
        }

        while (randEnemy_j == randNpc_j || randEnemy_j == 2 || randNpc_j == 2 || randEnemy_j < 4) {
            //check if y-coord of enemy = npc OR any x == 2 OR distance between enemy & player < 4, if same, generate BOTH new
            randNpc_i = rand.nextInt(size - 3) + 1;
            randNpc_j = rand.nextInt(size - 3) + 1;
        }
        //settle generate random position enemy & npc
        */

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= 1 && i <= size - 2 && j >= 1 && j <= size - 2) //dalam wall
                {
                    // if (i == randEnemy_i && j == randEnemy_j) {
                    if (i == 8 && j == 8) {
                        tile[i][j] = symbolList[1];
                        System.out.print(tile[i][j] + " "); //display enemy 'Y'
                    } // else if (i == randNpc_i && j == randNpc_j) {
                    else if (i == 4 && j == 5) {
                        tile[i][j] = symbolList[2];
                        System.out.print(tile[i][j] + " "); //display NPC 'X'
                    } else if (i == 2 && j == 2) {
                        tile[i][j] = symbolList[0];
                        System.out.print(tile[i][j] + " "); //display player '@'
                    } else //for the remaining tiles (which is w/o @, X and Y)
                    {
                        tileChosen = rand.nextInt(8) + 3; // symbol index 3 -> 10

                        for (int k = 3; k < symbolList.length; k++) //from after npc 'X'
                        {
                            if (tileChosen == k) //other symbols beside enemy ('Y') & player '@'
                            {
                                tile[i][j] = symbolList[k];
                                System.out.print(tile[i][j] + " ");
                            }
                        }
                    }
                }

                if ((i == 0 || i == size - 1) && j < size) //row 1 or last, AND all column
                {
                    tile[i][j] = '-';
                    System.out.print(tile[i][j] + " "); //display dash '-'
                }

                if ((j == 0 || j == size - 1) && (i >= 1 && i < size - 1)) //column 1 or last, AND row 2 until row
                {
                    tile[i][j] = '|';
                    System.out.print(tile[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
/*
    public void convertToTiles(Graphics g) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tile[i][j] == symbolList[1]) {
                    g.drawImage(type.enemy(), i * 32, j * 32, null);
                }
                if (tile[i][j] == symbolList[2]) {
                    g.drawImage(type.npc(), i * 32, j * 32, null);
                }
                if (tile[i][j] == symbolList[0]) {
                    g.drawImage(type.player(), i * 32, j * 32, null);
                } else {
                    for (int k = 3; k < symbolList.length; k++) {

                        if (symbolList[k] == ';') {
                            g.drawImage(type.grass1(), i * 32, j * 32, null);
                        }
                        if (symbolList[k] == '`') {
                            g.drawImage(type.grass2(), i * 32, j * 32, null);
                        }
                        if (symbolList[k] == '.') {
                            g.drawImage(type.grass3(), i * 32, j * 32, null);
                        }
                        if (symbolList[k] == ',') {
                            g.drawImage(type.grass4(), i * 32, j * 32, null);
                        }
                        if (symbolList[k] == '^') {
                            g.drawImage(type.grass5(), i * 32, j * 32, null);
                        }
                        if (symbolList[k] == '#') {
                            g.drawImage(type.grass6(), i * 32, j * 32, null);
                        }
                        if (symbolList[k] == '*') {
                            g.drawImage(type.water(), i * 32, j * 32, null);
                        }
                        if (symbolList[k] == '=') {
                            g.drawImage(type.desert(), i * 32, j * 32, null);
                        }
                    }
                }
            }
        }

    }
*/
    
    /*public void displayTiles() 
    //[IGNORE]display all tiles with symbols (symbolList index already including wall, can print wall because has been assigned in method randomWallTiles
    {
        Random rand = new Random();
        for(int i = 0; i < a; i++)
        {
            for(int j = 0; j < a; j++)
            {
                //tile[i][j] = symbolList[rand.nextInt(symbolList.length)];
                System.out.print(tile[i][j] + " ");
            }
            System.out.println("");
        }
    }*/
    public static void main(String[] args) {
        MapsBasic tiles = new MapsBasic();
        // tiles.generateDisplayRandomSymbols(g);
    }
}

/*

                    if (symbolList[k] == ';') {
                        g.drawImage(objectSet.crop(0, 64, 32, 32), i * 32, j * 32, null);
                    }
                    if (symbolList[k] == '`') {
                        g.drawImage(objectSet.crop(224, 32, 32, 32), i * 32, j * 32, null);
                    }
                    if (symbolList[k] == '.') {
                        g.drawImage(objectSet.crop(224, 96, 32, 32), i * 32, j * 32, null);
                    }
                    if (symbolList[k] == ',') {
                        g.drawImage(objectSet.crop(224, 160, 32, 32), i * 32, j * 32, null);
                    }
                    if (symbolList[k] == '^') {
                        g.drawImage(objectSet.crop(64, 64, 32, 32), i * 32, j * 32, null);
                    }
                    if (symbolList[k] == '#') {
                        g.drawImage(objectSet.crop(64, 96, 32, 32), i * 32, j * 32, null);
                    }
                    if (symbolList[k]

 */

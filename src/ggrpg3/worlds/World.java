package ggrpg3.worlds;

import ggrpg3.Game;
import ggrpg3.GetEverything;
import java.awt.Graphics;

import ggrpg3.tiles.Tile;

public class World {

    private GetEverything everything;
    private int width, height;
    private int[][] tiles;
    private MapsBasic maps = new MapsBasic();
    

    public World(GetEverything everything, String path) {
        this.everything = everything;
        loadWorld(path);
        
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                getTile(x, y).render(g, x * Tile.TILEWIDTH,
                        y * Tile.TILEHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.grassTile2;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.desertTile;
        }
        return t;
    }
    
    
    public int getEnemyPositionX(int i, int j) {  
        int widthX = width;
        int heightX = height;
        char[] cX = maps.getSymbolList(); //array symbol yasmin
        char[][] tX = maps.getTiles();
        int a = 0;
        
        for (i = 0; i < widthX; i++) {
            for (j = 0; j < heightX; j++) {
                if (tX[i][j] == cX[1]) {
                    a = widthX;
                    break;
                }
            }
        }
        return a;
    }
    
        public int getEnemyPositionY(int i, int j) {  
        int widthX = width;
        int heightX = height;
        char[] cX = maps.getSymbolList(); //array symbol yasmin
        char[][] tX = maps.getTiles();
        int a = 0;
        
        for (i = 0; i < widthX; i++) {
            for (j = 0; j < heightX; j++) {
                if (tX[i][j] == cX[1]) {
                    a = heightX;
                    break;
                }
            }
        }
        return a;
    }
    
    
    
    /*
    public int getEnemyPositionX() {  
        loadWorld("");
        int widthX = width;
        int heightX = height;
        char[] cX = maps.getSymbolList(); //array symbol yasmin
        char[][] tX = maps.getTiles();
        int a = 0;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (tX[i][j] == cX[1]) {
                    a = widthX;
                    break;
                    
                }
            }
        }
        return a;
    }
    
    public int getEnemyPositionY() {  
        loadWorld("");
        int widthY = width;
        int heightY = height;
        char[] cY = maps.getSymbolList(); //array symbol yasmin
        char[][] tY = maps.getTiles();
        int a = 0;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (tY[i][j] == cY[1]) {
                    a = heightY;
                    break;
                }
            }
        }
        return a;
    }
    */
    
    /*
    public int getEnemyPositionY() {
        width = maps.getSize();
        height = maps.getSize();
        char[] c = maps.getSymbolList(); //array symbol yasmin
        char[][] t = maps.getTiles();
        int a = 0;
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (t[i][j] == c[1]) {
                    a = height;
                }
            }
        }
        return a;
    }
    */
    
    private void loadWorld(String path) {
        maps.generateDisplayRandomSymbols(); // yasmin's dynamic map
        width = maps.getSize();
        height = maps.getSize();
        char[] c = maps.getSymbolList(); //array symbol yasmin
        char[][] t = maps.getTiles();   // array map yasmin
        tiles = new int[width][height]; // new array to read id

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (t[i][j] == c[1]) { //enemy
                    tiles[i][j] = 11;
                }
                if (t[i][j] == c[2]) { //npc
                    tiles[i][j] = 12;
                }
                if (t[i][j] == c[0]) { //player
                    tiles[i][j] = 10;
                }
                if (t[i][j] == c[3]) { // grass1
                    tiles[i][j] = 0;
                }
                if (t[i][j] == c[4]) {
                    tiles[i][j] = 1;
                }
                if (t[i][j] == c[5]) {
                    tiles[i][j] = 2;
                }
                if (t[i][j] == c[6]) { // grass4
                    tiles[i][j] = 3;
                }
                if (t[i][j] == c[7]) { // grass4
                    tiles[i][j] = 3;
                }
                if (t[i][j] == c[8]) { // stone2
                    tiles[i][j] = 5;
                }
                if (t[i][j] == c[9]) {
                    tiles[i][j] = 7;
                }
                if (t[i][j] == c[10]) {
                    tiles[i][j] = 6;
                }
                if (t[i][j] == '|' || t[i][j] == '-') {
                    tiles[i][j] = 8;
                }

            }
        }

        /*
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (t[i][j] == c[1]) {
                    g.drawImage(type.enemy(), i * 32, j * 32, null);
                }
                if (t[i][j] == c[2]) {
                    g.drawImage(type.npc(), i * 32, j * 32, null);
                }
                if (t[i][j] == c[0]) {
                    g.drawImage(type.player(), i * 32, j * 32, null);
                } else {
                    for (int k = 3; k < c.length; k++) {

                        if (c[k] == ';') {
                            g.drawImage(type.grass1(), i * 32, j * 32, null);
                        }
                        if (c[k] == '`') {
                            g.drawImage(type.grass2(), i * 32, j * 32, null);
                        }
                        if (c[k] == '.') {
                            g.drawImage(type.grass3(), i * 32, j * 32, null);
                        }
                        if (c[k] == ',') {
                            g.drawImage(type.grass4(), i * 32, j * 32, null);
                        }
                        if (c[k] == '^') {
                            g.drawImage(type.grass5(), i * 32, j * 32, null);
                        }
                        if (c[k] == '#') {
                            g.drawImage(type.grass6(), i * 32, j * 32, null);
                        }
                        if (c[k] == '*') {
                            g.drawImage(type.water(), i * 32, j * 32, null);
                        }
                        if (c[k] == '=') {
                            g.drawImage(type.desert(), i * 32, j * 32, null);
                        }
                    }
                }
            }
        }*/
    }
}

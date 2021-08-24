package ggrpg3.tiles;

import ggrpg3.tiles.type.PlayerTile;
import ggrpg3.tiles.type.GrassTile3;
import ggrpg3.tiles.type.GrassTile1;
import ggrpg3.tiles.type.StoneTile2;
import ggrpg3.tiles.type.StoneTile1;
import ggrpg3.tiles.type.EnemyTile;
import ggrpg3.tiles.type.WallTile;
import ggrpg3.tiles.type.DesertTile;
import ggrpg3.tiles.type.GrassTile2;
import ggrpg3.tiles.type.WaterTile;
import ggrpg3.tiles.type.NpcTile;
import ggrpg3.tiles.type.GrassTile4;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC STUFF HERE
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile1 = new GrassTile1(0);
        public static Tile grassTile2 = new GrassTile2(1);
        public static Tile grassTile3 = new GrassTile3(2);
        public static Tile grassTile4 = new GrassTile4(3);
	public static Tile stoneTile1 = new StoneTile1(4);
	public static Tile stoneTile2 = new StoneTile2(5);
        public static Tile desertTile = new DesertTile(6);
        public static Tile waterTile = new WaterTile(7);
        public static Tile wallTile1 = new WallTile(8);
        public static Tile wallTile2 = new WallTile(9);
        public static Tile playerTile = new PlayerTile(10);
        public static Tile enemyTile = new EnemyTile(11);
        public static Tile npcTile = new NpcTile(12);
        
        // YX@ - enemy, npc, player
        // ;`., - grass
        // ^# - stones
        // * - water
        // = - desert
        // |- - wall
	
	//CLASS
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64; // 64 64 initially
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
        
        public boolean isEnemy(){
            return false;
        }
	
	public boolean isSolid(){
		return false;
	}
        
        public boolean isNPC() {
            return false;
        }
	
	public int getId(){
		return id;
	}

	
}

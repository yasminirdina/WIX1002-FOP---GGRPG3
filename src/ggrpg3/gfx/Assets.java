package ggrpg3.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage playerMove, enemyMove, npcMove;
        public static BufferedImage stone1, stone2, grass1, grass2, grass3, grass4, grass5, grass6, desert, water, npc, player, enemy, wall;

	public static void init(){
		ImageSet sheet = new ImageSet(ImageLoader.loadImage("/textures/floortileset.png"));
                ImageSet playerimg = new ImageSet(ImageLoader.loadImage("/textures/alvin.png"));
                ImageSet enemyimg = new ImageSet(ImageLoader.loadImage("/textures/glooRotated.png"));
                ImageSet pandaimg = new ImageSet(ImageLoader.loadImage("/textures/Panda.png"));
                
                
                
                //cropped images
                grass1 = sheet.crop(0, 2*height, width, height);
                grass2 = sheet.crop(width, 7*height, width, height);
                grass3 = sheet.crop(6*width, 7*height, width, height);
                grass4 = sheet.crop(3*width, 2*height, width, height);
                stone1 = sheet.crop(2*width, 5*height, width, height);
                stone2 = sheet.crop(2*width, 5*height, width, height);
                water = sheet.crop(4*width, 5*height, width, height);
                desert = sheet.crop(0, 6*height, width, height);
                wall = sheet.crop(2*width, 4*height, width, height);
                npc = sheet.crop(width, 7*height, width, height);
                npcMove = pandaimg.crop(0, 0, width, height);
                player = sheet.crop(width, 7*height, width, height);
                playerMove = playerimg.crop(0, 0, width, height);
                enemy = sheet.crop(3*width, 2*height, width, height);
                enemyMove = enemyimg.crop(0, 0, width, height);
                
             
	}
	
}

package ggrpg3.gfx;

import java.awt.image.BufferedImage;

public class ImageSet {

	private BufferedImage sheet;
	
	public ImageSet(BufferedImage sheet){
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage(x, y, width, height);
	}
	
}

package org.uqbar.arkanoid.utils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.uqbar.vainilla.appearances.Sprite;

public class TetrisSpriteSheetHelper {
	
	final static String imageFileName = "images/tetris_sprite_sheet.jpg";
	
	
	
	public static Sprite getLargeBlock() {
		return getSpriteFromImage().crop(0, 30, 32, 8 );
	}
	
	public static Sprite getLargeBlock(Color color) {
		return getSpriteFromImage().crop(getColorInitialPosition(color), 30, 32, 8 );
	}
	
	private static Sprite getSpriteFromImage() {
		return Sprite.fromImage(imageFileName);
	}
	
	private static Integer getColorInitialPosition(Color color) {
		Map<Color, Integer> map = new HashMap<Color,Integer>();
		
		map.put(Color.BLUE, 0);
		map.put(Color.GRAY, 34);
		map.put(Color.GREEN, 68);
		map.put(Color.CYAN, 102);
		map.put(Color.RED, 136);
		map.put(Color.YELLOW, 170);
		if( map.containsKey(color)) {
			return map.get(color);
		}
		return 0;
	}
	
}

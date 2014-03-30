package tacoguy56.ccgdx.util;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.cookies.CookieManager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FontHelper {
	private static BitmapFont bmpfnt;
	public static void init(){
		bmpfnt = new BitmapFont();
	}
	public static void printCookies(SpriteBatch c){
		bmpfnt.setColor(Color.CYAN);
		bmpfnt.draw(c, "Cookies: " + Integer.toString(Game.cookies), 10, 100);
		int x = CookieManager.CPS % 10;
		int y = CookieManager.CPS / 10;
		bmpfnt.draw(c, "Per Second: " + Integer.toString(y) + "." + Integer.toString(x), 10, 80);
	}
	public static void printString(String s, SpriteBatch b, Color c, int x, int y){
		bmpfnt.setColor(c);
		bmpfnt.draw(b, s, x, y);
	}
}

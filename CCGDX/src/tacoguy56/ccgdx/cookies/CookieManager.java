package tacoguy56.ccgdx.cookies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.button.ButtonHandler;
import tacoguy56.ccgdx.util.FontHelper;
public class CookieManager {
	private static boolean manuCookieBool = false;
	private static int cursorPrice = 15;
	private static int cursorNum;
	public static void tick(SpriteBatch b) throws Exception{
		FontHelper.printCookies(b);
		if(ButtonHandler.getButtonByID("Cookie").currentMouseInteraction == 2){
			if(!manuCookieBool){
				Game.cookies++;
			}
			manuCookieBool = true;
			} else if(ButtonHandler.getButtonByID("Cookie").currentMouseInteraction == 1){
			manuCookieBool = false;	
		}
		if(Game.cookies >= cursorPrice){
			ButtonHandler.setEnabled("Cursor", true);
		} else{
			ButtonHandler.setEnabled("Cursor", false);
		}
		if(ButtonHandler.getButtonByID("Cursor").currentMouseInteraction == 2 && Game.cookies >= cursorPrice){
			if(!manuCookieBool){
				cursorNum++;
				Game.cookies -= cursorPrice;
				cursorPrice *= 1.13;
			}
			manuCookieBool = true;
			} else if(ButtonHandler.getButtonByID("Cursor").currentMouseInteraction == 1){
			manuCookieBool = false;	
		}
		FontHelper.printString(Integer.toString(cursorNum), b, Color.BLACK, 380, 220);
	}
}

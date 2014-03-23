package tacoguy56.ccgdx.cookies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.button.ButtonHandler;
import tacoguy56.ccgdx.util.FontHelper;
public class CookieManager {
	private static boolean manuCookieBool = false;
	public static void tick(SpriteBatch b) throws Exception{
		FontHelper.printCookies(b);
		if(ButtonHandler.getButtonByID("Cookie").currentMouseInteraction == 2){
			if(!manuCookieBool){
				Game.cookies++;
			}
			manuCookieBool = true;
			} else{
			manuCookieBool = false;	
		}
	}
}

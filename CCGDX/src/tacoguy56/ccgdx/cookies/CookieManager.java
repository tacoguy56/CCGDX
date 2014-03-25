package tacoguy56.ccgdx.cookies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.button.ButtonCPS;
import tacoguy56.ccgdx.button.ButtonHandler;
import tacoguy56.ccgdx.util.FontHelper;
public class CookieManager {
	private static boolean manuCookieBool = false;
	public static void tick(SpriteBatch b) throws Exception{
		FontHelper.printCookies(b);
		for(int i = 0; i < ButtonHandler.buttons.size(); i++){
			if(ButtonHandler.buttons.get(i) instanceof ButtonCPS){
				ButtonCPS bcps = (ButtonCPS) ButtonHandler.buttons.get(i);
				FontHelper.printString(Integer.toString(bcps.amount), b, Color.BLACK, bcps.position.x, bcps.position.y);
			}
		}
	}
}

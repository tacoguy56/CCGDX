package tacoguy56.ccgdx.cookies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.button.ButtonCPS;
import tacoguy56.ccgdx.button.ButtonHandler;
import tacoguy56.ccgdx.util.FontHelper;
import tacoguy56.ccgdx.util.Util;
public class CookieManager {
	private static int CPS;
	private static int centicookies = 0;
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
	private static boolean buffer;
	public static void addCookies(){
				Game.cookies += (CPS - CPS % 100 ) / 100;
				centicookies += CPS % 100;
				if(centicookies >= 100){
					centicookies -= 100;
					Game.cookies++;
				}
	}
	public static void updateCPS(){
		CPS = 0;
		for(int i = 0; i < ButtonHandler.buttons.size(); i++){
			if(ButtonHandler.buttons.get(i) instanceof ButtonCPS){
				ButtonCPS bcps = (ButtonCPS) ButtonHandler.buttons.get(i);
				CPS += (bcps.CPSPerButton * bcps.amount);
			}
		}
	}
}

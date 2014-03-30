package tacoguy56.ccgdx.util;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.cookies.CookieManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Util {
	private static long startTime;
	public static long runTime;
	public static Texture strToTex(String s){
		return new Texture(Gdx.files.internal(s));
	}
	public static void init(){
		startTime = System.currentTimeMillis();
	}
	private static boolean buffer = false;
	private static long cycles = 0;
	public static void updateRuntime(){
		runTime = System.currentTimeMillis() - startTime;
		if((int)Util.runTime / 100 >= cycles){
			cycles++;
			CookieManager.addCookies();
		}
	}
}

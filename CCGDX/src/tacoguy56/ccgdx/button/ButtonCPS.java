package tacoguy56.ccgdx.button;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.cookies.CookieManager;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ButtonCPS extends Button{
	public int buttonPrice;
	public int amount = 0;
	public int CPSPerButton;
	public ButtonCPS(int x, int y, Texture idle, Texture hover, Texture click, Texture disabled,
			String ID, int startPrice, int startCPS) {
		super(x, y, idle, hover, click, disabled, ID);
		this.buttonPrice = startPrice;
		this.CPSPerButton = startCPS;
	}
	@Override
	public void tick(){
		if(Game.cookies >= this.buttonPrice){
			this.enabled = true;
		} else{
			this.enabled = false;
		}
		super.tick();
	}
	@Override
	public void clicked(){
		if(this.enabled){
		amount++;
		Game.cookies -= buttonPrice;
		buttonPrice *= 1.15;
		CookieManager.updateCPS();
		}
	}
}

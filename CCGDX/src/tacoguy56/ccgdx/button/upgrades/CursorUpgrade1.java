package tacoguy56.ccgdx.button.upgrades;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.button.Button;
import tacoguy56.ccgdx.button.ButtonCPS;
import tacoguy56.ccgdx.button.ButtonHandler;
import tacoguy56.ccgdx.button.ButtonUpgrade;
import tacoguy56.ccgdx.cookies.CookieManager;

import com.badlogic.gdx.graphics.Texture;

public class CursorUpgrade1 extends ButtonUpgrade{
	public CursorUpgrade1(int x, int y, int xs, int ys, Texture idle, Texture hover, Texture click, Texture disable, Texture description, String ID, int price){
		super(x, y, xs, ys, idle, hover, click, disable, description, ID, price);
	}
	@Override
	public void tick(){
		if(Game.cookies >= this.price){
			this.enabled = true;
		} else{
			this.enabled = false;
		}
		super.tick();
	}
	@Override
	public boolean conditions(){
		//if you have at least 1 cursor, return true
		if(((ButtonCPS)ButtonHandler.buttons.get(1)).amount > 0){
		return true;
		}
		return false;
		
	}
	@Override
	public void clicked(){
		if(this.enabled){
		Game.cookies -= price;
		ButtonHandler.setButtonCPS(ButtonHandler.getButtonCPS("Cursor") * 2, "Cursor");
		try {
			ButtonHandler.setCPC(ButtonHandler.getButtonByID("Cookie").getCPC() * 2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.clicked();
	}
}
}


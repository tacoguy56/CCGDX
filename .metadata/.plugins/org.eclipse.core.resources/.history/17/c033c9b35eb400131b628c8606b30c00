package tacoguy56.ccgdx.button;

import com.badlogic.gdx.graphics.Texture;

public class ButtonCPS extends Button{
	public int buttonPrice;
	public int amount = 0;
	public ButtonCPS(int x, int y, Texture idle, Texture hover, Texture click,
			String ID, int startPrice) {
		super(x, y, idle, hover, click, ID);
		this.buttonPrice = startPrice;
	}
	@Override
	public void clicked(){
		amount++;
		buttonPrice *= 1.15;
	}
}

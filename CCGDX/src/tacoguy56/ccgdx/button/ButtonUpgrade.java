package tacoguy56.ccgdx.button;

import tacoguy56.ccgdx.Game;

import com.badlogic.gdx.graphics.Texture;

public class ButtonUpgrade extends Button{
	public final int price;
	public Texture description;
	public ButtonUpgrade(int x, int y, int xs, int ys, Texture idle, Texture hover, Texture click, Texture disable, Texture description, String ID, int price){
		super(x, y, idle, hover, click, disable, ID);
		this.setSize(xs, ys);
		this.price = price;
		this.description = description;
	}
	@Override
	public void tick(){
		if(Game.cookies >= price){
			this.enabled = true;
		} else{
			this.enabled = false;
		}
		super.tick();
	}
	public boolean conditions(){
		return false;
	}
	//IMPORTANT -- when implimenting a new upgrade, do super.clicked() after everything else is completed!!!
	@Override
	public void clicked(){
		if(enabled){
		ButtonHandler.deleteButtonByID(this.getID());
	
		}
		}
}

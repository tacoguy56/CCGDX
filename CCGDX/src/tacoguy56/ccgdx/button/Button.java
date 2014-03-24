package tacoguy56.ccgdx.button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.Size;
import tacoguy56.ccgdx.Thing;

public class Button extends Thing{
	private boolean isMouseHovering;
	private Texture texture;
	private Sprite sprite;
	public short currentMouseInteraction = 0;
	private Texture idle;
	private Texture hover;
	private Texture click;
	public static boolean enabled;
	private String ID;
	public Button(int x, int y, Texture idle, Texture hover, Texture click, String ID) {
		super(x, y);
		this.idle = idle;
		this.hover = hover;
		this.click = click;
		this.setTexture(idle);
		this.ID = ID;
	}
	public String getID(){
		return this.ID;
	}
	public void tick(){
		//the following variables are unnessecary, the if statement was just getting ridiculously big
		boolean x = false;
		boolean y = false;
		if(Game.trueX <= this.position.x + this.size.x && Game.trueX >= this.position.x){
			x = true;
		}
		if(Game.trueY <= this.position.y + this.size.y && Game.trueY >= this.position.y){
			y = true;
		}
		if(x && y){
			isMouseHovering = true;
		} else{
			isMouseHovering = false;
		}
		if(!isMouseHovering){
			//mouse not hovering over button
			if(currentMouseInteraction != 0){
				this.setTexture(idle);
			}
			currentMouseInteraction = 0;
		} else if(!Gdx.input.isButtonPressed(Buttons.LEFT)) {
			//mouse hovering over button
			if(currentMouseInteraction != 1){
				this.setTexture(hover);
			}
			currentMouseInteraction = 1;
		} else{
			//mouse down and hovering over button
			if(currentMouseInteraction != 2){
				this.setTexture(click);
			}
			currentMouseInteraction = 2;
		}
		if(!enabled){
			this.setTexture(click);
		}
	}
	
}

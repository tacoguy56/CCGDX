package tacoguy56.ccgdx;

import tacoguy56.ccgdx.button.ButtonCPS;
import tacoguy56.ccgdx.util.FontHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Thing{
	protected Texture texture;
	protected Sprite sprite;
	public Size size;
	public Size origin;
	public Size position;
	public Thing(int x, int y) {
		origin = new Size(0, 0);
		position = new Size(200, 200);	
		texture = new Texture(Gdx.files.internal("./bin/temp.png"));
		sprite = new Sprite(texture);
		size = new Size(x, y);
		sprite.setSize(this.size.x, this.size.y);
		sprite.setOrigin(0, 0);
		sprite.setPosition(200, 200);
	}
	public void setOrigin(int x, int y){
		this.origin.x = x;
		this.origin.y = y;
		sprite.setOrigin(this.origin.x, this.origin.y);
	}
	public void setPosition(int x, int y){
		position.x = x;
		position.y = y;
		sprite.setPosition(position.x, position.y);
	}
	public void setSize(int x, int y){
		this.size.x = x;
		this.size.y = y;
		this.sprite.setSize(this.size.x, this.size.y);
	}
	public void dispose() {
		texture.dispose();
	}
	public void setTexture(String s){
		System.out.println("Tried to set texture");
		this.setTexture(new Texture(Gdx.files.internal(s)));
	}
	public void setTexture(Texture t){
		texture = t;
		sprite.setTexture(texture);
	}
	public void render(SpriteBatch b) {	
		sprite.draw(b);
		if(this instanceof ButtonCPS){
			if(((ButtonCPS)this).currentMouseInteraction > 0){
			FontHelper.printString(Integer.toString(((ButtonCPS)this).buttonPrice), b, Color.GREEN, this.position.x, this.position.y + (this.size.y / 2));
		}
		}
	}
}

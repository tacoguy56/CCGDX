package tacoguy56.ccgdx;



import java.util.List;

import tacoguy56.ccgdx.button.Button;
import tacoguy56.ccgdx.button.ButtonHandler;
import tacoguy56.ccgdx.cookies.CookieManager;
import tacoguy56.ccgdx.util.ClickHandler;
import tacoguy56.ccgdx.util.FontHelper;
import tacoguy56.ccgdx.util.Util;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Game implements ApplicationListener {
	private OrthographicCamera camera;
	public SpriteBatch batch;
	private static int trueHeight;
	private static int trueWidth;
	public static int trueY;
	public static int trueX;
	public static int cookies = 0;
	//public static Button t;
	@Override
	public void create() {
		FontHelper.init();
		//t = new Button(200, 200, Util.strToTex("./bin/Idle.png"), Util.strToTex("./bin/Hover.png"), Util.strToTex("./bin/Click.png"), "Cookie");
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		ButtonHandler.addButton(0, 0, 200, 200, Util.strToTex("./bin/Idle.png"), Util.strToTex("./bin/Hover.png"), Util.strToTex("./bin/Click.png"), "Cookie");
		ButtonHandler.addButtonCPS(380, 220, 100, 100, Util.strToTex("./bin/Cursor/CursorIdle.png"), Util.strToTex("./bin/Cursor/CursorHover.png"), Util.strToTex("./bin/Cursor/CursorClick.png"), "Cursor", 15, 1);
		trueHeight = Gdx.graphics.getHeight();
		trueWidth = Gdx.graphics.getWidth();
		Util.init();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}
	@Override
	public void render() {
		//pre-pre-render stuff
		Util.updateRuntime();
		//pre-render stuffs
		trueY = (Gdx.graphics.getHeight() - Gdx.input.getY()) * trueHeight / Gdx.graphics.getHeight();
		trueX = (Gdx.input.getX()) * trueWidth / Gdx.graphics.getWidth();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		ClickHandler.tick();
		//begin rendering stuffs
		batch.begin();
		List<Button> buttons = ButtonHandler.buttons;
		for(int i = 0; i < buttons.size(); i++){
			buttons.get(i).tick();
			buttons.get(i).render(batch);
		}
		try {
			CookieManager.tick(batch);
		} catch (Exception e) {
			System.out.println("ERRROOOOOORRRR with getting a button by ID");
		}
		//t.tick();
		batch.end();
		//post rendering stuffs
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}

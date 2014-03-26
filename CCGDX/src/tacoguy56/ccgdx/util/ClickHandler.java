package tacoguy56.ccgdx.util;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;

import tacoguy56.ccgdx.Game;
import tacoguy56.ccgdx.button.Button;
import tacoguy56.ccgdx.button.ButtonHandler;

public class ClickHandler {
	private static boolean clickBoolean;
	public static void tick(){
		boolean mouse = Gdx.input.isButtonPressed(Buttons.LEFT);
		if(mouse){
			if(!clickBoolean){
				findClick();
			}
			clickBoolean = true;
			} else{
			clickBoolean = false;	
		}
	}
	private static void findClick(){
		List<Button> temp = ButtonHandler.buttons;
		for(int i = temp.size() - 1; i >= 0; i--){
			if(temp.get(i).currentMouseInteraction > 0){
				ButtonHandler.clickButton(i);
				return;
			}
		}
	}
}

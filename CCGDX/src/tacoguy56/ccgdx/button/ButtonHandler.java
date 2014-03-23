package tacoguy56.ccgdx.button;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

public class ButtonHandler {
	public static List<Button> buttons = new ArrayList<Button>();

	public static void addButton(int x, int y, int sizeX, int sizeY, Texture idle, Texture hover, Texture click, String ID){
		Button b = new Button(sizeY, sizeX, idle, hover, click, ID);
		b.setPosition(x, y);
		buttons.add(b);
		System.out.println("Added button " + ID);
	}
	public static Button getButtonByID(String ID) throws Exception{
		for(int i = 0; i < 12; i++){
			if(buttons.get(i).getID() == ID){
				return buttons.get(i);
			}
		}
		throw new Exception("Called for a button ID that does not exist!");
	}
}

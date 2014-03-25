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
	public static void addButtonCPS(int x, int y, int sizeX, int sizeY, Texture idle, Texture hover, Texture click, String ID, int startPrice){
		ButtonCPS b = new ButtonCPS(sizeY, sizeX, idle, hover, click, ID, startPrice);
		b.setPosition(x, y);
		buttons.add(b);
		System.out.println("Added button " + ID);
	}

	public static Button getButtonByID(String ID) throws Exception{
		return buttons.get(buttonByIDInt(ID));
	}
	private static int buttonByIDInt(String ID) throws Exception{
		for(int i = 0; i < buttons.size(); i++){
			if(buttons.get(i).getID() == ID){
				return i;
			}
		}
		throw new Exception("Called for a button ID that does not exist!");
	}
	public static void setEnabled(String ID, boolean bool){
		try {
			Button temp = getButtonByID(ID);
			temp.enabled = bool;
			buttons.set(buttonByIDInt(ID), temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void clickButton(String ID){
		try {
			Button temp = getButtonByID(ID);
			temp.clicked();
			buttons.set(buttonByIDInt(ID), temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void clickButton(int index){
		Button temp = buttons.get(index);
		temp.clicked();
		buttons.set(index, temp);
	}
}

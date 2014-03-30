package tacoguy56.ccgdx.button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tacoguy56.ccgdx.cookies.CookieManager;

import com.badlogic.gdx.graphics.Texture;

public class ButtonHandler {
	public static List<Button> buttons = new ArrayList<Button>();
	private static List<ButtonUpgrade> allUpgrades = new ArrayList<ButtonUpgrade>();
	public static void addButton(int x, int y, int sizeX, int sizeY,
			Texture idle, Texture hover, Texture click, Texture disabled,
			String ID) {
		Button b = new Button(sizeY, sizeX, idle, hover, click, disabled, ID);
		b.setPosition(x, y);
		buttons.add(b);
		System.out.println("Added button " + ID);
	}

	public static void addButtonCPS(int x, int y, int sizeX, int sizeY,
			Texture idle, Texture hover, Texture click, Texture disabled,
			String ID, int startPrice, int startCPS) {
		ButtonCPS b = new ButtonCPS(sizeY, sizeX, idle, hover, click, disabled,
				ID, startPrice, startCPS);
		b.setPosition(x, y);
		buttons.add(b);
		System.out.println("Added button " + ID);
	}

	public static void addButton(Button b) {
		buttons.add(b);
	}

	public static void deleteButtonByID(String ID) {
		try {
			buttons.remove(buttonByIDInt(ID));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Button getButtonByID(String ID) throws Exception {
		return buttons.get(buttonByIDInt(ID));
	}

	private static int buttonByIDInt(String ID) throws Exception {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i).getID() == ID) {
				return i;
			}
		}
		throw new Exception("Called for a button ID that does not exist!");
	}

	public static void setEnabled(String ID, boolean bool) {
		try {
			Button temp = getButtonByID(ID);
			temp.enabled = bool;
			buttons.set(buttonByIDInt(ID), temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void setButtonCPS(int cps, String ID){
		Button temp = null;
		try {
			temp = ButtonHandler.getButtonByID(ID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((ButtonCPS)temp).CPSPerButton = cps;
		CookieManager.updateCPS();
	}
	public static int getButtonCPS(String ID){
		int i = 0;
		try {
			i = ((ButtonCPS)(getButtonByID(ID))).CPSPerButton;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static void setCPC(int cpc){
		int id = 0;
		try {
			id = buttonByIDInt("Cookie");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Button b = buttons.get(id);
		b.setCPC(cpc);
		buttons.set(id, b);
	}
	public static void clickButton(String ID) {
		try {
			Button temp = getButtonByID(ID);
			temp.clicked();
			buttons.set(buttonByIDInt(ID), temp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickButton(int index) {
		Button temp = buttons.get(index);
		boolean tempBool;
		if (temp instanceof ButtonUpgrade)
			tempBool = true;
		int i = buttons.size();
		temp.clicked();
		if (buttons.size() == i) {
			buttons.set(index, temp);
			// TODO if tempbool is true; update the positioning of all of the
			// ButtonUpgrades.
		}
	}

	public static void updateUpgradePos() {
		for (int i = 0; i < buttons.size(); i++) {
			if (buttons.get(i) instanceof ButtonUpgrade) {
				allUpgrades.add((ButtonUpgrade) buttons.get(i));
				buttons.remove(i);
				i--;
			}
		}
		sortByPrice(allUpgrades);
		for(int i = 0; i < allUpgrades.size() && i < 4; i++){
			ButtonUpgrade temp = allUpgrades.get(i);
			temp.setSize(80, 80);
			temp.setPosition(400, 240 - (i * 80));
			buttons.add(temp);
		}
	}
	private static void sortByPrice(List<ButtonUpgrade> b) {
		Collections.sort(b, new Comparator<ButtonUpgrade>() {
			@Override
			public int compare(ButtonUpgrade arg0, ButtonUpgrade arg1) {
				if (arg0.price == arg1.price)
					return 0;
				if (arg0.price > arg1.price)
					return 1;
				return -1;
			}

		});
	}
}

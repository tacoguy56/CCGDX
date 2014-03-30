package tacoguy56.ccgdx.button;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

public class UpgradeHandler {
	public static List<ButtonUpgrade> allUpgrades = new ArrayList<ButtonUpgrade>();
	public static void addUpgrade(ButtonUpgrade b){
		System.out.println("Added Upgrade");
		allUpgrades.add(b);
	}
	public static void tick(){
		for(int i = 0; i < allUpgrades.size(); i++){
			if(allUpgrades.get(i).conditions()){
				System.out.println("Conditions met for " + allUpgrades.get(i).getID());
				ButtonHandler.addButton(allUpgrades.get(i));
				allUpgrades.remove(i);
				ButtonHandler.updateUpgradePos();
			}
		}
	}
}

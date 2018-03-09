package de.dyroxplays.cuberhills.lm_addon;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;

public class show_selectedkit extends SimpleModule{

	@Override
	public String getDefaultValue() {
		return null;
	}

	@Override
	public String getDisplayName() {
		return "CH × Kit";
	}

	@Override
	public String getDisplayValue() {
		return "" + cHaddon.main.selectedkit;
	}

	@Override
	public String getDescription() {
		return "Zeigt dir an, welches Kit du ausgewählt hast.";
	}

	@Override
	public String getSettingName() {
		return "CH × Kit";
	}

	@Override
	public int getSortingId() {
		return 0;
	}

	@Override
	public void loadSettings() {
	}
	
	@Override
	public IconData getIconData() {
		return new ControlElement.IconData(Material.DIAMOND_SWORD);
	}
	
	@Override
	public boolean isShown() {
		if(cHaddon.sorkpvp == false){
			return false;
		}
		try{
		return (cHaddon.sorkpvp == true) && cHaddon.main.getApi().isIngame() && (cHaddon.main.manager.isConnectedTorightServer() && cHaddon.main.hidewhennokit && !cHaddon.main.selectedkit.equalsIgnoreCase("/")) || (cHaddon.main.manager.isConnectedTorightServer() && !cHaddon.main.hidewhennokit);
		}catch(Exception ex){}
		return false;
	}
	
	@Override
	public ModuleCategory getCategory() {
		return cHaddon.main.ch_ctgry;
	}

}

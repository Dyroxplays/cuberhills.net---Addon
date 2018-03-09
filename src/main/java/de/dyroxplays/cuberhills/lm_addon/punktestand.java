package de.dyroxplays.cuberhills.lm_addon;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;

public class punktestand extends SimpleModule{

	@Override
	public String getDefaultValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		// TODO Auto-generated method stub
		return "CH × Punktestand";
	}

	@Override
	public String getDisplayValue() {
		// TODO Auto-generated method stub
		return ""+cHaddon.main.pkt;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Zeigt dir an, wie viele Wins du in der aktuellen Runde hast.";
	}

	@Override
	public IconData getIconData() {
		// TODO Auto-generated method stub
		return new ControlElement.IconData(Material.IRON_SWORD);
	}

	@Override
	public String getSettingName() {
		// TODO Auto-generated method stub
		return "CH × Punktestand";
	}

	@Override
	public int getSortingId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void loadSettings() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isShown() {
		if(cHaddon.main.iscw == false){
			return false;
		}
		try{
		return (cHaddon.main.iscw == true) && cHaddon.main.getApi().isIngame() && cHaddon.main.manager.isConnectedTorightServer();
		}catch(Exception ex){}
		return false;
	}
	
	@Override
	public ModuleCategory getCategory() {
		return cHaddon.main.ch_ctgry;
	}

}

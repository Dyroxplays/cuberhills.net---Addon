package de.dyroxplays.cuberhills.lm_addon;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;

public class whichrole extends SimpleModule{

	@Override
	public String getDefaultValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		return "CH × Rolle";
	}

	@Override
	public String getDisplayValue() {
		// TODO Auto-generated method stub
		return ""+cHaddon.main.role;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Zeigt dir, welche Rolle du aktuell spielst (z.B. Spectator).";
	}

	@Override
	public IconData getIconData() {
		// TODO Auto-generated method stub
		return new ControlElement.IconData(Material.ENDER_PEARL);
	}

	@Override
	public String getSettingName() {
		// TODO Auto-generated method stub
		return "CH × Rolle";
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

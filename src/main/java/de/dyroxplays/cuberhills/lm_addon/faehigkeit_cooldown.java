package de.dyroxplays.cuberhills.lm_addon;

import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.utils.Material;

public class faehigkeit_cooldown extends SimpleModule {

	@Override
	public String getDefaultValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDisplayName() {
		return "CH × Cooldown";
	}

	// ArrayList<Long> wait = new ArrayList<Long>();
	/*
	 * TimerTask tt = new TimerTask() {
	 * 
	 * @Override public void run() {
	 * 
	 * } };
	 * 
	 * Timer t = new Timer(); t.schedule(timerTask, 1000, 1000);(non-Javadoc)
	 * 
	 * @see net.labymod.ingamegui.moduletypes.SimpleModule#getDisplayValue()
	 */

	@Override
	public String getDisplayValue() {

		// for(;;){

		/*
		 * if(this.wait == 0){ this.wait =
		 * System.currentTimeMillis()+(networkplayercount.main.secs*1000); }else
		 * if(this.wait >= System.currentTimeMillis()){ updateCount(); this.wait
		 * = System.currentTimeMillis()+(networkplayercount.main.secs*1000); }
		 */
		return "" + cHaddon.main.manager.getCD();

		// }

	}

	@Override
	public boolean isShown() {
		if(cHaddon.sorkpvp == false){
			return false;
		}
		try{
		return (cHaddon.sorkpvp == true) && cHaddon.main.getApi().isIngame() && (cHaddon.main.manager.isConnectedTorightServer() && cHaddon.main.hidewhennull && cHaddon.main.manager.getCD() > 0) || (cHaddon.main.manager.isConnectedTorightServer() && !cHaddon.main.hidewhennull && cHaddon.main.manager.getCD() >= 0);
		}catch(Exception ex){}
		return false;
		
		}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Zeigt dir an, wie lange du noch bis zur nächsten Benutzung deiner Fähigkeit warten musst.";
	}

	@Override
	public IconData getIconData() {
		// TODO Auto-generated method stub
		return new ControlElement.IconData(Material.WATCH);
	}

	@Override
	public String getSettingName() {
		return "CH × Cooldown";
	}

	@Override
	public int getSortingId() {
		return 0;
	}

	@Override
	public void loadSettings() {
	}
	
	@Override
	public ModuleCategory getCategory() {
		return cHaddon.main.ch_ctgry;
	}

}

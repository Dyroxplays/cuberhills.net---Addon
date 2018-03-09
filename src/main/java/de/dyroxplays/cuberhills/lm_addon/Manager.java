package de.dyroxplays.cuberhills.lm_addon;

import net.labymod.utils.ServerData;

public class Manager {

	public int getCD() {
		try {
			long a = cHaddon.main.a;
			if ((int) ((a - System.currentTimeMillis()) / 1000l) > 0) {
				return (int) ((a - System.currentTimeMillis()) / 1000l);
			}
		} catch (Exception ex) {
		}
		return 0;
	}
	
	public boolean isConnectedTorightServer(){
		try{
		return (cHaddon.main.ip.contains("78.31.67.33") || cHaddon.main.ip.contains("cuberhills.net"));
		}catch(Exception ex){}
		return false;
	}
}

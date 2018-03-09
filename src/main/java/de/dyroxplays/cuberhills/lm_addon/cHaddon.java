package de.dyroxplays.cuberhills.lm_addon;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.labymod.api.LabyModAddon;
import net.labymod.api.events.ServerMessageEvent;
import net.labymod.api.events.TabListEvent;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.ModuleCategoryRegistry;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ServerData;

public class cHaddon extends LabyModAddon {

	// ALLGEMEIN //
	public static cHaddon main;
	public String ip;
	public ModuleCategory ch_ctgry;
	public Manager manager;

	// KIT- SKYPVP //
	public boolean hidewhennull;
	public static boolean sorkpvp = false;
	public long a;

	public boolean hidewhennokit;
	public String selectedkit = "/";

	// CUBEWARS //
	public boolean iscw;
	public int pkt = 0;
	public String role = "/";

	@Override
	public void onEnable() {
		main = this;

		manager = new Manager();

		ModuleCategoryRegistry.loadCategory(this.ch_ctgry = new ModuleCategory("cuberhills.net", true,
				new ControlElement.IconData("cuberhillsnet/textures/icon.png")));
		System.out.println("################################################");
		System.out.println("# [CuberHills Addon] activated!                #");
		System.out.println("# [CuberHills Addon] was coded by Dyroxplays   #");
		System.out.println("################################################");

		///////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////
		/// EVENTS ///
		///////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////

		/// TABLIST EVENT ///
		this.getApi().getEventManager().register(new TabListEvent() {
			@Override
			public void onUpdate(Type t, String s1, String s2) {
				if (t == t.HEADER) {
					if (s2.contains("KitPvP") || s2.contains("SkyPvP")) {
						cHaddon.main.sorkpvp = true;
						return;

					}

					if (s2.contains("CubeWars")) {
						cHaddon.main.iscw = true;
						return;
					}

					cHaddon.main.iscw = false;
					cHaddon.main.sorkpvp = false;
					return;
				}

			}
		});

		/// JOIN EVENT ///
		this.getApi().getEventManager().registerOnJoin(new Consumer<ServerData>() {

			public void accept(final ServerData sd) {
				try {
					cHaddon.main.ip = "" + String.valueOf(InetAddress.getByName(sd.getIp())).replace("/", "");
				} catch (UnknownHostException e) {
				}
			}

		});

		/// GET SERVER MESSAGE EVENT ///
		this.getApi().getEventManager().register(new ServerMessageEvent() {

			public void onServerMessage(String messageKey, JsonElement serverMessage) {
				if (messageKey.equals("CH-abilitycd") && serverMessage.isJsonObject()) {
					JsonObject cooldownobj = serverMessage.getAsJsonObject();
					if (cooldownobj.has("ch_abilitycd")) {
						cHaddon.main.a = (long) (cooldownobj.get("ch_abilitycd").getAsLong() * 1000
								+ System.currentTimeMillis());
					}
				}

				if (messageKey.equals("CH-selectedkit") && serverMessage.isJsonObject()) {
					JsonObject selectedkit = serverMessage.getAsJsonObject();
					if (selectedkit.has("ch_selectedkit")) {

						cHaddon.main.selectedkit = selectedkit.get("ch_selectedkit").getAsString();

					}
				}

				if (messageKey.equals("CH-cw") && serverMessage.isJsonObject()) {
					JsonObject selectedkit = serverMessage.getAsJsonObject();
					if (selectedkit.has("ch_role")) {

						cHaddon.main.role = selectedkit.get("ch_role").getAsString();

					}

					if (selectedkit.has("ch_pkt")) {

						cHaddon.main.pkt = selectedkit.get("ch_pkt").getAsInt();

					}
				}
			}

		});
		///////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////

		registerModules();
	}

	@Override
	public void onDisable() {
		System.out.println("################################################");
		System.out.println("# [CuberHills Addon] deactivated!              #");
		System.out.println("# [CuberHills Addon] was coded by Dyroxplays   #");
		System.out.println("################################################");
	}

	@Override
	public void loadConfig() {
		this.hidewhennull = getConfig().has("hidewhennull") ? getConfig().get("hidewhennull").getAsBoolean() : false;
		this.hidewhennokit = getConfig().has("hidewhennokit") ? getConfig().get("hidewhennokit").getAsBoolean() : false;
	}

	@Override
	protected void fillSettings(List<SettingsElement> list) {
		list.add(new BooleanElement("Cooldown ausblenden bei 0", this, new IconData(Material.WATCH), "hidewhennull",
				this.hidewhennull));

		list.add(new BooleanElement("Kit nur bei Auswahl anzeigen", this, new IconData(Material.DIAMOND_SWORD),
				"hidewhennokit", this.hidewhennokit));
	}

	public void registerModules() {
		this.getApi().registerModule(new faehigkeit_cooldown());
		this.getApi().registerModule(new show_selectedkit());
		this.getApi().registerModule(new whichrole());
		this.getApi().registerModule(new punktestand());
	}

}

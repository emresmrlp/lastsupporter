package me.emresmrlp.lastsupporter;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.jsoup.Jsoup;

public class LastSupporter extends JavaPlugin{
	private File urlFile =  new File(this.getDataFolder(), "url.yml");
	private YamlConfiguration url = YamlConfiguration.loadConfiguration(urlFile);
	private static LastSupporter ls;
	public void onEnable(){
		ls = this;
		if(!urlFile.exists()) {this.saveResource("url.yml", false);}
		Bukkit.getLogger().info("[LastSupporter] Plugin is actived.");
		Bukkit.getLogger().info("[LastSupporter] Developed by emresmrlp (ForestEdge)");
	}
	public static String getSupporter() {
		try {
			return Jsoup.connect(ls.url.getString("url")).get().body().text();
		} catch (IOException e) {
			return ls.url.getString("nodata");
		}
	}
}

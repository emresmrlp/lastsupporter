package me.emresmrlp.lastsupporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class LastSupporter extends JavaPlugin{
	private File urlFile =  new File(this.getDataFolder(), "url.yml");
	private YamlConfiguration url = YamlConfiguration.loadConfiguration(urlFile);
	private static LastSupporter ls;
	public void onEnable(){
		ls = this;
		if(!urlFile.exists()) {this.saveResource("url.yml", false);}
		new Placeholders().register();
		Bukkit.getLogger().info("[LastSupporter] Plugin is actived.");
		Bukkit.getLogger().info("[LastSupporter] Developed by emresmrlp (ForestEdge)");
	}
	public static String getSupporter() {
		try {
			InputStream data = new URL(ls.url.getString("url")).openStream();
			BufferedReader req = new BufferedReader(new InputStreamReader(data));
			return req.readLine();
		} catch (IOException e) {
			return ls.url.getString("nodata");
		}
	}
}
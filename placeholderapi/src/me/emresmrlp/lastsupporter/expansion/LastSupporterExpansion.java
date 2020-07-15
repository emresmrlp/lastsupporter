package me.emresmrlp.lastsupporter.expansion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.emresmrlp.lastsupporter.LastSupporter;

public class LastSupporterExpansion extends PlaceholderExpansion{
	
	private LastSupporter plugin;

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin(getPlugin()) != null;
    }

    @Override
    public boolean register() {
        if (!canRegister()) {
            return false;
        }

        plugin = (LastSupporter) Bukkit.getPluginManager().getPlugin(getPlugin());

        if (plugin == null) {
            return false;
        }

        return PlaceholderAPI.registerPlaceholderHook(getIdentifier(), this);
    }
	
	@Override
    public String getPlugin() {
        return "LastSupporter";
    }

	@Override
	public String getAuthor() {
		return "emresmrlp";
	}

	@Override
	public String getIdentifier() {
		return "lastsupporter";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}
	
	@Override
    public String onPlaceholderRequest(Player p, String identifier) {
        if(identifier.equals("name")) {
			return LastSupporter.getSupporter();
		}
        return null;
    }
}

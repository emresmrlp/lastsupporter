package me.emresmrlp.lastsupporter;

import org.bukkit.entity.Player;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class Placeholders extends PlaceholderExpansion{

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
	public String onPlaceholderRequest(Player o, String identifier) {
		if(identifier.equals("name")) {
			return LastSupporter.getSupporter();
		}
		return null;
	}
}

package br.com.treinaweb.designPatterns.creational.singleton;

public class ConfigManager {

	private static ConfigManager instance;
	private String serverName;
	
	public ConfigManager(String serverName) {
		setServerName(serverName);
	}
	
	public static ConfigManager getInstance() {
		return getInstance("Server" );
	}

	public static ConfigManager getInstance(String serverName) {
		if(ConfigManager.instance == null)
			ConfigManager.instance = new ConfigManager(serverName);
		
		return ConfigManager.instance;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

}

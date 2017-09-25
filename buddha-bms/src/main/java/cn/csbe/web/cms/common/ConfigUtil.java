package cn.csbe.web.cms.common;

import java.util.ResourceBundle;

public class ConfigUtil {

	private static Object lock = new Object();
	private static ConfigUtil config = null;
	private static ResourceBundle rb = null;
	private static final String CONFIG_FILE = "config";
	private ConfigUtil() {
		rb = ResourceBundle.getBundle(CONFIG_FILE);
	}

	public static ConfigUtil getInstance() {
		synchronized (lock) {
			if (null == config) {
				config = new ConfigUtil();
			}
		}
		return (config);
	}

	public String getValue(String key) {
		return (rb.getString(key));
	}
	
}

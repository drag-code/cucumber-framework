package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
	
	public static Logger logger = LogManager.getLogger(LoggerUtil.class);
	
	public static void logWarning(Object msg) {
		logger.warn(msg);
	}
	
	public static void logInfo(Object msg) {
		logger.info(msg);
	}
	
	public static void logError(String msg) {
		logger.error(msg);
	}
}

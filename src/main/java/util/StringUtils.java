package util;

import org.slf4j.helpers.MessageFormatter;

public class StringUtils {

    public static String sf(String messagePattern, Object... args) {
        return MessageFormatter.arrayFormat(messagePattern, args).getMessage();
    }
    
}

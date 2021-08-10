package core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static String getValue(String actualString, String regex, int groupIndex) {
        // compile the regex to create pattern
        // using compile() method
        Pattern pattern = Pattern.compile(regex);

        // get a matcher object from pattern
        Matcher matcher = pattern.matcher(actualString);

        // check whether Regex string is
        // found in actualString or not
        boolean matches = matcher.matches();
        if (matches) {
            return matcher.group(groupIndex);
        }

        return actualString;
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String result = "---武汉";
        System.out.println(isLetterDigitOrChinese(result));
        String ip = "10.0.0.1";
        System.out.println(isIp(ip));
    }

    public static boolean isLetterDigitOrChinese(String result) {
        //【含有英文】true
        String regex1 = ".*[a-zA-z].*";
        boolean hasLetter = result.matches(regex1);
        //【含有数字】true
        String regex2 = ".*[0-9].*";
        boolean hasNum = result.matches(regex2);

        //是否包含中文
        String regex3 = ".*[\\u4e00-\\u9fa5].*";
        boolean hasChinese = result.matches(regex3);
        return hasLetter | hasNum | hasChinese;
    }

    public static boolean isIp(String ipAddress) {
        String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }


}


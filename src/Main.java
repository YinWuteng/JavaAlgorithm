public class Main {

    public static void main(String[] args) {
       String result=".";
       System.out.println(isLetterDigitOrChinese(result));
    }

    public static boolean isLetterDigitOrChinese(String str) {
        String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";//其他需要，直接修改正则表达式就好
        return str.matches(regex);
    }
}


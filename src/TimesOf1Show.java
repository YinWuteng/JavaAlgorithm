/**
 * 1到n出现1的次数
 * 注意点 /(出发) 和 %（模）的区别
 */
public class TimesOf1Show {

    public static void main(String[] args) {
        System.out.println(String.valueOf(times(10)));
    }

    public static int times(int n) {
        int count = 0;
        if (n <= 0) return count;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == 1) {
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }
}

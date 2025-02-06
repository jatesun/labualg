package four;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的 正 整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数。
 * <p>
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * 提示：
 * -231 <= n <= 231 - 1
 */
public class IsUgly_263 {
    public static void main(String[] args) {
        IsUgly_263 isUgly263 = new IsUgly_263();
        System.out.println(isUgly263.isUgly(1));
    }

    public boolean isUgly(int n) {
        while (n >= 1) {
            if (n == 1) return true;
            if (n % 2 == 0) {
                n = n / 2;
                continue;
            }
            if (n % 3 == 0) {
                n = n / 3;
                continue;
            }
            if (n % 5 == 0) {
                n = n / 5;
            } else {
                break;
            }
        }
        return false;
    }
}

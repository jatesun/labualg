package four;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * <p>
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1690
 */
public class NthUglyNumber_264 {
    /**
     * 思路：规律为如果某个数n为丑数，那么n*2,n*3,n*5也为丑数
     * 我们可以初始三个列表分别代表2的丑数，3的，5的，然后开始找，找到一个丑数，将对应的列表下移动。
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        // 三个指向2，3，5丑数指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 三个2，3，5最新的值
        int product2 = 1, product3 = 1, product5 = 1;
        // （结果数组）
        int[] ugly = new int[n + 1];
        // 结果指针
        int p = 1;

        // 寻找第n个丑数
        while (p <= n) {
            // 取最小的，为当前丑数
            int min = Math.min(Math.min(product2, product3), product5);
            ugly[p] = min;
            p++;
            // 如果当前获取的min丑数为2 3 5 中，对应的需要前进一位，有公因数所以都判断。
            if (min == product2) {
                product2 = 2 * ugly[p2];
                p2++;
            }
            if (min == product3) {
                product3 = 3 * ugly[p3];
                p3++;
            }
            if (min == product5) {
                product5 = 5 * ugly[p5];
                p5++;
            }
        }
        // 返回第 n 个丑数
        return ugly[n];
    }
}

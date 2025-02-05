package four;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 5 * 106
 */
public class CountPrimes_204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];//使用筛选法
        Arrays.fill(isPrime, true);//初始都为true
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    //优化
    public int countPrimesBetter(int n) {
        boolean[] isPrime = new boolean[n];//使用筛选法
        Arrays.fill(isPrime, true);//初始都为true
        for (int i = 2; i * i < n; i++) {//由于因子的对称性，其中的 for 循环只需要遍历 [2,sqrt(n)] 就够了。
            if (isPrime[i]) {
                /**
                 * 下面的代码把 i 的整数倍都标记为 false，但是仍然存在计算冗余。
                 * 比如 n = 25，i = 5 时算法会标记 5 × 2 = 10，5 × 3 = 15 等等数字，但是这两个数字已经被 i = 2 和 i = 3 的 2 × 5 和 3 × 5 标记了。
                 * 我们可以稍微优化一下，让 j 从 i * i 开始遍历，而不是从 2 * i 开始
                 */
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}

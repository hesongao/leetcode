package leetcode.array;

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= n <= 5 * 106
 */
public class _204_CountPrimes_M_20260922 {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int[] primes = new int[n];
        int res = 0;
        Arrays.fill(primes, 1);
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                res += 1;
                if (i * i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        primes[j] = 0;
                    }
                }

            }

        }

        return res;
    }

    public int countPrimes2(int n) {
        if (n < 3) {
            return 0;
        }
        int[] primes = new int[n];
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i < n; i++) {
            for (int j = i * 2; j < n; j = j + i) {
                primes[j] = 0;
            }
        }
        return Arrays.stream(primes).sum();
    }
    public static void main(String[] args) {
        int n = 2;
        _204_CountPrimes_M_20260922 clazz = new _204_CountPrimes_M_20260922();
        System.out.println(clazz.countPrimes(n));
        System.out.println(clazz.countPrimes2(n));
    }
}

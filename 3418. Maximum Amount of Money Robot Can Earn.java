import java.util.Arrays;

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[2][n][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        dp[0][0][1] = dp[0][0][2] = 0;
        dp[0][0][0] = coins[0][0];
        for (int i = 0; i < m; i++) {
            if (i > 0) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i & 1][j], Integer.MIN_VALUE);
                }
            } 
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i > 0) {
                        dp[i & 1][j][k] = Math.max(dp[i & 1][j][k], dp[(i - 1) & 1][j][k] + coins[i][j]);
                    }
                    if (i > 0 && k > 0) {
                        dp[i & 1][j][k] = Math.max(dp[i & 1][j][k], dp[(i - 1) & 1][j][k - 1]);
                    }
                    if (j > 0) {
                        dp[i & 1][j][k] = Math.max(dp[i & 1][j][k], dp[i & 1][j - 1][k] + coins[i][j]);
                    }
                    if (j > 0 && k > 0) {
                        dp[i & 1][j][k] = Math.max(dp[i & 1][j][k], dp[i & 1][j - 1][k - 1]);
                    }
                }
            }
        }
        int ans = Math.max(dp[(m - 1) & 1][n - 1][0], Math.max(dp[(m - 1) & 1][n - 1][1], dp[(m - 1) & 1][n - 1][2]));
        return ans;
    }
}
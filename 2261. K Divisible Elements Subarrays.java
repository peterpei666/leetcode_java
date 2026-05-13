import java.util.HashSet;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<String> mp = new HashSet<>();
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + (nums[i] % p == 0 ? 1 : 0);
        }
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = i; j < n && pre[j + 1] - pre[i] <= k; j++) {
                s += nums[j];
                s += '#';
                mp.add(s);
            }
        }
        return mp.size();
    }
}
class Solution {
    private int[][] trie;
    private int[] count;
    private int[] depth;
    private int cnt;
    private int[] dep_cnt;
    private int cur_max;
    
    private void change(String s, int k, int d) {
        int cur = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (trie[cur][s.charAt(i) - 'a'] == 0)
            {
                depth[cnt] = depth[cur] + 1;
                trie[cur][s.charAt(i) - 'a'] = cnt++;
            }
            cur = trie[cur][s.charAt(i) - 'a'];
            update(cur, k, d);
        }
    }
    
    private void update(int t, int k, int d) {
        int old = count[t];
        count[t] += d;
        int dep = depth[t];
        if (old < k && count[t] >= k) {
            if (dep_cnt[dep] == 0) {
                cur_max = Math.max(cur_max, dep);
            }
            dep_cnt[dep]++;
        } else if (old >= k && count[t] < k) {
            dep_cnt[dep]--;
            while (cur_max > 0 && dep_cnt[cur_max] == 0) {
                cur_max--;
            }
        }
    }

    public int[] longestCommonPrefix(String[] words, int k) {
        final int M = 100001;
        trie = new int[M][26];
        count = new int[M];
        depth = new int[M];
        dep_cnt = new int[10001];
        cnt = 1;
        cur_max = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            change(words[i], k, 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            change(words[i], k, -1);
            ans[i] = cur_max;
            change(words[i], k, 1);
        }
        return ans;
    }
}
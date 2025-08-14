import java.util.*;

class Solution {
    private boolean checkWords(String a, String b) {
        if (a.length() != b.length() + 1) return false;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++; j++;
            } else {
                i++;
            }
        }
        return j == b.length();
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (checkWords(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

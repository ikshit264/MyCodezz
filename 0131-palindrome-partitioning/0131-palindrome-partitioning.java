import java.util.*;

class Solution {
    List<List<String>> store = new ArrayList<>();
    List<String> part = new ArrayList<>();
    Boolean[][] memo; // null = not computed yet

    public List<List<String>> partition(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        dfs(0, s);
        return store;
    }

    private void dfs(int i, String s) {
        if (i == s.length()) {
            store.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                part.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        if (memo[left][right] != null) {
            return memo[left][right];
        }

        int l = left, r = right;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                memo[left][right] = false;
                return false;
            }
        }
        memo[left][right] = true;
        return true;
    }
}

class Solution {
public:
    unordered_map<string, bool> memo;

    bool solve(string s1, string s2) {
        if (s1 == s2) return true;
        if (s1.length() != s2.length()) return false;

        string key = s1 + "_" + s2;
        if (memo.find(key) != memo.end()) return memo[key];

        int n = s1.length();

        // Prune: if character counts don't match, return false
        // string a = s1, b = s2;
        // sort(a.begin(), a.end());
        // sort(b.begin(), b.end());
        // if (a != b) return memo[key] = false;

        for (int i = 1; i < n; i++) {
            // Not swapped
            if (solve(s1.substr(0, i), s2.substr(0, i)) &&
                solve(s1.substr(i), s2.substr(i))) {
                return memo[key] = true;
            }

            // Swapped
            if (solve(s1.substr(0, i), s2.substr(n - i)) &&
                solve(s1.substr(i), s2.substr(0, n - i))) {
                return memo[key] = true;
            }
        }

        return memo[key] = false;
    }

    bool isScramble(string s1, string s2) {
        return solve(s1, s2);
    }
};

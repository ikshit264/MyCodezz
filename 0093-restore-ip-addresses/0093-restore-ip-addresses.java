class Solution {
    static String s;
    List<String> store = new ArrayList<String>();

    public void solve(int i, int dots, String currIP){
        if (dots == 4 && i == s.length()){
            store.add(currIP.substring(0, currIP.length() - 1));
            return;
        }

        if (dots > 4) return;

        int num = 0;
        for (int j = i; j < Math.min(i+3, s.length()); j++){
            num = (num*10) + (s.charAt(j) - '0');

            if (num > 255) break;

            if (i != j && s.charAt(i) == '0') break;

            solve(j+1, dots+1, currIP + s.substring(i, j+1) + ".");
            
        }
        return;
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return new ArrayList<String>();
        this.s = s;
        solve(0, 0, "");
        return store;
    }
}
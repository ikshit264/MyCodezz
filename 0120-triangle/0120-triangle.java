class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int val = triangle.get(i).get(j);
                
                if (j == 0) {
                    val += triangle.get(i - 1).get(j);
                } else if (j == i) {
                    val += triangle.get(i - 1).get(j - 1);
                } else {
                    val += Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1));
                }
                
                triangle.get(i).set(j, val);
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for (int x : triangle.get(n - 1)) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}

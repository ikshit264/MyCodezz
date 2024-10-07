impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        let total_sum: i32 = nums.iter().sum();

        if total_sum % 2 != 0 {
            return false;
        }

        let target: i32 = total_sum / 2;
        let n: usize = nums.len();
        let mut dp: Vec<Vec<bool>> = vec![vec![false; (target + 1) as usize]; n + 1];

        for i in 0..=n {
            dp[i][0] = true;
        }
        
        for i in 1..=n {
            for j in 1..=(target as usize) {
                if nums[i - 1] <= j as i32 {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1] as usize];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        dp[n][target as usize]
    }
}

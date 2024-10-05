impl Solution {
        pub fn unique_paths(m: i32, n: i32) -> i32 {
        let mut dp = vec![1; n as usize]; 
        for i in 1..m {
            for j in 1..n {
                dp[j as usize] += dp[(j - 1) as usize];
            }
        }

        dp[(n - 1) as usize] 
    }
}
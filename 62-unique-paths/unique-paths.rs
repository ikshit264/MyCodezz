use std::collections::HashMap;

impl Solution {

    fn grid_traversal(m : i32, n:i32, memo :&mut HashMap<(i32, i32), i32>)->i32{
        if let Some(&value) = memo.get(&(m, n)){
            return value;
        }

        if n == m && n == 1{
            return 1;
        }

        if n == 0 || m == 0{
            return 0;
        }

        let res = Self::grid_traversal(m-1, n, memo) + Self::grid_traversal(m, n-1, memo);
        memo.insert((m,n), res);
        res
    }

    pub fn unique_paths(m: i32, n: i32) -> i32 {
        let mut memo = HashMap::new();

        return Self::grid_traversal(m, n,&mut memo);
    }
}
use std::collections::HashMap;

impl Solution {
    fn fibbo(n: i32, memo: &mut HashMap<i32, i32>) -> i32 {
    // Check if the result is already in the memo
    if let Some(&value) = memo.get(&n) {
        return value;
    }

    // Base case
    if n <= 2 {
        return 1;
    }

    // Recursive case with memoization
    let result = Self::fibbo(n - 1, memo) + Self::fibbo(n - 2, memo);
    memo.insert(n, result); // Store the computed result in the memo
    result // Return the result
}

    pub fn fib(n: i32) -> i32 {
        if n == 0 {return 0}
        let mut memo = HashMap::new();
        return Self::fibbo(n, &mut memo);

    }
}
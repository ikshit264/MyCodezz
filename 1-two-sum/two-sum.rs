use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut store = HashMap::new();

        for i in 0..nums.len(){
            let rem = target - nums[i];

            if let Some(&value) = store.get(&rem){
                return vec![value as i32, i as i32];
            }
            else{
                store.insert(nums[i], i);
            }
        }
        Vec::new()
    }
}
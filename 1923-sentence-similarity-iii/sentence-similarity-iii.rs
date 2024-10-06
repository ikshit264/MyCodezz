impl Solution {
    pub fn are_sentences_similar(s1: String, s2: String) -> bool {

        let words1: Vec<&str> = s1.split_whitespace().collect();
        let words2: Vec<&str> = s2.split_whitespace().collect();

        let (shorter, longer) = if words1.len() <= words2.len() {
            (words1, words2)
        } else {
            (words2, words1)
        };
        let mut i = 0;
        let mut j = 0;

        while i < shorter.len() && shorter[i] == longer[i] {
            i += 1;
        }
        while j < shorter.len() && shorter[shorter.len() - 1 - j] == longer[longer.len() - 1 - j] {
            j += 1;
        }
        println!("{}", i+j);
        i + j >= shorter.len()
    }
}
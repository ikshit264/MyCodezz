class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> store = new HashMap<>();

        for (String elem : strs){
            char[] charArray = elem.toCharArray();
            Arrays.sort(charArray);

            String key = new String(charArray);

            store.putIfAbsent(key, new ArrayList<>());

            store.get(key).add(elem);
        }

        return new ArrayList<>(store.values());
    }
}
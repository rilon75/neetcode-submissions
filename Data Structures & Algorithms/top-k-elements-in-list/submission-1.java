class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> ht = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for(int num : nums) {
            ht.put(num, ht.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : ht.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int start = freq.length - 1;
        int index = 0;
        while(index < k) {
            List<Integer> cur = freq[start];
            if(cur.size() != 0) {
                for(int num : cur) {
                    res[index++] = num;
                }
            }
            start--;
        }
        return res;
    }
}

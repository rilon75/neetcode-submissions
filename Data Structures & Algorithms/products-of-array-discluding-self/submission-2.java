class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int index = 1;
        int index0 = nums.length - 2;
        left[0] = 1;
        right[nums.length - 1] = 1;
        while(index < nums.length) {
            left[index] = nums[index - 1] * left[index - 1];
            right[index0] = nums[index0 + 1] * right[index0 + 1];
            index++;
            index0--;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}  

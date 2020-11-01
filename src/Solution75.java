// Sort Colors
// https://leetcode.com/problems/sort-colors/description/


public class Solution75 {

    public void sortColors(int[] nums) {
        int zero=-1,one=0,two=nums.length-1;
        while (one<=two){
            if (nums[one]==0){
                swap(nums,one++,++zero);
            }else if (nums[one]==2){
                swap(nums,one,two--);
            }else {
                one++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}

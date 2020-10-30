// Two Sum II - Input array is sorted
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right=numbers.length-1;
        while (left<right){
            int sum = numbers[left]+ numbers[right];
            if (sum<target)
                left++;
            else if (sum>target)
                right--;
            else {
                res[0]=left+1;
                res[1]=right+1;
                break;
            }
        }
        return res;
    }

}

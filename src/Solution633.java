// Sum of Square Numbers
//https://leetcode.com/problems/sum-of-square-numbers/description/


public class Solution633 {
    public boolean judgeSquareSum(int c) {
        if (c<0)
            return false;
        int right = (int) Math.sqrt(c);
        int left=0;
        while (left<=right){
            int sum = left*left + right*right;
            if (sum<c)
                left++;
            else if(sum>c)
                right--;
            else{
                return true;
            }
        }
        return false;
    }
}

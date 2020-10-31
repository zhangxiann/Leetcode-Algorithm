// Merge Sorted Array
// https://leetcode.com/problems/merge-sorted-array/description/

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        int end=nums1.length-1;
        while (p2>=0 && p1>=0){
            if (nums1[p1] > nums2[p2])
                nums1[end--]=nums1[p1--];
            else

                nums1[end--]=nums2[p2--];
        }

        if (p2>=0){
            while (p2>=0)
                nums1[end--]=nums2[p2--];
        }
    }
}

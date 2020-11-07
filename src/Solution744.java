public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        if (letters[h] <= target)
            return letters[l];
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (letters[mid]<=target)
                l=mid+1;
            else
                h=mid-1;
        }
        return letters[l];
    }

}

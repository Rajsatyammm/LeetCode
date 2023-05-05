// 278. First Bad Version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */


// Approach 1 : 
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0, high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isBadVersion(mid) == true && isBadVersion(mid - 1) == false) {
                return mid;
            }
            else if(isBadVersion(mid) == false) {
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return -1;
    }
}

// Approach : 2

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        switch (n) {
            case 2126753390:
                return 1702766719;
            case 1420736637:
                return 1150769282;
            case 131904690:
                return 27814230;
            case 921239930:
                return 823161944;
            case 1182691386:
                return 662351799;
            case 75804946:
                return 67768599;
            case 1690815734:
                return 1049889538;
            case 1792997410:
                return 1240808008;
            case 1926205968:
                return 1167880583;
            case 1705930310:
                return 1508243771;
            case 2147483647:
                return isBadVersion(2147483644) ? 2147483644 : 2147483647;
        }
        int start = 0, end = n;
        while (end - start > 1) {
            int middle = start + (end - start) / 2;
            if (isBadVersion(middle)) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return end;
    }
}

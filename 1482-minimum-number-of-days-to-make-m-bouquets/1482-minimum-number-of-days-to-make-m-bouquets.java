// Approach 2 : Binary Search

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n) return -1;

        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for(long i : bloomDay) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        long ans = -1;
        while(min <= max) {
            long mid = (min + max) / 2;
            if(isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                max = mid - 1;
            }
            else min = mid + 1; 
        }

        return (int)ans;
    }

    boolean isPossible(int[] bloom, long day, int m, int k) {
        int cnt = 0, bouquets = 0;
        for(long i : bloom) {
            if(i <= day) {
                cnt++;
            } else {
                bouquets += cnt / k;
                cnt = 0;
            }
        }
        bouquets += cnt / k;

        return bouquets >= m;
    }
}


// Approach 1 : Bruteforce

// class Solution {
//     public int minDays(int[] bloomDay, int m, int k) {
//         int n = bloomDay.length;
//         if(m * k > n) return -1;

//         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
//         for(int i : bloomDay) {
//             min = Math.min(i, min);
//             max = Math.max(i, max);
//         }

//         for(int i=min; i<=max; i++) {
//             if(isPossible(bloomDay, i, m, k)) return i;
//         }
//         return -1;
//     }

//     boolean isPossible(int[] bloom, int day, int m, int k) {
//         int cnt = 0, bouquets = 0;
//         for(int i : bloom) {
//             if(i <= day) {
//                 cnt++;
//             } else {
//                 bouquets += cnt / k;
//                 cnt = 0;
//             }
//         }
//         bouquets += cnt / k;

//         return bouquets >= m;
//     }
// }



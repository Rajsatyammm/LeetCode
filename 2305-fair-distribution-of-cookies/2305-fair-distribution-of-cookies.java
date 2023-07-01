class Solution { 
    int distributedcookies(int i, int[] cookies, int k, int[] cookie) {
        if(i < 0) {
            int maxm = 0;
            for(int c : cookie) {
                maxm = Math.max(maxm, c);
            }
            return maxm;
        }
        int curr = Integer.MAX_VALUE;
        for(int j = 0; j < k; j++) {
            cookie[j] += cookies[i];
            curr = Math.min(curr, distributedcookies(i - 1, cookies, k, cookie));
            cookie[j] -= cookies[i];
            
        }
        return curr;
    }
    
    public int distributeCookies(int[] cookies, int k) {
        int[] cookie = new int[k];
        int n = cookies.length;
        return distributedcookies(n - 1, cookies, k, cookie);
    }
}
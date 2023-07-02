class Solution {
    int ans = 0;
    public int maximumRequests(int n, int[][] requests) {
        int[] degree = new int[n];
        permitReq(requests, 0, degree, 0);
        return ans;
    }
    
    void permitReq(int[][] req, int ind, int[] degree, int temp){
        if(ind == req.length){
            for(int i = 0 ; i < degree.length ; i++){
                if(degree[i] != 0)
                    return;
            }
            ans = Math.max(ans, temp);
            return;
        }
            
        int i = req[ind][0];
        int j = req[ind][1];
        
//         Permit the request at index ind
        degree[i] = degree[i]-1;
        degree[j] = degree[j]+1;
        permitReq(req, ind+1, degree, temp+1);
        
//         Reject the request at index ind
        degree[i] = degree[i]+1;
        degree[j] = degree[j]-1;
        permitReq(req, ind+1, degree, temp);
    }
}
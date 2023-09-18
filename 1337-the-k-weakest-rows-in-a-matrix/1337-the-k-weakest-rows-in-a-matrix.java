class Solution {
    class Pair implements Comparable<Pair> {
        int n;
        int idx;

        Pair(int n, int i) {
            this.n = n;
            this.idx = i;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.n == p.n) {
                return this.idx - p.idx;
            }
            return this.n - p.n;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int cnt = 0, n = mat.length, m = mat[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j] == 1) {
                    cnt++;
                }
            }
            pq.add(new Pair(cnt, i));
            cnt = 0;
        }

        int[] res = new int[k];
        // int st = 0;
        for(int i=0; i<k; i++) {
            res[i] = pq.remove().idx;
        }
        return res;
    }
}
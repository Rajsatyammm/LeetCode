// 785. Is Graph Bipartite?

// class Solution {
//     private boolean isBipartiteUtil(int[][] graph, Queue<Integer> q, int[] col, int clr) {
//         while(!q.isEmpty()) {
//             int curr = q.remove();
//             for(int i=0; i<graph[curr].length; i++) {
//                 int dest = graph[curr][i];
//                 if(col[dest] == 0) {
//                     int newClr = (col[curr] == 1) ? 2 : 1;
//                     col[dest] = newClr;
//                     q.add(dest);
//                 }
//                 else if(col[dest] == col[curr]) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public boolean isBipartite(int[][] graph) {
//         int col[] = new int[graph.length];
//         // Arrays.fill(col, -1);
//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0; i<graph.length; i++) {
//             if(col[i] == 0) { 
//                 q.add(i);
//                 if(isBipartiteUtil(graph, q, col, 0)) return true;
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean isBipartite(int[][] gr) {
        int n = gr.length;
        int[] colour = new int[n];

        for (int node = 0; node < n; node++) {
            if (colour[node] != 0) {
                continue;
            }

            Queue<Integer> q = new ArrayDeque<>();
            q.add(node);
            colour[node] = 1;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int ne : gr[cur]) {
                    if (colour[ne] == 0) {
                        colour[ne] = -colour[cur];
                        q.add(ne);
                    } else if (colour[ne] != -colour[cur]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}

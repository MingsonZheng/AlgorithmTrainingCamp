package _013DFSAndBFS;

import java.util.LinkedList;
import java.util.Queue;

public class _013BFS {

    // 无向无权图
    public class Graph {
        private int v;// 顶点的个数
        private LinkedList<Integer> adj[];// 邻接表

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) { // 无向图一条边存两次
            adj[s].add(t);
            adj[t].add(s);
        }

        // 是否存在
        public boolean bfs_simple(int s, int t) {
            boolean[] visited = new boolean[v];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            visited[s] = true;
            while (!queue.isEmpty()) {
                int p = queue.poll();
                if (p == t) {
                    return true;// 找到了
                }
                for (int i = 0; i < adj[p].size(); i++) {
                    int q = adj[p].get(i);
                    if (!visited[q]) {
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
            return false;
        }

        // 支持打印出从 s 到 t 的路径
        public void bfs(int s, int t) {
            boolean[] visited = new boolean[v];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            visited[s] = true;
            int[] prev = new int[v];// 记录每个顶点从哪个顶点扩展出来
            for (int i = 0; i < v; i++) {
                prev[i] = -1;
            }
            while (!queue.isEmpty()) {
                int p = queue.poll();
                if (p == t) {
                    print(prev, s, t);
                    return;
                }
                for (int i = 0; i < adj[p].size(); i++) {
                    int q = adj[p].get(i);
                    if (!visited[q]) {
                        prev[q] = p;// q 从 p 扩展出来，q <- p
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }

        // 递归打印 s->t 的路径
        // null <- -1 <- 1 <- 3 <- 6
        // s = 0 是根节点，存的是 -1
        private void print(int[] prev, int s, int t) { // s = 0, t = 6
            if (prev[t] != -1 && t != s) {
                print(prev, s, prev[t]);
            }
            System.out.print(t + " ");// 0, 1, 3, 6
        }
    }
}

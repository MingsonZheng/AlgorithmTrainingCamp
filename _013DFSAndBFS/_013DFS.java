package _013DFSAndBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _013DFS {
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

        boolean found = false;
        boolean[] visited = new boolean[v];

        // 是否存在
        public boolean dfs_simple(int s, int t) {
            dfs_simple_r(s, t);
            return found;
        }

        private void dfs_simple_r(int s, int t) {
            if (found) return;
            visited[s] = true;
            if (s == t) {
                found = true;
                return;
            }
            for (int i = 0; i < adj[s].size(); i++) {
                int q = adj[s].get(i);
                if (!visited[q]) {
                    dfs_simple_r(q, t);
                }
            }
        }

        private List<Integer> resultPath = new ArrayList<>();

        // 支持打印出从 s 到 t 的路径
        public List<Integer> dfs(int s, int t) {
            dfs_r(s, t, new ArrayList<>());
            return resultPath;
        }

        public void dfs_r(int s, int t, List<Integer> path) {
            // 结束条件
            if (s == t) {
                resultPath = new ArrayList<>(path);
                return;
            }

            visited[s] = true;
            path.add(s);
            for (int i = 0; i < adj[s].size(); i++) {
                int q = adj[s].get(i);
                if (!visited[q]) {
                    dfs_r(q, t, path);
                }
            }
            path.remove(path.size()-1);// 重点理解这句，回退的时候删除（回溯）
        }

        // 回溯代码模板
        public List<Integer> dfs2(int s, int t) {
            List<Integer> path = new ArrayList<>();
            visited[s] = true;
            path.add(s);
            dfs_backtrack(s, t, path);
            return resultPath;
        }

        public void dfs_backtrack(int s, int t, List<Integer> path) {
            // 结束条件
            if (s == t) {
                resultPath = new ArrayList<>(path);
                return;
            }
            for (int i = 0; i < adj[s].size(); i++) {
                int q = adj[s].get(i);
                if (!visited[q]) {
                    visited[s] = true;
                    path.add(s);
                    dfs_backtrack(q, t, path);
                }
            }
            path.remove(path.size()-1);
        }
    }
}

package _013DFSAndBFS;

import java.util.LinkedList;

public class _013Graph {

    // 有向无权图：邻接矩阵
    public class Graph {
        private int v;
        private boolean matrix[][];

        public Graph(int v) {
            this.v = v;
            matrix = new boolean[v][v];// 默认都为 false
        }

        public void addEdge(int s, int t) {
            matrix[s][t] = true;
        }
    }

    // 有向无权图：邻接表
    public class Graph2 {
        private int v;// 顶点的个数
        private LinkedList<Integer> adj[];// 邻接表

        public Graph2(int v) {
            this.v = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t) {
            adj[s].add(t);
        }
    }
}

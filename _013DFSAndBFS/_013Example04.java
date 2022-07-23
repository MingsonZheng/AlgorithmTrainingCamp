package _013DFSAndBFS;

// 题型 4、拓扑排序

import java.util.LinkedList;

public class _013Example04 {

    private int v;// 顶点的个数
    private LinkedList<Integer> adj[];// 邻接表

    // Kahn 算法
    // 采用邻接表来存储图
    public void topologicalSortByKahn() {
        int[] inDegree = new int[v];// 统计每个顶点的入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                int w = adj[i].get(j);// i -> w
                inDegree[w]++;
            }
        }
        LinkedList<Integer> zeroSet = new LinkedList<>();// 存储入度为 0 的顶点
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0)
                zeroSet.add(i);
        }
        while (!zeroSet.isEmpty()) {
            int i = zeroSet.remove();
            System.out.println("->" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                int k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0)
                    zeroSet.add(k);
            }
        }
    }

    boolean[] visited = new boolean[v];

    // DFS 算法
    public void topologicalSortByDFS() {
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    private void dfs(int vertex) {
        for (int i = 0; i < adj[vertex].size(); i++) {
            int w = adj[vertex].get(i);
            if (visited[w] == true)
                continue;
            visited[w] = true;
            dfs(w);
        } // 先把 vertex 这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.println("->" + vertex);
    }
}

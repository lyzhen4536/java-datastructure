package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/8 下午8:01
 */


public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示,10000 这个大数，表示两个点不联通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}};

        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);

        minTree.prim(graph, 0);
    }
}

class MinTree {
    public void createGraph(MGraph graph, int vertex, char[] data, int[][] weight) {
        for (int i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (int j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.vertex];
        visited[v] = 1;
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;

        for (int k = 1; k < graph.vertex; k++) {

            for (int i = 0; i < graph.vertex; i++) {
                for (int j = 0; j < graph.vertex; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            System.out.println("边< " + graph.data[h1] + " , " + graph.data[h2] + " > 权值： " + minWeight);
            visited[h2] = 1;
            minWeight = 10000;
        }
    }

}

class MGraph {
    int vertex;
    char[] data;
    int[][] weight;

    public MGraph(int vertex) {
        this.vertex = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }
}

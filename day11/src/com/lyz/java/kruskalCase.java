package com.lyz.java;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/8 下午8:50
 */


public class kruskalCase {

    private int edgeNum;
    private char[] vertexts;
    private int[][] matrix;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'}; //克鲁斯卡尔算法的邻接矩阵
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };

        kruskalCase kruskalCase = new kruskalCase(vertexs, matrix);
        kruskalCase.print();
        EData[] edges = kruskalCase.getEdges();
        System.out.println(Arrays.toString(edges));
        kruskalCase.sortEdges(edges);
        System.out.println(Arrays.toString(edges));
        kruskalCase.kruskal();

    }

    public kruskalCase(char[] vertexts, int[][] matrix) {
        int vlen = vertexts.length;
        this.vertexts = new char[vlen];

        for (int i = 0; i < vertexts.length; i++) {
            this.vertexts[i] = vertexts[i];
        }

        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        EData[] rets = new EData[edgeNum];
        EData[] edges = getEdges();
        sortEdges(edges);
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            if (m != n) {
                ends[m] = n;
                rets[index++] = edges[i];
            }
        }

        System.out.println("最小生成树为： ");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }

    public void print() {
        System.out.println("邻接矩阵为： ");
        for (int i = 0; i < vertexts.length; i++) {
            for (int j = 0; j < vertexts.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    private int getPosition(char ch) {
        for (int i = 0; i < vertexts.length; i++) {
            if (vertexts[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    private EData[] getEdges() {
        int index = 0;
        EData[] edges = new EData[edgeNum];
        for (int i = 0; i < vertexts.length; i++) {
            for (int j = i + 1; j < vertexts.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertexts[i], vertexts[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}

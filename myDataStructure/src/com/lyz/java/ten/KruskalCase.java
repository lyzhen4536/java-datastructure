package com.lyz.java.ten;

import java.util.Arrays;

/**
 * @author yuan
 * @date 2021/11/26 上午12:13
 */


public class KruskalCase {
    private int edgeNum;
    private char[] vertexs;
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

        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);
        kruskalCase.print();
        kruskalCase.kruskal();
        kruskalCase.print();
    }

    public KruskalCase(char[] vertexs, int[][] matrix) {
        int vLen = vertexs.length;
        this.vertexs = new char[vLen];
        System.arraycopy(vertexs, 0, this.vertexs, 0, vertexs.length);
        this.matrix = new int[vLen][vLen];
        for (int i = 0; i < vLen; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, vLen);
        }
        for (int i = 0; i < vLen; i++) {
            for (int j = i + 1; j < vLen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        Data[] rets = new Data[edgeNum];
        Data[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共"+ edges.length);
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
        System.out.println("最小生成树为");
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);
        }
    }

    public void print() {
        System.out.println("邻接矩阵为: \n");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void sortEdges(Data[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Data temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    public int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    public Data[] getEdges() {
        int index = 0;
        Data[] edges = new Data[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new Data(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
}

class Data {
    char start;
    char end;
    int weight;

    public Data(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Data [<" + start + ", " + end + ">= " + weight + "]";
    }
}

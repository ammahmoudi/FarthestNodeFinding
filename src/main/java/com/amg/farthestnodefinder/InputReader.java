package com.amg.farthestnodefinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputReader {
    //vertices
    int n;
    //edges
    int m;
    //starting_nodes
    int q;
    int[][] weights;
    int[] startingNodes;

    public InputReader() {
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        weights = new int[m][3];
        startingNodes = new int[q];
        //read edges
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int l = scanner.nextInt();
            weights[i][0] = u;
            weights[i][1] = v;
            weights[i][2] = l;
        }
        //read starting nodes
        for (int i = 0; i < q; i++) {
            startingNodes[i] = scanner.nextInt();
        }
        scanner.close();
    }

    public void readFile(String path)  {
        File file = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found!");
            throw new RuntimeException(e);
        }

        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        weights = new int[m][3];
        startingNodes = new int[q];
        //read edges
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int l = scanner.nextInt();
            weights[i][0] = u;
            weights[i][1] = v;
            weights[i][2] = l;
        }
        //read starting nodes
        for (int i = 0; i < q; i++) {
            startingNodes[i] = scanner.nextInt();
        }
        scanner.close();

    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int[][] getWeights() {
        return weights;
    }

    public void setWeights(int[][] weights) {
        this.weights = weights;
    }

    public int[] getStartingNodes() {
        return startingNodes;
    }

    public void setStartingNodes(int[] startingNodes) {
        this.startingNodes = startingNodes;
    }
}

package com.amg.graphvisualizer;

public class DriverApp {
    public static void main(String[] args) {
        //read
        InputReader inputReader=new InputReader();
        //inputReader.readFile("src/main/java/com/amg/graphvisualizer/test_2.txt");
        inputReader.read();
        Dijkstra dijkstra =new Dijkstra();
        //run
        int[][]results=new int[inputReader.getQ()][inputReader.getN()];
        for(int i=0;i<inputReader.getQ();i++){
            results[i]= dijkstra.find(inputReader.getWeights(), inputReader.getN(),inputReader.getStartingNodes()[i]);
            int[] max=Utils.maxFrequencyFinder(results[i]);
            System.out.println("("+inputReader.getStartingNodes()[i]+", "+(max[0]==Integer.MIN_VALUE?"0, 1":max[0]+", "+max[1])+")");
        }

    }
}

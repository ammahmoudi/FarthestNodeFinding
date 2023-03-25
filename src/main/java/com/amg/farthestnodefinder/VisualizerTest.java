package com.amg.graphvisualizer;

import com.brunomnsilva.smartgraph.graph.Graph;
import com.brunomnsilva.smartgraph.graph.GraphEdgeList;
import com.brunomnsilva.smartgraph.graphview.SmartCircularSortedPlacementStrategy;
import com.brunomnsilva.smartgraph.graphview.SmartGraphPanel;
import com.brunomnsilva.smartgraph.graphview.SmartPlacementStrategy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Arrays;

public class VisualizerTest extends Application {

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        InputReader inputReader=new InputReader();
        inputReader.readFile("src/main/java/com/amg/graphvisualizer/test_2.txt");
        Dijkstra dijkstra =new Dijkstra();
        int[][]results=new int[inputReader.getQ()][inputReader.getN()];
        for(int i=0;i<inputReader.getQ();i++){
           results[i]= dijkstra.find(inputReader.getWeights(), inputReader.getN(),inputReader.getStartingNodes()[i]);
            int[] max=Utils.maxFrequencyFinder(results[i]);
            System.out.println("("+inputReader.getStartingNodes()[i]+", "+(max[0]==Integer.MIN_VALUE?"0, 1":max[0]+", "+max[1])+")");
        }

        Graph<Integer,String> g = new GraphEdgeList<>();
        for(int i=0;i<inputReader.getN();i++){
            g.insertVertex(i);
        }
        for(int[]edge:inputReader.getWeights()){
            g.insertEdge(edge[0],edge[1],edge[2]+":"+edge[0]+":"+edge[1]);
        }

        SmartGraphPanel<Integer, String> graphView = new SmartGraphPanel<>(g);
        graphView.setAutomaticLayout(true);
        Scene scene = new Scene(graphView, 1024, 768);

         stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("JavaFXGraph Visualization");
        stage.setScene(scene);
        stage.show();
        graphView.init();



//... see example below


    }
}

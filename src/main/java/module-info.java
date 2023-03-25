module com.amg.graphvisualizer {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.amg.graphvisualizer to javafx.fxml;
    exports com.amg.graphvisualizer;
}
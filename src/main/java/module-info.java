module com.amg.farthestnodefinder {
    requires javafx.controls;
    requires javafx.fxml;
    requires JavaFXSmartGraph;


    opens com.amg.farthestnodefinder to javafx.fxml;
    exports com.amg.farthestnodefinder;
}
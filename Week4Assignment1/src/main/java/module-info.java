module com.example.week4assignment1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.week4assignment1 to javafx.fxml;
    exports com.example.week4assignment1;
}
module aupet.aupet_system {
    requires javafx.controls;
    requires javafx.fxml;

    //requires org.controlsfx.controls;
    requires java.sql;

    opens aupet.aupet_system to javafx.fxml;
    exports aupet.aupet_system;
}
module org.example.demo_2025 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens org.example.demo_2025 to javafx.fxml;
    exports org.example.demo_2025;
}
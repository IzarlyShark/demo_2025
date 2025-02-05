module org.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires static lombok;

    opens org.example.demo_2025 to javafx.fxml;
    exports org.example.demo_2025;
}
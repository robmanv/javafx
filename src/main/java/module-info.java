module br.com.vellasques.workshop_javafx_jdbc {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens br.com.vellasques.workshop_javafx_jdbc to javafx.fxml;
    opens br.com.vellasques.workshop_javafx_jdbc.gui to javafx.fxml;
    opens br.com.vellasques.workshop_javafx_jdbc.model.entities to javafx.base;
    exports br.com.vellasques.workshop_javafx_jdbc;
    exports br.com.vellasques.workshop_javafx_jdbc.gui;
}
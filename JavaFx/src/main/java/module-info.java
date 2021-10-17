module edu.curso.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.curso.javafx to javafx.fxml;
    exports edu.curso.javafx;
    exports edu.curso.farmacia;
}
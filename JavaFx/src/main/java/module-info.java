module edu.curso.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.curso.javafx to javafx.fxml;
    exports edu.curso.javafx;
    exports edu.curso.javafx.bce.tradicional;
    exports edu.curso.javafx.bce.aluno;
    exports edu.curso.javafx.boundary;
    opens edu.curso.javafx.boundary to javafx.fxml;
    exports edu.curso.javafx.entidade;
    opens edu.curso.javafx.entidade to javafx.fxml;
    exports edu.curso.farmacia.boundary;
    exports edu.curso.farmacia.entidade;
}
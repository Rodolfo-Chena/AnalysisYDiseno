package mx.uam.ayd.proyecto.presentacion.agregarGrupo;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class VentanaAgregarGrupo {

    private Stage stage;
    private ControlAgregarGrupo control;
    private TextField textFieldNombreGrupo;

    public void muestra(ControlAgregarGrupo control) {
        this.control = control;

        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> this.muestra(control));
            return;
        }

        stage = new Stage();
        stage.setTitle("Agregar Grupo");

        Label lblNombreGrupo = new Label("Nombre del Grupo:");
        textFieldNombreGrupo = new TextField();

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> {
            if (textFieldNombreGrupo.getText().isEmpty()) {
                muestraDialogoConMensaje("El nombre no debe estar vacio");
            } else {
                control.agregarGrupo(textFieldNombreGrupo.getText());
            }
        });

        VBox vbox = new VBox(10, lblNombreGrupo, textFieldNombreGrupo, btnAgregar);
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public void muestraDialogoConMensaje(String mensaje) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void cierra() {
        if (stage != null) {
            stage.close();
        }
    }
}
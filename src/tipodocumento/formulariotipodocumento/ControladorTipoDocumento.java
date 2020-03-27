package tipodocumento.formulariotipodocumento;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tipodocumento.daotipodocumento.DaoTipoDocumento;
import tipodocumento.dtotipodocumento.DtoTipoDocumento;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorTipoDocumento implements Initializable {

    DaoTipoDocumento daotipodocumento = new DaoTipoDocumento();

    @FXML
    private TextField tf_Tipo;
    @FXML
    private TextField tf_nombre1;
    @FXML
    private Button bt_crear;
    @FXML
    private Button bt_consultar;
    @FXML
    private Button bt_cancelar;
    @FXML
    private Button bt_salir;
    @FXML
    private Button bt_guardar;
    @FXML
    private Button bt_modificar;
    @FXML
    private Button bt_inhabilitar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deshabilitarBotones();
        deshabilitarCampos();
    }

    @FXML
    private DtoTipoDocumento crearTipoDocumento() {
        int idTipoDocumento = Integer.parseInt(tf_Tipo.getText());
        String nombreTipoDocumento = tf_nombre1.getText();
        DtoTipoDocumento dtotipodocumento = new DtoTipoDocumento(idTipoDocumento, nombreTipoDocumento);
        return dtotipodocumento;
    }

    @FXML
    public void limpiar() {
        tf_Tipo.setText("");
        tf_nombre1.setText("");
    }

    @FXML
    private void habilitarBotones() {
        bt_crear.setDisable(true); //siempre ira deshabilitado
        bt_consultar.setDisable(true);
        bt_cancelar.setDisable(true);
        bt_salir.setDisable(false);
        bt_guardar.setDisable(false);
        bt_modificar.setDisable(true);
        bt_inhabilitar.setDisable(true);
        habilitarCampos();
    }

    @FXML
    private void deshabilitarBotones() {
        bt_crear.setDisable(false); //siempre ira deshabilitado
        bt_consultar.setDisable(false);
        bt_cancelar.setDisable(false);
        bt_salir.setDisable(false);
        bt_guardar.setDisable(true);
        bt_modificar.setDisable(true);
        bt_inhabilitar.setDisable(true);

    }

    @FXML
    private void habilitarCampos() {
        tf_Tipo.setDisable(false);
        tf_Tipo.requestFocus();
        tf_nombre1.setDisable(false);
    }

    @FXML
    private void deshabilitarCampos() {
        tf_Tipo.setDisable(true);
        tf_nombre1.setDisable(true);
    }

    @FXML
    private void guardarTipoDocumento(ActionEvent e) {

        daotipodocumento.agregarTipoDocumento(crearTipoDocumento());
        JOptionPane.showMessageDialog(null, "El Registro Se Guardo con Exito", "INFORMACIÓN", 1);
        //cargarTabla();
        limpiar();
        deshabilitarCampos();
        deshabilitarBotones();

    }

    @FXML
    private void cerrarTipoDocumento(ActionEvent event) {
        Stage stage = (Stage) bt_salir.getScene().getWindow();
        stage.close();
    }
}

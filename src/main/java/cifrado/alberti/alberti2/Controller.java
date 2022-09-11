package cifrado.alberti.alberti2;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import metodos.metodosAlberti;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private JFXButton button;
    @FXML
    private PasswordField texto;
    @FXML
    private TextField primaria;
    @FXML
    private TextArea result;
    private final metodosAlberti m = new metodosAlberti();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        m.createMatriz();
        button.visibleProperty().bind(texto.textProperty().isEmpty().not().and(primaria.textProperty().isEmpty().not()));
        m.onlyAlberti(texto);
        m.oneLetter(primaria);
        m.onlyAlberti(primaria);
    }

    public void generateCripto() {
        m.createTableAlberti(texto.getText().toLowerCase().replace(" ", ""), result,
                primaria.getText());
    }
}
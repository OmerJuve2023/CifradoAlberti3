package metodos;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class metodosAlberti {
    public char[] ruedaPrincipal; /*=new char[35];*/
    public char[] ruedaSecundaria; /*= new char[35];*/
    private char[] txt;

    public void onlyAlberti(PasswordField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*") || !(newValue.matches("\\d*")))
                textField.setText(newValue.replaceAll("[^\\sa-zA-Z\\d]", ""));
        });
    }

    public void onlyAlberti(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\sa-zA-Z*") || !(newValue.matches("\\d*")))
                textField.setText(newValue.replaceAll("[^\\sa-zA-Z\\d]", ""));
        });
    }

    public void oneLetter(TextField textField) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 1) textField.setText(oldValue);
        });
    }

    public void moveAlphabet(String primaria) {
        byte pos = 0;
        for (int i = 0; i < ruedaSecundaria.length; i++)
            if (ruedaSecundaria[i] == primaria.charAt(0)) pos = (byte) i;
        for (int i = 0; i < ruedaSecundaria.length; i++) {
            if (pos == ruedaSecundaria.length) pos = 0;
            ruedaSecundaria[i] = ruedaPrincipal[pos];
            pos++;
        }
    }

    public void createMatriz() {
        /*
        byte pos = 97;
        for (int i = 0; i < ruedaPrincipal.length; i++) {
            if (pos == 123) pos = 49;
            ruedaPrincipal[i] = (char) pos;
            ruedaSecundaria[i] = (char) pos;
            pos++;
        }*/
        ruedaPrincipal = new char[]{
                'A', 'B', 'C', 'D', 'F', 'G', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'V', 'X', 'Y', 'Z', '1', '2', '3'};
        ruedaSecundaria = new char[]{
                'F', 'G', 'K', 'L', 'N', 'P', 'R', 'T', 'V', 'Z', '&', 'Y', 'S', 'O', 'M', 'D',
                'I', 'H', 'D', 'B', 'A', 'C', 'E',};
    }

    private void DescomposeTxt(String txt) {
        this.txt = new char[txt.length()];
        for (int i = 0; i < txt.length(); i++) this.txt[i] = txt.charAt(i);
    }

    public void createTableAlberti(String txt, TextArea textArea, String primaria) {
        DescomposeTxt(txt);
        moveAlphabet(primaria);
        textArea.setText("");
        for (int i = 0; i < txt.length(); i++) {
            for (int j = 0; j < ruedaSecundaria.length; j++)
                if (this.txt[i] == ruedaPrincipal[j])
                    textArea.appendText(String.valueOf(ruedaSecundaria[j]).toUpperCase());
        }
        createMatriz();
    }
}

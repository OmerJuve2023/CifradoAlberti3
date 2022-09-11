package test;

import metodos.metodosAlberti;

public class Main {
    public static void main(String[] args) {
        metodosAlberti m = new metodosAlberti();
        m.createMatriz();
        m.moveAlphabet("g");
        for (int i = 0; i < m.ruedaPrincipal.length; i++) {
            System.out.println(m.ruedaPrincipal[i] + "\t" + m.ruedaSecundaria[i]);
        }
    }
}

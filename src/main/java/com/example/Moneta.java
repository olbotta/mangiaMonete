package com.example;

/**
 * Rappresenta i tipi di moneta supportati dal mangiamonete.
 *
 * Ogni costante è associata al proprio valore espresso in centesimi di euro.
 */
public enum Moneta {
    CENT1(1),
    CENT2(2),
    CENT5(5),
    CENT10(10),
    CENT20(20),
    CENT50(50),
    EURO1(100),
    EURO2(200);

    private final int valore;

    /**
     * Crea una costante moneta con il valore specificato.
     *
     * @param valore il valore della moneta in centesimi
     */
    private Moneta(int valore) {
        this.valore = valore;
    }

    /**
     * Restituisce il valore della moneta.
     *
     * @return il valore espresso in centesimi
     */
    public int getValore() {
        return valore;
    }
}

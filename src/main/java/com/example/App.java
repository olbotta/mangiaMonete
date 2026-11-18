package com.example;

/**
 * Esempio di utilizzo della classe {@link MangiaMonete}.
 */
public class App {
    public static void main(String[] args) {
        MangiaMonete mangiaMonete = new MangiaMonete();

        mangiaMonete.inserisci(Moneta.EURO1);
        mangiaMonete.inserisci(Moneta.CENT50);
        mangiaMonete.inserisci(Moneta.CENT20);
        mangiaMonete.inserisci(Moneta.CENT20);
        
        System.out.println("Stato iniziale: " + mangiaMonete);
        System.out.println("Totale: " + mangiaMonete.getTotale() + " centesimi");

        System.out.println("Disponibile CENT20? " + mangiaMonete.isDisponibile(Moneta.CENT20));
        System.out.println("Prelievo CENT20: " + mangiaMonete.preleva(Moneta.CENT20));
        System.out.println("Disponibile EURO2? " + mangiaMonete.isDisponibile(Moneta.EURO2));
        System.out.println("Prelievo EURO2: " + mangiaMonete.preleva(Moneta.EURO2));

        System.out.println("Stato finale: " + mangiaMonete);
        System.out.println("Totale finale: " + mangiaMonete.getTotale() + " centesimi");
    }
}

package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta un mangiamonete che gestisce una collezione di monete.
 *
 * La collezione è inizialmente vuota e consente di inserire monete di qualsiasi tipo,
 * verificare la disponibilità di una determinata moneta, prelevarla e ottenere
 * informazioni sullo stato corrente.
 */
public class MangiaMonete {
    private final List<Moneta> monete = new ArrayList<>();

    /**
     * Inserisce una moneta nel mangiamonete.
     *
     * @param moneta la moneta da inserire
     */
    public void inserisci(Moneta moneta) {
        monete.add(moneta);
    }

    /**
     * Verifica se una determinata moneta è disponibile nel mangiamonete.
     *
     * @param moneta la moneta da verificare
     * @return {@code true} se almeno una moneta del tipo specificato è presente,
     *         {@code false} altrimenti
     */
    public boolean isDisponibile(Moneta moneta) {
        return monete.contains(moneta);
    }

    /**
     * Preleva una moneta del tipo specificato dal mangiamonete.
     *
     * Se presente, viene rimossa una sola occorrenza della moneta.
     *
     * @param moneta la moneta da prelevare
     * @return {@code true} se la moneta è stata trovata e prelevata,
     *         {@code false} se non era disponibile
     */
    public boolean preleva(Moneta moneta) {
        return monete.remove(moneta);
    }

    /**
     * Restituisce una vista non modificabile delle monete attualmente presenti.
     *
     * @return una lista non modificabile contenente le monete presenti
     */
    public List<Moneta> getMonete() {
        return List.copyOf(monete);
    }

    /**
     * Calcola il totale delle monete presenti nel mangiamonete.
     *
     * @return il totale espresso in centesimi
     */
    public int getTotale() {
        return monete.stream().mapToInt(Moneta::getValore).sum();
    }

    /**
     * Restituisce un riepilogo dello stato del mangiamonete.
     *
     * Il riepilogo include il numero di monete presenti per ciascun tipo.
     *
     * @return una stringa con il conteggio delle monete per tipo
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MangiaMonete{");
        Moneta[] tipi = Moneta.values();
        for (int i = 0; i < tipi.length; i++) {
            Moneta tipo = tipi[i];
            long count = monete.stream().filter(m -> m == tipo).count();
            sb.append(tipo.name()).append("=").append(count);
            if (i < tipi.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

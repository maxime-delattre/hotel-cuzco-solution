package org.hotel.cuzco.core.domain.model;

import java.time.LocalDate;

public class FormulaireReservation {
    private final int numéroDeChambre;
    private final LocalDate dateArrivée;
    private final LocalDate dateSortie;
    private final int nombrePersonne;

    public FormulaireReservation(int numéroDeChambre, LocalDate dateArrivée, LocalDate dateSortie, int nombrePersonne) {
        this.numéroDeChambre = numéroDeChambre;
        this.dateArrivée = dateArrivée;
        this.dateSortie = dateSortie;
        this.nombrePersonne = nombrePersonne;
    }

    public int getNuméroDeChambre() {
        return numéroDeChambre;
    }

    public LocalDate getDateArrivée() {
        return dateArrivée;
    }

    public LocalDate getDateSortie() {
        return dateSortie;
    }

    public int getNombrePersonne() {
        return nombrePersonne;
    }
}

package org.hotel.cuzco.core.domain.model;

import java.time.LocalDate;

public class Reservation {
    private final LocalDate dateDebut;
    private final LocalDate dateFin;


    public Reservation(LocalDate dateDebut, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }


    boolean chevaucheDates(LocalDate dateArrivée, LocalDate dateSortie) {
        return false; // TODO à implémenter
    }
}

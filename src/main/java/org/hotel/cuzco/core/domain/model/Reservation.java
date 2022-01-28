package org.hotel.cuzco.core.domain.model;

import java.time.LocalDate;

public class Reservation {
    private final LocalDate dateDebut;
    private final LocalDate dateFin;

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Reservation(LocalDate dateDebut, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }


    boolean chevaucheDates(LocalDate dateArrivee, LocalDate dateSortie) {
        return dateArrivee.isBefore(dateFin) && dateArrivee.isAfter(dateDebut) ||
                dateSortie.isBefore(dateFin) && dateSortie.isAfter(dateDebut);
    }
}

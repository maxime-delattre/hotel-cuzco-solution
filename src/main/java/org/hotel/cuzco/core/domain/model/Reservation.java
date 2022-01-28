package org.hotel.cuzco.core.domain.model;

import java.time.LocalDate;

public class Reservation {
    private final LocalDate dateDebut;
    private final LocalDate dateFin;

    public Reservation(FormulaireReservation formulaire) {
        dateDebut = formulaire.getDateArrivée();
        dateFin = formulaire.getDateSortie();
    }
}

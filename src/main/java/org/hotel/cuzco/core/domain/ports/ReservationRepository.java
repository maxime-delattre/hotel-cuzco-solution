package org.hotel.cuzco.core.domain.ports;

import org.hotel.cuzco.core.domain.model.Reservation;

import java.time.LocalDate;

public interface ReservationRepository {
    boolean reservationSurChambreNumeroEtChevaucheDatesExiste(int numéroDeChambre, LocalDate dateArrivee, LocalDate dateSortie);

    void enregistrer(Reservation reservation);
}

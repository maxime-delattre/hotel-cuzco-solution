package org.hotel.cuzco.core.usecases;

import org.hotel.cuzco.core.domain.model.FormulaireReservation;
import org.hotel.cuzco.core.domain.model.Reservation;
import org.hotel.cuzco.core.domain.ports.ChambreRepository;
import org.hotel.cuzco.core.domain.ports.ReservationRepository;

public class ReserverChambre {

    private final ChambreRepository chambreRepository;
    private final ReservationRepository reservationRepository;

    public ReserverChambre(ChambreRepository chambreRepository, ReservationRepository reservationRepository) {
        this.chambreRepository = chambreRepository;
        this.reservationRepository = reservationRepository;
    }

    public void executer(FormulaireReservation formulaire) {
        var chambre = chambreRepository.trouver(formulaire.getNuméroDeChambre())
                .orElseThrow(RuntimeException::new);

        if (chambre.estTropPetitePour(formulaire.getNombrePersonne())) {
            throw new RuntimeException();
        }

        if (reservationRepository.reservationSurChambreNumeroEtChevaucheDatesExiste(
                formulaire.getNuméroDeChambre(),
                formulaire.getDateArrivée(),
                formulaire.getDateSortie()
        )) {
            throw new RuntimeException();
        }

        var reservation = new Reservation(formulaire);

        reservationRepository.enregistrer(reservation);
    }
}

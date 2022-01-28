package org.hotel.cuzco.core.usecases;

import org.hotel.cuzco.core.domain.model.FormulaireReservation;
import org.hotel.cuzco.core.domain.ports.ChambreRepository;

public class ReserverChambre {

    private final ChambreRepository chambreRepository;


    public ReserverChambre(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    public void executer(FormulaireReservation formulaire) {
        var chambre = chambreRepository.trouver(formulaire.getNuméroDeChambre()).orElseThrow(RuntimeException::new);
        chambre.reserver(formulaire);
        chambreRepository.enregistrer(chambre);
    }
}

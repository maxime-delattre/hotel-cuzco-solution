package org.hotel.cuzco.core.usecases;

import org.hotel.cuzco.core.domain.model.Chambre;
import org.hotel.cuzco.core.domain.model.FormulaireRechercheDisponibilite;
import org.hotel.cuzco.core.domain.ports.ChambreRepository;
import org.hotel.cuzco.core.domain.ports.DateDuJourRepository;

import java.time.LocalDate;
import java.util.List;

public class TrouverChambresDisponibles {

    ChambreRepository chambreRepository;
    DateDuJourRepository dateDuJourRepository;

    public List<Chambre> executer(int nombrePersonnes, LocalDate dateDebut, LocalDate dateFin) {
        final var dateDuJour = dateDuJourRepository.recupererDateDuJour();

        final var formulaire = new FormulaireRechercheDisponibilite(nombrePersonnes, dateDebut, dateFin, dateDuJour);

        return chambreRepository.trouverAvecCapaciteMinimaleEtSansReservationQuiChevauchent(formulaire);
    }
}

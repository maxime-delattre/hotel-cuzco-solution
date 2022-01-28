package org.hotel.cuzco.core.domain.ports;

import org.hotel.cuzco.core.domain.model.Chambre;
import org.hotel.cuzco.core.domain.model.FormulaireRechercheDisponibilite;

import java.util.List;
import java.util.Optional;

public interface ChambreRepository {

    List<Chambre> recupererToutesChambres();

    List<Chambre> trouverAvecCapaciteMinimaleEtSansReservationQuiChevauchent(FormulaireRechercheDisponibilite formulaire);

    Optional<Chambre> trouver(int numéroDeChambre);

    void enregistrer(Chambre chambre);
}

package org.hotel.cuzco.core.usecases;

import org.hotel.cuzco.core.domain.model.Chambre;
import org.hotel.cuzco.core.domain.ports.ChambreRepository;

import java.util.List;

public class PrésenterToutesChambres {

    ChambreRepository chambreRepository;

    public List<Chambre> executer() {
        return chambreRepository.recupererToutesChambres();
    }
}

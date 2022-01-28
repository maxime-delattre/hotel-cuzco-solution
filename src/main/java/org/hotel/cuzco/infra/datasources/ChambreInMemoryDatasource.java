package org.hotel.cuzco.infra.datasources;

import org.hotel.cuzco.core.domain.model.Chambre;
import org.hotel.cuzco.core.domain.model.FormulaireRechercheDisponibilite;
import org.hotel.cuzco.core.domain.ports.ChambreRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChambreInMemoryDatasource implements ChambreRepository {

    List<Chambre> toutesChambres = List.of(
            new Chambre(1, 101, 2, "1 king size bed - A/C - Wi-Fi - private bathroom - wheelchair accessible", List.of()),
            new Chambre(1, 102, 4, "2 queen size beds - A/C - Wi-Fi - private bathroom - wheelchair accessible", List.of()),
            new Chambre(1, 103, 3, "3 single beds - A/C - Wi-Fi - private bathroom - wheelchair accessible", List.of()),
            new Chambre(2, 201, 2, "1 king size bed - A/C - Wi-Fi - private bathroom", List.of()),
            new Chambre(2, 202, 2, "1 queen size bed - Wi-Fi - private bathroom", List.of()),
            new Chambre(2, 203, 5, "1 king size bed + 3 single beds - A/C - Wi-Fi - private bathroom", List.of()),
            new Chambre(2, 204, 1, "1 single bed - Wi-Fi - shared bathroom", List.of()),
            new Chambre(2, 205, 2, "2 single beds - A/C - Wi-Fi - shared bathroom", List.of()),
            new Chambre(3, 301, 2, "1 queen size bed - A/C - private bathroom", List.of()),
            new Chambre(3, 302, 2, "2 single beds - A/C - private bathroom", List.of()),
            new Chambre(3, 303, 3, "3 single beds - A/C - shared bathroom", List.of()),
            new Chambre(3, 304, 3, "2 single beds - shared bathroom", List.of())
    );

    @Override
    public List<Chambre> recupererToutesChambres() {
        return toutesChambres;
    }

    @Override
    public List<Chambre> trouverAvecCapaciteMinimaleEtSansReservationQuiChevauchent(FormulaireRechercheDisponibilite formulaire) {
        return toutesChambres.stream()
                .filter(chambre -> chambre.getCapacite() >= formulaire.getNombrePersonnes())
                .filter(chambre -> chambre.getReservations().stream().anyMatch(reservation -> {
                    LocalDate dateArrivee = formulaire.getDateDebut();
                    LocalDate dateSortie = formulaire.getDateFin();
                    return !(dateArrivee.isBefore(reservation.getDateFin()) && dateArrivee.isAfter(reservation.getDateDebut()) ||
                            dateSortie.isBefore(reservation.getDateFin()) && dateSortie.isAfter(reservation.getDateDebut()));
                }))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Chambre> trouver(int numeroDeChambre) {
        return toutesChambres.stream().filter(chambre -> chambre.getNumero() == numeroDeChambre).findFirst();
    }

    @Override
    public void enregistrer(Chambre chambre) {
        // TODO
    }
}

package org.hotel.cuzco.core.domain.model;

import java.time.LocalDate;

public class FormulaireRechercheDisponibilite {

    private final int nombrePersonnes;
    private final LocalDate dateDebut;
    private final LocalDate dateFin;

    public FormulaireRechercheDisponibilite(
            int nombrePersonnes,
            LocalDate dateDebut,
            LocalDate dateFin,
            LocalDate dateDuJour
    ) {
        if (nombrePersonnes <= 0)
            throw new RuntimeException();

        if (dateDebut.isEqual(dateFin) || dateDebut.isAfter(dateFin))
            throw new RuntimeException();

        if (dateDebut.isBefore(dateDuJour))
            throw new RuntimeException();

        this.nombrePersonnes = nombrePersonnes;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }


    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }
}

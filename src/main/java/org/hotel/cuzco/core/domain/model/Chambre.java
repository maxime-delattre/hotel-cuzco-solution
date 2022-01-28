package org.hotel.cuzco.core.domain.model;

import java.util.List;

public class Chambre {
    private final int etage;
    private final int numero;
    private final int capacite;
    private final String description;
    private final List<Reservation> reservations;

    public int getNumero() {
        return numero;
    }

    public int getCapacite() {
        return capacite;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Chambre(int etage, int numero, int capacite, String description, List<Reservation> reservations) {
        this.etage = etage;
        this.numero = numero;
        this.capacite = capacite;
        this.description = description;
        this.reservations = reservations;
    }

    public void reserver(FormulaireReservation formulaire) {
        if (capacite < formulaire.getNombrePersonne())
            throw new RuntimeException();

        if (datesChevauchentReservationExistante(formulaire))
            throw new RuntimeException();

        final var nouvelleReservation = new Reservation(formulaire.getDateArrivée(), formulaire.getDateSortie());

        reservations.add(nouvelleReservation);
    }

    private boolean datesChevauchentReservationExistante(FormulaireReservation params) {
        return reservations.stream().anyMatch(
                reservation -> reservation.chevaucheDates(params.getDateArrivée(), params.getDateSortie()));
    }
}

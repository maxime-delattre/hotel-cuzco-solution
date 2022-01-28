package org.hotel.cuzco.core.domain.model;

public class Chambre {
    private final int numero;
    private final int capacite;
    private final String description;

    public Chambre(int numero, int capacite, String description) {
        this.numero = numero;
        this.capacite = capacite;
        this.description = description;
    }

    public boolean estTropPetitePour(int nombrePersonnes) {
        return capacite >= nombrePersonnes;
    }
}

package org.hotel.cuzco.infra.clock;

import org.hotel.cuzco.core.domain.ports.DateDuJourRepository;

import java.time.LocalDate;

public class DateDuJourHorlogeSystemeRepository implements DateDuJourRepository {
    @Override
    public LocalDate recupererDateDuJour() {
        return LocalDate.now();
    }
}

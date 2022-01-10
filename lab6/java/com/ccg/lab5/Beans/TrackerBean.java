package com.ccg.lab5.Beans;

import com.ccg.lab5.Entities.Reservation;
import com.ccg.lab5.Repositories.ReservationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;

import javax.ejb.EJB;
import java.util.List;

@Singleton
public class TrackerBean {
    public List current;
    @EJB
    ReservationRepository reservationRepository;

    public TrackerBean() {
        current = reservationRepository.getReservations();
    }

    public List update() {
        current = reservationRepository.getReservations();
        return current;
    }
}

package com.ccg.lab5.Beans;

import com.ccg.lab5.Entities.Reservation;
import com.ccg.lab5.Repositories.ReservationRepository;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.List;

@Stateful
@ManagedBean(name = "assign")
public class AssingmentBean {
    @EJB
    ReservationRepository reservationRepository;

    public void saveReservations(List<Reservation> reservationList) {
        Boolean flag = Boolean.FALSE;
        reservationRepository.saveReservations(reservationList);
    }
}

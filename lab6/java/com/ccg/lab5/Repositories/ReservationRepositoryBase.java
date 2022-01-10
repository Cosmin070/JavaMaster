package com.ccg.lab5.Repositories;

import com.ccg.lab5.DTOs.ExamsEntity;
import com.ccg.lab5.Entities.Reservation;

import java.sql.SQLException;
import java.util.List;

public interface ReservationRepositoryBase {
    void saveReservation(Reservation exam) throws SQLException;

    List getReservations();

    Boolean saveReservations(List<Reservation> reservationList);
}

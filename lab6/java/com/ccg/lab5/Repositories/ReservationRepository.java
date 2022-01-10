package com.ccg.lab5.Repositories;

import com.ccg.lab5.Beans.TrackerBean;
import com.ccg.lab5.DTOs.ReservationEntity;
import com.ccg.lab5.Entities.Reservation;
import jakarta.inject.Inject;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Transactional(rollbackOn = {SQLException.class})
public class ReservationRepository implements ReservationRepositoryBase {
    @Inject
    private EntityManager entityManager;
    @EJB
    private TrackerBean trackerBean;

    @Override
    public void saveReservation(Reservation reservation) throws SQLException {
        ReservationEntity entity = new ReservationEntity();
        entity.setExam(reservation.getExamName());
        entity.setResource(reservation.getResource());
        entity.setAmount(reservation.getAmount());
        entityManager.persist(entity);
    }

    @Override
    public List getReservations() {
        return entityManager.createNamedQuery("Reservation.GetAll").getResultList();
    }

    @Override
    public Boolean saveReservations(List<Reservation> reservationList) {
        entityManager.getTransaction().begin();
        for (Reservation reservation : reservationList) {
            try {
                saveReservation(reservation);
            } catch (SQLException e) {
                entityManager.getTransaction().rollback();
                return Boolean.FALSE;
            }
        }
        entityManager.getTransaction().commit();
        trackerBean.update();
        return Boolean.TRUE;
    }

    public void commit() {
        entityManager.getTransaction().commit();
    }
}

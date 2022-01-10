package com.ccg.lab5.Beans;

import com.ccg.lab5.DTOs.ReservationEntity;
import com.ccg.lab5.DTOs.ResourceEntity;
import com.ccg.lab5.Entities.Resource;
import jakarta.inject.Inject;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import java.util.List;

@ManagedBean(name = "reservation")
@Stateless
public class ReservationBean {
    private final List<ResourceEntity> resources;
    private final List<ReservationEntity> reservations;
    @EJB
    TrackerBean trackerBean;
    @Inject
    private EntityManager entityManager;
    private List<Resource> available;

    public ReservationBean() {
        resources = entityManager.createNamedQuery("Resource.GetAll").getResultList();
        reservations = trackerBean.update();
        for (Object resource : resources) {
            ResourceEntity temp = (ResourceEntity) resource;
            boolean flag = Boolean.FALSE;
            for (ReservationEntity ent : reservations) {
                if (ent.getResource().equalsIgnoreCase(temp.getResource())) {
                    flag = Boolean.TRUE;
                    break;
                }
            }
            if (!flag) {
                available.add(new Resource(temp.getResource(), temp.getAmount()));
            }
        }
    }

    public List<Resource> getAvailable() {
        return available;
    }
}

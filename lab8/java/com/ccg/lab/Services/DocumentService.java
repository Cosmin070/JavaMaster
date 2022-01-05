package com.ccg.lab.Services;

import com.ccg.lab.Beans.UploadBean;
import com.ccg.lab.Entities.Upload;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Path("/documents")
public class DocumentService {
    @Inject
    protected EntityManager entityManager;

    @GET
    public List getDocuments(@QueryParam("user") String user) {
        if (user == null) {
            return entityManager.createNamedQuery("Upload.getUploads").getResultList();
        }
        return entityManager.createNamedQuery("Upload.getUploadsByUser").setParameter(1, user).getResultList();
    }

    @DELETE
    @Path("delete")
    public Boolean deleteDocument(@QueryParam("id") Integer id) {
        if (id != null) {
            entityManager.getTransaction().begin();
            Upload up = entityManager.find(Upload.class, id);
            entityManager.remove(up);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean updateDocument(UploadBean upload) {
        if (upload == null) {
            return false;
        } else {
            entityManager.getTransaction().begin();
            Upload up = entityManager.find(Upload.class, upload.getId());
            if (!Objects.equals(upload.getDocument(), up.getDocument())) {
                up.setDocument(upload.getDocument());
            }
            if (!Objects.equals(upload.getUsername(), up.getUsername())) {
                up.setUsername(upload.getUsername());
            }
            entityManager.merge(up);
            entityManager.getTransaction().commit();
            return true;
        }
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Boolean create(UploadBean upload) {
        if (upload == null) {
            return false;
        } else {
            Upload up = new Upload();
            up.setDocument(upload.getDocument());
            up.setUsername(upload.getUsername());
            up.setDocumentId(UUID.randomUUID().toString());
            entityManager.getTransaction().begin();
            entityManager.persist(up);
            entityManager.getTransaction().commit();
            return true;
        }
    }

}

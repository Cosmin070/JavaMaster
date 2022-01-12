package com.example.demo.Repositories;

import com.example.demo.Models.Upload;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class UploadRepo implements UploadRepoBase {
    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertUpload(Upload upload) {
        entityManager.persist(upload);
    }

    @Override
    @Transactional
    public List<Upload> getUploads(String author) {
        if (author != null) {
            return entityManager.createNamedQuery("Upload.getByAuthor").setParameter(1, author).getResultList();
        }
        return entityManager.createNamedQuery("Upload.getAll").getResultList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Upload upload = entityManager.find(Upload.class, id);
        entityManager.remove(upload);
    }

    @Override
    @Transactional
    public Upload update(Upload upload) {
        entityManager.merge(upload);
        return upload;
    }
}

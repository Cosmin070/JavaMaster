package com.ccg.lab.Repositories;

import com.ccg.lab.Beans.UploadBean;
import com.ccg.lab.Entities.Upload;
import com.ccg.lab.Utils.CustomInterceptorBinding;
import com.ccg.lab.Utils.TimeCheck;
import com.ccg.lab.Utils.UIDGenerator;
import jakarta.annotation.security.RolesAllowed;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@ManagedBean(name = "uploadRepo")
public class UploadRepository {
    @Inject
    protected EntityManager entityManager;

    @CustomInterceptorBinding
    @RolesAllowed({"user", "admin"})
    public void insertUpload(UploadBean uploadBean) throws IOException {
        Upload upload = new Upload();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (TimeCheck.checkTime()) {
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            Cookie[] userCookies = request.getCookies();
            Cookie cookie = null;
            if (userCookies != null && userCookies.length > 0) {
                for (Cookie userCookie : userCookies) {
                    if (userCookie.getName().equals("username")) {
                        cookie = userCookie;
                        break;
                    }
                }
            }
            assert cookie != null;
            upload.setUsername(cookie.getValue());
            upload.setDocumentId(UIDGenerator.getUUID());
            upload.setDocument(uploadBean.getDocument());
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("D:\\log.txt", true), StandardCharsets.UTF_8));
            writer.append(upload.toString()).append("\n");
            writer.close();
            entityManager.getTransaction().begin();
            entityManager.persist(upload);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    @RolesAllowed({"user","admin"})
    public List getUploads() {
        Query query = entityManager.createNamedQuery("Upload.getUploads");
        return query.getResultList();
    }
}

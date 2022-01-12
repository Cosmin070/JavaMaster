package com.ccg.lab.Repositories;

import com.ccg.lab.Beans.LoginBean;
import com.ccg.lab.Beans.UserBean;
import com.ccg.lab.Entities.User;
import com.ccg.lab.Utils.TimeCheck;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@ManagedBean(name = "userRepo")
@Transactional(rollbackOn = {SQLException.class})
public class UserRepository {
    @Inject
    protected EntityManager entityManager;

    public void insertUser(UserBean userBean) {
        if (TimeCheck.checkTime()) {
            User user = new User();
            user.setUsername(userBean.getUsername());
            user.setPassword(userBean.getPassword());
            user.setRole(userBean.getRole());
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    public void checkUser(LoginBean loginBean) throws ServletException, IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        System.out.println("///////// "+ loginBean.getUsername()+" ///////////// " + loginBean.getPassword()+" /////////////////////////");
        request.login(loginBean.getUsername(), loginBean.getPassword());
        String role = (String) entityManager.createNamedQuery("User.checkUser").setParameter(1, loginBean.getUsername()).setParameter(2, loginBean.getPassword()).getSingleResult();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
        if (Objects.equals(role, "reviewer") || Objects.equals(role, "author")) {

            Cookie cookie = new Cookie("username", loginBean.getUsername());
            cookie.setMaxAge(1800);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect(context.getExternalContext().getRequestContextPath() + "faces/user/main.xhtml");
        } else if (Objects.equals(role, "admin")) {
            Cookie cookie = new Cookie("username", loginBean.getUsername());
            cookie.setMaxAge(1800);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect(context.getExternalContext().getRequestContextPath() + "/faces/admin/main.xhtml");
        } else {
            response.sendRedirect(context.getExternalContext().getRequestContextPath() + "faces/unregistered/main.xhtml");
        }
    }
}

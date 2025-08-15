
package com.mycompany.projetosenac.persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;


public class UserJPA {
    
    public static User validarUsuario (User user) {
        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.senha = :senha");
            consulta.setParameter("login", user.getLogin());
            consulta.setParameter("senha", user.getSenha());
            List<User> lista = consulta.getResultList();
            
            if(!lista.isEmpty()) {
                return lista.get(0);
            }
           
        } catch(Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        } 
        return null;
    }
}
    


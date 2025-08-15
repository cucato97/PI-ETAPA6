
package com.mycompany.projetosenac.persistencia;

import jakarta.persistence.EntityManager;
import java.util.List;


public class CadastroTutorJPA {
    
        public static void cadastrar(CadastroTutor cadastrotutor) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(cadastrotutor);
            manager.getTransaction().commit();

            System.out.println("Tutor cadastrado com sucesso!");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.desconectar();
        }
    }
        
            public static List<CadastroTutor> listar() {
        EntityManager manager = JPAUtil.conectar();
        try {
            String jpql = "SELECT p FROM CadastroTutor  p";
            return manager.createQuery(jpql, CadastroTutor.class).getResultList();
        } finally {
            JPAUtil.desconectar();
        }
    }



}
    

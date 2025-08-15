package com.mycompany.projetosenac.persistencia;

import com.mycompany.projetosenac.TELAS.CadastroPETS;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class CadastroPETJPA {

    public static void cadastrar(CadastroPet pet) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(pet);
            manager.getTransaction().commit();

            System.out.println("Pet cadastrado com sucesso!");
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<CadastroPet> listar() {
        EntityManager manager = JPAUtil.conectar();
        try {
            String jpql = "SELECT p FROM CadastroPet  p";
            return manager.createQuery(jpql, CadastroPet.class).getResultList();
        } finally {
            JPAUtil.desconectar();
        }
    }

}

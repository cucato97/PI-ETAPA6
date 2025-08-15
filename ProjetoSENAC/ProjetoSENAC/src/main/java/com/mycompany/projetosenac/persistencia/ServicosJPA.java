package com.mycompany.projetosenac.persistencia;

import com.mycompany.projetosenac.TELAS.Servicos;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ServicosJPA {

    public static void cadastrar(TiposServicos servicos) {

        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(servicos);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<TiposServicos> listar() {
        List<TiposServicos> lista = null;
        EntityManager manager = JPAUtil.conectar();

        try {
            Query consulta = manager.createQuery("SELECT l FROM servicos l");
            lista = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return lista;
    }

    public static void excluirPorTipo(String tipo) {
    EntityManager manager = JPAUtil.conectar();
    try {
        manager.getTransaction().begin();

        Query query = manager.createQuery("DELETE FROM TiposServicos t WHERE t.tipo = :tipo");
        query.setParameter("tipo", tipo);
        query.executeUpdate();

        manager.getTransaction().commit();
    } catch (Exception e) {
        manager.getTransaction().rollback();
        e.printStackTrace(); // opcional: ajuda a depurar erros
    } finally {
        JPAUtil.desconectar();
    }
}

    public static List<TiposServicos> buscar(String filtro) {
        List<TiposServicos> lista = new ArrayList<TiposServicos>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT l FROM servicos l WHERE (:tipo is null OR l.tipo LIKE :tipo)");
            consulta.setParameter("tipo", filtro.isEmpty() ? null : "%" + filtro + "%");
            lista = consulta.getResultList();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao listar os dados");
            System.out.println(e);
        } finally {
            JPAUtil.desconectar();
        }
        return lista;

    }
    

}

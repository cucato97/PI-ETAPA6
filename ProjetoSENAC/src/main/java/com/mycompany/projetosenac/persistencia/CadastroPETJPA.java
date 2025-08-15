package com.mycompany.projetosenac.persistencia;

import com.mycompany.projetosenac.TELAS.CadastroPETS;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class CadastroPETJPA {

       // Método para cadastrar um pet no banco de dados
    public static void cadastrar(CadastroPet pet) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin(); // Inicia transação
            manager.persist(pet); // Persiste o objeto
            manager.getTransaction().commit(); // Finaliza a transação com sucesso
            System.out.println("Pet cadastrado com sucesso!");
        } catch (Exception e) {
            manager.getTransaction().rollback(); // Em caso de erro, desfaz a transação
            e.printStackTrace(); // Exibe o erro no console (poderia ser tratado melhor)
        } finally {
            JPAUtil.desconectar(); // Garante que o EntityManager seja fechado
        }
    }

    // Método para listar todos os pets cadastrados
    public static List<CadastroPet> listar() {
        EntityManager manager = JPAUtil.conectar();
        try {
            String jpql = "SELECT p FROM CadastroPet p"; // Consulta JPQL
            return manager.createQuery(jpql, CadastroPet.class).getResultList(); // Executa e retorna resultado
        } finally {
            JPAUtil.desconectar(); // Fecha o EntityManager
        }
    }
}

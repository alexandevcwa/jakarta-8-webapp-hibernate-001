/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.alexandevcwa.model;

import com.alexandevcwa.model.Client;
import com.alexandevcwa.orm.PostgreSQLSessionFactory;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author AlexanDev_CWA
 */
public class ClientTest {

    private static PostgreSQLSessionFactory sessionFactory;
    private static final Logger log = Logger.getLogger(ClientTest.class.getCanonicalName());

    public ClientTest() {

    }

    @BeforeAll
    @Disabled
    public static void setUpClass() {
        sessionFactory = new PostgreSQLSessionFactory();
    }
    
    @Test
    @Disabled
    public void crearUnNuevoCliente() {

        Client client = Client.builder()
                .name("JHON SNOW")
                .address("NEW YORK CITY, USA")
                .email("jhonsnow@user.com")
                .password("1234567890")
                .nit("123456789010")
                .phone("12345678")
                .build();

        try (Session session = sessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
            session.evict(client);
            session.close();
        }
    }

    @Test
    @Disabled
    public void actualizarDatosCliente() {
        try (Session session = sessionFactory.getSessionFactory().openSession()) {
            String query = "SELECT d FROM Client d WHERE d.nit = :nit";
            Query<Client> clientQuery = session.createQuery(query, Client.class);
            clientQuery.setParameter("nit", "123456789010");
            Client client = clientQuery.getSingleResult();

            assertEquals(client.getNit(), "123456789010", "NIT retrived is equals");
            session.beginTransaction();
            client.setName("JHON COLD");
            client.setPhone("00000000");
            session.flush();
            session.evict(client);
            session.getTransaction().commit();
            //session.close();
        }
    }

    @Test
    @Disabled
    public void errorEliminarCliente() {

        try (Session session = sessionFactory.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Client> criteriaQuery = criteriaBuilder.createQuery(Client.class);
            Root<Client> clientRoot = criteriaQuery.from(Client.class);
            Predicate nitPredicate = criteriaBuilder.equal(clientRoot.get("nit"), "123456789010");
            criteriaQuery.where(nitPredicate);
            Client client = session.createQuery(criteriaQuery).getSingleResult();

            assertThrows(PersistenceException.class, () -> {
                session.beginTransaction();
                session.remove(client);
                session.getTransaction().commit();
            }, "Client should not have grants to remove an entity");
        }
    }
}

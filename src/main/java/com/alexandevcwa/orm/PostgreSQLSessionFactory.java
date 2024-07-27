package com.alexandevcwa.orm;

import javax.enterprise.context.ApplicationScoped;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


@ApplicationScoped
public class PostgreSQLSessionFactory {
    
    private final StandardServiceRegistry standardServiceRegistry;
    
    @Getter
    private final SessionFactory sessionFactory;
    
    public PostgreSQLSessionFactory(){
        // Create Registry
        standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.postgresql.cfg.xml").build();
        // Crear MetadataSources
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        // Create Metadata
        Metadata metadata = metadataSources.getMetadataBuilder().build();
        // Crear SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }
    
    public void shutdown(){
        StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
    }
}

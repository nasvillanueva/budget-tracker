package com.nasvillanueva.budgettracker.config;

import com.nasvillanueva.budgettracker.util.PropertySplitter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.support.MergingPersistenceUnitManager;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;


/**
 * Created by NazIsEvil on 13/12/2015.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.nasvillanueva.budgettracker.model")
public class DataSourceConfig {

    @Value("${jndi.datasource.name}")
    private String jndi;

    @Value("${hibernate.properties}")
    private String hibernateProperties;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws NamingException {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("budget-tracker-pu");
        em.setPersistenceUnitManager(persistenceUnitManager());
        em.setDataSource(dataSource());
        em.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaDialect(new HibernateJpaDialect());
        em.setJpaProperties(jpaProperties());
        return em;
    }

    private Properties jpaProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        properties.setProperty("hibernate.id.new_generator_mappings", "true");
        Map<String, String> hibernateProp = PropertySplitter.map(hibernateProperties);
        for (Map.Entry<String, String> prop : hibernateProp.entrySet()) {
            properties.setProperty(prop.getKey(), prop.getValue());
        }
        return properties;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        JndiObjectFactoryBean ds = new JndiObjectFactoryBean();
        ds.setJndiName(jndi);
        ds.setResourceRef(true);
        ds.setLookupOnStartup(true);
        ds.setProxyInterface(DataSource.class);
        ds.afterPropertiesSet();
        return (DataSource) ds.getObject();
    }

    @Bean
    public MergingPersistenceUnitManager persistenceUnitManager() throws NamingException {
        MergingPersistenceUnitManager pum = new MergingPersistenceUnitManager();
        pum.setDefaultPersistenceUnitName("budget-tracker-pu");
        pum.setPackagesToScan("com.nasvillanueva.budgettracker.model");
        pum.setDefaultDataSource(dataSource());
        return pum;
    }

    @Bean
    public JpaTransactionManager transactionManager() throws NamingException {
        JpaTransactionManager tx = new JpaTransactionManager();
        tx.setEntityManagerFactory(entityManagerFactoryBean().getNativeEntityManagerFactory());
        return tx;
    }
}

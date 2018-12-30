package siso.edu.cn.config;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"siso.edu.cn.dao", "siso.edu.cn.entity", "siso.edu.cn.service"})
public class DatabaseConfig {

    /*==========数据源设置==========*/
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/electric_iot?useSSL=true&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("05200902");

        return dataSource;
    }

    private Properties databaseProperties() {
        Properties properties = new Properties();
        properties.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty(AvailableSettings.SHOW_SQL, "true");
        properties.setProperty(AvailableSettings.FORMAT_SQL, "true");

        return properties;
    }

    /*==========Hibernate设置==========*/
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan("siso.edu.cn.entity");
//        sessionFactory.setHibernateProperties(databaseProperties());
//
//        return sessionFactory;
//    }

//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//
//        return transactionManager;
//    }

    /*==========JPA设置==========*/
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setJpaProperties(databaseProperties());
        localContainerEntityManagerFactoryBean.setPackagesToScan("siso.edu.cn.entity");

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");

        return adapter;
    }

    @Bean
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();

        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

        return jpaTransactionManager;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    /*==========使Repository能够捕获异常==========*/
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

}

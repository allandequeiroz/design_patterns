package java4.fun.dataLayer.config;

import org.hibernate.cfg.AnnotationConfiguration;

public class DefaultAnnotationConfiguration extends AnnotationConfiguration{

	private static final long serialVersionUID = 4075011169502165739L;

	public DefaultAnnotationConfiguration(){
		super.setProperty("hibernate.bytecode.use_reflection_optimizer", "true").
		setProperty("hibernate.c3p0.acquire_increment", "1").
		setProperty("hibernate.c3p0.idle_test_period", "600").
		setProperty("hibernate.c3p0.max_size", "100").
		setProperty("hibernate.c3p0.max_statements", "0").
		setProperty("hibernate.c3p0.min_size", "1").
		setProperty("hibernate.hbm2ddl.auto", "update").
		setProperty("hibernate.connection.driver_class", "org.apache.derby.jdbc.ClientDriver").
		setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect").
		setProperty("hibernate.connection.url", "jdbc:derby://localhost:1527/derbydb;create=true").
		setProperty("hibernate.connection.username", "app").
		setProperty("hibernate.connection.password", "app");
	}
}

package out.simplilearnproject.com;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	public static SessionFactory method() {
		StandardServiceRegistry registry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta=new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory=meta.getSessionFactoryBuilder().build();
		return factory;
	}
}

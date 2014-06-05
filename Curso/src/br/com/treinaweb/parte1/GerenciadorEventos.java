package br.com.treinaweb.parte1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class GerenciadorEventos {
	public boolean salvarEvento(String evento, String data){
		try{			
			Session session = getSessionFactory();
			Transaction transaction = session.beginTransaction();
			
			Eventos eventos = new Eventos();
			eventos.setData(data);
			eventos.setEvento(evento);
			
			session.saveOrUpdate(eventos);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	public List listarEventos(){
		Session session = getSessionFactory();
		session.beginTransaction();
		List list = session.createQuery("from Eventos").list();
		session.getTransaction().commit();
		if (list.size() > 0)
			list.remove(0);
		return list;
	}
	
	private Session getSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory.openSession();
	}
}

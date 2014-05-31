package br.com.treinaweb.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public abstract class ImplJpaDAO<T, I extends Serializable> implements DAO<T, I> {

	private static final String UNIT_NAME = "entidade";
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	@Override
	public T save(T entity) {
		T saved = null;
		
		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	@Override
	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public T getById(Class<T> classe, I pk) {
		try{
			return getEntityManager().find(classe, pk);
		}catch(NoResultException ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {
		return (List<T>) getEntityManager().createQuery("select e from " + classe.getSimpleName() + " e");
	}

	@Override
	public EntityManager getEntityManager() {
		if(entityManagerFactory == null)
			entityManagerFactory = Persistence.createEntityManagerFactory(UNIT_NAME);

		if(entityManager == null)
			entityManager = entityManagerFactory.createEntityManager();
		
		return entityManager;
	}

}

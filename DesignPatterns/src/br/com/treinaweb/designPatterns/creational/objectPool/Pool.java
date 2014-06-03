package br.com.treinaweb.designPatterns.creational.objectPool;

public interface Pool<T> {
	
	T acquire();

	void release(T t);

	int availables();
}

package dao;

import java.util.List;

public interface IDao<E> {
	
		/**
		 * Insere a entidade.
		 * @param entityObject Entidade com o "registro" a ser inserido.
		 */
	    public void create(E entityObject);
	    
	    /**
	     * Altera a entidade.
	     * @param entityObject Entidade com o "registro" a ser alterado.
	     */
	    public void edit(E entityObject);
	    
	    /**
	     * Apaga a entidade.
	     * @param entityObject Entidade com o "registro" a ser excluido.
	     */
	    public void delete(E entityObject);
	    
	    /**
	     * Apaga a entidade.
	     * @param entityClass Classe que representa a entidade
	     * @param pk Chave prim�ria
	     */
	    public void delete(Class<E> entityClass,Object pk);
	    
	    /**
	     * Busca a entidade atrav�s da chave prim�ria.     
	     * @param entityClass Classe que representa a entidade.
	     * @param pk Chave prim�ria
	     * @return Retorna a entidade
	     */
	    public E find(Class<E> entityClass, Object pk);

	    /**
	     * Busca todos os registros de uma entidade.
	     * @param entityClass Classe que representa a entidade.
	     * @return Retorna a lista de entidades.
	     */
	    public List<E> findAll(Class<E> entityClass);


	    /**
	     * Busca todos os registros de uma entidade dentro de um determinado intervalo.
	     * @param entityClass Classe que representa a entidade.
	     * @param firstResult Primeiro registro da consulta.
	     * @param maxResult N�mero de registros na consulta.
	     * @return Retorna a lista de entidades.
	     */
	    public List<E> findAll(Class<E> entityClass,int firstResult, int maxResult);
	    
}

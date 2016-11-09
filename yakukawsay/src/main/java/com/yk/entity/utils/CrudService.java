package com.yk.entity.utils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * @author jrocha
 *
 */
public interface CrudService {

    /**
     * @return The current EntityMamager
     */
    public EntityManager getEm();

    /**
     * Persist the object t, throws Exception if any persist exception occurs
     *
     * @param t
     * @throws Exception
     */
    public <T> void create(T t) throws Exception;

    /**
     * Persist the object t and flush, throws Exception if any persist exception
     * occurs
     *
     * @param t
     * @return the persisted object
     * @throws Exception
     */
    public <T> T createFlush(T t) throws Exception;

    /**
     * Finds the registry by its primary key
     *
     * @param type
     * @param id
     * @return the resulting entity
     */
    public <T> T find(Class<T> type, Object id);

    /**
     * Updates the entity data and flush
     *
     * @param t
     * @return the entity with persisted data
     */
    public <T> T updateFlush(T t);

    /**
     * Updates the entity data
     *
     * @param t
     * @return the entity with persisted data
     */
    public <T> T update(T t);

    /**
     * Deletes the registry by its primary key
     *
     * @param type
     * @param id
     */
    public <T> void delete(Class<T> type, Object id);

    /**
     * Finds all registers from a given entity
     *
     * @param entityClass
     * @return result list
     */
    public <T> List<T> findAll(Class<T> entityClass);

    /**
     * @param entityClass
     * @return the number of registers from a given entity
     */
    public <T> int count(Class<T> entityClass);

    /**
     * @param entityClass
     * @param whereClausule
     * @param <T>
     * @return the number of registers from a given entity
     */
    public <T> int countWithParms(Class<T> entityClass, Map<String, Object> whereClausule);

    /**
     * Finds registers using a defined named query
     *
     * @param queryName
     * @return result list
     */
    public <T> List<T> findWithNamedQuery(String queryName);

    /**
     * Finds registers using a defined named query and a limit of result list
     * size
     *
     * @param queryName
     * @param resultLimit
     * @return result list
     */
    public <T> List<T> findWithNamedQuery(String queryName, int resultLimit);

    /**
     * Finds registers using a defined named with parameters
     *
     * @param namedQueryName
     * @param parameters
     * @return result list
     */
    public <T> List<T> findWithNamedQuery(String namedQueryName,
            Map<String, Object> parameters);

    /**
     * Finds registers using a defined named query with parameters and limit of
     * result list size
     *
     * @param namedQueryName
     * @param parameters
     * @param resultLimit
     * @return result list
     */
    public <T> List<T> findWithNamedQuery(String namedQueryName,
            Map<String, Object> parameters, int resultLimit);

    /**
     * Finds registers in a given range [start, end], useful for pagination
     *
     * @param start
     * @param end
     * @param entityClass
     * @return result list
     */
    public <T> List<T> findRange(final int start, final int end,
            Class<T> entityClass);

    /**
     * Finds registers using a defined named query with parameters and a given
     * range [start, end], useful for pagination
     *
     * @param namedQueryName
     * @param start
     * @param end
     * @return result list
     */
    public <T> List<T> findRangeWithNamed(String namedQueryName,
                                          final int start, final int end);

    /**
     * Finds registers using a defined named query with parameters and a given
     * range [start, end], useful for pagination
     *
     * @param namedQueryName
     * @param parameters
     * @param start
     * @param end
     * @return result list
     */
    public <T> List<T> findRangeWithNamed(String namedQueryName,
            Map<String, Object> parameters, final int start, final int end);

    /**
     * Finds register executing native query
     *
     * @param sql
     * @return result list
     */
    public List<Object> findByNativeQuery(String sql);

    /**
     * Finds register executing native query
     *
     * @param sql
     * @param type
     * @return result list
     */
    public <T> List<T> findByNativeQuery(String sql, Class<T> type);

}

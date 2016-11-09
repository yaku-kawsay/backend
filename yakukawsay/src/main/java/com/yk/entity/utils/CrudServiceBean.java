package com.yk.entity.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;

/**
 * @author jrocha
 *
 */
public class CrudServiceBean implements CrudService {

    private final EntityManager em;

    /**
     * Creates a CrudServiceBean object with the specific EntityManager
     *
     * @param em
     */
    public CrudServiceBean(EntityManager em) {
        this.em = em;
    }

    @Override
    public EntityManager getEm() {
        return em;
    }

   
    @Override
    public <T> void create(T t) throws Exception {
        em.persist(t);
    }

   
    @Override
    public <T> T createFlush(T t) throws Exception {
        em.persist(t);
        em.flush();
        em.refresh(t);
        return t;
    }

    
    @Override
    public <T> T find(Class<T> type, Object id) {
        return em.find(type, id);
    }

    
    @Override
    public <T> T update(T t) {
        return em.merge(t);
    }

    @Override
    public <T> T updateFlush(T t) {
        em.merge(t);
        em.flush();
        em.refresh(t);
        return t;
    }

    @Override
    public <T> void delete(Class<T> type, Object id) {
        Object ref = em.getReference(type, id);
        em.remove(ref);
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

   
    @Override
    public <T> int count(Class<T> entityClass) {
        return countWithParms(entityClass, null);
    }

    /**
     * @param filter
     * @param root
     * @return The resolver path for the field
     */
    private Path resolvePath(Map.Entry<String, Object> filter, Root root) {
        String[] keys = filter.getKey().split("\\.");
        Path path = root.get(keys[0]);
        for (int i = 1; i < keys.length; i++) {
            path = path.get(keys[i]);
        }
        return path;
    }

    @Override
    public <T> int countWithParms(Class<T> entityClass, Map<String, Object> whereClausule) {
        CriteriaQuery<Long> cq = em.getCriteriaBuilder()
                .createQuery(Long.class);
        Root<T> rt = cq.from(entityClass);
        CriteriaBuilder cBuilder = em.getCriteriaBuilder();
        cq.select(cBuilder.count(rt));
        if(whereClausule !=null && !whereClausule.isEmpty()){
            List<Predicate> predicates = new ArrayList<>();
            for(final Entry<String, Object> filter : whereClausule.entrySet()){
                Path path = resolvePath(filter, rt);
                Object value = filter.getValue();
                if(value != null){
                    if(value instanceof  List){
                        predicates.add(path.in((List)value));
                    }else{
                       predicates.add(cBuilder.equal(path, value));
                    }
                } else{
                    predicates.add(cBuilder.isNull(path));
                }
            }
            cq.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findWithNamedQuery(String queryName) {
        return em.createNamedQuery(queryName).getResultList();
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findWithNamedQuery(String queryName, int resultLimit) {
        return em.createNamedQuery(queryName).setMaxResults(resultLimit)
                .getResultList();
    }


    @Override
    public <T> List<T> findWithNamedQuery(String namedQueryName,
            Map<String, Object> parameters) {
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findWithNamedQuery(String namedQueryName,
            Map<String, Object> parameters, int resultLimit) {
        Set<Entry<String, Object>> params = parameters.entrySet();
        Query query = em.createNamedQuery(namedQueryName);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Entry<String, Object> entry : params) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findRange(int start, int end, Class<T> entityClass) {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));

        Query q = em.createQuery(cq);
        q.setMaxResults(end - start + 1);
        q.setFirstResult(start);
        return q.getResultList();
    }


    public <T> List<T> findRangeWithNamed(String namedQueryName,
                                          final int start, final int end){
        return  findRangeWithNamed(namedQueryName, null, start, end);
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findRangeWithNamed(String namedQueryName,
            Map<String, Object> parameters, int start, int end) {
        Query query = em.createNamedQuery(namedQueryName);
        if(parameters != null) {
            Set<Entry<String, Object>> params = parameters.entrySet();
            for (Entry<String, Object> entry : params) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        query.setMaxResults(end - start + 1);
        query.setFirstResult(start);
        return query.getResultList();
    }


    @Override
    public List<Object> findByNativeQuery(String sql) {
        return em.createNativeQuery(sql).getResultList();
    }


    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findByNativeQuery(String sql, Class<T> type) {
        return em.createNativeQuery(sql, type).getResultList();
    }

}

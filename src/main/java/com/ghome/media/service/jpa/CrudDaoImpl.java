package com.ghome.media.service.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class CrudDaoImpl<ReturnType, IdType> implements CrudDao<ReturnType, IdType> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<? extends ReturnType> entityType;

    public CrudDaoImpl(Class<? extends ReturnType> entityType) {
        this.entityType = entityType;
    }

    @Override
    public void create(ReturnType entity) {
        entityManager.persist(entity);
    }

    @Override
    public ReturnType get(IdType id) {
        return entityManager.find(entityType, id);
    }

    @Override
    public void update(ReturnType entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(ReturnType entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<ReturnType> getAll() {
        return entityManager.createQuery("from " + entityType.getSimpleName()).getResultList();
    }

}

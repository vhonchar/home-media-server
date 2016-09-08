package com.ghome.media.service.jpa;

import java.util.List;

/**
 * Main operations which all DTOs should implements
 *
 * @param <ReturnType>
 * @param <IdType>     - the type of Primary Key
 */
public interface CrudDao<ReturnType, IdType> {

    void create(ReturnType entity);

    ReturnType get(IdType id);

    void update(ReturnType entity);

    void delete(ReturnType entity);

    List<ReturnType> getAll();
}

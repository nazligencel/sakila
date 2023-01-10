package com.uniyaz.inventory.dao;

import com.uniyaz.HibernateUtil;
import com.uniyaz.common.dao.BaseDao;
import com.uniyaz.inventory.domain.Inventory;
import com.uniyaz.inventory.queryfilterdto.InventoryQueryFilterDto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class InventoryDao extends BaseDao<Inventory> {

    public InventoryDao() {
        super(Inventory.class);
    }

    public List<Inventory> findAllByQueryFilterDto(InventoryQueryFilterDto inventoryQueryFilterDto) {
        String hql =
                "Select inventory " +
                        "From Inventory inventory " +
                        "Left Join fetch inventory.film title " +
                        "Left Join fetch inventory.store id " +
                        "where 1=1 ";

        if (inventoryQueryFilterDto.getId() != null){
            hql += " and inventory.id = :inventoryId";
        }
        if (inventoryQueryFilterDto.getFilm() != null) {
            hql += " and inventory.film.title = :film";
        }
        if (inventoryQueryFilterDto.getStore() != null){
            hql += " and inventory.store.id = :store";
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session currentSession = sessionFactory.openSession();
        Query query = currentSession.createQuery(hql);

        if (inventoryQueryFilterDto.getId() != null){
            query.setParameter("inventoryId", inventoryQueryFilterDto.getId());
        }

        if (inventoryQueryFilterDto.getFilm() != null){
            query.setParameter("film", inventoryQueryFilterDto.getFilm().getTitle());
        }

        if (inventoryQueryFilterDto.getStore() != null){
            query.setParameter("store", inventoryQueryFilterDto.getStore().getId());
        }

        List<Inventory> inventoryList = query.list();
        return inventoryList;
    }
}

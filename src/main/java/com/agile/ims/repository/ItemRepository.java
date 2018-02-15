/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.repository;

import com.agile.ims.entity.Item;
import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammad
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("UPDATE Item item set item.deleted = 1 where item.id = :id")
    boolean deleteItem(@Param("id") int id);

    @Query("Select item From Item item  Where item.groupid = :groupId AND item.deleted <> 1")
    Collection<Item> findByGroupid(@Param("groupId") int groupId);

    Item findByBarcode(String barcode);

    @Query("Select item from  Item item where item.name LIKE CONCAT('%',:name,'%') AND item.deleted <> 1 ")
    Collection<Item> findByName(@Param("name") String name);

    @Query("Select item From Item item Where item.expiredate = :date  AND item.deleted <> 1 ")
    Item findByExbiredate(@Param("date") Date date);

    @Query("Select item From Item item Where item.deleted <> 1")
    Collection<Item> getAll();

    @Query("Select item From Item item Where item.expiredate >= :from AND item.expiredate <= :to AND item.deleted <> 1")
    Collection<Item> findByExbiredateBetween(Date from, Date to);

    @Query("select item from Item item where item.id = :id and item.deleted <> 1 ")
    Item findById(@Param("id") int id);

    /*@Query("from StoreItem si inner join si.itemid as items ")
    Collection<Item> getLowestquantity();*/
}

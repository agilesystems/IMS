/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.repository;

import com.agile.ims.entity.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammad
 */
@Repository
public interface StoreItemRepository extends JpaRepository<StoreItem, Integer> {

    @Query("select storeitem from StoreItem storeitem where storeitem.itemid = :itemid and storeitem.deleted <> 1  ")
    StoreItem findByItemid(@Param("itemid") int itemid);
}

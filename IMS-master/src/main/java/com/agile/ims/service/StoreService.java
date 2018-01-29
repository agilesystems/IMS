/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.Store;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad
 */
@Service
public interface StoreService {

    /**
     * this method to add new or update current data in store table
     *
     * @param store an object to get the data of store to save it in the table
     * @return true if the data saved successfully or false if not saved
     */
    boolean save(Store store);

    /**
     * This method for soft deleted the store , just update the deleted field
     * with value(1
     *
     * @param store an argument to specify the data to updated
     * @return true if deleted field updated successfully or false in not
     * updated
     */
    boolean delete(Store store);

    /**
     * this method to get all store data
     *
     * @return a collection of stores
     */
    Collection<Store> getAll();

    /**
     * this method to get one store if the store id parameter true .
     *
     * @param id an integer to specify the store id
     * @return Store object if @param id is correct
     */
    Store findByid(int id);

    /**
     * this method to get collection of store using like (%{name}%) this method
     * to search in store table using any part of store name
     *
     * @param name an String argument to specify the name of store Or part of
     * name to get the store
     * @return a collection of stores
     */
    Collection<Store> findByName(String name);

}

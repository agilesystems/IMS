/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;


import com.agile.ims.entity.Store;
import com.agile.ims.entity.StoreItem;
import com.agile.ims.repository.StoreItemRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Muhammad
 */
public class StoreItemServiceImp implements StoreItemService {

    @Autowired
    StoreItemRepository storeItemRepository;

    @Override
    public boolean save(StoreItem storeitem) {
       return storeItemRepository.save(storeitem) != null;
    }

    @Override
    public boolean delete(StoreItem storeItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StoreItem getByItemid(int itemid) {
        if (storeItemRepository.findByItemid(itemid) != null) {
                 return storeItemRepository.findByItemid(itemid);
        }else{
            return null;
        }
   
    }

    @Override
    public Collection<StoreItem> getByStoreid(Store store) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

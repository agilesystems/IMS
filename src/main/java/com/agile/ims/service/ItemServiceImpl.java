/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.Item;
import com.agile.ims.repository.ItemRepository;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mhdsy
 */
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;
    
    @Override
    public boolean save(Item item) {
        return itemRepository.save(item)!=null;
    }

    @Override
    public boolean delete(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Collection<Item> findByGroupid(int groupid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Item> getLowestquantity(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item findByBarcode(String barcode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Item> getItemExbiredate(Date from, Date to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

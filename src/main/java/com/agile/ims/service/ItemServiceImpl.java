/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.Item;
import com.agile.ims.entity.StoreItem;
import com.agile.ims.repository.ItemRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mhdsy
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public boolean save(Item item) {
        return itemRepository.save(item) != null;
    }

    @Override
    public boolean delete(int id) {
        return itemRepository.deleteItem(id);
    }

    @Override
    public Collection<Item> getAll() {
        if (!itemRepository.findAll().isEmpty()) {
            return itemRepository.getAll();
        } else {
            return null;
        }
    }

    @Override
    public Collection<Item> findByGroupid(int groupid) {
        if (!itemRepository.findByGroupid(groupid).isEmpty()) {
            return itemRepository.findByGroupid(groupid);
        } else {
            return null;
        }
    }

    @Override
    public Collection<Item> getLowestquantity() {
       Collection<Item> allitem = new ArrayList<>();
        for (Item item : getAll()) {
            for (StoreItem storeItem : item.getStoreItemCollection()) {
                if (storeItem.getQuantity() <= item.getLowestquantity()) {
                    allitem.add(item);
                }
            }
        }
        return allitem;
    }

    @Override
    public Item findByBarcode(String barcode) {
        Item item = itemRepository.findByBarcode(barcode);
        if (item != null) {
            return item;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Item> getItemExbiredateBetween(Date from, Date to) {
        if (itemRepository.findByExbiredateBetween(from, to) != null) {
            return itemRepository.findByExbiredateBetween(from, to);
        } else {
            return null;
        }

    }

    @Override
    public Collection<Item> getByName(String Name) {
        Collection<Item> item = itemRepository.findByName(Name);
        if (item != null) {
            return itemRepository.findByName(Name);

        } else {
            return null;
        }
    }

    @Override
    public Item findByExbiredate(Date date) {

        if (itemRepository.findByExbiredate(date) != null) {
            return itemRepository.findByExbiredate(date);
        } else {
            return null;
        }

    }

    @Override
    public Item findById(int id) {
        if (itemRepository.findById(id) != null) {
            return itemRepository.findById(id);
        } else {
            return null;
        }

    }

}

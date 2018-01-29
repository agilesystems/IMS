/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.Item;
import com.agile.ims.entity.TransferItem;
import java.util.Collection;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad
 */
@Service
public interface TransferitemService {

    boolean save(TransferItem transferItem);

    boolean delete(TransferItem transferitem);

    Collection<TransferItem> getByItemid(Item item);
}

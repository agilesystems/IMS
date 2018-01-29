/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.repository;

import com.agile.ims.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Muhammad
 */
@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {

}

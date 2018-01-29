/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.service;

import com.agile.ims.entity.InvoiceItem;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muhammad
 */
@Service
public interface InvoiceitemService {

    /**
     * this method to add new Or update Current of the invoice item , this
     * method use when make invoice
     *
     * @param invoiceItem to get the data to save in item invoice table
     * @return true if the row added Or False if row not added
     */
    boolean save(InvoiceItem invoiceItem);

    /**
     * This method for soft deleted the invoice items , just update the deleted
     * field with value(1
     *
     * @param invoiceitem 
     * @return true if the update successfully Or false if not updated
     */
    boolean delete(InvoiceItem invoiceitem);

    /**
     * this method to calculate the total of invoice item (quantity * price )
     *
     * @param invoiceitem to get the invoice item to calculate the total of
     * invoice item
     */
    void itemtotal(InvoiceItem invoiceitem);

    /**
     * this method to calculate the discount per item in invoice item
     *
     * @param invoiceitem an object parameter to get the invoice item data to
     * calculate the total per item
     */
    void itemdiscount(InvoiceItem invoiceitem);

    /**
     * this method to calculate the net value of item after the calculate the
     * discount net value = item total - item discount
     *
     * @param invoiceitem An object parameter to get the data o item to
     * calculate the net value
     */
    void itemnetvalue(InvoiceItem invoiceitem);
}

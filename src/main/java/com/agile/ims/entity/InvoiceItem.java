/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muhammad
 */
@Entity
@Table(catalog = "inventory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceItem.findAll", query = "SELECT i FROM InvoiceItem i")
    , @NamedQuery(name = "InvoiceItem.findById", query = "SELECT i FROM InvoiceItem i WHERE i.id = :id")
    , @NamedQuery(name = "InvoiceItem.findByQuantity", query = "SELECT i FROM InvoiceItem i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "InvoiceItem.findByPrice", query = "SELECT i FROM InvoiceItem i WHERE i.price = :price")
    , @NamedQuery(name = "InvoiceItem.findByDiscountpr", query = "SELECT i FROM InvoiceItem i WHERE i.discountpr = :discountpr")
    , @NamedQuery(name = "InvoiceItem.findByDiscountvalue", query = "SELECT i FROM InvoiceItem i WHERE i.discountvalue = :discountvalue")
    , @NamedQuery(name = "InvoiceItem.findByTotal", query = "SELECT i FROM InvoiceItem i WHERE i.total = :total")})
public class InvoiceItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float price;
    private Integer discountpr;
    private Float discountvalue;
    private Float total;
    @JoinColumn(name = "invoiceid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Invoice invoiceid;
    @JoinColumn(name = "itemid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Item itemid;

    public InvoiceItem() {
    }

    public InvoiceItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getDiscountpr() {
        return discountpr;
    }

    public void setDiscountpr(Integer discountpr) {
        this.discountpr = discountpr;
    }

    public Float getDiscountvalue() {
        return discountvalue;
    }

    public void setDiscountvalue(Float discountvalue) {
        this.discountvalue = discountvalue;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Invoice getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Invoice invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Item getItemid() {
        return itemid;
    }

    public void setItemid(Item itemid) {
        this.itemid = itemid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceItem)) {
            return false;
        }
        InvoiceItem other = (InvoiceItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Invoiceitem[ id=" + id + " ]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ramy
 */
@Entity
@Table(name = "lookup")
@NamedQueries({
    @NamedQuery(name = "Lookup.findAll", query = "SELECT l FROM Lookup l")})
public class Lookup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "parent")
    private Integer parent;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "unitid")
    private Collection<Item> itemCollection;
    @OneToMany(mappedBy = "groupid")
    private Collection<Item> itemCollection1;
    @OneToMany(mappedBy = "typeid")
    private Collection<Invoice> invoiceCollection;
    @OneToMany(mappedBy = "cachtype")
    private Collection<Invoice> invoiceCollection1;
    @OneToMany(mappedBy = "typeid")
    private Collection<Account> accountCollection;
    @OneToMany(mappedBy = "typeid")
    private Collection<Transaction> transactionCollection;

    public Lookup() {
    }

    public Lookup(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Item> getItemCollection() {
        return itemCollection;
    }

    public void setItemCollection(Collection<Item> itemCollection) {
        this.itemCollection = itemCollection;
    }

    public Collection<Item> getItemCollection1() {
        return itemCollection1;
    }

    public void setItemCollection1(Collection<Item> itemCollection1) {
        this.itemCollection1 = itemCollection1;
    }

    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    public Collection<Invoice> getInvoiceCollection1() {
        return invoiceCollection1;
    }

    public void setInvoiceCollection1(Collection<Invoice> invoiceCollection1) {
        this.invoiceCollection1 = invoiceCollection1;
    }

    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    public Collection<Transaction> getTransactionCollection() {
        return transactionCollection;
    }

    public void setTransactionCollection(Collection<Transaction> transactionCollection) {
        this.transactionCollection = transactionCollection;
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
        if (!(object instanceof Lookup)) {
            return false;
        }
        Lookup other = (Lookup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Lookup[ id=" + id + " ]";
    }
    
}

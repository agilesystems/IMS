/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ramy
 */
@Entity
@Table(name = "transaction")
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "invoiceid")
    private Integer invoiceid;
    @Column(name = "transactiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactiondate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "value")
    private Float value;
    @Column(name = "valuetype")
    private Integer valuetype;
    @Size(max = 255)
    @Column(name = " note")
    private String note;
    @Column(name = "createdat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    @Column(name = "updatedby")
    private Integer updatedby;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "deletedby")
    private Integer deletedby;
    @JoinColumn(name = "typeid", referencedColumnName = "id")
    @ManyToOne
    private Lookup typeid;
    @JoinColumn(name = "accountid", referencedColumnName = "id")
    @ManyToOne
    private Account accountid;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne
    private User createdby;

    public Transaction() {
    }

    public Transaction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(Integer invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Integer getValuetype() {
        return valuetype;
    }

    public void setValuetype(Integer valuetype) {
        this.valuetype = valuetype;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Integer getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(Integer updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getDeletedby() {
        return deletedby;
    }

    public void setDeletedby(Integer deletedby) {
        this.deletedby = deletedby;
    }

    public Lookup getTypeid() {
        return typeid;
    }

    public void setTypeid(Lookup typeid) {
        this.typeid = typeid;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    public User getCreatedby() {
        return createdby;
    }

    public void setCreatedby(User createdby) {
        this.createdby = createdby;
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
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Transaction[ id=" + id + " ]";
    }
    
}

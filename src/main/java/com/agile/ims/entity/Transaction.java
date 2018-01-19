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
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Muhammad
 */
@Entity
@Table(catalog = "inventory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")
    , @NamedQuery(name = "Transaction.findById", query = "SELECT t FROM Transaction t WHERE t.id = :id")
    , @NamedQuery(name = "Transaction.findByInvoiceid", query = "SELECT t FROM Transaction t WHERE t.invoiceid = :invoiceid")
    , @NamedQuery(name = "Transaction.findByTransactiondate", query = "SELECT t FROM Transaction t WHERE t.transactiondate = :transactiondate")
    , @NamedQuery(name = "Transaction.findByValue", query = "SELECT t FROM Transaction t WHERE t.value = :value")
    , @NamedQuery(name = "Transaction.findByValuetype", query = "SELECT t FROM Transaction t WHERE t.valuetype = :valuetype")
    , @NamedQuery(name = "Transaction.findByNote", query = "SELECT t FROM Transaction t WHERE t.note = :note")
    , @NamedQuery(name = "Transaction.findByCreatedat", query = "SELECT t FROM Transaction t WHERE t.createdat = :createdat")
    , @NamedQuery(name = "Transaction.findByUpdatedby", query = "SELECT t FROM Transaction t WHERE t.updatedby = :updatedby")
    , @NamedQuery(name = "Transaction.findByUpdatedat", query = "SELECT t FROM Transaction t WHERE t.updatedat = :updatedat")
    , @NamedQuery(name = "Transaction.findByDeleted", query = "SELECT t FROM Transaction t WHERE t.deleted = :deleted")
    , @NamedQuery(name = "Transaction.findByDeletedby", query = "SELECT t FROM Transaction t WHERE t.deletedby = :deletedby")})
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    private Integer invoiceid;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactiondate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float value;
    private Integer valuetype;
    @Size(max = 255)
    @Column(name = " note")
    private String note;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdat;
    private Integer updatedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    private Boolean deleted;
    private Integer deletedby;
    @JoinColumn(name = "typeid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lookup typeid;
    @JoinColumn(name = "accountid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Account accountid;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
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

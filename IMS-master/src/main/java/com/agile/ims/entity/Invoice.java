/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agile.ims.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ramy
 */
@Entity
@Table(name = "invoice")
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "refrence")
    private String refrence;
    @Column(name = "transactiondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactiondate;
    @Column(name = "discountper")
    private Integer discountper;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "discountvalue")
    private Float discountvalue;
    @Column(name = "tax1per")
    private Integer tax1per;
    @Column(name = "tax1val")
    private Float tax1val;
    @Column(name = "tax2per")
    private Integer tax2per;
    @Column(name = "tax2val")
    private Float tax2val;
    @Column(name = "tax3per")
    private Integer tax3per;
    @Column(name = "tax3val")
    private Float tax3val;
    @Column(name = "total")
    private Float total;
    @Column(name = "paied")
    private Float paied;
    @Column(name = "net")
    private Float net;
    @Column(name = "outstanding")
    private Float outstanding;
    @Column(name = "createdat")
    @Temporal(TemporalType.DATE)
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
    @OneToMany(mappedBy = "invoiceid")
    private Collection<InvoiceItem> invoiceItemCollection;
    @JoinColumn(name = "storeid", referencedColumnName = "id")
    @ManyToOne
    private Store storeid;
    @JoinColumn(name = "accountid", referencedColumnName = "id")
    @ManyToOne
    private Account accountid;
    @JoinColumn(name = "typeid", referencedColumnName = "id")
    @ManyToOne
    private Lookup typeid;
    @JoinColumn(name = "cachtype", referencedColumnName = "id")
    @ManyToOne
    private Lookup cachtype;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne
    private User createdby;

    public Invoice() {
    }

    public Invoice(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRefrence() {
        return refrence;
    }

    public void setRefrence(String refrence) {
        this.refrence = refrence;
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public Integer getDiscountper() {
        return discountper;
    }

    public void setDiscountper(Integer discountper) {
        this.discountper = discountper;
    }

    public Float getDiscountvalue() {
        return discountvalue;
    }

    public void setDiscountvalue(Float discountvalue) {
        this.discountvalue = discountvalue;
    }

    public Integer getTax1per() {
        return tax1per;
    }

    public void setTax1per(Integer tax1per) {
        this.tax1per = tax1per;
    }

    public Float getTax1val() {
        return tax1val;
    }

    public void setTax1val(Float tax1val) {
        this.tax1val = tax1val;
    }

    public Integer getTax2per() {
        return tax2per;
    }

    public void setTax2per(Integer tax2per) {
        this.tax2per = tax2per;
    }

    public Float getTax2val() {
        return tax2val;
    }

    public void setTax2val(Float tax2val) {
        this.tax2val = tax2val;
    }

    public Integer getTax3per() {
        return tax3per;
    }

    public void setTax3per(Integer tax3per) {
        this.tax3per = tax3per;
    }

    public Float getTax3val() {
        return tax3val;
    }

    public void setTax3val(Float tax3val) {
        this.tax3val = tax3val;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getPaied() {
        return paied;
    }

    public void setPaied(Float paied) {
        this.paied = paied;
    }

    public Float getNet() {
        return net;
    }

    public void setNet(Float net) {
        this.net = net;
    }

    public Float getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(Float outstanding) {
        this.outstanding = outstanding;
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

    public Collection<InvoiceItem> getInvoiceItemCollection() {
        return invoiceItemCollection;
    }

    public void setInvoiceItemCollection(Collection<InvoiceItem> invoiceItemCollection) {
        this.invoiceItemCollection = invoiceItemCollection;
    }

    public Store getStoreid() {
        return storeid;
    }

    public void setStoreid(Store storeid) {
        this.storeid = storeid;
    }

    public Account getAccountid() {
        return accountid;
    }

    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    public Lookup getTypeid() {
        return typeid;
    }

    public void setTypeid(Lookup typeid) {
        this.typeid = typeid;
    }

    public Lookup getCachtype() {
        return cachtype;
    }

    public void setCachtype(Lookup cachtype) {
        this.cachtype = cachtype;
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
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.agile.ims.entity.Invoice[ id=" + id + " ]";
    }
    
}

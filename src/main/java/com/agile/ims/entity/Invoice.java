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
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Muhammad
 */
@Entity
@Table(catalog = "inventory", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invoice.findAll", query = "SELECT i FROM Invoice i")
    , @NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id")
    , @NamedQuery(name = "Invoice.findByRefrence", query = "SELECT i FROM Invoice i WHERE i.refrence = :refrence")
    , @NamedQuery(name = "Invoice.findByTransactiondate", query = "SELECT i FROM Invoice i WHERE i.transactiondate = :transactiondate")
    , @NamedQuery(name = "Invoice.findByDiscountper", query = "SELECT i FROM Invoice i WHERE i.discountper = :discountper")
    , @NamedQuery(name = "Invoice.findByDiscountvalue", query = "SELECT i FROM Invoice i WHERE i.discountvalue = :discountvalue")
    , @NamedQuery(name = "Invoice.findByTax1per", query = "SELECT i FROM Invoice i WHERE i.tax1per = :tax1per")
    , @NamedQuery(name = "Invoice.findByTax1val", query = "SELECT i FROM Invoice i WHERE i.tax1val = :tax1val")
    , @NamedQuery(name = "Invoice.findByTax2per", query = "SELECT i FROM Invoice i WHERE i.tax2per = :tax2per")
    , @NamedQuery(name = "Invoice.findByTax2val", query = "SELECT i FROM Invoice i WHERE i.tax2val = :tax2val")
    , @NamedQuery(name = "Invoice.findByTax3per", query = "SELECT i FROM Invoice i WHERE i.tax3per = :tax3per")
    , @NamedQuery(name = "Invoice.findByTax3val", query = "SELECT i FROM Invoice i WHERE i.tax3val = :tax3val")
    , @NamedQuery(name = "Invoice.findByTotal", query = "SELECT i FROM Invoice i WHERE i.total = :total")
    , @NamedQuery(name = "Invoice.findByPaied", query = "SELECT i FROM Invoice i WHERE i.paied = :paied")
    , @NamedQuery(name = "Invoice.findByNet", query = "SELECT i FROM Invoice i WHERE i.net = :net")
    , @NamedQuery(name = "Invoice.findByOutstanding", query = "SELECT i FROM Invoice i WHERE i.outstanding = :outstanding")
    , @NamedQuery(name = "Invoice.findByCreatedat", query = "SELECT i FROM Invoice i WHERE i.createdat = :createdat")
    , @NamedQuery(name = "Invoice.findByUpdatedby", query = "SELECT i FROM Invoice i WHERE i.updatedby = :updatedby")
    , @NamedQuery(name = "Invoice.findByUpdatedat", query = "SELECT i FROM Invoice i WHERE i.updatedat = :updatedat")
    , @NamedQuery(name = "Invoice.findByDeleted", query = "SELECT i FROM Invoice i WHERE i.deleted = :deleted")
    , @NamedQuery(name = "Invoice.findByDeletedby", query = "SELECT i FROM Invoice i WHERE i.deletedby = :deletedby")})
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Size(max = 255)
    private String refrence;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactiondate;
    private Integer discountper;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Float discountvalue;
    private Integer tax1per;
    private Float tax1val;
    private Integer tax2per;
    private Float tax2val;
    private Integer tax3per;
    private Float tax3val;
    private Float total;
    private Float paied;
    private Float net;
    private Float outstanding;
    @Temporal(TemporalType.DATE)
    private Date createdat;
    private Integer updatedby;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    private Boolean deleted;
    private Integer deletedby;
    @OneToMany(mappedBy = "invoiceid", fetch = FetchType.EAGER)
    private Collection<Invoiceitem> invoiceitemCollection;
    @JoinColumn(name = "storeid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Store storeid;
    @JoinColumn(name = "accountid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Account accountid;
    @JoinColumn(name = "typeid", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lookup typeid;
    @JoinColumn(name = "cachtype", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lookup cachtype;
    @JoinColumn(name = "createdby", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
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

    @XmlTransient
    public Collection<Invoiceitem> getInvoiceitemCollection() {
        return invoiceitemCollection;
    }

    public void setInvoiceitemCollection(Collection<Invoiceitem> invoiceitemCollection) {
        this.invoiceitemCollection = invoiceitemCollection;
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

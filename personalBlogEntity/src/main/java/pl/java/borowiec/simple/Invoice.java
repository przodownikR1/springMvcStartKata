package pl.java.borowiec.simple;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@XmlRootElement(name = "invoice")
@Entity   //wymagane przez hibernate           // Entity POJO
@Table(name="simple_invoice")
public class Invoice extends AbstactId implements Serializable{  // POJO
   
    private static final long serialVersionUID = -7305875286472112192L;
   
    
    @Column(name="invoice_name",nullable=false)
    private String name;
    
    private boolean payed;
    
    @Past
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date creataDate ;
    
    @Future
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date payDate;
    
    @Size(min=3,max=20)
    private String user;
    
    @Transient //nie wstawia do bazy 
    private String description;
    
    @Min(10)
    @Max(1000)
    @NumberFormat(style=Style.CURRENCY)
    private BigDecimal amount;
    
    @Enumerated(EnumType.STRING)  //wpisuje do bazy w postaci stringa
    @Column(name="invoice_type")
    private InvoiceType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Date getCreataDate() {
        return creataDate;
    }

    public void setCreataDate(Date creataDate) {
        this.creataDate = creataDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public InvoiceType getType() {
        return type;
    }

    public void setType(InvoiceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Invoice [name=" + name + ", payed=" + payed + ", user=" + user + ", description="
                + description + ", amount=" + amount + ", type=" + type + "]";
    }

  
    
    
}


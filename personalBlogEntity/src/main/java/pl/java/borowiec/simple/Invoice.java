package pl.java.borowiec.simple;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@XmlRootElement(name = "invoice")
@Entity   //wymagane przez hibernate           // Entity POJO
@Table(name="simple_invoice")
@Data
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

 
     @ManyToOne(cascade = CascadeType.ALL)
     private Customer customer;
    
}


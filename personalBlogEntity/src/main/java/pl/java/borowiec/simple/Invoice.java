package pl.java.borowiec.simple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import pl.java.borowiec.common.AbstactId;
import pl.java.borowiec.product.Product;
import pl.java.borowiec.xml.DateAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "simple_invoice")
@Data
@EqualsAndHashCode(callSuper = true)
@NamedQueries({ @NamedQuery(name = "Invoice.findByUser", query = "FROM Invoice inv WHERE inv.user = :user ") })
public class Invoice extends AbstactId {

    private static final long serialVersionUID = -7305875286472112192L;

    @XmlElement(name = "invoice_name", required = true)
    @Column(name = "invoice_name", nullable = false)
    private String name;
    
    @XmlElement(name = "paid", required = true)
    private boolean paid;

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "products", required = true)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

    @Past
    @XmlElement(name = "create_date", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creataDate;

    @Future
    @XmlElement(name = "pay_date", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDate;

    @Size(min = 3, max = 20)
    private String user;

    @Transient
    private String description;

    @Min(10)
    @Max(1000)
    @XmlElement(name = "amount", required = true)
    @NumberFormat(style = Style.CURRENCY)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @XmlElement(name = "invoice_customer_type", required = true)
    @Column(name = "invoice_type")
    private InvoiceType type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

}

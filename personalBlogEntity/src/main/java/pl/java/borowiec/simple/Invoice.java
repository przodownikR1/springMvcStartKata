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
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import pl.java.borowiec.common.AbstactId;
import pl.java.borowiec.product.Product;

@XmlRootElement(name = "invoice")
@Entity
@Table(name = "simple_invoice")
@Data
@EqualsAndHashCode(callSuper = true)
@NamedQueries({ @NamedQuery(name = "Invoice.findByUser", query = "FROM Invoice inv WHERE inv.user = :user ") })
public class Invoice extends AbstactId {

    private static final long serialVersionUID = -7305875286472112192L;

    @Column(name = "invoice_name", nullable = false)
    private String name;

    private boolean payed;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creataDate;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date payDate;

    @Size(min = 3, max = 20)
    private String user;

    @Transient
    private String description;

    @Min(10)
    @Max(1000)
    @NumberFormat(style = Style.CURRENCY)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "invoice_type")
    private InvoiceType type;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

}

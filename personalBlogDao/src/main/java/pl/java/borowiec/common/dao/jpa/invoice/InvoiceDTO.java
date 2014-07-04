package pl.java.borowiec.common.dao.jpa.invoice;

import lombok.Data;
@Data

public class InvoiceDTO {
  
    private long productCount;
    private String user;
    
    public InvoiceDTO(){}
    
    public InvoiceDTO(long productCount, String user) {
        super();
        this.productCount = productCount;
        this.user = user;
    }
    
    
}

package pl.java.borowiec.controller.invoice;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import pl.java.borowiec.service.invoce.InvoiceService;
import pl.java.borowiec.simple.Invoice;
import pl.java.borowiec.tools.InvoiceGenerator;
import pl.java.borowiec.validator.InvoiceValidator;

@Controller
@RequestMapping("/invoice")
@Slf4j
public class InvoiceController {
    private final static String INVOICE = "invoice";
    private final static String INVOICE_NEW = "invoiceNew";

    private final InvoiceService invoiceService;

    private final InvoiceValidator invoiceValidator;
    
    private void createInvoice(InvoiceService invoiceService){
        InvoiceGenerator.generate().forEach(invoice -> invoiceService.save(invoice)); 
    }
   
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,"creataDate", new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Date.class,"payDate", new CustomDateEditor(dateFormat, true));
        //binder.setValidator(invoiceValidator);
    }
    
    @Autowired
    public InvoiceController(InvoiceService invoiceService,InvoiceValidator invoiceValidator){
        log.info("===========================================================================");
        this.invoiceService = invoiceService;
        this.invoiceValidator = invoiceValidator;
        invoiceService.deleteAll(); //double invoking
        createInvoice(invoiceService);
    }
    
    
    
    @RequestMapping(value="/edit/{id}",method = RequestMethod.GET)  //klik na zasob URL
    public String edit(@PathVariable("id") Long id, Model model){
        model.addAttribute(INVOICE, invoiceService.findById(id));
        return INVOICE_NEW;
    }
  
    
    
    
    
    @RequestMapping(method = RequestMethod.GET)  //klik na zasob URL
    public String init(Model model){
        model.addAttribute(INVOICE, new Invoice());
        return INVOICE_NEW;
    }
    
    //valid wlaczenie walidacji , result - wynik wewnetrzny walidacji  //po submit
    @RequestMapping(value={"","/edit/{id}"},method = RequestMethod.POST)
    public String create(@Valid Invoice invoice, BindingResult result,Errors errors) {
        log.info("+++  invoice save :  {}",invoice);
        invoiceValidator.validate(invoice, errors);
        if (result.hasErrors()) {

            log.info("+++  invoice error  {}",result);
            return INVOICE_NEW;
        }
       
        invoiceService.save(invoice);
        return "redirect:/invoice/all";
    }
    
   
    
    @RequestMapping(value="/displayHeaderInfo")
    @ResponseBody
    public String displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("Accept-Language") String language) {
         return  encoding + " ,  " + language;
    }
    
    //produces = format w jakim bedziemy serworac tresc
    @RequestMapping(value="/json",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody //wymagane jak chcemy pominac viewResolver i bezposrednio wyswietlac zawartosc
    public List<Invoice> getInvoicesAsJson(){
        return invoiceService.getList();
    }
    
    //produces = format w jakim bedziemy serworac tresc
    @RequestMapping(value="/xml",produces=MediaType.APPLICATION_XML_VALUE)
    @ResponseBody //wymagane jak chcemy pominac viewResolver i bezposrednio wyswietlac zawartosc
    public List<Invoice> getInvoicesAsXml(){
        return invoiceService.getList();
    }
    
        
    @RequestMapping("/all")
    public String get(Model model,Locale locale , WebRequest webRequest){
        model.addAttribute("invoices", invoiceService.getList());
        return INVOICE;
    }
    
    
    
}

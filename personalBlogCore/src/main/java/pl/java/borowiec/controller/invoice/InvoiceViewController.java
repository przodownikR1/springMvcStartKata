package pl.java.borowiec.controller.invoice;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.java.borowiec.service.invoce.InvoiceService;
import pl.java.borowiec.simple.Invoice;
import pl.java.borowiec.view.InvoiceAtomView;
import pl.java.borowiec.view.InvoiceRssView;



@Controller
@RequestMapping("/invoiceInfo")
@Slf4j
public class InvoiceViewController {
    
    @Autowired
    private InvoiceService invoiceService;
    
    @RequestMapping("/atomfeed")
    public ModelAndView getAtomFeed(Model model) {
        List<Invoice> invoices = invoiceService.getList();
        model.addAttribute("invoices", invoices);
        return new ModelAndView(new InvoiceAtomView(), model.asMap());
    }

    @RequestMapping("/rssfeed")
    public ModelAndView getRSSFeed(Model model) {
        List<Invoice> invoices = invoiceService.getList();
        model.addAttribute("invoices", invoices);
        return new ModelAndView(new InvoiceRssView(), model.asMap());
    }
    
}
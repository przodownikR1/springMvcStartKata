package pl.java.JCodeLeader.core.contollers.experimental.faktura;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.java.JCodeLeader.core.contollers.basic.BaseController;
import pl.java.JCodeLeader.core.contollers.basic.dto.LabelValue;
import pl.java.JCodeLeader.core.services.experimental.faktura.FakturaService;
import pl.java.JCodeLeader.experimental.evners.Faktura;
import pl.java.JCodeLeader.experimental.types.ChooseTest;


@Controller
@RequestMapping("/faktura")
@SessionAttributes(value="faktura")
public class FakturaController extends BaseController {
	private final static Logger logger = Logger.getLogger(FakturaController.class);
	private final static String VIEW_NAME = "fakturaView";
	private final static String VIEW_NAME_UPDATE = "fakturaUpdateView";
	@Autowired
	private FakturaService fakturaService;
 
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Boolean.class,"mustBeTrue", new CustomBooleanEditor(true));
		binder.registerCustomEditor(BigDecimal.class, "amount", new CustomNumberEditor(BigDecimal.class, true));
		
	}
	
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView getCreateForm(Model model, HttpServletRequest request) {
		model.addAttribute("faktura",new Faktura());
		model.addAttribute("title","insert");
		return new ModelAndView(VIEW_NAME_UPDATE,model.asMap());
	}

	@RequestMapping(value = "/{fakturaId}", method={RequestMethod.GET})
	public ModelAndView getHandle(@PathVariable Long fakturaId, Model model) {
		Assert.notNull(fakturaId);
		Faktura faktura = null;
		if (fakturaId != null) {
			faktura = fakturaService.getFakturaById(fakturaId);
		} else {
			faktura = new Faktura();
		}
		model.addAttribute("faktura", faktura);
		return new ModelAndView(VIEW_NAME_UPDATE,model.asMap());
	}
	
	

	@RequestMapping(value  = "/{fakturaId}",method = RequestMethod.POST)
	public ModelAndView updateMesssage(@ModelAttribute("faktura")@Valid Faktura faktura, BindingResult result, SessionStatus status, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("faktura", faktura);
			return new ModelAndView(VIEW_NAME_UPDATE, model.asMap());
		}
		fakturaService.mergeFaktura(faktura);
		status.setComplete();
		return new ModelAndView("redirect:/faktura/all");
	}
	
	
	@RequestMapping(value  = "/",method = RequestMethod.POST)
	public ModelAndView updateFaktura(@ModelAttribute("faktura") @Valid Faktura faktura, BindingResult result, SessionStatus status, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			model.addAttribute("faktura", faktura);
			return new ModelAndView(VIEW_NAME_UPDATE,model.asMap());
		}
		fakturaService.mergeFaktura(faktura);
		status.setComplete();
		return new ModelAndView("redirect:/faktura/all");
	}

	
	@RequestMapping("/response")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) {
	String requestHeader = requestEntity.getHeaders().getFirst("ETag");
	byte[] requestBody = requestEntity.getBody();
	
	HttpHeaders responseHeaders = new HttpHeaders();
	
	responseHeaders.set("ETag", requestHeader);
	return new ResponseEntity<String>("slawek test ", responseHeaders,
	HttpStatus.CREATED);
	}


	@RequestMapping("/jpg")
	public ResponseEntity<byte[]> handleByte(HttpEntity<byte[]> requestEntity) throws IOException {

	File file = new File("/home/programmer/1.jpg");
	FileInputStream fin = new FileInputStream(file);
	 
     byte fileContent[] = new byte[(int)file.length()];
     
       fin.read(fileContent);
	HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.setContentType( MediaType.IMAGE_JPEG );
    responseHeaders.setContentLength( fileContent.length );

    return new ResponseEntity< byte[] >( fileContent, 
        responseHeaders, HttpStatus.OK );

	}
	
    @RequestMapping(value="/all",method=RequestMethod.GET)
	public ModelAndView showAll(Model model, HttpServletRequest request){
		model.addAttribute("title", "showAll");
		model.addAttribute("faktury", fakturaService.getAll());
		model.addAttribute("count", fakturaService.getAll().size());	
		return new ModelAndView(VIEW_NAME,model.asMap());
	}
	
    @ModelAttribute("userRoles")
	public Collection<String> chooseList() {
		List<String> userRoles = Arrays.asList(new String[]{"USER","ADMIN","BUSINESS"});
		return userRoles;
	}
	
      
    @ModelAttribute("operations")
    public List<LabelValue<String, String>> operations(HttpServletRequest request){
        return getLabelValues(request,ChooseTest.class);
    }
}

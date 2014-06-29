package pl.java.borowiec.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  11-04-2013 23:00:52
 
 */
@Controller
@RequestMapping("/admin")
public class MainController {
	static final Logger logger = LoggerFactory.getLogger(MainController.class);
	//@Resource(name = "sessionRegistry")
	private SessionRegistryImpl sessionRegistry;
	@RequestMapping(value = "/usersInfo", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
     logger.debug("Received request to show users page");
     logger.debug("Total logged-in users: " + sessionRegistry.getAllPrincipals().size());
     logger.debug("List of logged-in users: ");
     for (Object username: sessionRegistry.getAllPrincipals()) {
      logger.debug(username.toString());
     }
     if(!sessionRegistry.getAllPrincipals().isEmpty()){
      logger.debug("Total sessions including expired ones: " + sessionRegistry.getAllSessions(sessionRegistry.getAllPrincipals().get(0), true).size());
      logger.debug("Total sessions: " + sessionRegistry.getAllSessions(sessionRegistry.getAllPrincipals().get(0), false).size());
     }

     model.addAttribute("users", sessionRegistry.getAllPrincipals());
     model.addAttribute("total", sessionRegistry.getAllPrincipals().size());
     return "/admin/usersInfo";
 }

	@RequestMapping(value = "/activateUsers", method = RequestMethod.GET)
	public @ResponseBody String getActivateList(Model model) {
		Map<Object, Date> lastActivityDates = new HashMap<Object, Date>();
		for (Object principal : sessionRegistry.getAllPrincipals()) {
			for (SessionInformation session : sessionRegistry.getAllSessions(principal, false)) {
				  
				if (lastActivityDates.get(principal) == null) {
					lastActivityDates.put(principal, session.getLastRequest());
				} else {
					Date prevLastRequest = lastActivityDates.get(principal);
					if (session.getLastRequest().after(prevLastRequest)) {
					
						lastActivityDates.put(principal, session.getLastRequest());
					}
				}
			}

			model.addAttribute("activeUsers", lastActivityDates);
			
		}
		return model.asMap().toString();
	}


}
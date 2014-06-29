package org.java.controller.car;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class XmlReceiverController {

	@RequestMapping(value = "/xmlPostReceiver",method = RequestMethod.POST)
	public @ResponseBody
	String getHandlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		InputStreamReader isr = new InputStreamReader(request.getInputStream(), "UTF-8");
		StringWriter writer = new StringWriter();
		IOUtils.copy(isr, writer);
		String theString = writer.toString();
		log.info("RESULT :  {}",  theString);
		return theString;
	}

}

package pl.java.borowiec.controller.photo;

import java.io.File;
import java.io.IOException;
import java.security.Principal;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.java.borowiec.service.user.UserService;
import pl.java.borowiec.user.User;


/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  11-04-2013 17:04:49
 
 */
@Controller
@RequestMapping("/photo")
public class ServerPhotoController {
	private static final Logger logger = LoggerFactory.getLogger(ServerPhotoController.class);
	@Resource
	private org.springframework.core.io.Resource anonymousImg;
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/{login}", method = RequestMethod.GET,headers = "Accept=image/jpeg, image/jpg, image/png, image/gif")
	public @ResponseBody
	byte[] getPhoto(@PathVariable("login") String login, Principal principal) throws IllegalAccessException, IOException {
	//	User user =userService.getUserByLogin(login);
		logger.info("Serve {} photo ", login);

		byte[] userPhotoBytes =null;// user.getPhoto();

		if (userPhotoBytes == null) {
			userPhotoBytes = new byte[(int) anonymousImg.contentLength()];
			anonymousImg.getInputStream().read(userPhotoBytes);
		}

		return userPhotoBytes;
	}

	@RequestMapping(value = "/temp/{fileName}/{ext}", method = RequestMethod.GET)
	public @ResponseBody
	byte[] getTempPhoto(@PathVariable("fileName") String fileName, @PathVariable("ext") String extension, Principal principal) throws IllegalAccessException,
			IOException {
		// 'jpeg', 'jpg', 'gif', 'png'
		if (!(extension.toLowerCase().trim().equals("jpeg") || extension.toLowerCase().trim().equals("jpg") || extension.toLowerCase().trim().equals("gif") || extension
				.toLowerCase().trim().equals("png"))) {
			return null;
		}
		String tmpDir = System.getProperty("java.io.tmpdir");
		if (!tmpDir.endsWith("//")) {
			tmpDir += "//";
		}
		File tempFile = new File(tmpDir + fileName + "." + extension);
		return FileUtils.readFileToByteArray(tempFile);
	}
}

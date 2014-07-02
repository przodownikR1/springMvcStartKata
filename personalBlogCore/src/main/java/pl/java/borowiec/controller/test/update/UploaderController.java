package pl.java.borowiec.controller.test.update;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pl.java.borowiec.tools.PictureTool;

/**
 * @author Sławomir Borowiec 
 * Module name : personalBlogCore
 * Creating time :  13-04-2013 13:08:59
 
 */
@Controller
@RequestMapping("/upload")
public class UploaderController  {
	static final Logger LOGGER = LoggerFactory.getLogger(UploaderController.class);
	private final static String VIEW_NAME = "uploadView";

	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public ModelAndView getCreateForm(Model model) {
         model.addAttribute("upload", new UploadItem()); 
		return new ModelAndView(VIEW_NAME, model.asMap());
	}

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("upload")UploadItem uploadItem,Model model, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (bindingResult.hasErrors()) {
			return VIEW_NAME;
		}

		try {
			if (!uploadItem.getFile().isEmpty()) {
				 validateImage(uploadItem.getFile());
				 saveCardImage(uploadItem.getFile(),"./src/main/webapp/images/");
				 
				// sendBinaryStream(response, uploadItem.getFile().getBytes());
			}
		} catch (ImageUploadException e) {
			bindingResult.reject(e.getMessage());
			return VIEW_NAME;
		}
		model.addAttribute("successful", true);
		return VIEW_NAME;
	}

	
	private void saveCardImage(MultipartFile image , String path) throws IOException {
		String fileName = image.getName();
		PictureTool.transformBytesToPicture(fileName, image.getBytes(), path, PictureTool.widths, PictureTool.DEFAULT_FORMAT);
	}
	
	private void saveImage(MultipartFile image) throws ImageUploadException {
		try {
			File file = new File("" + "/resources/" + image.getName());
		    FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			throw new ImageUploadException("Unable to save image", e);
		}
	}
	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/png")) {
			throw new ImageUploadException("Only JPG images accepted");
		}
	}
}

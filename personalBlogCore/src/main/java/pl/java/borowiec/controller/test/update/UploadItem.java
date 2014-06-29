package pl.java.borowiec.controller.test.update;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 12:55:01
 */
public class UploadItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1499100972120704386L;
	private String name;
	private String type;
	private MultipartFile file;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}

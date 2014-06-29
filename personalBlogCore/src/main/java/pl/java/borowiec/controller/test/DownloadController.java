package pl.java.borowiec.controller.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 13-04-2013 13:24:39
 */
@Controller
@RequestMapping("download")
public class DownloadController {
	static final Logger LOGGER = LoggerFactory.getLogger(DownloadController.class);
	@Resource
	private org.springframework.core.io.Resource anonymousImg;

	@RequestMapping(value = "/{fileName}", method = RequestMethod.GET)
	public void download(@PathVariable("fileName") String fileName, HttpServletResponse response, HttpServletRequest request) throws IOException {
		try {
			download(response, fileName, IOUtils.toByteArray(anonymousImg.getInputStream()));
		} catch (Exception ex) {
			LOGGER.error("{}", ex);

		}
	}

	private void download(HttpServletResponse resp, String fileName, byte[] data) {
		try {
			fileName = URLEncoder.encode(fileName, "utf-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Encode FileName Error:" + e.getMessage());
		}

		String content = "attachment; filename=" + fileName;
		resp.addHeader("Content-Disposition", content);
		resp.setCharacterEncoding("utf-8");
		ByteArrayInputStream stream = new ByteArrayInputStream(data);
		sendBinaryStream(resp, "application/octet-stream", stream);
	}

	private void sendBinaryStream(HttpServletResponse resp, String contentType, InputStream data) {
		try {
			resp.setContentType(contentType);
			int length = FileCopyUtils.copy(data, resp.getOutputStream());
			resp.setContentLength(length);
		} catch (IOException e) {
			LOGGER.error("BinaryStream：" + e.getLocalizedMessage());
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("", e);
			}
		}
	}

	@RequestMapping(value = "/csv", method = RequestMethod.GET)
	public void generateCSV(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 400; i++) {
			sb.append(i).append("|");
		}
		generateCSVFile(response, "test.csv", sb.toString());

	}

	private void generateCSVFile(HttpServletResponse response, String fileName, String contentReport) throws IOException {
		response.addHeader("content-disposition", "attachment; filename=\"" + fileName + "\"");
		response.setContentType("text/csv");
		response.getWriter().write(contentReport);
		response.getWriter().close();
	}

}

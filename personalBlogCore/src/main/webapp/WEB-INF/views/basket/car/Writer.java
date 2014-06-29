package org.java.controller.car;

import java.io.ByteArrayOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.mchange.util.AssertException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public final class Writer {


	private Writer(){
		throw new AssertException();
	}

	public static void write(HttpServletResponse response, ByteArrayOutputStream bao) {

		log.debug("Writing report to the stream");
		try {

			@SuppressWarnings("resource")
			ServletOutputStream outputStream = response.getOutputStream();

			bao.writeTo(outputStream);

			outputStream.flush();

			outputStream.close();

		} catch (Exception e) {
			log.error("Unable to write report to the output stream");
		}
	}

	@SuppressWarnings("resource")
	public static void write(HttpServletResponse response, byte[] byteArray) {

		log.debug("Writing report to the stream");
		try {

			ServletOutputStream outputStream = response.getOutputStream();

			outputStream.write(byteArray);

			outputStream.flush();

			outputStream.close();

		} catch (Exception e) {
			log.error("Unable to write report to the output stream");
		}
	}
}

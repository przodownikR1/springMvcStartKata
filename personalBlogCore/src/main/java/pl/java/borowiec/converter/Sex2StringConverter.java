package pl.java.borowiec.converter;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.core.convert.converter.Converter;

import pl.java.borowiec.types.Sex;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 09-04-2013 08:33:22
 */
public class Sex2StringConverter implements Converter<Sex, String> {

	@Resource
	private MessageSource messageSource;

	@Override
	public String convert(Sex source) {
		return messageSource.getMessage(source.name(), null, Locale.getDefault());
	}

}

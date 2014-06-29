package pl.java.borowiec.converter;

import org.springframework.core.convert.converter.Converter;

import pl.java.borowiec.types.Sex;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogCore
 *         Creating time : 09-04-2013 08:32:53
 */
public class String2SexConverter implements Converter<String, Sex> {

	@Override
	public Sex convert(String source) {
		if (Sex.FEMALE.name().equals(source))
			return Sex.FEMALE;
		return Sex.MALE;
	}

}

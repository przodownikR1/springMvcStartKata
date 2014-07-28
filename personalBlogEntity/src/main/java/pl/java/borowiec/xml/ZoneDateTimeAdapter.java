package pl.java.borowiec.xml;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ZoneDateTimeAdapter extends XmlAdapter<String, ZonedDateTime> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);

    @Override
    public ZonedDateTime unmarshal(String v) throws Exception {
	return ZonedDateTime.parse(v, formatter);
    }

    @Override
    public String marshal(ZonedDateTime v) throws Exception {
	return v.format(formatter);
    }
}
package no.nav.os.eskatt.eskattekortbestilling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeAdapter extends XmlAdapter<String,LocalDateTime> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalDateTimeAdapter.class);

    @Override
    public LocalDateTime unmarshal(String localDateTimeAsString) {
        try {
            return LocalDateTime.parse(localDateTimeAsString, DateTimeFormatter.ISO_DATE_TIME);
        } catch (DateTimeParseException e) {
            LOGGER.error("Parsing av dato '{}' feilet!", localDateTimeAsString);
            return null;
        }
    }

    @Override
    public String marshal(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.format(DateTimeFormatter.ISO_DATE_TIME) : null;
    }
}
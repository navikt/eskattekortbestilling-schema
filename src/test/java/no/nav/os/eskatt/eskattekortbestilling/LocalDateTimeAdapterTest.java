package no.nav.os.eskatt.eskattekortbestilling;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class LocalDateTimeAdapterTest {

    private LocalDateTimeAdapter adapter = new LocalDateTimeAdapter();

    private static final LocalDateTime DATE = LocalDateTime.of(2017, 1, 1, 12, 15, 30);
    private static final String DATE_AS_STRING = "2017-01-01T12:15:30";

    @Test
    public void skalKonvertereTilLocalDateTime() {
        LocalDateTime unmarshal = adapter.unmarshal(DATE_AS_STRING);
        Assert.assertThat(unmarshal, CoreMatchers.equalTo(DATE));
    }

    @Test
    public void skalReturnereNullVedUgyldigDato() {
        LocalDateTime time = adapter.unmarshal("IKKE_GYLDIG");
        Assert.assertNull(time);
    }

    @Test
    public void skalKonvertereTilString() {
        String marshal = adapter.marshal(DATE);
        Assert.assertThat(marshal, CoreMatchers.equalTo(DATE_AS_STRING));
    }

}
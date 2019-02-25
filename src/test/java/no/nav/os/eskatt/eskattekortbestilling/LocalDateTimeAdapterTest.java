package no.nav.os.eskatt.eskattekortbestilling;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class LocalDateTimeAdapterTest {

    private LocalDateTimeAdapter adapter = new LocalDateTimeAdapter();

    private static final LocalDateTime DATE = LocalDateTime.of(2017, 01, 01, 12, 15, 30);
    private static final String DATE_AS_STRING = "2017-01-01T12:15:30";

    @Test
    public void skalKonvertereTilLocalDateTime() throws Exception {
        LocalDateTime unmarshal = adapter.unmarshal(DATE_AS_STRING);
        Assert.assertThat(unmarshal, CoreMatchers.equalTo(DATE));
    }

    @Test
    public void skalKonvertereTilString() throws Exception {
        String marshal = adapter.marshal(DATE);
        Assert.assertThat(marshal, CoreMatchers.equalTo(DATE_AS_STRING));
    }

}
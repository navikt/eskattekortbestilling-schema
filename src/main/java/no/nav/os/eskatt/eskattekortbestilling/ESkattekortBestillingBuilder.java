package no.nav.os.eskatt.eskattekortbestilling;

import no.nav.eskattekort.bestilling.v1.Applikasjon;
import no.nav.eskattekort.bestilling.v1.ESkattekortBestilling;
import no.nav.eskattekort.bestilling.v1.ObjectFactory;
import no.nav.eskattekort.bestilling.v1.Receipt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ESkattekortBestillingBuilder {
    private Applikasjon bestiller;
    private String inntektsaar;
    private Integer bestillingId;
    private Integer receiptId;
    private String archiveReference;
    private String receiversReference;
    private LocalDateTime datoSendt;
    private List<String> fnr;
    private ObjectFactory objectFactory;
    private LocalDateTime nesteForsok;
    private Integer antallForsok;

    private ESkattekortBestillingBuilder(ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    public static ESkattekortBestillingBuilder create() {
        return new ESkattekortBestillingBuilder(new ObjectFactory());
    }

    public ESkattekortBestillingBuilder bestiller(Applikasjon bestiller) {
        this.bestiller = bestiller;
        return this;
    }

    public ESkattekortBestillingBuilder inntektsaar(String inntektsaar) {
        this.inntektsaar = inntektsaar;
        return this;
    }

    public ESkattekortBestillingBuilder bestillingId(Integer bestillingId) {
        this.bestillingId = bestillingId;
        return this;
    }

    public ESkattekortBestillingBuilder receiptId(Integer receiptId) {
        this.receiptId = receiptId;
        return this;
    }

    public ESkattekortBestillingBuilder archiveReference(String archiveReference) {
        this.archiveReference = archiveReference;
        return this;
    }

    public ESkattekortBestillingBuilder receiversReference(String receiversReference) {
        this.receiversReference = receiversReference;
        return this;
    }

    public ESkattekortBestillingBuilder datoSendt(LocalDateTime datoSendt) {
        this.datoSendt = datoSendt;
        return this;
    }

    public ESkattekortBestillingBuilder fnr(List<String> fnr) {
        if (this.fnr == null) {
            this.fnr = new ArrayList<>();
        }
        this.fnr.addAll(fnr);
        return this;
    }

    public ESkattekortBestillingBuilder fnr(String... fnr) {
        fnr(Arrays.asList(fnr));
        return this;
    }

    public ESkattekortBestillingBuilder nesteForsok(LocalDateTime nesteForsok) {
        this.nesteForsok = nesteForsok;
        return this;
    }

    public ESkattekortBestillingBuilder antallForsok(Integer antallForsok) {
        this.antallForsok = antallForsok;
        return this;
    }

    public ESkattekortBestilling build() {
        ESkattekortBestilling eSkattekortBestilling = objectFactory.createESkattekortBestilling();
        eSkattekortBestilling.setBestillingId(bestillingId);
        eSkattekortBestilling.setBestiller(bestiller);
        eSkattekortBestilling.setInntektsaar(inntektsaar);
        eSkattekortBestilling.setDatoSendt(datoSendt);
        eSkattekortBestilling.setKvittering(createReceipt(objectFactory));
        eSkattekortBestilling.setBrukere(createBrukere(objectFactory));
        eSkattekortBestilling.setNesteForsok(nesteForsok);
        eSkattekortBestilling.setAntallForsok(antallForsok);

        return eSkattekortBestilling;
    }

    private ESkattekortBestilling.Brukere createBrukere(ObjectFactory objectFactory) {
        if (fnr != null) {
            ESkattekortBestilling.Brukere brukere = objectFactory.createESkattekortBestillingBrukere();
            brukere.getFnr().addAll(fnr);
            return brukere;
        }
        return null;
    }

    private Receipt createReceipt(ObjectFactory objectFactory) {
        if (receiptId != null) {
            Receipt kvittering = objectFactory.createReceipt();
            kvittering.setReceiptId(receiptId);
            kvittering.setArchiveReference(archiveReference);
            kvittering.setReceiversReference(receiversReference);
            return kvittering;
        }
        return null;
    }

}

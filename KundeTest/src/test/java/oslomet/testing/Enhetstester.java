package oslomet.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class Enhetstester {

    @InjectMocks
    // denne skal testes
    private KundeController kundeController;

    @Mock
    // denne skal Mock'es
    private KundeRepository repository;

    @Test
    public void test_lagreKundeOK() {

        // arrage
        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.lagreKunde((any(Kunde.class)))).thenReturn("OK");

        // act
        String resultat = kundeController.lagreKunde(kunde1); // husk å bruke denne Controlleren, ikke opprett en ny!

        // assert
        assertEquals("OK", resultat);
    }

    @Test
    public void test_lagreKundeFeil() {

        // arrage
        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.lagreKunde((any(Kunde.class)))).thenReturn("Feil");

        // act
        String resultat = kundeController.lagreKunde(kunde1); // husk å bruke denne Controlleren, ikke opprett en ny!

        // assert
        assertEquals("Feil", resultat);
    }

    @Test
    public void test_HentAlleOK() {

        // arrage
        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");
        Kunde kunde2 = new Kunde(2, "Ole Olsen", "Oslorveien 82");
        List<Kunde> kundeliste = new ArrayList<>();
        kundeliste.add(kunde1);
        kundeliste.add(kunde2);

        Mockito.when(repository.hentAlleKunder()).thenReturn(kundeliste);

        // act
        List<Kunde> resultat = kundeController.hentAlle();

        // assert
        assertEquals(kundeliste, resultat);
    }

    @Test
    public void test_hentAlleFeil() {

        // arrage
        Mockito.when(repository.hentAlleKunder()).thenReturn(null);

        // act
        List<Kunde> resultat = kundeController.hentAlle();

        // assert
        assertNull(resultat);
    }

    @Test
    public void test_hentEnKundeOK() {

        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.hentEnKunde(anyInt())).thenReturn(kunde1);

        Kunde resultat = kundeController.hentEnKunde(1);

        assertEquals(kunde1, resultat);
    }

    @Test
    public void test_hentEnKundeFeil() {

        Mockito.when(repository.hentEnKunde(anyInt())).thenReturn(null);

        Kunde resultat = kundeController.hentEnKunde(1);

        assertNull(resultat);
    }

    @Test
    public void test_endreEnKundeOK() {

        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.endreEnKunde(any(Kunde.class))).thenReturn("OK");

        String restulat = kundeController.endreEnKunde(kunde1);
        assertEquals("OK", restulat);
    }

    @Test
    public void test_endreEnKundeFeil() {

        Kunde kunde1 = new Kunde(1, "Lene Jensen", "Askerveien 82");

        Mockito.when(repository.endreEnKunde(any(Kunde.class))).thenReturn("Feil");

        String restulat = kundeController.endreEnKunde(kunde1);
        assertEquals("Feil", restulat);
    }


    @Test
    public void test_slettEnKundeOK() {

        Mockito.when(repository.slettEnKunde(anyInt())).thenReturn("OK");

        String resultat = kundeController.slettEnKunde(1);
        assertEquals("OK", resultat);
    }

    @Test
    public void test_slettEnKundeFeil() {

        Mockito.when(repository.slettEnKunde(anyInt())).thenReturn("Feil");

        String resultat = kundeController.slettEnKunde(1);
        assertEquals("Feil", resultat);
    }

    @Test
    public void test_slettAlleOK() {

        Mockito.when(repository.slettAlleKunder()).thenReturn("OK");

        String resultat = kundeController.slettAlle();
        assertEquals("OK", resultat);
    }

    @Test
    public void test_slettAlleFeil() {

        Mockito.when(repository.slettAlleKunder()).thenReturn("Feil");

        String resultat = kundeController.slettAlle();
        assertEquals("Feil", resultat);
    }
}

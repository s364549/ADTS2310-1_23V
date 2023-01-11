package oslomet.testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KundeController {

    @Autowired
    private KundeRepository rep;

    @PostMapping("/lagreKunde")
    public String lagreKunde(Kunde kunde){
        return rep.lagreKunde(kunde);
    }

    @GetMapping("/hentKunder")
    public List<Kunde> hentAlle(){
        return rep.hentAlleKunder();
    }

    @GetMapping("/hentEnKunde")
    public Kunde hentEnKunde(int id){
        return rep.hentEnKunde(id);
    }

    @PostMapping("/endreEnKunde")
    public String endreEnKunde(Kunde kunde){
        return rep.endreEnKunde(kunde);
    }

    @GetMapping("/slettEnKunde")
    public String slettEnKunde(int id){
        return rep.slettEnKunde(id);
    }

    @GetMapping("/slettAlleKunder")
    public String slettAlle(){
        return rep.slettAlleKunder();
    }
}
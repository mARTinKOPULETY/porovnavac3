package cz.mARTin.porovnavac3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OvladacPorovnavace {

    /** Denpendency injection k predavani sluzby (service)
     * */
    @Autowired
    private SluzbaPorovnavace sluzbaPorovnavace;

    /** Metoda k vykresleni sablony (template) porovnavace
     * */
    @GetMapping("/porovnavac")
    public String vykreslovacPorovnavace(Model model){
        model.addAttribute("porovnavac", new FormularPorovnavace());
        return "porovnavac";
    }

    /** Metoda k vykresleni sablony (template) vysedku
     * */
     @PostMapping("/porovnavac")
    public String ovladacPorovnavace(@ModelAttribute FormularPorovnavace porovnavac){
        sluzbaPorovnavace.porovnej(porovnavac);
        return "vysledek";
    }
}

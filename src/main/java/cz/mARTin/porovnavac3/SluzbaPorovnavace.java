package cz.mARTin.porovnavac3;

import org.springframework.stereotype.Service;

/** Sluzba (Service) slouzici k porovnavani zadanych  cisel
 * */
@Service
public class SluzbaPorovnavace {
    public FormularPorovnavace porovnej(FormularPorovnavace porovnavac) {
        if (porovnavac.getCislo1() == porovnavac.getCislo2()) {
            porovnavac.setVysledek("Číslo " + porovnavac.getCislo1() + " se rovná číslu " + porovnavac.getCislo2() + ".");
        } else if (porovnavac.getCislo1() > porovnavac.getCislo2()) {
            porovnavac.setVysledek("Číslo " + porovnavac.getCislo1() + " je větší než " + porovnavac.getCislo2()  + ".");
        } else if (porovnavac.getCislo1() < porovnavac.getCislo2()) {
            porovnavac.setVysledek( "Číslo " + porovnavac.getCislo1() + " je menší než " + porovnavac.getCislo2() + ".");
        }
        return porovnavac;
    }
}
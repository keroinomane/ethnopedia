package info.ethnopedia.account.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.ethnopedia.account.model.AncientYdna;

@Controller
public class StaticController {
	
	@RequestMapping(value = "/inserisciEutest", method = RequestMethod.GET)
    public String inserisciEutest(Model model) {
        return "inserisciEutest";
    }
    
    @RequestMapping(value = "/inserisciEutestPlebe", method = RequestMethod.GET)
    public String inserisciEutestPlebe(Model model) {
        return "inserisciEutestPlebe";
    }
    
    @RequestMapping(value = "/statistiche", method = RequestMethod.GET)
    public String statistiche(Model model) {
		return "statistiche";
    }
    
    @RequestMapping(value = "/diffusioneCladi", method = RequestMethod.GET)
    public String diffusioneCladi(Model model) {
		return "diffusioneCladi";
    }
    
    @RequestMapping(value = "/insertAncientYdna", method = RequestMethod.GET)
    public String insertAncientYdna(Model model) {
    	AncientYdna ancientYdna = new AncientYdna();
    	model.addAttribute("ancientYdna",ancientYdna);
		return "admin/insertAncientYdna";
    }
}

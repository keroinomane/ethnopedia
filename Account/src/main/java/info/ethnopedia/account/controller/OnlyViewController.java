package info.ethnopedia.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.ethnopedia.account.model.AncientYdna;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.service.UserService;

@Controller
public class OnlyViewController {
	
	@Autowired
    private UserService userService;
	
	@RequestMapping(value = "/aploMtdnaMacroregioni", method = RequestMethod.GET)
	public String aploMtdnaMacroregioni(Model model) {
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
	 	User user = userService.findByUsername(nome);
	   	model.addAttribute("user",user);
	    return "aploMtdnaMacroregioni";
	}
	
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
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
		return "statistiche";
    }
    
    @RequestMapping(value = "/diffusioneCladi", method = RequestMethod.GET)
    public String diffusioneCladi(Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
		return "diffusioneCladi";
    }
    
    @RequestMapping(value = "/howToRaw23", method = RequestMethod.GET)
    public String howToRaw23(Model model) {
        return "howTo/howToRaw23";
    }
    
    @RequestMapping(value = "/howToRawGeno", method = RequestMethod.GET)
    public String howToRawGeno(Model model) {
        return "howTo/howToRawGeno";
    }
    
    @RequestMapping(value = "/howToRawGenoNext", method = RequestMethod.GET)
    public String howToRawGenoNext(Model model) {
        return "howTo/howToRawGenoNext";
    }
    
    @RequestMapping(value = "/howToRawLiving", method = RequestMethod.GET)
    public String howToRawLiving(Model model) {
        return "howTo/howToRawLiving";
    }
    
    @RequestMapping(value = "/howToGedmatch", method = RequestMethod.GET)
    public String howToGedmatch(Model model) {
        return "howTo/howToGedmatch";
    }
    
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(Model model) {
        return "result";
    }
    
    @RequestMapping(value = "/inserisci", method = RequestMethod.GET)
    public String inserisci(Model model) {
        return "inserisciAplo";
    }
    
    @RequestMapping(value = "/inserisciMtdna", method = RequestMethod.GET)
    public String inserisciMtdna(Model model) {
        return "inserisciMtdna";
    }
    
    //nel caso da cruscotto inserisci aplogruppi già esistenti
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(Model model) {
        return "error";
    }
    
    @RequestMapping(value = "/insertAncientYdna", method = RequestMethod.GET)
    public String insertAncientYdna(Model model) {
    	AncientYdna ancientYdna = new AncientYdna();
    	model.addAttribute("ancientYdna",ancientYdna);
		return "admin/insertAncientYdna";
    }
    
    @RequestMapping(value = "/emailForPassword", method = RequestMethod.GET)
    public String emailForPassword(Model model) {
		return "changePassword/insertEmail";
    }
    
}

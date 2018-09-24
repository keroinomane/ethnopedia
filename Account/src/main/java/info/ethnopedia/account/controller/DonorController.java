package info.ethnopedia.account.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.ethnopedia.account.model.Mtdna;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.messaggi.Messaggio;
import info.ethnopedia.account.model.messaggi.Mittente;
import info.ethnopedia.account.service.MtdnaService;
import info.ethnopedia.account.service.UserDatiService;
import info.ethnopedia.account.service.UserService;
import info.ethnopedia.account.service.YdnaService;
import info.ethnopedia.account.utility.EmailUtility;

@Controller
public class DonorController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private UserDatiService userDatiService;
    
    @Autowired
    private MtdnaService mtdnaService;
    
    @Autowired
    private YdnaService ydnaService;
	
    @RequestMapping(value = "/donatori", method = RequestMethod.GET)
    public String donatori(Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
    	
    	UserDati userDati = userDatiService.findByCognomeAndNome(user.getCognome(), user.getNome());
    	Ydna ydna = userService.findById(userDati.getId());
    	Mtdna mtdna = mtdnaService.findById(userDati.getId());
    	
    	List<Ydna> personeClade = null;
    	
    	if (ydna != null)
    		personeClade = ydnaService.getPersoneByClade(ydna.getClade(), user.getId());
    	
    	List<Mtdna> personeMtdna = null;
    	String cladeMtdnaUtente = null;
    	if (mtdna != null) {
    		personeMtdna = mtdnaService.getPersoneByAplogruppo(mtdna.getMtdnaId().getAplogruppo(), user.getId());
    		cladeMtdnaUtente = mtdna.getClade();
    	}
    	model.addAttribute("personeClade",personeClade);
    	model.addAttribute("personeMtdna",personeMtdna);
    	model.addAttribute("cladeMtdnaUtente",cladeMtdnaUtente);
        return "donatori/home";
    }
    
    @RequestMapping(value = "/contatta/{id}", method = RequestMethod.GET)
    public String contatta(@PathVariable("id")Long id, Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
    	
    	List<String> listaEmail = userService.findEmailById(id);
    	
    	Messaggio messaggio = new Messaggio(new Mittente(user.getUsername(), user.getEmail()), listaEmail, "");
    	model.addAttribute("messaggio",messaggio);
        return "donatori/scriviMessaggio";
    }
    
    @RequestMapping(value="/inviaMessaggio", method=RequestMethod.POST)
    public String inviaMessaggio(@ModelAttribute Messaggio messaggio, Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
    	
    	List<String> destinatari = messaggio.getDestinatari();
    	String oggetto = "Hai ricevuto un nuovo messaggio";
    	String testo = "Ciao, hai ricevuto un messaggio dall'utente " + messaggio.getMittente().getUsername() + ".\n";
    	testo += "La nostra è un'email automatica. Né tu né il mittente potete vedere il nome o l'email dell'altro.\n";
    	testo += "Questo è il testo del messaggio: \n--------------------------------------------------------------------\n";
    	testo += messaggio.getTesto();
    	try {
			EmailUtility.sendMultipleEmail("smtp.ethnopedia.info", "587", "admin@ethnopedia.info", "C4p1d31c4p1", destinatari, oggetto, testo);
			model.addAttribute("feedback","Il messaggio è stato inviato correttamente!");
    	} catch (AddressException e) {
    		model.addAttribute("feedback","Qualcosa è andato storto!");
		} catch (MessagingException e) {
			model.addAttribute("feedback","Qualcosa è andato storto!");
		}
		
    	return "donatori/scriviMessaggio";
    }

}

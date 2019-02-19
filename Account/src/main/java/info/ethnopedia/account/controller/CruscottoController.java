package info.ethnopedia.account.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import info.ethnopedia.account.model.AncientYdna;
import info.ethnopedia.account.model.CladiAplo;
import info.ethnopedia.account.model.Mtdna;
import info.ethnopedia.account.model.MtdnaBozza;
import info.ethnopedia.account.model.MtdnaId;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaBozza;
import info.ethnopedia.account.model.YdnaId;
import info.ethnopedia.account.service.BozzaService;
import info.ethnopedia.account.service.MtdnaService;
import info.ethnopedia.account.service.StatisticheService;
import info.ethnopedia.account.service.UserDatiService;
import info.ethnopedia.account.service.UserService;
import info.ethnopedia.account.service.YdnaService;
import info.ethnopedia.account.utility.EmailUtility;

@Controller
public class CruscottoController {
	 
	@Autowired
	private UserDatiService userDatiService;
	
	@Autowired
    private UserService userService;
	    
	@Autowired
	private MtdnaService mtdnaService;
	    
	@Autowired
	private YdnaService ydnaService;
	
	@Autowired
    private BozzaService bozzaService;
	
	@Autowired
    private StatisticheService statService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
    	List<YdnaBozza> yb = bozzaService.findAllYdna();
    	List<MtdnaBozza> mb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", yb);
    	model.addAttribute("mtdnaBozza", mb);
    	
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
        return "admin";
    }
    
    @RequestMapping(value = "/scorciatoiaAplo", method = RequestMethod.GET)
    public String scorciatoiaAplo(Model model) {
    	YdnaId ydnaId= new YdnaId();
    	ydnaId.setAplogruppo("E1b1b");
		Ydna ydna = new Ydna();
		ydna.setYdnaId(ydnaId);
		MtdnaId mtdnaId = new MtdnaId();
		Mtdna mtdna = new Mtdna();
		mtdna.setMtdnaId(mtdnaId);		
		model.addAttribute("ydna",ydna);
		model.addAttribute("mtdna",mtdna);
        return "scorciatoiaAplo";
    }
    
    @RequestMapping(value = "/ancientDNA", method = RequestMethod.GET)
    public String ancientDNA(Model model) {
    	List<AncientYdna> adna = ydnaService.findAllAncientYdna();
		model.addAttribute("adna",adna);
        return "ancientDNA";
    }
    
    @RequestMapping(value = " /modificaAncientYdna/{id}", method=RequestMethod.GET)
    public String modificaAncientYdna(@PathVariable("id")String id, Model model) {
    	AncientYdna ancientYdna = ydnaService.findAncientYdnaById(id);
		model.addAttribute("ancientYdna",ancientYdna);
		model.addAttribute("modifica",true);
		return "admin/insertAncientYdna";
    }
	
	@RequestMapping(value = "/getCladiByAploForAdna", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<CladiAplo> getCladiByAploForAdna(@RequestParam("aplo") String aplo) {
        return ydnaService.getCladiByAploForAdna(aplo);
    }
	
	@RequestMapping(value = " /insertYdna/{id}", method=RequestMethod.GET)
    public String insertYdna(@PathVariable("id")Long id,Model model) {
    	YdnaBozza yb = bozzaService.findById(id);
		YdnaId ydnaId= new YdnaId(yb.getCognome(),yb.getAplogruppo(),yb.getProvincia());
		Ydna ydna = new Ydna();
		ydna.setYdnaId(ydnaId);
		ydna.setNome(yb.getNome());
		ydna.setClade(yb.getClade());
		
		// per mostrare gli utenti giù presenti con quel cognome, se ci sono
		List<Ydna> utentiYdnaConQuelCognome = ydnaService.getPersoneByCognome(yb.getCognome());
		
		model.addAttribute("ydna",ydna);
		model.addAttribute("idOld",yb.getId());
		model.addAttribute("username",yb.getUsername());
		model.addAttribute("utentiYdna",utentiYdnaConQuelCognome);
		return "cruscotto";
    }
    
    @RequestMapping(value = " /insertMater/{id}", method=RequestMethod.GET)
    public String insertMater(@PathVariable("id")Long id,Model model) {
    	MtdnaBozza mb = bozzaService.findMtdnaBozzaById(id);
    	String aplo;
    	String[] aplo2lettere = {"HV","H1","H2","H3","H4","H5","T1","T2","U1","U2","U3","U4","U5","U6","U7","U8"};
    	boolean isDueLettere = false;
    	for (String tmp : aplo2lettere)
    		if (mb.getAplogruppo().startsWith(tmp))
    			isDueLettere = true;
    	if (isDueLettere)
    		aplo = mb.getAplogruppo().substring(0,2);
    	else
    		aplo = ""+mb.getAplogruppo().charAt(0);
		MtdnaId mtdnaId= new MtdnaId(mb.getCognome(),mb.getNome(),aplo,mb.getProvincia());
		Mtdna mtdna = new Mtdna();
		mtdna.setMtdnaId(mtdnaId);
		mtdna.setClade(mb.getAplogruppo());
		
		// per mostrare gli utenti giù presenti con quel cognome, se ci sono
		List<Mtdna> utentiMtdnaConQuelCognome = mtdnaService.getPersoneByCognome(mb.getCognome());
				
		model.addAttribute("mtdna",mtdna);
		model.addAttribute("idOld",mb.getId());
		model.addAttribute("username",mb.getUsername());
		model.addAttribute("utentiMtdna",utentiMtdnaConQuelCognome);
		return "cruscotto";
    }
    
    @RequestMapping(value="/saveYdna", method=RequestMethod.POST)
    public String saveYdna(@ModelAttribute Ydna ydna, Long idBozza, Model model) {
    	if (ydna.getClade().equals("null"))
    		ydna.setClade(null);
    	else
    		ydna.setClade(ydna.getClade().toUpperCase());
    	if (ydna.getSubclade().equals("null"))
    		ydna.setSubclade(null);
    	else
    		ydna.setSubclade(ydna.getSubclade().toUpperCase());
    	if (ydna.getDownstream().equals("null"))
    		ydna.setDownstream(null);
    	else
    		ydna.setDownstream(ydna.getDownstream().toUpperCase());
    	
    	// se non esiste già quell'aplogruppo associato a quel cognome e provincia
    	if(!ydnaService.exists(ydna.getYdnaId())) {
    		YdnaBozza yb = bozzaService.findById(idBozza);
        	UserDati ud = new UserDati(ydna.getYdnaId().getCognome(), ydna.getNome(), null, "maschio", yb.getNascita(), true, null);
        	userDatiService.save(ud);
        	ydna.setId(ud.getId());
        	ydnaService.save(ydna);
        	bozzaService.deleteYdna(idBozza);
        	List<YdnaBozza> lyb = bozzaService.findAllYdna();
        	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
        	model.addAttribute("ydnaBozza", lyb);
        	model.addAttribute("mtdnaBozza", lmb);
        	
        	User user = userService.findByUsername(yb.getUsername());
        	user.setId(ydna.getId());
        	userService.update(user);
        	
        	String content = "Ciao " + user.getNome() + ",\nil tuo aplogruppo Y-DNA è stato approvato. Ora potrai accedere al tuo profilo e completarlo.\n";
        	content += "Ti consigliamo di iscriverti al nostro gruppo su Facebook dedicato al tuo aplogruppo "+ydna.getYdnaId().getAplogruppo() + ": ";
        	
        	content = aggiungiLinkGruppoFB (ydna.getYdnaId().getAplogruppo(), content);
        	content+= "\n\nSaluti\nEthnopedia staff";
        	
        	statService.aggiornaMedieYdnaRegionali();
        	
        	try {
    			EmailUtility.sendEmail(user.getEmail(), "Registrazione Ethnopedia", content);
    		} catch (AddressException e) {
    			e.printStackTrace();
    		} catch (MessagingException e) {
    			e.printStackTrace();
    		}
        	
        	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
        	user = userService.findByUsername(nome);
        	model.addAttribute("user",user);
        	return "admin";
        // se esiste già quell'aplogruppo associato a quel cognome e provincia
    	} else {
    		return "error";
    	}
    	
    	
    }
    
    private String aggiungiLinkGruppoFB (String aplo, String content) {
    	switch (aplo) {
	    	case "E1b1b":
				content += "https://www.facebook.com/groups/961610670667507";
				break;
			case "G2a":
				content += "https://www.facebook.com/groups/377998456047741";
				break;
			case "I1":
				content += "https://www.facebook.com/groups/1667245460018074";
				break;
			case "I2":
				content += "https://www.facebook.com/groups/443604132742578";
				break;
			case "J1":
				content += "https://www.facebook.com/groups/2049800221907739";
				break;
			case "J2":
				content += "https://www.facebook.com/groups/225796151506608";
				break;
			case "R1a":
				content += "https://www.facebook.com/groups/1783440311712524";
				break;
			case "R1b":
				content += "https://www.facebook.com/groups/2036198019979624";
				break;
			case "T":
	    		content += "https://www.facebook.com/groups/463826757407866";
	    		break;	
    	}
		return content;
    }
    
    @RequestMapping(value="/saveAncientYdna", method=RequestMethod.POST)
    public String saveAncientYdna(@ModelAttribute AncientYdna ancientYdna, String cladeRadio, String altroClade, String datazione, String modifica, Model model) {
    	
    	if (cladeRadio.equals("altro"))
	    	ancientYdna.setClade(altroClade);
	    else if (cladeRadio.equals("non si sa"))
	    	ancientYdna.setClade(null);
    	
    	if (ancientYdna.getTerminalsnp().equals(""))
    		ancientYdna.setTerminalsnp(null);
    	
    	if (ancientYdna.getCultura().equals(""))
    		ancientYdna.setCultura(null);
    	
    	if (datazione.equals("bce")) {
    		ancientYdna.setFromybp(ancientYdna.getFromybp() + 2017);
    		ancientYdna.setToybp(ancientYdna.getToybp() + 2017);
    	} else if (datazione.equals("ce")) {
    		ancientYdna.setFromybp(2017 - ancientYdna.getFromybp());
    		ancientYdna.setToybp(2017 - ancientYdna.getToybp());
    	}
    	
    	if (ydnaService.exists(ancientYdna) && !modifica.equals("true"))
    		return "admin/errorAncient";
    	else
    		ydnaService.save(ancientYdna);
    	
    	ancientYdna = new AncientYdna();
    	model.addAttribute("ancientYdna", ancientYdna);
    	if (modifica.equals("true"))
    		return "ancientDNA";
    	else
    		return "admin/insertAncientYdna";
    }
    
    @RequestMapping(value="/saveYdnaManual", method=RequestMethod.POST)
    public String saveYdnaManual(@ModelAttribute Ydna ydna, String username, Model model) {
    	if (ydna.getNome().equals("null"))
    		ydna.setNome(null);
    	else
    		ydna.setNome(WordUtils.capitalizeFully(ydna.getNome()));
    	if (ydna.getClade().equals("null"))
    		ydna.setClade(null);
    	else
    		ydna.setClade(ydna.getClade().toUpperCase());
    	if (ydna.getSubclade().equals("null"))
    		ydna.setSubclade(null);
    	else
    		ydna.setSubclade(ydna.getSubclade().toUpperCase());
    	if (ydna.getDownstream().equals("null"))
    		ydna.setDownstream(null);
    	else
    		ydna.setDownstream(ydna.getDownstream().toUpperCase());
    	
    	YdnaId ydnaId = new YdnaId(WordUtils.capitalizeFully(ydna.getYdnaId().getCognome()),WordUtils.capitalize(ydna.getYdnaId().getAplogruppo()),WordUtils.capitalize(ydna.getYdnaId().getProvincia()));
    	
    	if(!ydnaService.exists(ydnaId)) {
    		ydna.setYdnaId(ydnaId);
        	UserDati ud = new UserDati(ydna.getYdnaId().getCognome(), ydna.getNome(), "maschio", true);
        	userDatiService.save(ud);
        	ydna.setId(ud.getId());
        	ydnaService.save(ydna);  
        	
        	if (!username.equals("null")) {
        		User user = userService.findByUsername(username);
        		user.setId(ud.getId());
        		userService.update(user);
        	}
        	
        	statService.aggiornaMedieYdnaRegionali();
        	
        	List<YdnaBozza> lyb = bozzaService.findAllYdna();
        	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
        	model.addAttribute("ydnaBozza", lyb);
        	model.addAttribute("mtdnaBozza", lmb);
        	
        	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
        	User user = userService.findByUsername(nome);
        	model.addAttribute("user",user);
        	return "admin";
    	} else {
    		return "error";
    	}
    	
    }
    
    @RequestMapping(value="/saveMtdna", method=RequestMethod.POST)
    public String saveMtdna(@ModelAttribute Mtdna mtdna, Long idBozza, Model model) {
    	if (mtdna.getClade().equals("null"))
    		mtdna.setClade(null);
    	else
    		mtdna.setClade(WordUtils.capitalize(mtdna.getClade()));
    	
    	MtdnaBozza mb = bozzaService.findMtdnaBozzaById(idBozza);
    	UserDati ud = userDatiService.findByCognomeAndNome(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome());
    	if (ud == null) {
    		ud = new UserDati(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome(), null, mb.getSesso(), mb.getNascita(), true, null);
    		userDatiService.save(ud);
    	}
    	mtdna.setId(ud.getId());
    	mtdnaService.save(mtdna);
    	
    	statService.aggiornaMedieMtdnaRegionali();
        statService.aggiornaMedieMtdnaMacroregionali();
		statService.aggiornaGraficoTortaMtdna();
    	
    	bozzaService.deleteMtdna(idBozza);
    	List<YdnaBozza> lyb = bozzaService.findAllYdna();
    	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", lyb);
    	model.addAttribute("mtdnaBozza", lmb);
    	
    	User user = userService.findByUsername(mb.getUsername());
    	user.setId(mtdna.getId());
    	userService.update(user);
    	
    	// Invia l'email solo se è femmina, se no va a finire che manda due email per entrambi gli aplo
    	if (ud.getSesso().equals("femmina")) {
    		String content = "Ciao " + user.getNome() + ",\nil tuo aplogruppo mtDNA è stato approvato. Ora potrai accedere al tuo profilo e completarlo.\nSaluti\nEthnopedia staff";
        	try {
    			EmailUtility.sendEmail(user.getEmail(), "Registrazione Ethnopedia", content);
    		} catch (AddressException e) {
    			e.printStackTrace();
    		} catch (MessagingException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
    	
    	return "admin";
    }
    
    @RequestMapping(value="/saveMtdnaManual", method=RequestMethod.POST)
    public String saveMtdnaManual(@ModelAttribute Mtdna mtdna, String sesso, Model model) {
    	if (mtdna.getClade().equals("null"))
    		mtdna.setClade(null);
    	else
    		mtdna.setClade(WordUtils.capitalize(mtdna.getClade()));
    	
    	MtdnaId mtdnaId = new MtdnaId(WordUtils.capitalizeFully(mtdna.getMtdnaId().getCognome()),WordUtils.capitalizeFully(mtdna.getMtdnaId().getNome()),mtdna.getMtdnaId().getAplogruppo(),WordUtils.capitalize(mtdna.getMtdnaId().getProvincia()));
    	mtdna.setMtdnaId(mtdnaId);
    	UserDati ud = userDatiService.findByCognomeAndNome(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome());
    	if (ud == null) {
    		ud = new UserDati(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome(), null, sesso, null, true, null);
    		userDatiService.save(ud);
    	}
    	mtdna.setId(ud.getId());
    	mtdnaService.save(mtdna);   	
    	
    	statService.aggiornaMedieMtdnaRegionali();
        statService.aggiornaMedieMtdnaMacroregionali();
		statService.aggiornaGraficoTortaMtdna();
    	
    	List<YdnaBozza> lyb = bozzaService.findAllYdna();
    	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", lyb);
    	model.addAttribute("mtdnaBozza", lmb);
    	
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
    	return "admin";
    }
    
    @RequestMapping(value = "/deleteYdna")
	public String deleteYdna(Long id) throws IOException {
		bozzaService.deleteYdna(id);
		return "admin";
	}
    
    @RequestMapping(value = "/deleteMtdna")
	public String deleteMtdna (Long id) throws IOException {
		bozzaService.deleteMtdna(id);
		return "admin";
	}
    
    @RequestMapping(value = " /assegnaIDaUtenteYdna/{id}/{idBozza}/{username}", method=RequestMethod.GET)
    public String assegnaIDaUtenteYdna(@PathVariable("id")Long id,@PathVariable("idBozza")Long idBozza,@PathVariable("username")String username,Model model) {
    	User user = userService.findByUsername(username);
    	user.setId(id);
    	userService.update(user);
    	bozzaService.deleteYdna(idBozza);
    	
    	List<YdnaBozza> lyb = bozzaService.findAllYdna();
    	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User admin = userService.findByUsername(nome);
    	model.addAttribute("ydnaBozza", lyb);
    	model.addAttribute("mtdnaBozza", lmb);
    	model.addAttribute("user",admin);
    	return "admin";
	}
    
    @RequestMapping(value = " /assegnaIDaUtenteMtdna/{id}/{idBozza}/{username}", method=RequestMethod.GET)
    public String assegnaIDaUtenteMtdna(@PathVariable("id")Long id,@PathVariable("idBozza")Long idBozza,@PathVariable("username")String username,Model model) {
    	User user = userService.findByUsername(username);
    	user.setId(id);
    	userService.update(user);
    	bozzaService.deleteMtdna(idBozza);
    	
    	List<YdnaBozza> lyb = bozzaService.findAllYdna();
    	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User admin = userService.findByUsername(nome);
    	model.addAttribute("ydnaBozza", lyb);
    	model.addAttribute("mtdnaBozza", lmb);
    	model.addAttribute("user",admin);
    	return "admin";
	}
	
}

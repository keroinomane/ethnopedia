package info.ethnopedia.account.controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import info.ethnopedia.account.model.Altezza;
import info.ethnopedia.account.model.CambioPassword;
import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.EutestPlebe;
import info.ethnopedia.account.model.EutestPuri;
import info.ethnopedia.account.model.Mtdna;
import info.ethnopedia.account.model.MtdnaBozza;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaBozza;
import info.ethnopedia.account.repository.InfoAploRepository;
import info.ethnopedia.account.service.AltezzaService;
import info.ethnopedia.account.service.BozzaService;
import info.ethnopedia.account.service.EutestService;
import info.ethnopedia.account.service.MtdnaService;
import info.ethnopedia.account.service.SecurityService;
import info.ethnopedia.account.service.StatisticheService;
import info.ethnopedia.account.service.UserDatiService;
import info.ethnopedia.account.service.UserService;
import info.ethnopedia.account.service.YdnaService;
import info.ethnopedia.account.utility.EmailUtility;
import info.ethnopedia.account.utility.VerifyAplo;
import info.ethnopedia.account.validator.UserValidator;

@Controller
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private StatisticheService statService;
	
	@Autowired
	private InfoAploRepository infoAploRepository;
	
	@Autowired
    private EutestService eutestService;
    
    @Autowired
    private UserDatiService userDatiService;
    
    @Autowired
    private MtdnaService mtdnaService;
    
    @Autowired
    private YdnaService ydnaService;
    
    @Autowired
    private BozzaService bozzaService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private AltezzaService altezzaService;

    @Autowired
    private UserValidator userValidator;    
    
    @RequestMapping(value = " /insertAltezza", method=RequestMethod.POST)
    public String insertAltezza(String centimetri, Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	EutestPuri eutest = eutestService.findPuroById(user.getId());
		Altezza altezza= new Altezza(user.getId(),Integer.parseInt(centimetri),eutest.getRegione());
		altezzaService.save(altezza);
		return welcome(model);
    }
    
    @RequestMapping(value = " /insertAltezzaPhenProject", method=RequestMethod.POST)
    public String insertAltezzaPhenProject(String centimetri, String regione, Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
		Altezza altezza= new Altezza(user.getId(),Integer.parseInt(centimetri),regione);
		altezzaService.save(altezza);
		return welcome(model);
    }
    
    @RequestMapping(value = " /insertNascita", method=RequestMethod.POST)
    public String insertNascita(String nascita, Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	UserDati userDati = userDatiService.findById(user.getId());
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date nascitaDate = new Date();
		try {
			nascitaDate = sdf.parse(nascita);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		userDati.setNascita(nascitaDate);
		userDatiService.save(userDati);
		return welcome(model);
    }
    
    @RequestMapping(value = "/UploadDownloadFile", method = RequestMethod.POST)
    public ModelAndView aplogruppi (HttpServletRequest request) throws Exception{
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(name);
    	String email = user.getEmail();
    	DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) request.getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		ServletFileUpload uploader = new ServletFileUpload(fileFactory);
		// reads SMTP server setting from web.xml file
        String content="";
        String resultMessage="";
        ModelAndView modelAndView=new ModelAndView("result");       
       
	   	if(!ServletFileUpload.isMultipartContent(request))
			throw new Exception("Content type is not multipart/form-data");
		
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			String nome = fileItemsList.get(0).getString();
			String cognome = fileItemsList.get(1).getString();
			String sesso = fileItemsList.get(2).getString();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String nascita = fileItemsList.get(3).getString();
			Date nascitaDate= sdf.parse(nascita);
			String test = fileItemsList.get(4).getString();
			String aplo = "";
	        String clade = "";
	        String provinciaP = fileItemsList.get(7).getString();
	        String gedmatch = fileItemsList.get(8).getString();
	        String nonnop = fileItemsList.get(9).getString();
	        String nonnap = fileItemsList.get(10).getString();
	        String nonnom = fileItemsList.get(11).getString();
	        String nonnam = fileItemsList.get(12).getString();
	        
	        String mtDNA = fileItemsList.get(13).getString();
	        String provinciaM = fileItemsList.get(14).getString();
			FileItem rawdataFile = fileItemsList.get(15);
			String rawdata = IOUtils.toString(rawdataFile.getInputStream(),"UTF-8");
			
			boolean b = false;
			
			if (test.equals("ancestry")) {
				content = "Cognome: " + cognome + "\nnome: " + nome + "\nData di nascita: " + nascita + "\nGEDmatch: " + gedmatch + "\nnonno paterno: " + nonnop + "\nnonna paterna: " + nonnap + "\nnonno materno: " + nonnom + "\nnonna materna: " + nonnam + "\nemail: " + email;
				b = true;
			} else if (sesso.equals("femmina"))  {
				content = "Cognome: " + cognome + "\nnome: " + nome + "\nData di nascita: " + nascita + "\nmtDNA: " + mtDNA + "\nprovincia materna: " + provinciaM + "\nemail: " + email;
				b = true;
			} else {
				aplo = fileItemsList.get(5).getString();
				clade = fileItemsList.get(6).getString();
				content = "Cognome: " + cognome + "\nnome: " + nome + "\nData di nascita: " + nascita + "\naplogruppo: " + aplo + "\nclade: " + clade + 
		           		"\nprovincia paterna: " + provinciaP + "\nmtDNA: " + mtDNA + "\nprovincia materna: " + provinciaM + "\nemail: " + email;
				
				b = VerifyAplo.isOk(test, rawdata, aplo, clade);
			}
			content += "\ntest: " + test;
			if (b) {				
				resultMessage = "Stiamo elaborando i tuoi dati. <b>Non reinserirli un'altra volta.</b><br><br>"
						+ "We're elaborating your data. <b>Don't insert them again.</b>";
				String usern = SecurityContextHolder.getContext().getAuthentication().getName();
				if (sesso.equals("maschio") && !test.equals("ancestry")) {
					content += "\n\nRaw data corretti.";
					YdnaBozza yb = new YdnaBozza(usern, WordUtils.capitalizeFully(cognome), WordUtils.capitalizeFully(nome), WordUtils.capitalize(aplo), clade, WordUtils.capitalizeFully(provinciaP), nascitaDate);
					bozzaService.save(yb);
				}
				MtdnaBozza mb = new MtdnaBozza(usern, WordUtils.capitalizeFully(cognome), WordUtils.capitalizeFully(nome), WordUtils.capitalize(mtDNA), WordUtils.capitalizeFully(provinciaM), sesso, nascitaDate);
				bozzaService.save(mb);
			} else {
				content += "\n\nRaw data errati.";
				resultMessage = "Hai inserito dati errati oppure il file da te inserito non è corretto.<br><a href=\"javascript:history.back()\"><b>Riprova!</b></a>"
						+ "<br><br>You have entered wrong data or the uploaded file is not correct.<br><a href=\"javascript:history.back()\"><b>Try again!</b></a>";
			}
			
			EmailUtility.sendEmail("smtp.ethnopedia.info", "587", "admin@ethnopedia.info", "C4p1d31c4p1", "admin@ethnopedia.info", "Aplogruppi", content);
			
		} catch (Exception e) {
			resultMessage = "Qualcosa è andato storto.<br>Hai inserito la data di nascita?<br>Hai scompattato il file zip?<br><br><a href=\"javascript:history.back()\"><b>Prova ancora!</b></a>"
					+ "<br><br><br><small>Something went wrong.<br>Did you insert the date of birth?<br>Did you unzip the file?<br><br><a href=\"javascript:history.back()\"><b>Try again!</b></small></a>";
		} 
		modelAndView.addObject("message", resultMessage);
	     
	    
		return modelAndView;
	}
    
    @RequestMapping(value = "/insertMtDNA", method = RequestMethod.POST)
    public ModelAndView insertMtDNA (String aplogruppoM, String provinciaM, String sesso) {
    	
    	String resultMessage="";
        
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(username);
    	String nome = user.getNome();
    	String cognome = user.getCognome();
    	
        
        ModelAndView modelAndView=new ModelAndView("result"); 
		
        resultMessage = "Stiamo elaborando i tuoi dati. <b>Non reinserirli un'altra volta.</b><br><br>"
				+ "We're elaborating your data. <b>Don't insert them again.</b>";
        
		MtdnaBozza mb = new MtdnaBozza(username, cognome, nome, aplogruppoM, provinciaM, sesso);
		bozzaService.save(mb);
		modelAndView.addObject("message", resultMessage);
     
		return modelAndView;
	}
    	
    @RequestMapping(value = "/eutest", method = RequestMethod.POST)
    public String eurotest(Model model, String nonnoP, String nonnaP, String nonnoM, String nonnaM, String macroregione, String baltic, String
		easteuro, String northcentraleuro, String atlantic, String westmed, String eastmed, String westasian, String middleastern, 
		String southasian, String eastafrican, String eastasian, String siberian, String westafrican, String gedmatch) {
    	
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	boolean regionalResult = false;

    	String content = "Id: " + user.getId() + "\nCognome: " + user.getCognome() + "\nNome: " + user.getNome() + "\nCodice GedMatch: " + gedmatch;
    	try {
			EmailUtility.sendEmail("smtp.ethnopedia.info", "587", "admin@ethnopedia.info", "C4p1d31c4p1", "admin@ethnopedia.info", "autosomal", content);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    	if (nonnoP.equals("null")) nonnoP = null; 
    	if (nonnaP.equals("null")) nonnaP = null; 
    	if (nonnoM.equals("null")) nonnoM = null; 
    	if (nonnaM.equals("null")) nonnaM = null; 
    	Eutest eutest = new Eutest(user.getId(), user.getCognome(), user.getNome(), macroregione, gedmatch, Double.parseDouble(baltic),Double.parseDouble(easteuro), Double.parseDouble(northcentraleuro), 
    			Double.parseDouble(atlantic), Double.parseDouble(westmed), Double.parseDouble(eastmed), Double.parseDouble(westasian), Double.parseDouble(middleastern), 
    	    	Double.parseDouble(southasian), Double.parseDouble(eastafrican), Double.parseDouble(eastasian), Double.parseDouble(siberian), Double.parseDouble(westafrican), nonnoP, nonnaP, nonnoM, nonnaM);
    	
    	eutestService.save(eutest);
    	
    	EutestPlebe eutestPlebe = new EutestPlebe(user.getId(), user.getCognome(), user.getNome(), gedmatch, Double.parseDouble(baltic),Double.parseDouble(easteuro), Double.parseDouble(northcentraleuro), 
    			Double.parseDouble(atlantic), Double.parseDouble(westmed), Double.parseDouble(eastmed), Double.parseDouble(westasian), Double.parseDouble(middleastern), 
    	    	Double.parseDouble(southasian), Double.parseDouble(eastafrican), Double.parseDouble(eastasian), Double.parseDouble(siberian), Double.parseDouble(westafrican));
    	
    	eutestService.save(eutestPlebe);
    	
    	if (nonnoP.equals(nonnaP) && nonnaP.equals(nonnoM) && nonnoM.equals(nonnaM) && nonnaM.equals(nonnoP)) {
    		EutestPuri eutestPuro = new EutestPuri(eutest);
        	statService.save(eutestPuro);
    	}
    	
    	UserDati userDati = userDatiService.findById(user.getId());
		Ydna ydna = userService.findById(user.getId());
    	Mtdna mtdna = mtdnaService.findById(user.getId());
    	String closestPop = statService.calcolaClosestPop(eutestPlebe);
    	String pureClosestPop = statService.calcolaPureClosestPop(eutestPlebe);
    	
		if (!closestPop.equals(pureClosestPop))
			regionalResult  = true;
    	
		model.addAttribute("ydna", ydna);
		model.addAttribute("mtdna", mtdna);
		model.addAttribute("userDati", userDati);
		model.addAttribute("eutest", eutest);
		model.addAttribute("closestPop", closestPop);
		model.addAttribute("pureClosestPop", pureClosestPop);
		model.addAttribute("regionalResult", regionalResult);
    	
        return "welcome";
    }
    
    @RequestMapping(value = "/eutestPlebe", method = RequestMethod.POST)
    public String eutestPlebe(Model model, String baltic, String easteuro, String northcentraleuro, String atlantic, String westmed, 
    		String eastmed, String westasian, String middleastern, String southasian, String eastafrican, String eastasian, 
    		String siberian, String westafrican, String gedmatch) {
    	
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	boolean regionalResult = false;
    	
    	EutestPlebe eutestPlebe = new EutestPlebe(user.getId(), user.getCognome(), user.getNome(), gedmatch, Double.parseDouble(baltic),Double.parseDouble(easteuro), Double.parseDouble(northcentraleuro), 
    			Double.parseDouble(atlantic), Double.parseDouble(westmed), Double.parseDouble(eastmed), Double.parseDouble(westasian), Double.parseDouble(middleastern), 
    	    	Double.parseDouble(southasian), Double.parseDouble(eastafrican), Double.parseDouble(eastasian), Double.parseDouble(siberian), Double.parseDouble(westafrican));
    	
    	eutestService.save(eutestPlebe);
    	
    	UserDati userDati = userDatiService.findById(user.getId());
		Ydna ydna = userService.findById(user.getId());
    	Mtdna mtdna = mtdnaService.findById(user.getId());
    	String closestPop = statService.calcolaClosestPop(eutestPlebe);
    	String pureClosestPop = statService.calcolaPureClosestPop(eutestPlebe);
    	
		if (!closestPop.equals(pureClosestPop))
			regionalResult  = true;
    	
		model.addAttribute("ydna", ydna);
		model.addAttribute("mtdna", mtdna);
		model.addAttribute("userDati", userDati);
		model.addAttribute("eutest", eutestPlebe);
		model.addAttribute("closestPop", closestPop);
		model.addAttribute("pureClosestPop", pureClosestPop);
		model.addAttribute("regionalResult", regionalResult);
    	
        return "welcome";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }
    
    
    @RequestMapping(value = "/aggiorna", method = RequestMethod.POST)
    public String aggiorna(Model model, String autosomal) {
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
		UserDati userDati = userDatiService.findById(user.getId());
		Ydna ydna = userService.findById(user.getId());
    	Mtdna mtdna = mtdnaService.findById(user.getId());
		if (autosomal.equals("true")) {
			userDati.setAutosomal(true);
			String content = "Id: " + user.getId() + "\nCognome: " + user.getCognome() + "\nNome: " + user.getNome() + "\nEmail: " + user.getEmail() + "\n"
					+ "Ha dichiarato di avere 4 nonni della stessa macroregione.";
			try {
				EmailUtility.sendEmail("smtp.ethnopedia.info", "587", "admin@ethnopedia.info", "C4p1d31c4p1", "admin@ethnopedia.info", "Dichiarazione dei nonni", content);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} else {
			userDati.setAutosomal(false);
		}
		userDatiService.save(userDati);	
		model.addAttribute("ydna", ydna);
		model.addAttribute("mtdna", mtdna);
		model.addAttribute("userDati", userDati);
		return "welcome";
	}
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        
    	// valida i campi
    	userValidator.validate(userForm, bindingResult);
    	
    	// se ci sono errori nel validator, rimanda alla pagina di registrazione
        if (bindingResult.hasErrors())
            return "registration";
            
        userService.save(userForm);
        
        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return welcome(model);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Username e/o password errati.");

        if (logout != null)
            model.addAttribute("message", "Ti sei disconnesso con successo.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	Ydna ydna = new Ydna();
    	Mtdna mtdna = new Mtdna();
    	EutestPlebe eutest = new EutestPlebe();
    	Altezza altezza = new Altezza();
    	UserDati userDati = userDatiService.findByCognomeAndNome(user.getCognome(), user.getNome());
    	String infoaplo = null;
    	String infoclade = null;
    	String closestPop = "";
    	String pureClosestPop = "";
    	boolean nonniStessaRegione = false;
    	boolean fasciaEtaOK = false;
    	boolean regionalResult = false;
    	
    	if (userDati != null) {
    		// se non ha inserito Y-DNA o mtDNA o autosomal
    		if (user.getId() == null) {
    			if (userDati.getNome() == null) {
    	    		userDati.setNome(user.getNome());
    	    		userDatiService.save(userDati);
    	    	}
    			ydna = userService.findById(userDati.getId());
	    		mtdna = mtdnaService.findById(userDati.getId());
	    		user.setId(userDati.getId());
	    		userService.update(user);
	    		if (ydna != null) {
		    		ydna.setNome(user.getNome());
		    		ydnaService.save(ydna);
	    		}
	    	// se ha inserito Y-DNA o mtDNA o autosomal
    		} else {
    	    	ydna = userService.findById(user.getId());
    	    	mtdna = mtdnaService.findById(user.getId());
    	    	userDati = userDatiService.findById(user.getId());
    	    	eutest = eutestService.findById(user.getId());
    	    	if (ydna != null) {
    	    		if (ydna.getClade() != null)
    	    			infoclade = infoAploRepository.getContent(ydna.getClade());
    	    		infoaplo = infoAploRepository.getContent(ydna.getYdnaId().getAplogruppo());
    	    	}
    	    	if (eutest != null) {
    	    		closestPop = statService.calcolaClosestPop(eutest);
    	    		pureClosestPop = statService.calcolaPureClosestPop(eutest);
    	    		if (!closestPop.equals(pureClosestPop))
    	    			regionalResult = true;
    	    	}
        	}
    		EutestPuri tizio = eutestService.findPuroById(user.getId());
    		
    		
    		// controllo età (da 21 a 60 anni)
    		if (userDati.getNascita() != null) {
    			Calendar c1 = Calendar.getInstance();
    			Calendar c2 = Calendar.getInstance();
    			c1.setTime(new Date());
    			c2.setTime(userDati.getNascita());
    			int yearDiff = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
    			if (yearDiff > 20 && yearDiff < 61)
    				fasciaEtaOK = true;
    		}
    		
    		// restituisce altezza se è già inserita, altrimenti null
    		if (tizio != null || userDati.getPhenproject() != null) {
    				
    			nonniStessaRegione = true;
    			altezza = altezzaService.findById(user.getId());
    		}
    		
    	}
    	
    	model.addAttribute("ydna", ydna);
    	model.addAttribute("mtdna", mtdna);
    	model.addAttribute("infoaplo", infoaplo);
    	model.addAttribute("infoclade", infoclade);
    	model.addAttribute("user", user);
    	model.addAttribute("userDati", userDati);
    	model.addAttribute("fasciaEtaOK", fasciaEtaOK);
    	model.addAttribute("nonniStessaRegione", nonniStessaRegione);
    	model.addAttribute("altezza", altezza);
    	model.addAttribute("eutest", eutest);
    	model.addAttribute("closestPop", closestPop);
    	model.addAttribute("pureClosestPop", pureClosestPop);
    	model.addAttribute("regionalResult", regionalResult);
        return "welcome";
    }
    
    @RequestMapping(value = "/inviaLinkEmail", method = RequestMethod.POST)
    public String inviaLinkEmail (Model model, String email) {
		
        String resultMessage;
        
		User user = userService.findByEmail(email);
		if (user != null) {
			resultMessage = "<b>Ti abbiamo inviato un'email col link da cliccare per cambiare la password.<br><br>"
					+ "We sent you an e-mail. Click the link to change password.</b>";
			String link = UUID.randomUUID().toString().replace("-", "");
			CambioPassword cambioPassword = new CambioPassword(user.getUsername(), link, email);
			userService.save(cambioPassword);
			
			String content = "Ciao " + user.getNome() + ",\n" + 
					"il tuo username è " + user.getUsername() + ".\n" + 
					"Clicca qui per cambiare la password: https://www.ethnopedia.info/account/insertPassword/"+link+"\n" +
					"Saluti\nEthnopedia staff";
			try {
				EmailUtility.sendEmail("smtp.ethnopedia.info", "587", "admin@ethnopedia.info", "C4p1d31c4p1", user.getEmail(), "Cambia password", content);
			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		} else {
			resultMessage = "<b>L'email inserita non è corretta.<br><br>"
					+ "The email is wrong.</b><br><br><br>"
					+ "<a href=\"emailForPassword\"><button>Riprova</button></a>";
		}
	
		model.addAttribute("message", resultMessage);
     
		return "changePassword/insertEmail";
	}
    
    @RequestMapping(value = " /insertPassword/{link}", method=RequestMethod.GET)
    public String insertMater(@PathVariable("link")String link,Model model) {
    	CambioPassword change = userService.findByLink(link);
    	if (change != null)
    		model.addAttribute("cambioPassword", new CambioPassword(change.getUsername(), link, change.getEmail()));
    	
		return "changePassword/insertPassword";
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public String changePassword(@ModelAttribute("cambioPassword") CambioPassword cambioPassword, BindingResult bindingResult, Model model) {
            
        userService.updatePassword(cambioPassword);
        
        userService.delete(cambioPassword);
        
        String resultMessage = "<b>La password è stata modificata correttamente.<br><br>"
				+ "Password changed successfully.</b><br><br><br>"
				+ "<a href=\"login\"><button>Accedi</button></a>";
        
        model.addAttribute("message", resultMessage);
        
		return "changePassword/insertEmail";
    }
}

package info.ethnopedia.account.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import info.ethnopedia.account.model.Autosomal;
import info.ethnopedia.account.model.CladeFreqRegionali;
import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.Frequenza;
import info.ethnopedia.account.model.FrequenzeMtdna;
import info.ethnopedia.account.model.Mtdna;
import info.ethnopedia.account.model.MtdnaBozza;
import info.ethnopedia.account.model.MtdnaId;
import info.ethnopedia.account.model.PieChartData;
import info.ethnopedia.account.model.TableMtdna;
import info.ethnopedia.account.model.TableYdna;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.model.UserDati;
import info.ethnopedia.account.model.Ydna;
import info.ethnopedia.account.model.YdnaBozza;
import info.ethnopedia.account.model.YdnaId;
import info.ethnopedia.account.repository.InfoAploRepository;
import info.ethnopedia.account.service.BozzaService;
import info.ethnopedia.account.service.EutestService;
import info.ethnopedia.account.service.MtdnaService;
import info.ethnopedia.account.service.SecurityService;
import info.ethnopedia.account.service.StatisticheService;
import info.ethnopedia.account.service.UserDatiService;
import info.ethnopedia.account.service.UserService;
import info.ethnopedia.account.service.YdnaService;
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
    private UserValidator userValidator;    
    
    @RequestMapping(value = "/inserisciEutest", method = RequestMethod.GET)
    public String inserisciEutest(Model model) {
        return "inserisciEutest";
    }
    
    @RequestMapping(value = "/statistiche", method = RequestMethod.GET)
    public String statistiche(Model model) {
		return "statistiche";
    }
    
    @RequestMapping(value = "/diffusioneCladi", method = RequestMethod.GET)
    public String diffusioneCladi(Model model) {
		return "diffusioneCladi";
    }
    
    @RequestMapping(value = "/calcolaFrequenzaClade", method = RequestMethod.GET)
    public String CalcolaFrequenzaClade(@RequestParam(value = "checkSubclade", required = false) String checkSubclade,
    		String aplogruppi, String cladi, String subcladi, Model model) {
    		
    		CladeFreqRegionali cfr = null;
    		String nome="";
    		List<Frequenza> frequenze = new ArrayList<Frequenza>();
    		List<String> regioni = statService.getRegioni();
    		Iterator<String> it = regioni.iterator();
    		while (it.hasNext()) {
    			String regione = it.next();
    			int campioni = statService.countRegio(regione);
    			double tot = 0;
    			
    			if (checkSubclade != null) {
    				tot = statService.countSubcladeRegio(subcladi, regione);
    				nome = subcladi;
    			} else {
    				tot = statService.countCladeRegio(cladi, regione);
    				nome = cladi;
    			}
    			tot /= campioni;
    			tot *= 10000;
    			tot = (int) tot;
    			tot /= 100;
    			frequenze.add(new Frequenza (regione, tot, campioni));
    			
    		}  
    		cfr = new CladeFreqRegionali(aplogruppi+"-"+nome,frequenze);
    		model.addAttribute("cfr",cfr);
    		
		return "diffusioneCladi";
    }
    
    @RequestMapping(value = "/getCladiByAplo", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<String> getCladiByAplo(@RequestParam("aplo") String aplo) {
        return ydnaService.getCladiByAplo(aplo);
    }
    
    @RequestMapping(value = "/getSubcladiByClade", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<String> getSubcladiByClade(@RequestParam("clade") String clade) {
        return ydnaService.getSubcladiByClade(clade);
    }
    
    @RequestMapping(value = " /calcMediaAploRegioni", method=RequestMethod.GET)
    public String calcMediaAploRegioni(Model model) {
		statService.deleteAllTableYdna();
		List<String> aplog = Arrays.asList("E1b1b", "G2a", "I1", "I2", "J1", "J2", "R1a", "R1b", "T");
		List<String> regioni = statService.getRegioni();
		Collections.sort(regioni);
		double[] campi = new double[9];
		Iterator<String> iterReg = regioni.iterator();
		while (iterReg.hasNext()) {
			String reg = iterReg.next();
			int campioni = statService.countRegio(reg);
			Iterator<String> iterAplo = aplog.iterator();
			int ciclo = 0;
	    	while (iterAplo.hasNext()) {
	    		int ap;
	    		String apl = iterAplo.next();
	    		if (apl.equals("G2a"))
	    			ap = statService.countAploG(reg);
	    		else
	    			ap = statService.countAploRegio(apl,reg);
	        	double tot = campioni;
	        	tot = ap/tot*10000;
	        	tot = (int)tot;
	        	tot /= 100;
	        	campi[ciclo] = tot;
	        	ciclo++;
	    	}
	    	TableYdna all = new TableYdna(reg, campioni, campi);
	    	statService.save(all);
		}	
		List<TableYdna> ydnaReg = statService.findAll();
		model.addAttribute("ydnaReg",ydnaReg);
		return "aploRegioni";
    }
    
    @RequestMapping(value = " /insertYdna/{id}", method=RequestMethod.GET)
    public String insertYdna(@PathVariable("id")Long id,Model model) {
    	YdnaBozza yb = bozzaService.findById(id);
		YdnaId ydnaId= new YdnaId(yb.getCognome(),yb.getAplogruppo(),yb.getProvincia());
		Ydna ydna = new Ydna();
		ydna.setYdnaId(ydnaId);
		ydna.setNome(yb.getNome());
		ydna.setClade(yb.getClade());
		model.addAttribute("ydna",ydna);
		model.addAttribute("idOld",yb.getId());
		return "cruscotto";
    }
    
    @RequestMapping(value = " /insertMater/{id}", method=RequestMethod.GET)
    public String insertMater(@PathVariable("id")Long id,Model model) {
    	MtdnaBozza mb = bozzaService.findMtdnaBozzaById(id);
    	String aplo;
    	if (mb.getAplogruppo().startsWith("HV"))
    		aplo = "HV";
    	else
    		aplo = ""+mb.getAplogruppo().charAt(0);
		MtdnaId mtdnaId= new MtdnaId(mb.getCognome(),mb.getNome(),aplo,mb.getProvincia());
		Mtdna mtdna = new Mtdna();
		mtdna.setMtdnaId(mtdnaId);
		mtdna.setClade(mb.getAplogruppo());
		model.addAttribute("mtdna",mtdna);
		model.addAttribute("idOld",mb.getId());
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
    	
    	UserDati ud = new UserDati(ydna.getYdnaId().getCognome(), ydna.getNome());
    	userDatiService.save(ud);
    	ydna.setId(ud.getId());
    	ydnaService.save(ydna);
    	YdnaBozza yb = bozzaService.findById(idBozza);
    	bozzaService.deleteYdna(idBozza);
    	List<YdnaBozza> lyb = bozzaService.findAllYdna();
    	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", lyb);
    	model.addAttribute("mtdnaBozza", lmb);
    	
    	User user = userService.findByUsername(yb.getUsername());
    	user.setId(ydna.getId());
    	userService.update(user);
    	
    	return "admin";
    }
    
    @RequestMapping(value="/saveYdnaManual", method=RequestMethod.POST)
    public String saveYdnaManual(@ModelAttribute Ydna ydna, Model model) {
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
        	UserDati ud = new UserDati(ydna.getYdnaId().getCognome(), ydna.getNome());
        	userDatiService.save(ud);
        	ydna.setId(ud.getId());
        	ydnaService.save(ydna);    	
        	
        	List<YdnaBozza> lyb = bozzaService.findAllYdna();
        	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
        	model.addAttribute("ydnaBozza", lyb);
        	model.addAttribute("mtdnaBozza", lmb);
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
    	
    	UserDati ud = userDatiService.findByCognomeAndNome(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome());
    	if (ud == null) {
    		ud = new UserDati(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome());
    		userDatiService.save(ud);
    	}
    	mtdna.setId(ud.getId());
    	mtdnaService.save(mtdna);
    	MtdnaBozza mb = bozzaService.findMtdnaBozzaById(idBozza);
    	bozzaService.deleteMtdna(idBozza);
    	List<YdnaBozza> lyb = bozzaService.findAllYdna();
    	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", lyb);
    	model.addAttribute("mtdnaBozza", lmb);
    	
    	User user = userService.findByUsername(mb.getUsername());
    	user.setId(mtdna.getId());
    	userService.update(user);
    	
    	return "admin";
    }
    
    @RequestMapping(value="/saveMtdnaManual", method=RequestMethod.POST)
    public String saveMtdnaManual(@ModelAttribute Mtdna mtdna, Model model) {
    	if (mtdna.getClade().equals("null"))
    		mtdna.setClade(null);
    	else
    		mtdna.setClade(WordUtils.capitalize(mtdna.getClade()));
    	
    	MtdnaId mtdnaId = new MtdnaId(WordUtils.capitalizeFully(mtdna.getMtdnaId().getCognome()),WordUtils.capitalizeFully(mtdna.getMtdnaId().getNome()),mtdna.getMtdnaId().getAplogruppo(),WordUtils.capitalize(mtdna.getMtdnaId().getProvincia()));
    	mtdna.setMtdnaId(mtdnaId);
    	UserDati ud = userDatiService.findByCognomeAndNome(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome());
    	if (ud == null) {
    		ud = new UserDati(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome());
    		userDatiService.save(ud);
    	}
    	mtdna.setId(ud.getId());
    	mtdnaService.save(mtdna);   	
    	
    	List<YdnaBozza> lyb = bozzaService.findAllYdna();
    	List<MtdnaBozza> lmb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", lyb);
    	model.addAttribute("mtdnaBozza", lmb);
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
        ServletContext context = request.getServletContext();
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
		String test = fileItemsList.get(3).getString();
		String aplo = "";
        String clade = "";
        String provinciaP = fileItemsList.get(8).getString();
        String mtDNA = fileItemsList.get(9).getString();
        String provinciaM = fileItemsList.get(10).getString();
		FileItem rawdataFile = fileItemsList.get(11);
		String rawdata=IOUtils.toString(rawdataFile.getInputStream(),"UTF-8");
		boolean b = false;
		
		if (sesso.equals("maschio")) {
			if (test.equals("23andMe")) {
				aplo = fileItemsList.get(4).getString();
				clade = fileItemsList.get(5).getString();
				content = "Cognome: " + cognome + "\nnome: " + nome + "\naplogruppo 23andMe: " + aplo + "\nclade 23andMe: " + clade + 
	            		"\nprovincia paterna: " + provinciaP + "\nmtDNA: " + mtDNA + "\nprovincia materna: " + provinciaM;
			} else {
				aplo = fileItemsList.get(6).getString();
				clade = fileItemsList.get(7).getString();
				content = "Cognome: " + cognome + "\nnome: " + nome + "\naplogruppo Geno: " + aplo + "\nclade Geno: " + clade + "\nprovincia paterna: " + provinciaP + "\nmtDNA: " + mtDNA + "\nprovincia materna: " + provinciaM + "\nemail: " + email;
			}
			b = VerifyAplo.isOk(test, rawdata, aplo, clade);
		} else {
			// sesso femminile
			content = "Cognome: " + cognome + "\nnome: " + nome + "\nmtDNA: " + mtDNA + "\nprovincia materna: " + provinciaM + "\nemail: " + email;
			b = true;
		}
		if (b) {				
			resultMessage = "Stiamo elaborando i tuoi dati. <b>Non reinserirli un'altra volta.</b><br>Ti manderemo una mail quando l\'elaborazione è finita.";
			String usern = SecurityContextHolder.getContext().getAuthentication().getName();
			if (sesso.equals("maschio")) {
				content += "\n\nRaw data corretti.";
				YdnaBozza yb = new YdnaBozza(usern, WordUtils.capitalizeFully(cognome), WordUtils.capitalizeFully(nome), WordUtils.capitalize(aplo), clade, WordUtils.capitalizeFully(provinciaP));
				bozzaService.save(yb);
			}
			MtdnaBozza mb = new MtdnaBozza(usern, WordUtils.capitalizeFully(cognome), WordUtils.capitalizeFully(nome), WordUtils.capitalize(mtDNA), WordUtils.capitalizeFully(provinciaM));
			bozzaService.save(mb);
		} else {
			content += "\n\nRaw data errati.";
			resultMessage = "Hai inserito dati errati oppure il file da te inserito non è corretto.<br><a href=\"javascript:history.back()\"><b>Riprova!</b></a>"
					+ "<br><br>You have entered wrong data or the uploaded file is not correct.<br><a href=\"javascript:history.back()\"><b>Try again!</b></a>";
		}
		
		EmailUtility.sendEmail("smtp.gmail.com", "587", "daniele.pisano90@gmail.com", "zwpwhxoldjicegmj", "admin@ethnopedia.info", "Aplogruppi", content);
		
	} catch (Exception e) {
		resultMessage = "Exception in uploading file.";
	} 
	modelAndView.addObject("message", resultMessage);
     
    
	return modelAndView;
}
    
    @RequestMapping(value = "/insertMtDNA", method = RequestMethod.POST)
    public ModelAndView insertMtDNA (String aplogruppoM, String provinciaM) {
    	
    	
        String resultMessage="";
        
    	String username = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(username);
    	String nome = user.getNome();
    	String cognome = user.getCognome();
    	
        
        ModelAndView modelAndView=new ModelAndView("result"); 
		
		resultMessage = "Stiamo elaborando i tuoi dati. <b>Non reinserirli un'altra volta.</b><br>Ti manderemo una mail quando l\'elaborazione è finita.";
	
		MtdnaBozza mb = new MtdnaBozza(username, cognome, nome, aplogruppoM, provinciaM);
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

    	String content = "Id: " + user.getId() + "\nCognome: " + user.getCognome() + "\nNome: " + user.getNome() + "\nCodice GedMatch: " + gedmatch;
    	try {
			EmailUtility.sendEmail("smtp.gmail.com", "587", "daniele.pisano90@gmail.com", "zwpwhxoldjicegmj", "admin@ethnopedia.info", "autosomal", content);
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
    	
    	UserDati userDati = userDatiService.findById(user.getId());
		Ydna ydna = userService.findById(user.getId());
    	Mtdna mtdna = mtdnaService.findById(user.getId());
    	
		model.addAttribute("ydna", ydna);
		model.addAttribute("mtdna", mtdna);
		model.addAttribute("userDati", userDati);
		model.addAttribute("eutest", eutest);
    	
        return "welcome";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
    	List<YdnaBozza> yb = bozzaService.findAllYdna();
    	List<MtdnaBozza> mb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", yb);
    	model.addAttribute("mtdnaBozza", mb);
        return "admin";
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
    
    @RequestMapping(value = "/howToRaw23", method = RequestMethod.GET)
    public String howToRaw23(Model model) {

        return "howToRaw23";
    }
    
    @RequestMapping(value = "/howToRawGeno", method = RequestMethod.GET)
    public String howToRawGeno(Model model) {

        return "howToRawGeno";
    }
    
    @RequestMapping(value = "/howToRawGenoNext", method = RequestMethod.GET)
    public String howToRawGenoNext(Model model) {

        return "howToRawGenoNext";
    }
    
    @RequestMapping(value = "/aploRegioni", method = RequestMethod.GET)
    public String aploRegioni(Model model) {
    	List<TableYdna> ydnaReg = statService.findAll();
		model.addAttribute("ydnaReg",ydnaReg);
        return "aploRegioni";
    }
    
    @RequestMapping(value = "/autosomal", method = RequestMethod.GET)
    public String autosomal(Model model) {
    	List<Autosomal> auto = statService.findAllAutosomal();
		model.addAttribute("auto",auto);
        return "autosomal";
    }
    
    @RequestMapping(value = "/aploMtdnaMacroregioni", method = RequestMethod.GET)
    public String aploMtdnaMacroregioni(Model model) {
        return "aploMtdnaMacroregioni";
    }
    
    @RequestMapping(value = "/aggiornaAutosomal", method = RequestMethod.GET)
    public String aggiornaAutosomal(Model model) throws IOException, IllegalArgumentException, IllegalAccessException {
    	
    	statService.deleteAllAutosomal();
    	String[] admix = new String[] {"baltic","nordic","atlantic","westmed","eastmed","westasian","mena","asian","ssa"};
		List<String> macro = statService.getMacroregioniAutosomal();
		Collections.sort(macro);
		
		Double[] valori = new Double[9];
		Iterator<String> it = macro.iterator();
		while (it.hasNext()) {
			String mac = it.next();
			int campioni = statService.countAutoMacroregio(mac);
			for (int i=0; i<admix.length; i++) {
				valori[i] = statService.countSumAdmixMacroregio(admix[i], mac);
			}
			Autosomal daje = new Autosomal(mac,campioni,valori[0],valori[1],valori[2],valori[3],valori[4],valori[5],valori[6],valori[7],valori[8]);
	    	statService.save(daje);
		}		
		List<Autosomal> auto = statService.findAllAutosomal();
		model.addAttribute("auto",auto);
        return "autosomal";
    }
    
    @RequestMapping(value = "/aggiornaAploMtdnaMacroregioni", method = RequestMethod.GET)
    public String aggiornaAploMtdnaMacroregioni(Model model) throws IOException, IllegalArgumentException, IllegalAccessException {
    	
    	statService.deleteAllTableMtdna();
		List<String> aplog = mtdnaService.getAplogruppi();
		List<String> macroregioni = mtdnaService.getMacroregioni();
		Collections.sort(macroregioni);
		double[] campi = new double[aplog.size()];
		Iterator<String> iterReg = macroregioni.iterator();
		while (iterReg.hasNext()) {
			String macroreg = iterReg.next();
			Iterator<String> iterAplo = aplog.iterator();
			int ciclo = 0;
			int campioni = 0;
	    	while (iterAplo.hasNext()) {
	    		int ap;
	    		String apl = iterAplo.next();
	    		
	    		ap = statService.countAploMtdnaMacroRegio(apl, macroreg);
	        	double tot = statService.countMacroRegio(macroreg);
	        	campioni = (int) tot;
	        	tot = ap/tot*10000;
	        	tot = (int)tot;
	        	tot /= 100;
	        	campi[ciclo] = tot;
	        	ciclo++;
	    	}
	    	TableMtdna all = new TableMtdna(macroreg, campioni, campi);
	    	statService.save(all);
		}		
		
    	List<TableMtdna> mtdnaMacroreg = statService.findAllMtdnaMacroreg();
    	
    	Iterator<TableMtdna> it = mtdnaMacroreg.iterator();
    	
    	List<PieChartData> listPcd = new ArrayList<PieChartData>();
    	while (it.hasNext()) {
    		TableMtdna tm = it.next();
    		if (tm.getCampioni() > 5) {
	    		List<FrequenzeMtdna> listFm = new ArrayList<FrequenzeMtdna>();
	    		for(Field f : tm.getClass().getDeclaredFields()) {
	    			if (!f.getName().equals("macroregione") && !f.getName().equals("campioni"))
	    				listFm.add(new FrequenzeMtdna(f.getName(),(double) f.get(tm)));
	    		}
	    		listPcd.add(new PieChartData(tm.getMacroregione(), tm.getCampioni(), listFm));
    		}
    	}
    	Iterator<PieChartData> itPie = listPcd.iterator();
    	while (itPie.hasNext()) {
    		Grafico.create(itPie.next());
    	}
        return "aploMtdnaMacroregioni";
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
				EmailUtility.sendEmail("smtp.gmail.com", "587", "daniele.pisano90@gmail.com", "zwpwhxoldjicegmj", "admin@ethnopedia.info", "Dichiarazione dei nonni", content);
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
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
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
    	Eutest eutest = new Eutest();
    	UserDati userDati = userDatiService.findByCognomeAndNome(user.getCognome(), user.getNome());
    	String infoaplo = null;
    	String infoclade = null;
    	if (userDati != null) {
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
        	}
    	}
    	model.addAttribute("ydna", ydna);
    	model.addAttribute("mtdna", mtdna);
    	model.addAttribute("infoaplo", infoaplo);
    	model.addAttribute("infoclade", infoclade);
    	model.addAttribute("userDati", userDati);
    	model.addAttribute("eutest", eutest);
        return "welcome";
    }
}

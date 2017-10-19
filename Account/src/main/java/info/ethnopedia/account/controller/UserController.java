package info.ethnopedia.account.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import info.ethnopedia.account.model.Altezza;
import info.ethnopedia.account.model.AncientYdna;
import info.ethnopedia.account.model.Autosomal;
import info.ethnopedia.account.model.AutosomalPuri;
import info.ethnopedia.account.model.CladeFreqRegionali;
import info.ethnopedia.account.model.CladiAplo;
import info.ethnopedia.account.model.Eutest;
import info.ethnopedia.account.model.EutestPlebe;
import info.ethnopedia.account.model.EutestPuri;
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
import info.ethnopedia.account.utility.Grafico;
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
    
    @RequestMapping(value = "/getCladiByAploForAdna", method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<CladiAplo> getCladiByAploForAdna(@RequestParam("aplo") String aplo) {
        return ydnaService.getCladiByAploForAdna(aplo);
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
    	
    	return "admin";
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
        	UserDati ud = new UserDati(ydna.getYdnaId().getCognome(), ydna.getNome(), "maschio", true);
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
    	
    	MtdnaBozza mb = bozzaService.findMtdnaBozzaById(idBozza);
    	UserDati ud = userDatiService.findByCognomeAndNome(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome());
    	if (ud == null) {
    		ud = new UserDati(mtdna.getMtdnaId().getCognome(),mtdna.getMtdnaId().getNome(), null, mb.getSesso(), mb.getNascita(), true, null);
    		userDatiService.save(ud);
    	}
    	mtdna.setId(ud.getId());
    	mtdnaService.save(mtdna);
    	
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
    	String closestPop = calcolaClosestPop(eutestPlebe);
    	
		model.addAttribute("ydna", ydna);
		model.addAttribute("mtdna", mtdna);
		model.addAttribute("userDati", userDati);
		model.addAttribute("eutest", eutest);
		model.addAttribute("closestPop", closestPop);
    	
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
    	String closestPop = calcolaClosestPop(eutestPlebe);
    	String pureClosestPop = calcolaPureClosestPop(eutestPlebe);
    	
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
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
    	List<YdnaBozza> yb = bozzaService.findAllYdna();
    	List<MtdnaBozza> mb = bozzaService.findAllMtdna();
    	model.addAttribute("ydnaBozza", yb);
    	model.addAttribute("mtdnaBozza", mb);
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
    
    @RequestMapping(value = "/autosomalPuri", method = RequestMethod.GET)
    public String autosomalPuri(Model model) {
    	List<AutosomalPuri> auto = statService.findAllAutosomalPuri();
		model.addAttribute("auto",auto);
        return "autosomalPuri";
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
    
    @RequestMapping(value = "/aggiornaAutosomalPuri", method = RequestMethod.GET)
    public String aggiornaAutosomalPuri(Model model) throws IOException, IllegalArgumentException, IllegalAccessException {
    	statService.deleteAllAutosomalPuri();
    	String[] admix = new String[] {"baltic","nordic","atlantic","westmed","eastmed","westasian","mena","asian","ssa"};
		List<String> regioni = statService.getRegioniAutosomalPuri();
		Collections.sort(regioni);
		
		Double[] valori = new Double[9];
		Iterator<String> it = regioni.iterator();
		while (it.hasNext()) {
			String reg = it.next();
			int campioni = statService.countAutoRegio(reg);
			for (int i=0; i<admix.length; i++) {
				valori[i] = statService.countSumAdmixRegio(admix[i], reg);
			}
			AutosomalPuri daje = new AutosomalPuri(reg,campioni,valori[0],valori[1],valori[2],valori[3],valori[4],valori[5],valori[6],valori[7],valori[8]);
	    	statService.save(daje);
		}		
		List<AutosomalPuri> auto = statService.findAllAutosomalPuri();
		model.addAttribute("auto",auto);
        return "autosomalPuri";
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
    	    		closestPop = calcolaClosestPop(eutest);
    	    		pureClosestPop = calcolaPureClosestPop(eutest);
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

	private String calcolaClosestPop(EutestPlebe e) {
		int nordovest,nordest,centro,sud,sicilia,sardegna;
		nordovest=nordest=centro=sud=sicilia=sardegna=0;
		
		List<Autosomal> atList = statService.findAllAutosomal();
    	double[] percent = new double [] {e.getBaltic()+e.getEasteuro(),e.getNorthcentraleuro(),e.getAtlantic(),e.getWestmed(),e.getEastmed(),e.getWestasian(),e.getMiddleastern(),e.getSouthasian()+e.getEastasian()+e.getSiberian(),e.getWestafrican()+e.getEastafrican()};
    	for (int i=0; i<9; i++) {
    		List<String> res = closest(percent[i], i, atList);
    		Iterator<String> it = res.iterator();
    		while(it.hasNext()) {
	    		switch(it.next()) {
		    		case "centro":
		    			centro++;
		    			break;
		    		case "nordest":
		    			nordest++;
		    			break;
		    		case "nordovest":
		    			nordovest++;
		    			break;
		    		case "sardegna":
		    			sardegna++;
		    			break;
		    		case "sicilia":
		    			sicilia++;
		    			break;
		    		case "sud":
		    			sud++;
		    			break;
	    		}  
    		}
    	}
		
		return calcola(nordovest,nordest,centro,sud,sicilia,sardegna);
	}
	
	public List<String> closest(double of, int admixture, List<Autosomal> in) {
	    double min = Double.MAX_VALUE;
	    List<String> result = new ArrayList<String>();
	    String riserva="";
	    Iterator<Autosomal> it = in.iterator();
	    while (it.hasNext()) {
	    	Autosomal at = it.next();
	    	if (!at.getMacroregione().equals("Svizzera")) {
		    	double diff = 0;
		    	switch(admixture) {
		    		case 0:
			    		diff = Math.abs(at.getBaltic() - of);
			    		break;
		    		case 1:
		    			diff = Math.abs(at.getNordic() - of);
			    		break;
		    		case 2:
		    			diff = Math.abs(at.getAtlantic() - of);
			    		break;
		    		case 3:
		    			diff = Math.abs(at.getWestmed() - of);
			    		break;
		    		case 4:
		    			diff = Math.abs(at.getEastmed() - of);
			    		break;
		    		case 5:
		    			diff = Math.abs(at.getWestasian() - of);
			    		break;
		    		case 6:
		    			diff = Math.abs(at.getMena() - of);
			    		break;
		    		case 7:
		    			diff = Math.abs(at.getAsian() - of);
			    		break;
		    		case 8:
		    			diff = Math.abs(at.getSsa() - of);
			    		break;		    	
		    	}
		    	if (diff < min) {
				    min = diff;		
				    riserva = at.getMacroregione();
		    	}
		    	if (admixture != 7 && admixture != 8 && diff < 1)
		    		result.add(at.getMacroregione());
	    	}
	    }
	    if (result.isEmpty() && admixture != 7)
    		result.add(riserva);
	    return result;
	}

	private String calcola(int nordovest, int nordest, int centro, int sud, int sicilia, int sardegna) {
		int max = max(new int[]{nordovest,nordest,centro,sud,sicilia,sardegna});
		String risp = "";
		if (nordovest==max)
			risp += "gli italiani nordoccidentali, ";
		if (nordest==max)
			risp += "gli italiani nordorientali, ";
		if (centro==max)
			risp += "gli italiani centrali, ";
		if (sud==max)
			risp += "gli italiani meridionali, ";
		if (sicilia==max)
			risp += "i siciliani, ";
		if (sardegna==max)
			risp += "i sardi, ";
		return risp.substring(0, risp.length()-2);
	}

	private int max(int[]val) {
		for (int i=1; i<6; i++) 
			if(val[0] < val[i])
				val[0] = val[i];
		return val[0];
	}
	
	private String calcolaPureClosestPop(EutestPlebe e) {
		int ticino,valledaosta,piemonte,liguria,lombardia,veneto,trentino,friuli,emilia,toscana,umbria,marche,lazio,abruzzo,molise,campania,puglia,basilicata,calabria,sicilia,sardegna;

		ticino=valledaosta=piemonte=liguria=lombardia=veneto=trentino=friuli=emilia=toscana=umbria=marche=lazio=abruzzo=molise=campania=puglia=basilicata=calabria=sicilia=sardegna=0;
		
		List<AutosomalPuri> atList = statService.findAllAutosomalPuri();
    	double[] percent = new double [] {e.getBaltic()+e.getEasteuro(),e.getNorthcentraleuro(),e.getAtlantic(),e.getWestmed(),e.getEastmed(),e.getWestasian(),e.getMiddleastern(),e.getSouthasian()+e.getEastasian()+e.getSiberian(),e.getWestafrican()+e.getEastafrican()};
    	for (int i=0; i<9; i++) {
    		List<String> res = closestPuro(percent[i], i, atList);
    		Iterator<String> it = res.iterator();
    		while(it.hasNext()) {
	    		switch(it.next()) {
		    		case "Ticino":
		    			ticino++;
		    			break;
		    		case "Valle d'Aosta":
		    			valledaosta++;
		    			break;
		    		case "Piemonte":
		    			piemonte++;
		    			break;
		    		case "Liguria":
		    			liguria++;
		    			break;
		    		case "Lombardia":
		    			lombardia++;
		    			break;
		    		case "Veneto":
		    			veneto++;
		    			break;
		    		case "Trentino - Alto Adige":
		    			trentino++;
		    			break;
		    		case "Friuli - Venezia Giulia":
		    			friuli++;
		    			break;
		    		case "Emilia - Romagna":
		    			emilia++;
		    			break;
		    		case "Toscana":
		    			toscana++;
		    			break;
		    		case "Umbria":
		    			umbria++;
		    			break;
		    		case "Marche":
		    			marche++;
		    			break;
		    		case "Lazio":
		    			lazio++;
		    			break;
		    		case "Abruzzo":
		    			abruzzo++;
		    			break;
		    		case "Molise":
		    			molise++;
		    			break;
		    		case "Campania":
		    			campania++;
		    			break;
		    		case "Puglia":
		    			puglia++;
		    			break;
		    		case "Basilicata":
		    			basilicata++;
		    			break;
		    		case "Calabria":
		    			calabria++;
		    			break;
		    		case "Sicilia":
		    			sicilia++;
		    			break;
		    		case "Sardegna":
		    			sardegna++;
		    			break;
	    		}  
    		}
    	}
		
		return calcolaPuro(ticino,valledaosta,piemonte,liguria,lombardia,veneto,trentino,friuli,emilia,toscana,umbria,marche,lazio,abruzzo,molise,campania,puglia,basilicata,calabria,sicilia,sardegna);
	}
	
	public List<String> closestPuro(double of, int admixture, List<AutosomalPuri> in) {
	    double min = Double.MAX_VALUE;
	    List<String> result = new ArrayList<String>();
	    String riserva="";
	    Iterator<AutosomalPuri> it = in.iterator();
	    while (it.hasNext()) {
	    	AutosomalPuri at = it.next();
		    double diff = 0;
		    switch(admixture) {
		    	case 0:
			   		diff = Math.abs(at.getBaltic() - of);
			   		break;
		    	case 1:
		    		diff = Math.abs(at.getNordic() - of);
			   		break;
		    	case 2:
		    		diff = Math.abs(at.getAtlantic() - of);
			   		break;
		    	case 3:
		    		diff = Math.abs(at.getWestmed() - of);
			   		break;
		    	case 4:
		    		diff = Math.abs(at.getEastmed() - of);
			   		break;
		    	case 5:
		    		diff = Math.abs(at.getWestasian() - of);
			   		break;
		    	case 6:
		    		diff = Math.abs(at.getMena() - of);
			   		break;
		    	case 7:
		    		diff = Math.abs(at.getAsian() - of);
			   		break;
		    	case 8:
		    		diff = Math.abs(at.getSsa() - of);
			   		break;		    	
		    }
		    if (diff < min) {
			    min = diff;		
			    riserva = at.getRegione();
		    }
		    if (admixture != 7 && admixture != 8 && diff < 1)
		    	result.add(at.getRegione());
	    }
	    if (result.isEmpty() && admixture != 7)
    		result.add(riserva);
	    return result;
	}
	
	private String calcolaPuro(int ticino, int valledaosta, int piemonte, int liguria, int lombardia, int veneto, int trentino, int friuli, int emilia, int toscana, int umbria, int marche, int lazio, int abruzzo, int molise, int campania, int puglia, int basilicata, int calabria, int sicilia, int sardegna) {
		int max = maxPuro(new int[]{ticino,valledaosta,piemonte,liguria,lombardia,veneto,trentino,friuli,emilia,toscana,umbria,marche,lazio,abruzzo,molise,campania,puglia,basilicata,calabria,sicilia,sardegna});
		String risp = "";
		if (ticino==max)
			risp += "i ticinesi, ";
		if (valledaosta==max)
			risp += "i valdostani, ";
		if (piemonte==max)
			risp += "i piemontesi, ";
		if (liguria==max)
			risp += "i liguri, ";
		if (lombardia==max)
			risp += "i lombardi, ";
		if (veneto==max)
			risp += "i veneti, ";
		if (trentino==max)
			risp += "i trentini e gli altoatesini, ";
		if (friuli==max)
			risp += "i friulani, ";
		if (emilia==max)
			risp += "gli emiliani e i romagnoli, ";
		if (toscana==max)
			risp += "i toscani, ";
		if (umbria==max)
			risp += "gli umbri, ";
		if (marche==max)
			risp += "i marchigiani, ";
		if (lazio==max)
			risp += "i laziali, ";
		if (abruzzo==max)
			risp += "gli abruzzesi, ";
		if (molise==max)
			risp += "i molisani, ";
		if (campania==max)
			risp += "i campani, ";
		if (puglia==max)
			risp += "i pugliesi, ";
		if (basilicata==max)
			risp += "i lucani, ";
		if (calabria==max)
			risp += "i calabresi, ";
		if (sicilia==max)
			risp += "i siciliani, ";
		if (sardegna==max)
			risp += "i sardi, ";
		return risp.substring(0, risp.length()-2);
	}
	
	private int maxPuro(int[]val) {
		for (int i=1; i<21; i++) 
			if(val[0] < val[i])
				val[0] = val[i];
		return val[0];
	}
}

package info.ethnopedia.account.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import info.ethnopedia.account.model.Autosomal;
import info.ethnopedia.account.model.AutosomalPuri;
import info.ethnopedia.account.model.CladeFreqRegionali;
import info.ethnopedia.account.model.Frequenza;
import info.ethnopedia.account.model.TableYdna;
import info.ethnopedia.account.model.User;
import info.ethnopedia.account.service.StatisticheService;
import info.ethnopedia.account.service.UserService;
import info.ethnopedia.account.service.YdnaService;

@Controller
public class StatisticheController {
	
	@Autowired
    private StatisticheService statService;
    
    @Autowired
    private YdnaService ydnaService;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/aploRegioni", method = RequestMethod.GET)
    public String aploRegioni(Model model) {
    	List<TableYdna> ydnaReg = statService.findAll();
		model.addAttribute("ydnaReg",ydnaReg);
		model.addAttribute("provincia",false);
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
        return "aploRegioni";
    }
    
    @RequestMapping(value = "/autosomal", method = RequestMethod.GET)
    public String autosomal(Model model) {
    	List<Autosomal> auto = statService.findAllAutosomal();
		model.addAttribute("auto",auto);
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
        return "autosomal";
    }
    
    @RequestMapping(value = "/autosomalPuri", method = RequestMethod.GET)
    public String autosomalPuri(Model model) {
    	List<AutosomalPuri> auto = statService.findAllAutosomalPuri();
		model.addAttribute("auto",auto);
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
        return "autosomalPuri";
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
    
    @RequestMapping(value = "/calcMediaAploRegioni", method=RequestMethod.GET)
    public String calcMediaAploRegioni(Model model) {
		
    	statService.aggiornaMedieYdnaRegionali();

		List<TableYdna> ydnaReg = statService.findAll();
		model.addAttribute("ydnaReg",ydnaReg);
		model.addAttribute("provincia",false);
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
		return "aploRegioni";
    }
    
    @RequestMapping(value = "/aggiornaYdnaProvinceConPiuDi10Campioni", method = RequestMethod.GET)
    public String aggiornaYdnaProvinceConPiuDi10Campioni(Model model) throws IOException, IllegalArgumentException, IllegalAccessException {
    	statService.deleteAllTableYdna();
		List<String> aplog = Arrays.asList("E1b1b", "G2a", "I1", "I2", "J1", "J2", "R1a", "R1b", "T");
		List<String> province = statService.getProvinceConPiuCampioni();
		Collections.sort(province);
		double[] campi = new double[9];
		Iterator<String> iterProv = province.iterator();
		while (iterProv.hasNext()) {
			String prov = iterProv.next();
			int campioni = statService.countProv(prov);
			Iterator<String> iterAplo = aplog.iterator();
			int ciclo = 0;
	    	while (iterAplo.hasNext()) {
	    		double ap;
	    		String apl = iterAplo.next();
	    		if (apl.equals("G2a"))
	    			ap = statService.countAploGProv(prov);
	    		else
	    			ap = statService.countAploProv(apl,prov);
	        	double tot = ap/campioni*10000;
	        	tot = (int)tot;
	        	tot /= 100;
	        	campi[ciclo] = tot;
	        	ciclo++;
	    	}
	    	TableYdna all = new TableYdna(prov, campioni, campi);
	    	statService.save(all);
		}		
		List<TableYdna> ydnaProv = statService.findAll();
		model.addAttribute("ydnaReg",ydnaProv);
		model.addAttribute("provincia",true);
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
		return "aploRegioni";
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
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
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
		
		String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
        return "autosomalPuri";
    }
    
    /* 
     * il metodo sottostante è da rimuovere se non ci sono stati problemi finora 
     * riguardo l'aggiornamento delle medie mtDNA e dei grafici
     * a seguito di ogni inserimento di aplogruppo mtDNA
    */
    
    @RequestMapping(value = "/aggiornaAploMtdnaMacroregioni", method = RequestMethod.GET)
    public String aggiornaAploMtdnaMacroregioni(Model model) throws IOException, IllegalArgumentException, IllegalAccessException {
    	
    	statService.aggiornaMedieMtdnaMacroregionali();
		
    	statService.aggiornaGraficoTortaMtdna();
    	
    	String nome = SecurityContextHolder.getContext().getAuthentication().getName();
    	User user = userService.findByUsername(nome);
    	model.addAttribute("user",user);
        return "aploMtdnaMacroregioni";
    }
    
}

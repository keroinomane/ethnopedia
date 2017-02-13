package info.ethnopedia.account.web;

import org.apache.commons.lang.StringUtils;

public class VerifyAplo {
	
	public static boolean isOk(String test, String rawdata, String aplo, String clade) {
		if (test.equals("geno")) {
			return (				
					(aplo.equals("e") && StringUtils.contains(rawdata, "M96,Y,G,G") && StringUtils.contains(rawdata, clade)) ||
					(aplo.equals("g") && StringUtils.contains(rawdata, "M201,Y,T,T") && StringUtils.contains(rawdata, clade)) ||
					(aplo.equals("i") && StringUtils.contains(rawdata, "M170,Y,C,C") && StringUtils.contains(rawdata, clade)) || //OK
					(aplo.equals("j") && (StringUtils.contains(rawdata, "CTS687,Y,A,A") || StringUtils.contains(rawdata, "M267,Y,G,G")) && StringUtils.contains(rawdata, clade)) || //OK
					(aplo.equals("r") && StringUtils.contains(rawdata, "M207,Y,G,G") && StringUtils.contains(rawdata, clade)) || //OK
					(aplo.equals("t") && StringUtils.contains(rawdata, "M70,Y,C,C") && StringUtils.contains(rawdata, clade))
			);
		} else if (test.equals("genoNext")) {
			return (				
					(aplo.equals("e") && StringUtils.contains(rawdata, "\"P29\",\"Y\",\"CC\"") && StringUtils.contains(rawdata, clade)) ||
					(aplo.equals("g") && StringUtils.contains(rawdata, "\"M201\",\"Y\",\"TT\"") && StringUtils.contains(rawdata, clade)) ||
					(aplo.equals("i") && StringUtils.contains(rawdata, "\"L846\",\"Y\",\"TT\"") && StringUtils.contains(rawdata, clade)) ||
					(aplo.equals("j") && StringUtils.contains(rawdata, "\"CTS687\",\"Y\",\"AA\"") && StringUtils.contains(rawdata, clade)) ||
					(aplo.equals("r") && StringUtils.contains(rawdata, "\"M207\",\"Y\",\"GG\"") && StringUtils.contains(rawdata, clade)) ||
					(aplo.equals("t") && StringUtils.contains(rawdata, "\"M70\",\"Y\",\"CC\"") && StringUtils.contains(rawdata, clade)) 
			);
		} else {
			// 23andMe
			return (															
					(aplo.equals("e1b1b") && StringUtils.contains(rawdata, "rs2032654	Y	15467824	G")) ||
					(aplo.equals("g2a") && StringUtils.contains(rawdata, "rs4116820	Y	22072097	T")) ||
					(aplo.equals("i1") && StringUtils.contains(rawdata, "rs9341296	Y	15022707	T")) ||
					(aplo.equals("i2") && StringUtils.contains(rawdata, "rs17307294	Y	16638804	G")) ||
					(aplo.equals("j1") && StringUtils.contains(rawdata, "rs9341313	Y	22741818	G")) ||
					(aplo.equals("j2") && StringUtils.contains(rawdata, "rs2032604	Y	14969634	G")) ||
					(aplo.equals("r1a") && StringUtils.contains(rawdata, "rs17307677	Y	18162834	C")) ||
					(aplo.equals("r1b") && StringUtils.contains(rawdata, "rs9785702	Y	18656508	C")) ||
					(aplo.equals("t") && StringUtils.contains(rawdata, "rs20320	Y	14898163	A"))
					
				);
		}
	}
}

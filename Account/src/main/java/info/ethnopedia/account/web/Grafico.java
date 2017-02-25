package info.ethnopedia.account.web;

import java.io.IOException;
import java.util.Iterator;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.ChartTheme;

import info.ethnopedia.account.model.FrequenzeMtdna;
import info.ethnopedia.account.model.PieChartData;

public class Grafico {
	
	public static void create(PieChartData pcd) throws IOException {
		
		String macroregione = null;
		switch (pcd.getMacroregione()) {
			case "nord":
				macroregione = "Italia settentrionale";
				break;
			case "centro":
				macroregione = "Italia centrale";
				break;
			case "sud":
				macroregione = "Italia meridionale";
				break;
			case "sicilia":
				macroregione = "Sicilia";
				break;
			case "sardegna":
				macroregione = "Sardegna";
				break;
		}
	    // Create Chart
	    PieChart chart = new PieChartBuilder().width(800).height(600).title(macroregione).theme(ChartTheme.GGPlot2).build();

	    // Customize Chart
	    chart.getStyler().setLegendVisible(false);
	    chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
	    chart.getStyler().setAnnotationDistance(1.15);
	    chart.getStyler().setPlotContentSize(.7);
	    chart.getStyler().setStartAngleInDegrees(90);

	    // Series
	    Iterator<FrequenzeMtdna> it = pcd.getFrequenzeMtdna().iterator();
	    while (it.hasNext()) {
	    	FrequenzeMtdna fm = it.next();
	    	String aplogruppo = null;
	    	if (fm.getAplogruppo().equals("h"))
	    		aplogruppo = "H*";
	    	else if (fm.getAplogruppo().equals("t"))
	    		aplogruppo = "T*";
	    	else
	    		aplogruppo = fm.getAplogruppo().toUpperCase();
	    	chart.addSeries(aplogruppo, fm.getPercentuale());
	    }

	    // or save it in high-res
	    BitmapEncoder.saveBitmapWithDPI(chart, "/nfs_home/ethno710/ethnopedia.info/html/account/resources/img/graficiMtdna/"+pcd.getMacroregione(), BitmapFormat.PNG, 100);
	  }
}

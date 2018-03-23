package br.com.flexvision.befd.flex4.dto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WrapperInfluxToSerie {

	private InfluxData influxData;
	
	public WrapperInfluxToSerie(InfluxData influxData) {
		this.influxData = influxData;
	}
	
	public List<Serie> toListSeries() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		
		List<Serie> listSeries = new ArrayList<Serie>();
		
		this.influxData.getResults().stream().forEach((result) -> {
			result.getSeries().stream().forEach((series) -> {
				series.getValues().stream().forEach((value) -> {
					Calendar cal = Calendar.getInstance();
					BigDecimal val = new BigDecimal(0);
					
					Object[] values = value.toArray();
					try {
						cal.setTime(sdf.parse(((String) values[0]).replaceAll("T", "").replaceAll("Z", "")));
					} catch (ParseException e) {
						cal = null;
					}
					try {
						val = new BigDecimal((String) values[1]);
					} catch (Exception e) {}
					listSeries.add(new Serie(cal, val));
				});
			});
		});
		
		return listSeries;
	}

}

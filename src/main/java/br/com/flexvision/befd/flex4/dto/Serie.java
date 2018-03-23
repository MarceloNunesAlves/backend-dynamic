package br.com.flexvision.befd.flex4.dto;

import java.math.BigDecimal;
import java.util.Calendar;

public class Serie {

	private Calendar time;
	private BigDecimal value;
	
	public Serie(Calendar time, BigDecimal value) {
		super();
		this.time = time;
		this.value = value;
	}
	
	public Calendar getTime() {
		return time;
	}
	public void setTime(Calendar time) {
		this.time = time;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}

	
}

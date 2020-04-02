package xml;

import java.time.LocalDate;

public class Bars {
	private String barname;
	private String SN;
	private float fett;
	private float energy;
	private float kolhydrat;
	private float protein;
	private float fiber;
	private String reviewer;

	// private LocalDate date;
	// private int score;
	public String getBarname() {
		return barname;
	}

	public void setBarname(String barname) {
		this.barname = barname;
	}

	public float getFett() {
		return fett;
	}

	public void setFett(float fett) {
		this.fett = fett;
	}

	public float getEnergy() {
		return energy;
	}

	public void setEnergy(float energy) {
		this.energy = energy;
	}

	public float getKolhydrat() {
		return kolhydrat;
	}

	public void setKolhydrat(float kolhydrat) {
		this.kolhydrat = kolhydrat;
	}

	public float getProtein() {
		return protein;
	}

	public void setProtein(float protein) {
		this.protein = protein;
	}

	public float getFiber() {
		return fiber;
	}

	public void setFiber(float fiber) {
		this.fiber = fiber;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		this.SN = sN;
	}

	
	
}

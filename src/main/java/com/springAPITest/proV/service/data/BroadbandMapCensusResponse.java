package com.springAPITest.proV.service.data;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "response")
public class BroadbandMapCensusResponse {
	@JsonProperty("geographyId")
	String geographyId;
	
	@JsonProperty("geographyName")
	String geographyName;
	
	@JsonProperty("landArea")
	double landArea;
	
	@JsonProperty("population")
	int population;
	
	@JsonProperty("households")
	double households;
	
	@JsonProperty("raceWhite")
	double raceWhite;
	
	@JsonProperty("raceBlack")
	double raceBlack;
	
	@JsonProperty("raceHispanic")
	double raceHispanic;
	
	@JsonProperty("raceAsian")
	double raceAsian;
	
	@JsonProperty("raceNativeAmerican")
	double raceNativeAmerican;
	
	@JsonProperty("incomeBelowPoverty")
	double incomeBelowPoverty;
	
	@JsonProperty("medianIncome")
	double medianIncome;
	
	@JsonProperty("incomeLessThan25")
	double incomeLessThan25;
	
	@JsonProperty("incomeBetween25to50")
	double incomeBetween25to50;
	
	@JsonProperty("incomeBetween50to100")
	double incomeBetween50to100;
	
	@JsonProperty("incomeBetween100to200")
	double incomeBetween100to200;
	
	@JsonProperty("incomeGreater200")
	double incomeGreater200;
	
	@JsonProperty("educationHighSchoolGraduate")
	double educationHighSchoolGraduate;
	
	@JsonProperty("educationBachelorOrGreater")
	double educationBachelorOrGreater;
	
	@JsonProperty("ageUnder5")
	double ageUnder5;
	
	@JsonProperty("ageBetween5to19")
	double ageBetween5to19;
	
	@JsonProperty("ageBetween20to34")
	double ageBetween20to34;
	
	@JsonProperty("ageBetween35to59")
	double ageBetween35to59;
	
	@JsonProperty("ageGreaterThan60")
	double ageGreaterThan60;
	
	@JsonProperty("myAreaIndicator")
	Boolean myAreaIndicator;

	public String getGeographyId() {
		return geographyId;
	}

	public void setGeographyId(String geographyId) {
		this.geographyId = geographyId;
	}

	public String getGeographyName() {
		return geographyName;
	}

	public void setGeographyName(String geographyName) {
		this.geographyName = geographyName;
	}

	public double getLandArea() {
		return landArea;
	}

	public void setLandArea(double landArea) {
		this.landArea = landArea;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public double getHouseholds() {
		return households;
	}

	public void setHouseholds(double households) {
		this.households = households;
	}

	public double getRaceWhite() {
		return raceWhite;
	}

	public void setRaceWhite(double raceWhite) {
		this.raceWhite = raceWhite;
	}

	public double getRaceBlack() {
		return raceBlack;
	}

	public void setRaceBlack(double raceBlack) {
		this.raceBlack = raceBlack;
	}

	public double getRaceHispanic() {
		return raceHispanic;
	}

	public void setRaceHispanic(double raceHispanic) {
		this.raceHispanic = raceHispanic;
	}

	public double getRaceAsian() {
		return raceAsian;
	}

	public void setRaceAsian(double raceAsian) {
		this.raceAsian = raceAsian;
	}

	public double getRaceNativeAmerican() {
		return raceNativeAmerican;
	}

	public void setRaceNativeAmerican(double raceNativeAmerican) {
		this.raceNativeAmerican = raceNativeAmerican;
	}

	public double getIncomeBelowPoverty() {
		return incomeBelowPoverty;
	}

	public void setIncomeBelowPoverty(double incomeBelowPoverty) {
		this.incomeBelowPoverty = incomeBelowPoverty;
	}

	public double getMedianIncome() {
		return medianIncome;
	}

	public void setMedianIncome(double medianIncome) {
		this.medianIncome = medianIncome;
	}

	public double getIncomeLessThan25() {
		return incomeLessThan25;
	}

	public void setIncomeLessThan25(double incomeLessThan25) {
		this.incomeLessThan25 = incomeLessThan25;
	}

	public double getIncomeBetween25to50() {
		return incomeBetween25to50;
	}

	public void setIncomeBetween25to50(double incomeBetween25to50) {
		this.incomeBetween25to50 = incomeBetween25to50;
	}

	public double getIncomeBetween50to100() {
		return incomeBetween50to100;
	}

	public void setIncomeBetween50to100(double incomeBetween50to100) {
		this.incomeBetween50to100 = incomeBetween50to100;
	}

	public double getIncomeBetween100to200() {
		return incomeBetween100to200;
	}

	public void setIncomeBetween100to200(double incomeBetween100to200) {
		this.incomeBetween100to200 = incomeBetween100to200;
	}

	public double getIncomeGreater200() {
		return incomeGreater200;
	}

	public void setIncomeGreater200(double incomeGreater200) {
		this.incomeGreater200 = incomeGreater200;
	}

	public double getEducationHighSchoolGraduate() {
		return educationHighSchoolGraduate;
	}

	public void setEducationHighSchoolGraduate(double educationHighSchoolGraduate) {
		this.educationHighSchoolGraduate = educationHighSchoolGraduate;
	}

	public double getEducationBachelorOrGreater() {
		return educationBachelorOrGreater;
	}

	public void setEducationBachelorOrGreater(double educationBachelorOrGreater) {
		this.educationBachelorOrGreater = educationBachelorOrGreater;
	}

	public double getAgeUnder5() {
		return ageUnder5;
	}

	public void setAgeUnder5(double ageUnder5) {
		this.ageUnder5 = ageUnder5;
	}

	public double getAgeBetween5to19() {
		return ageBetween5to19;
	}

	public void setAgeBetween5to19(double ageBetween5to19) {
		this.ageBetween5to19 = ageBetween5to19;
	}

	public double getAgeBetween20to34() {
		return ageBetween20to34;
	}

	public void setAgeBetween20to34(double ageBetween20to34) {
		this.ageBetween20to34 = ageBetween20to34;
	}

	public double getAgeBetween35to59() {
		return ageBetween35to59;
	}

	public void setAgeBetween35to59(double ageBetween35to59) {
		this.ageBetween35to59 = ageBetween35to59;
	}

	public double getAgeGreaterThan60() {
		return ageGreaterThan60;
	}

	public void setAgeGreaterThan60(double ageGreaterThan60) {
		this.ageGreaterThan60 = ageGreaterThan60;
	}

	public Boolean getMyAreaIndicator() {
		return myAreaIndicator;
	}

	public void setMyAreaIndicator(Boolean myAreaIndicator) {
		this.myAreaIndicator = myAreaIndicator;
	}
}

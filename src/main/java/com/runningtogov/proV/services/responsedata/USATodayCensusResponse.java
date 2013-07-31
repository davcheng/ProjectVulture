package com.runningtogov.proV.services.responsedata;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "response")
public class USATodayCensusResponse {
	@JsonProperty("Placename")
	String Placename;
	
	@JsonProperty("PlacenameFull")
    String PlacenameFull;
	
	@JsonProperty("FIPS")
    String FIPS;
	
	@JsonProperty("GNIS")
    String GNIS;
	
	@JsonProperty("StateAP")
    String StateAP;
	
	@JsonProperty("StatePostal")
    String StatePostal;
	
	@JsonProperty("PctChange")
    double PctChange;
	@JsonProperty("Pop")
    int Pop;
	
	@JsonProperty("PctHisp")
    double PctHisp;
    
	@JsonProperty("PctNonHisp")
    double PctNonHisp;
    
	@JsonProperty("PctWhite")
    double PctWhite;
	
	@JsonProperty("PctNonHispWhite")	
    double PctNonHispWhite;
	
	@JsonProperty("PctBlack")
    double PctBlack;
	
	@JsonProperty("PctAmInd")
    double PctAmInd;
    
	@JsonProperty("PctAsian")
    double PctAsian;
	
	@JsonProperty("PctNatHawOth")
    double PctNatHawOth;
	
	@JsonProperty("PctTwoOrMore")
    double PctTwoOrMore;
	
	@JsonProperty("PctOther")
    double PctOther;
	
	@JsonProperty("USATDiversityIndex")
    double USATDiversityIndex;
	
	@JsonProperty("PopSqMi")
    double PopSqMi;
	
	@JsonProperty("LandSqMi")
    double LandSqMi;
	
	@JsonProperty("WaterSqMi")
    double WaterSqMi;
	
	@JsonProperty("TotSqMi")
    double TotSqMi;
	
	@JsonProperty("Lat")
    double Lat;
	
	@JsonProperty("Long")
    double Long;
	
	@JsonProperty("HousingUnits")
    double HousingUnits;
	
	@JsonProperty("PctVacant")
    double PctVacant;
    
	public String getPlacename() {
		return Placename;
	}
	public void setPlacename(String placename) {
		Placename = placename;
	}
	public String getPlacenameFull() {
		return PlacenameFull;
	}
	public void setPlacenameFull(String placenameFull) {
		PlacenameFull = placenameFull;
	}
	public String getFIPS() {
		return FIPS;
	}
	public void setFIPS(String fIPS) {
		FIPS = fIPS;
	}
	public String getGNIS() {
		return GNIS;
	}
	public void setGNIS(String gNIS) {
		GNIS = gNIS;
	}
	public String getStateAP() {
		return StateAP;
	}
	public void setStateAP(String stateAP) {
		StateAP = stateAP;
	}
	public String getStatePostal() {
		return StatePostal;
	}
	public void setStatePostal(String statePostal) {
		StatePostal = statePostal;
	}
	public double getPctChange() {
		return PctChange;
	}
	public void setPctChange(double pctChange) {
		PctChange = pctChange;
	}
	public int getPop() {
		return Pop;
	}
	public void setPop(int pop) {
		Pop = pop;
	}
	public double getPctHisp() {
		return PctHisp;
	}
	public void setPctHisp(double pctHisp) {
		PctHisp = pctHisp;
	}
	public double getPctNonHisp() {
		return PctNonHisp;
	}
	public void setPctNonHisp(double pctNonHisp) {
		PctNonHisp = pctNonHisp;
	}
	public double getPctWhite() {
		return PctWhite;
	}
	public void setPctWhite(double pctWhite) {
		PctWhite = pctWhite;
	}
	public double getPctNonHispWhite() {
		return PctNonHispWhite;
	}
	public void setPctNonHispWhite(double pctNonHispWhite) {
		PctNonHispWhite = pctNonHispWhite;
	}
	public double getPctBlack() {
		return PctBlack;
	}
	public void setPctBlack(double pctBlack) {
		PctBlack = pctBlack;
	}
	public double getPctAmInd() {
		return PctAmInd;
	}
	public void setPctAmInd(double pctAmInd) {
		PctAmInd = pctAmInd;
	}
	public double getPctAsian() {
		return PctAsian;
	}
	public void setPctAsian(double pctAsian) {
		PctAsian = pctAsian;
	}
	public double getPctNatHawOth() {
		return PctNatHawOth;
	}
	public void setPctNatHawOth(double pctNatHawOth) {
		PctNatHawOth = pctNatHawOth;
	}
	public double getPctTwoOrMore() {
		return PctTwoOrMore;
	}
	public void setPctTwoOrMore(double pctTwoOrMore) {
		PctTwoOrMore = pctTwoOrMore;
	}
	public double getPctOther() {
		return PctOther;
	}
	public void setPctOther(double pctOther) {
		PctOther = pctOther;
	}
	public double getUSATDiversityIndex() {
		return USATDiversityIndex;
	}
	public void setUSATDiversityIndex(double uSATDiversityIndex) {
		USATDiversityIndex = uSATDiversityIndex;
	}
	public double getPopSqMi() {
		return PopSqMi;
	}
	public void setPopSqMi(double popSqMi) {
		PopSqMi = popSqMi;
	}
	public double getLandSqMi() {
		return LandSqMi;
	}
	public void setLandSqMi(double landSqMi) {
		LandSqMi = landSqMi;
	}
	public double getWaterSqMi() {
		return WaterSqMi;
	}
	public void setWaterSqMi(double waterSqMi) {
		WaterSqMi = waterSqMi;
	}
	public double getTotSqMi() {
		return TotSqMi;
	}
	public void setTotSqMi(double totSqMi) {
		TotSqMi = totSqMi;
	}
	public double getLat() {
		return Lat;
	}
	public void setLat(double lat) {
		Lat = lat;
	}
	public double getLong() {
		return Long;
	}
	public void setLong(double l) {
		Long = l;
	}
	public double getHousingUnits() {
		return HousingUnits;
	}
	public void setHousingUnits(double housingUnits) {
		HousingUnits = housingUnits;
	}
	public double getPctVacant() {
		return PctVacant;
	}
	public void setPctVacant(double pctVacant) {
		PctVacant = pctVacant;
	}
}

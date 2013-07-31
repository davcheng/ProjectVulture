/**
 * 
 */
package com.runningtogov.proV.services.responsedata;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;


/**
 * @author awsmdavid
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "response")
public class OpenSecretResponse {
	
	@JsonProperty("cand_name")
	private String cand_name;

	@JsonProperty("cid")
	private String cid;
	
	@JsonProperty("cycle")
	private String cycle;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("party")
	private String party;
	
	@JsonProperty("chamber")
	private String chamber;
	
	@JsonProperty("first_elected")
	private String first_elected;
	
	@JsonProperty("next_election")
	private String next_election;
	
	@JsonProperty("total")
	private String total;
	
	@JsonProperty("spent")
	private String spent;
	
	@JsonProperty("cash_on_hand")
	private String cash_on_hand;
	
	@JsonProperty("debt")
	private String debt;
	
	@JsonProperty("origin")
	private String origin;
	
	@JsonProperty("source")
	private String source;
	
	@JsonProperty("last_updated")
	private String last_updated;

	public String getCand_name() {
		return cand_name;
	}
	public void setCand_name(String cand_name) {
		this.cand_name = cand_name;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCycle() {
		return cycle;
	}
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getChamber() {
		return chamber;
	}
	public void setChamber(String chamber) {
		this.chamber = chamber;
	}
	public String getFirst_elected() {
		return first_elected;
	}
	public void setFirst_elected(String first_elected) {
		this.first_elected = first_elected;
	}
	public String getNext_election() {
		return next_election;
	}
	public void setNext_election(String next_election) {
		this.next_election = next_election;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getSpent() {
		return spent;
	}
	public void setSpent(String spent) {
		this.spent = spent;
	}
	public String getCash_on_hand() {
		return cash_on_hand;
	}
	public void setCash_on_hand(String cash_on_hand) {
		this.cash_on_hand = cash_on_hand;
	}
	public String getDebt() {
		return debt;
	}
	public void setDebt(String debt) {
		this.debt = debt;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
}

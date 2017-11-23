/*
 * 
 */
package edu.sjsu.cmpe275.lab2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
@Entity
public class Player {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** The firstname. */
	private String firstname;

	/** The lastname. */
	private String lastname;

	/** The email. */
	@Column(unique=true)
	private String email;

	/** The description. */
	private String description;

	/** The street. */
	private String street;

	/** The city. */
	private String city;

	/** The state. */
	private String state;

	/** The zip. */
	private String zip;

	/** The opponents. */
	@JsonIgnoreProperties({"opponents"})
	@ManyToMany(cascade = CascadeType.REMOVE)
    @JoinTable(name = "player_opponents")
    @JoinColumns ({ @JoinColumn(name = "player_id", referencedColumnName="id"), @JoinColumn(name = "opponent_id", referencedColumnName="id") })
	private Set<Player> opponents = new HashSet<Player>();
	

	/**
	 * Gets the opponents.
	 *
	 * @return the opponents
	 */
	public Set<Player> getOpponents() {
		return opponents;
	}

	/**
	 * Sets the opponents.
	 *
	 * @param opponents the new opponents
	 */
	public void setOpponents(Set<Player> opponents) {
		this.opponents = opponents;
	}

	/** The sponsor. */
	@OneToOne()
	private Sponsor sponsor;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the street.
	 *
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets the street.
	 *
	 * @param street the new street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the zip.
	 *
	 * @param zip the new zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the sponsor.
	 *
	 * @return the sponsor
	 */
	public Sponsor getSponsor() {
		return sponsor;
	}

	/**
	 * Sets the sponsor.
	 *
	 * @param sponsor the new sponsor
	 */
	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

}

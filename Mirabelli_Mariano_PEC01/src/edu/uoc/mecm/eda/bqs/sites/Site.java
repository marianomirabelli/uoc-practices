package edu.uoc.mecm.eda.bqs.sites;

import java.net.URL;
import java.util.Date;

/**
 * Esta clase modela el Tipo Abstracto de Datos (TAD) Sede
 * @author Carles Pairot Gavaldà
 *
 */
public class Site {
	
	/**
	 * El identificador de la Sede
	 */
	private int id = 0;
	
	/**
	 * El nombre de la Sede
	 */
	private String name = "";
	
	/**
	 * La descripción de la Sede
	 */
	private String description = "";
	
	/**
	 * Dirección de la Sede
	 */
	private String address = "";
	
	/**
	 * Fecha de alta de la Sede
	 */
	private Date iniDate = null;
	
	/**
	 * Dispone o no de homologación
	 */
	private boolean homologation = false;
	
	/**
	 * Dirección URL de los planos
	 */
	private URL blueprintsUrl = null;

	/**
	 * Devuelve el identificador de la Sede
	 * @return el identificador de la Sede
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador de la Sede
	 * @param id el identificador de la Sede
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre de la Sede
	 * @return el nombre de la Sede
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre de la Sede
	 * @param name el nombre de la Sede
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Devuelve la descripción de la Sede
	 * @return la descripción de la Sede
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripción de la Sede
	 * @param description la descripción de la Sede
	 */
	public void setDescription (String description) {
		this.description = description;
	}

	/**
	 * Devuelve la dirección de la Sede
	 * @return la dirección de la Sede
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Establece la dirección de la Sede
	 * @param address la dirección de la Sede
	 */
	public void setAddress (String address) {
		this.address = address;
	}

	/**
	 * Devuelve la fecha de alta de la Sede
	 * @return la fecha de alta de la Sede
	 */
	public Date getIniDate() {
		return iniDate;
	}

	/**
	 * Establece la fecha de alta de la Sede
	 * @param iniDate la fecha de alta de la Sede
	 */
	public void setIniDate (Date iniDate) {
		this.iniDate = iniDate;
	}

	/**
	 * Devuelve si dispone de homologación o no
	 * @return si dispone de homologación o no
	 */
	public boolean isHomologation() {
		return homologation;
	}

	/**
	 * Establece si dispone de homologación o no
	 * @param generateExp si dispone de homologación o no
	 */
	public void setHomologation (boolean homologation) {
		this.homologation = homologation;
	}

	/**
	 * Devuelve la URL de los planos de la Sede
	 * @return la URL de los planos de la Sede
	 */
	public URL getBlueprintsUrl() {
		return blueprintsUrl;
	}

	/**
	 * Establece la URL de los planos de la Sede
	 * @param modelUrl la URL de los planos de la Sede
	 */
	public void setBlueprintsUrl (URL blueprintsUrl) {
		this.blueprintsUrl = blueprintsUrl;
	}


	/**
	 * Inicializa una Sede
	 * @param id el identificador de la Sede
	 * @param name el nombre de la Sede
	 * @param description la descripción de la Sede
	 * @param owner la dirección de la Sede
	 * @param iniDate la fecha de alta de la Sede
	 * @param generateExp si dispone de homologación o no
	 * @param modelUrl la URL de los planos de la Sede
	 */
	public Site (int id, String name, String description, String address, Date iniDate, boolean homologation,
			URL blueprintsUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.address = address;
		this.iniDate = iniDate;
		this.homologation = homologation;
		this.blueprintsUrl = blueprintsUrl;
	}
	
	public Site() { }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Site site = (Site) o;

		if (id != site.id) return false;
		if (homologation != site.homologation) return false;
		if (name != null ? !name.equals(site.name) : site.name != null) return false;
		if (description != null ? !description.equals(site.description) : site.description != null) return false;
		if (address != null ? !address.equals(site.address) : site.address != null) return false;
		if (iniDate != null ? !iniDate.equals(site.iniDate) : site.iniDate != null) return false;
		return blueprintsUrl != null ? blueprintsUrl.equals(site.blueprintsUrl) : site.blueprintsUrl == null;
	}


	@Override
	public String toString() {
		return "{[id : " + this.id + "][name: " + this.name + "][description: " + this.description + "][iniDate: " + this.iniDate + "][address: " + this.address + "][isHomologation: " + this.isHomologation() + "][blueprintsURL: " + this.blueprintsUrl + "]}";  
	}
}

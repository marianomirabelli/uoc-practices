package edu.uoc.mecm.eda.bqs.sites;

/**
 * Esta clase modela un objeto asociado a una Sede
 * @author Carles Pairot Gavaldà
 *
 */
public class SiteObject {
	
	/**
	 * Identificador de la sede
	 */
	private int siteId = 0;
	
	/**
	 * Nombre del objeto
	 */
	private String name = "";
	
	/**
	 * Descripción del objeto
	 */
	private String description = "";
	
	/**
	 * Tipo del objeto
	 */
	private ObjectType type = null;

	/**
	 * Devuelve el identificador de la sede a la cual está asociado este objeto
	 * @return el identificador de la sede
	 */
	public int getSiteId() {
		return siteId;
	}

	/**
	 * Establece el identificador de la sede a la que asociar este objeto
	 * @param modelId el identificador de la sede
	 */
	public void setSiteId (int siteId) {
		this.siteId = siteId;
	}

	/**
	 * Devuelve el nombre del objeto
	 * @return el nombre del objeto
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del objeto
	 * @param name el nombre del objeto
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	/**
	 * Devuelve la descripción del objeto
	 * @return la descripción del objeto
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Establece la descripción del objeto
	 * @param description la descripción del objeto
	 */
	public void setDescription (String description) {
		this.description = description;
	}

	/**
	 * Devuelve el tipo del objeto
	 * @return el tipo del objeto
	 */
	public ObjectType getType() {
		return type;
	}

	/**
	 * Establece el tipo del objeto
	 * @param type el tipo del objeto
	 */
	public void setType (ObjectType type) {
		this.type = type;
	}

	/**
	 * Inicializa un objeto
	 * @param siteId el identificador de la sede
	 * @param name el nombre del objeto
	 * @param description la descripción del objeto
	 * @param type el tipo del objeto
	 */
	public SiteObject (int siteId, String name, String description, ObjectType type) {
		this.siteId = siteId;
		this.name = name;
		this.description = description;
		this.type = type;
	}
	
	public SiteObject() { }
}

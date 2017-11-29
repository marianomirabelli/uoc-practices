package edu.uoc.mecm.eda.bqs.sites;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Tipo Abstracto de Datos que permite almacenar Sedes
 * @author Carles Pairot Gavaldà
 *
 */
public class SiteList {

	private List<Site> sites;


	public SiteList(){
		this.sites = new ArrayList<Site>();
	}


	/**
	 * Método que añade una sede al almacén de sedes
	 * @param s la sede a añadir
	 */
	public void addSite (Site s) {
		if (s != null) {
			this.sites.add(s);
		}
	}
	
	/**
	 * Método que elimina una sede del almacén de sedes
	 * @param siteId el identificador de la sede a eliminar
	 */
	public void removeSite (int siteId) {
		Site lookedSite = this.getSite(siteId);
		if(lookedSite!= null){
			this.sites.remove(lookedSite);
		}
	}
	
	/**
	 * Método que obtiene una sede del almacén de sedes. Devuelve null si no la encuentra 
	 * @param siteId el identificador de la sede a devolver
	 * @return la sede encontrada
	 */
	public Site getSite (int siteId) {
		Iterator<Site> it = this.sites.iterator();
		boolean found = false;
		Site lookedSite = null;
		Site currentSize;
		while(!found && it.hasNext()){
			currentSize = it.next();
			if(currentSize.getId() == siteId){
				found = true;
				lookedSite = currentSize;
			}
		}

		return lookedSite;
	}
	
	/**
	 * Método que devuelve el número de sedes almacenadas
	 * @return el número de sedes almacenadas
	 */
	public int getSiteListSize() {
		return this.sites.size();
	}
}
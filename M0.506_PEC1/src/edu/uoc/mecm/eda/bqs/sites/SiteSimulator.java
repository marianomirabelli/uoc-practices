package edu.uoc.mecm.eda.bqs.sites;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que implementa unos tests unitarios para comprobar el correcto funcionamento de los métodos de la clase ModelList
 * @author Carles Pairot Gavaldà
 *
 */
public class SiteSimulator {
	public static void main (String args[]) throws Exception {
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
		
		// Creamos las sedes
		Site m1 = new Site(10, "sintesi", "Edifici Síntesi", "C/Pere Martell, 4",
					df.parse("01/01/2015"), true, new URL("https://appsint02.intra.net/blueprints/sintesi"));

		Site m2 = new Site(12, "palau", "Palaui", "Passeig Sant Antoni, 100",
					df.parse ("01/06/1900"), true, new URL("https://appsint02.intra.net/blueprints/palau"));

		Site m3 = new Site(3,"formacio","Formació del SAM","Vall de l'Arrabassada",
					df.parse ("01/10/2012"),false, 	new  URL("https://appsint02.intra.net/blueprints/formSAM"));

		Site m4 = new Site(7, "base","BASE - Gestió d'Ingressos","Passeig Lluís Companys",
					df.parse ("01/01/1985"),true, new URL("https://appsint02.intra.net/blueprints/base"));

		Site m5 = new Site(2,"turisme","Patronat de Turisme","Passeig Torroja",
				df.parse ("01/01/2000"),false, new URL("https://appsint02.intra.net/blueprints/turisme"));
		
		// Modificamos datos de las sedes
		m1.setIniDate (df.parse ("01/01/2014"));
		m2.setHomologation (false);
		m2.setBlueprintsUrl (new URL ("https://appsint02.intra.net/blueprints/formRH"));
		m3.setDescription ("Formació RH / SAM");
		
		// Creamos los objetos
		SiteObject t1 = new SiteObject(10,"macbookpro13","Macbook Pro 13''", ObjectType.COMPUTER);

		SiteObject t2 = new SiteObject(10,"hpdeskjet2540","HP Deskjet 2540", ObjectType.PRINTER);
		SiteObject t3 = new SiteObject(10,"executivetable","Taula directiva", ObjectType.FURNITURE);
		SiteObject t4 = new SiteObject(12,"executivechair","Cadira directiva", ObjectType.FURNITURE);
		
		// Creamos la Lista de Sedes
		SiteList ml = new SiteList();
		
		// Realizamos los tests unitarios para comprobar el correcto funcionamiento de nuestras clases
		if (t1.getSiteId() == m1.getId() && t2.getSiteId() == m1.getId() && t3.getSiteId() == m1.getId() && t1.getSiteId() == 10 && t2.getSiteId() == 10 && t3.getSiteId() == 10) {
			System.out.println ("Test Unitario 1 OK");
		} else {
			System.err.println ("Test Unitario 1 KO - Los objetos t1, t2 y t3 no están correctamente asignados a la Sede m1");
		}
		
		if (t4.getSiteId() == m2.getId() && t4.getSiteId() == 12) {
			System.out.println ("Test Unitario 2 OK");
		} else {
			System.err.println ("Test Unitario 2 KO - El objeto t4 no está correctamenta asignado a la Sede m2");
		}
		
		if (ml.getSiteListSize() == 0) {
			System.out.println ("Test Unitario 3 OK");
		} else {
			System.err.println ("Test Unitario 3 KO - Se esperaba 0 y se encontró "+ ml.getSiteListSize());
		}
		
		// Añadimos las sedes a la lista
		ml.addSite (m1);
		ml.addSite (m2);
		ml.addSite (m3);
		ml.addSite (m4);
		ml.addSite (m5);

		if (ml.getSiteListSize() == 5) {
			System.out.println ("Test Unitario 4 OK");
		} else {
			System.err.println ("Test Unitario 4 KO - Se esperaba 5 y se encontró "+ ml.getSiteListSize());
		}
		
		ml.addSite (null);
		
		if (ml.getSiteListSize() == 5) {
			System.out.println ("Test Unitario 5 OK");
		} else {
			System.err.println ("Test Unitario 5 KO - Se esperaba 5 y se encontró "+ ml.getSiteListSize());
		}

		Site mod = ml.getSite (m3.getId());
		
		if (mod != null && mod.equals (m3)) {
			System.out.println ("Test Unitario 6 OK");
		} else if (mod != null) {
			System.err.println ("Test Unitario 6 KO - Se esperaba " + m3.toString() + " y se encontró " + mod.toString());
		} else {
			System.err.println ("Test Unitario 6 KO - La sede devuelta no existe en la lista");
		}
		
		ml.removeSite (m4.getId());
		ml.removeSite (m5.getId());
		ml.removeSite (-1);
		
		if (ml.getSiteListSize() == 3) {
			System.out.println ("Test Unitario 7 OK");
		} else {
			System.err.println ("Test Unitario 7 KO - Se esperaba 3 y se encontró "+ ml.getSiteListSize());
		}
		
		mod = ml.getSite (m5.getId());
		
		if (mod == null) {
			System.out.println ("Test Unitario 8 OK");
		} else {
			System.err.println ("Test Unitario 8 KO - La sede m5 no se ha borrado correctamente de la lista");
		}
	}
}
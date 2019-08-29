package com.astarteam.Pruebas;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.transaction.api.annotation.TransactionMode;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.astarteam.entidades.Persona;



/**
 * Clase de pruebas dedicada para la pruebas de las entidades
 * 
 * @author Alvaro Sebastian Tabares Gaviria
 * @version 1.0
 */
@RunWith(Arquillian.class)
public class TestModelo {

	/**
	 * instancia para realizar las transaciones con las entidades
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * general el archivo de depliegue de pruebas
	 * 
	 * @return genera un archivo de configuracion web
	 */
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war").addPackage(Persona.class.getPackage())
				.addAsResource("persistenceForTest.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	

	/**
	 * prueba para la inserción de personas en la base de datos
	 */
	@Test
	@Transactional(value = TransactionMode.ROLLBACK)
	public void insertarPersona() {
	
		Persona p = new Persona();
		p.setApodo("Lucho");
		p.setCedula("123456");
		p.setCorreo("a@mail.com");
		p.setNombre("Luis");
		p.setNumeroTelefono("312312312");
		
		entityManager.persist(p);
		
		Persona a = new Persona();
		a = entityManager.find(Persona.class, "123456");
		Assert.assertNotNull(a);
	}
}

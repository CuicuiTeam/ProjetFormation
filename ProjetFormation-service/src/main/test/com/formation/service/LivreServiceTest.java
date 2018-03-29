package com.formation.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.formation.config.ConteneurSpringFullJava;
import com.formation.entities.Livre;
import com.formation.implementation.LivreServiceImpl;

public class LivreServiceTest {
	
	private LivreService service; // SUT
	
	@Before
	public void setup() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(ConteneurSpringFullJava.class);
		ctx.refresh();
		
		service = ctx.getBean(LivreService.class);
	}
	
	@Test
	public void itShouldReturnLivreWithTintin() throws Exception {
		// arrange
		String recherche = "tintin";
		
		// act
		List<Livre> livres = service.getLivreByRecherche(recherche);
		
		// assert
		assertThat(livres)
			.isNotNull()
			.hasSize(1)
			.doesNotContainNull();
		
		
		Livre livre0 = livres.get(0);
		assertThat(livre0)
			.extracting(Livre::getId, Livre::getTitre, Livre::getPrix) // actual
			.contains(1718, "Les trésors de Tintin : 22 fac-similés rares extraits des archives d'Hergé", 34.0); // expected

//		Livre livre1 = livres.get(1);
//		assertThat(livre1)
//			.extracting(Livre::getId, Livre::getTitre, Livre::getPrix) // actual
//			.contains(171, "Les trésors de Tintin : 22 fac-similés rares extraits des archives d'Hergé", 34.0); // expected
	}

}

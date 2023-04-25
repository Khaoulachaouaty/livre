package com.khaoula.livres;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.khaoula.livres.entities.Livre;
//import com.khaoula.livres.service.LivreService;

@SpringBootApplication
public class LivresApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(LivresApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Livre.class);
	//	livreService.saveLivre(new Livre("Al-Fiqh al-Akbar", 70.0, new Date()));
	//	livreService.saveLivre(new Livre("Le Collier de la colombe", 60.0, new Date()));
	//	livreService.saveLivre(new Livre("Kitab al-'Ibar", 50.0, new Date()));
	}

}

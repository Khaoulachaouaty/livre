package com.khaoula.livres.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.khaoula.livres.entities.Editeur;
import com.khaoula.livres.entities.Livre;

public interface LivreService {
	Livre saveLivre(Livre l);
	Livre updateLivre(Livre l);
	void deleteLivre(Livre l);
	void deleteLivreById(Long id);
	Livre getLivre(Long id);
	List<Livre> getAllLivres();
	Page<Livre> getAllLivresParPage(int page, int size);
	List<Livre> findByNomLivre(String nom);
	List<Livre> findByNomLivreContains(String nom);
	List<Livre> findByNomPrix (String nom, Double prix);
	List<Livre> findByEditeur (Editeur editeur);
	List<Livre> findByEditeurIdEd(Long id);
	List<Livre> findByOrderByNomLivreAsc();
	List<Livre> trierLivresNomsPrix();
	List<Editeur> getAllEditeurs();
}

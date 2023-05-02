package com.khaoula.livres.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.khaoula.livres.entities.Livre;
import com.khaoula.livres.service.LivreService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LivreRESTController {
	@Autowired
	LivreService livreservice;
	@RequestMapping(method = RequestMethod.GET)
	public List<Livre> getAllLivres() {
		return livreservice.getAllLivres();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Livre getLivreById(@PathVariable("id") Long id) {
	return livreservice.getLivre(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Livre createLivre(@RequestBody Livre livre) {
	return livreservice.saveLivre(livre);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Livre updateLivre(@RequestBody Livre livre) {
	return livreservice.updateLivre(livre);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteLivre(@PathVariable("id") Long id)
	{
	livreservice.deleteLivreById(id);
	}
	
	@RequestMapping(value="/lvresed/{idEd}",method = RequestMethod.GET)
	public List<Livre> getLivresByEdId(@PathVariable("idEd") Long idEd) {
	return livreservice.findByEditeurIdEd(idEd);
	}

}

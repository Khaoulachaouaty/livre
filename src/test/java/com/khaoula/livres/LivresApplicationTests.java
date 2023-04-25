package com.khaoula.livres;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.khaoula.livres.entities.Editeur;
import com.khaoula.livres.entities.Livre;
import com.khaoula.livres.repos.LivreRepository;
import com.khaoula.livres.service.LivreService;


@SpringBootTest
class LivresApplicationTests {
@Autowired
private LivreRepository livreRepository;
@Autowired
private LivreService livreService;
@Test
public void testCreateLivre() {
Livre l = new Livre("Al-Ayyam Al-Tawila",10.000,new Date());
livreRepository.save(l);
}

@Test
public void testFindLivre()
{
Livre l = livreRepository.findById(1L).get(); 
System.out.println(l);
}
@Test
public void testUpdateLivre()
{
Livre l = livreRepository.findById(2L).get();
l.setPrixLivre(2000.0);
livreRepository.save(l);
System.out.println(l);
}

@Test
public void testDeleteProduit()
{
livreRepository.deleteById(1L);;
}
 
@Test
public void testListerTousLivres()
{
List<Livre> lvres = livreRepository.findAll();
for (Livre l : lvres)
{
System.out.println(l);
}
}
@Test
public void testFindByNomLivreContains()
{
Page<Livre> lvres = livreService.getAllLivresParPage(0,2);
System.out.println(lvres.getSize());
System.out.println(lvres.getTotalElements());
System.out.println(lvres.getTotalPages());
lvres.getContent().forEach(p -> {System.out.println(p.toString());
 });
/*ou bien
for (Produit p : prods)
{
System.out.println(p);
}*/ 
}
@Test
public void testFindByNomLivre()
{
List<Livre> lvres = livreRepository.findByNomLivre("Muqaddimah");
	for (Livre l : lvres)
	{
		System.out.println(l);
	}
}
@Test
public void testFindByNomLivreeContains()
{
List<Livre> lvres = livreRepository.findByNomLivreContains("M");
	for (Livre l : lvres)
	{
		System.out.println(l);
	}
}

@Test
public void testfindByNomPrix()
{
	List<Livre> lvres = livreRepository.findByNomPrix("Muqaddimah", 10.0);
	for (Livre l : lvres)
	{
		System.out.println(l);
	}
}

@Test
public void testfindByEditeur()
{
Editeur e = new Editeur();
e.setIdEd(1L);
List<Livre> lvres = livreRepository.findByEditeur(e);
for (Livre l : lvres)
{
System.out.println(l);
}
}

@Test
public void findByEditeurIdEd()
{
	List<Livre> lvres = livreRepository.findByEditeurIdEd(1L);
	for (Livre l : lvres)
	{
		System.out.println(l);
	}
 }

@Test
public void testfindByOrderByNomLivreAsc()
{
	List<Livre> lvres =livreRepository.findByOrderByNomLivreAsc();
	for (Livre l : lvres)
	{
		System.out.println(l);
	}
}

@Test
public void testTrierLivresNomsPrix()
{
	List<Livre> lvres = livreRepository.trierLivresNomsPrix();
	for (Livre l : lvres)
	{
		System.out.println(l);
	}
}


}
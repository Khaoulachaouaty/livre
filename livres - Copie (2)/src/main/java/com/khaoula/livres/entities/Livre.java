package com.khaoula.livres.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Livre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idLivre;
@NotNull
@Size (min = 4,max = 30)
private String nomLivre;
@Min(value = 5)
@Max(value = 100)
private Double prixLivre;
@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date datePublication;

@ManyToOne
private Editeur editeur;

public Livre() {
super();
}
public Livre(String nomLivre, Double prixLivre, Date datePublication) {
super();
this.nomLivre = nomLivre;
this.prixLivre = prixLivre;
this.datePublication = datePublication;
}

public Long getIdLivre() {
	return idLivre;
}
public void setIdLivre(Long idLivre) {
	this.idLivre = idLivre;
}
public String getNomLivre() {
	return nomLivre;
}
public void setNomLivre(String nomLivre) {
	this.nomLivre = nomLivre;
}
public Double getPrixLivre() {
	return prixLivre;
}
public void setPrixLivre(Double prixLivre) {
	this.prixLivre = prixLivre;
}
public Date getDatePublication() {
	return datePublication;
}
public void setDatePublication(Date datePublication) {
	this.datePublication = datePublication;
}
@Override
public String toString() {
return "Livre [idLivre=" + idLivre + ", nomLivre=" +
nomLivre + ", prixLivre=" + prixLivre
+ ", datePublication=" + datePublication + "]";
}
public Editeur getEditeur() {
	return editeur;
}
public void setEditeur(Editeur editeur) {
	this.editeur = editeur;
}
}
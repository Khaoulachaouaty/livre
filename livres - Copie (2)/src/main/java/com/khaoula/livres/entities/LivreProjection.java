package com.khaoula.livres.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomLv", types = { Livre.class })
public interface LivreProjection {
	public String getNomLivre();
}

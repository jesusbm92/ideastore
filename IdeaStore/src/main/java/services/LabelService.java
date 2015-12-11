package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Label;

import repositories.LabelRepository;

@Transactional
@Service
public class LabelService {
	// Managed repository-----------------------

	@Autowired
	private LabelRepository labelRepository;

	// Supporting services -----------------

	// Constructors --------------------------
	public LabelService() {
		super();
	}

	// Simple CRUD methods -----------------
	/**
	 * Constructor por defecto de LabelService
	 * 
	 * @return Idea idea
	 */
	public Label create() {
		Label label = new Label();

		return label;
	}

	/**
	 * Devuelve una colección con todos los objetos de tipo Label
	 * 
	 * @return Collection<Label> labels
	 */
	public Collection<Label> findAll() {
//		Assert.isTrue(userService.IAmAnAdmin());
		return labelRepository.findAll();
	}
	
	
	/**
	 * Devuelve una instancia de un objetos de tipo Idea En caso de no
	 * encontrarse, devuelve null
	 * 
	 * @return Idea idea
	 */
	public Label findOne(int labelId) {
		return labelRepository.findOne(labelId);
	}

	/**
	 * Persiste (guarda o crea) el objeto de tipo Idea en la base de datos a
	 * través del repositorio IdeaRepository
	 * 
	 * @return void
	 */
	public void save(Label label) {
		// TODO Restricciones de Save 
		//WE HAVE TO PUT HERE THE USER ROLE (IF ITS ADMIN OR NOT TO DO THE ACTION)

		labelRepository.save(label);
	}

	/**
	 * Elimina el objeto de tipo Idea de la base de datos a través del
	 * repositorio IdeaRepository
	 * 
	 * @return void
	 */
	public void delete(Label label) {
		Assert.notNull(label);
		// TODO Restricciones de Borrado

		labelRepository.delete(label);
	}

}

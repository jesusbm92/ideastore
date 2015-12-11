package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import services.IdeaService;
import services.LabelService;
import domain.Idea;
import domain.Label;

@Controller
@RequestMapping("/label")
public class LabelController {
	// Services ----------------------------------------------------------------

	@Autowired
	private LabelService labelService;
	
	@Autowired
	private IdeaService ideaService;

	// Constructor
	// ---------------------------------------------------------------
	public LabelController() {
		super();
	}

	// Listing
	// -------------------------------------------------------------------

	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView result;
		String uri = "label/list";
		String requestURI = "label/list.do";
		Collection<Label> plans = labelService.findAll();
		result = createListModelAndView(requestURI, plans, uri);

		return result;
	}

	// Creation
	// ------------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int ideaId) {
		ModelAndView result;
		
		//Find the idea for which the label is for (it's passed by parameter) and assign to it
		Idea idea = new Idea();
		idea = ideaService.findOne(ideaId);

		Label label = labelService.create();
		label.setIdea(idea);
		
		result = createEditModelAndView(label);
		result.addObject("create", true);

		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Label label, BindingResult binding, RedirectAttributes redirect) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(label);
		} else {
			try {
				labelService.save(label);
				result = new ModelAndView("redirect:/idea/details.do?ideaId="+label.getIdea().getId());
				//result = new ModelAndView("redirect:/comment/list.do?ideaId="+comment.getIdea().getId());
			} catch (Throwable oops) {
				result = createEditModelAndView(label, "label.commit.error");
			}
			result.addObject("create", false);
		}

		return result;
	}

	// Creation
	// ------------------------------------------------------------------
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int labelId) {
		ModelAndView result;
		
		Label label= labelService.findOne(labelId);
		labelService.delete(label);
				
		result = new ModelAndView("redirect:/idea/details.do?ideaId="+label.getIdea().getId());

		return result;
	}
	
	
	protected ModelAndView createEditModelAndView(Label label) {
		assert label != null;

		ModelAndView result;

		result = createEditModelAndView(label, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Label label, String message) {
		assert label != null;

		ModelAndView result;

		result = new ModelAndView("label/create");
		result.addObject("label", label);
		result.addObject("message", message);

		return result;
	}
	
	protected ModelAndView createListModelAndView(String requestURI,
			Collection<Label> labels, String uri) {
		ModelAndView result;

		result = new ModelAndView(uri);
		result.addObject("labels", labels);
		result.addObject("requestURI", requestURI);

		return result;
	}
}

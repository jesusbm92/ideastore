package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domain.Idea;
import domain.Label;

import services.IdeaService;

 
@Controller
@RequestMapping("/idea")
public class IdeaController extends AbstractController{

	// Services ----------------------------------------------------------------
	@Autowired
	private IdeaService ideaService;
	
	// Constructor
		// ---------------------------------------------------------------
		public IdeaController() {
			super();
		}
	
		// Listing
		// -------------------------------------------------------------------

		
		@RequestMapping("/list")
		public ModelAndView listDays() {
			ModelAndView result;
			String uri = "idea/list";
			String requestURI = "idea/list.do";

			Collection<Idea> days = ideaService.findAll();
			result = createListModelAndView(requestURI, days, uri);

			return result;
		}
		
		@RequestMapping("/details")
		public ModelAndView details(@RequestParam int ideaId) {
			ModelAndView result;
			String uri = "idea/details";
			String requestURI = "idea/details.do";
			Idea idea = ideaService.findOne(ideaId);
			result = createListModelAndView(requestURI, idea, uri);

			return result;
		}
		
		
		protected ModelAndView createListModelAndView(String requestURI,
				Collection<Idea> ideas, String uri) {
			ModelAndView result;

			result = new ModelAndView(uri);
			result.addObject("ideas", ideas);
			result.addObject("requestURI", requestURI);

			return result;
		}
		
		// Creating Idea
		// --------------------------------------------------------------------
		
		@RequestMapping(value = "/create", method = RequestMethod.GET)
		public ModelAndView createIdea(){
			ModelAndView result;
			Idea idea = ideaService.create();		
			result = createEditModelAndView(idea);
			result.addObject("create", true);
			
			return result;
		}
		
		// Editing Idea
		// --------------------------------------------------------------------
		
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public ModelAndView editIdea(@RequestParam int ideaId){
			ModelAndView result;
			Idea idea = ideaService.findOne(ideaId);
			result = createEditModelAndView(idea);
			result.addObject("create", true);
			
			return result;
		}
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
		public ModelAndView editIdea(@Valid Idea idea, BindingResult bindingResult, RedirectAttributes redirect){
			ModelAndView result;
			
			if(bindingResult.hasErrors()){
				result = createEditModelAndView(idea);
			}
			else{
				try{
					ideaService.save(idea);
					//result = new ModelAndView("redirect:/idea/details.do?ideaId="+idea.getId());			
					result = new ModelAndView("redirect:/idea/list.do");
				}
				catch(Throwable oops){
					result = createEditModelAndView(idea, "idea.commit.error");
				}
				result.addObject("create", false);
			}
			
			return result;
		}
		
		// Delete Idea
		// --------------------------------------------------------------------
		@RequestMapping(value = "/delete", method = RequestMethod.GET)
		public ModelAndView delete(@RequestParam int ideaId) {
			ModelAndView result;
			
			Idea idea= ideaService.findOne(ideaId);
			ideaService.delete(idea);
					
			result = new ModelAndView("redirect:/idea/list.do");

			return result;
		}	
		
		// Business Logic
		// --------------------------------------------------------------------
		
		protected ModelAndView createEditModelAndView(Idea idea){
			ModelAndView result;
			result = createEditModelAndView(idea, null);
			
			return result;
		}
		
		protected ModelAndView createEditModelAndView(Idea idea, String message){
			assert idea != null;
			ModelAndView result;
			result = new ModelAndView("idea/edit");
			result.addObject("idea", idea);
			result.addObject("message", message);
			
			return result;
		}
		
		protected ModelAndView createEditModelAndView(String requestURI, Collection<Idea> ideas, String uri){
			ModelAndView result;
			result = new ModelAndView(uri);
			result.addObject("idea", ideas);
			result.addObject("requestURI", requestURI);
			
			return result;
		}
		
		protected ModelAndView createListModelAndView(String requestURI, Idea idea,
				String uri) {
			ModelAndView result;

			result = new ModelAndView(uri);
			result.addObject("idea", idea);
			result.addObject("requestURI", requestURI);

			return result;
		}
		
}
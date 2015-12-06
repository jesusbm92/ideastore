package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import domain.Idea;

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
		public ModelAndView createIdea(@RequestParam String name, @RequestParam String description){
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
		
		@RequestMapping(value = "/edit", method = RequestMethod.POST)
		public ModelAndView editIdea(@Valid Idea idea, BindingResult bindingResult){
			ModelAndView result;
			
			if(bindingResult.hasErrors()){
				result = createEditModelAndView(idea);
			}
			else{
				try{
					ideaService.save(idea);
					result = new ModelAndView("");
				}
				catch(Throwable oops){
					result = createEditModelAndView(idea, "idea.commit.error");
				}
				result.addObject("create", false);
			}
			
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
		
}
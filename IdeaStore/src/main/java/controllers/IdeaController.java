package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

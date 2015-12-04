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

import services.CommentService;
import domain.Comment;
import services.IdeaService;
import domain.Idea;

@Controller
@RequestMapping("/comment")
public class CommentController extends AbstractController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private IdeaService ideaService;	

	// Constructors -----------------------------------------------------------

	public CommentController() {
		super();
	}

	// list ---------------------------------------------------------------

	@RequestMapping("/list")
	public ModelAndView list(@RequestParam int ideaId) {
		ModelAndView result;

		Collection<Comment> comments = commentService.findCommentByIdea(ideaId);

		String uri = "comment/list";
		String requestURI = "comment/list.do";
		Idea idea = ideaService.findOne(ideaId);
		result = createListModelAndView(requestURI, comments, uri,idea);
		return result;
	}

	// Creation
	// ------------------------------------------------------------------
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam int ideaId) {
		ModelAndView result;

		Comment comment = commentService.create(ideaId);

		result = createEditModelAndView(comment);
		result.addObject("create", true);

		return result;
	}

	// Edition
	// -------------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int commentId) {
		ModelAndView result;
		Comment comment = commentService.findOne(commentId);

		result = createEditModelAndView(comment);
		result.addObject("create", false);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Comment comment, BindingResult binding,
			RedirectAttributes redirect) {
		ModelAndView result;
		commentService.save(comment);
		result = new ModelAndView("redirect:/plan/customer/list.do");
		return result;
	}

	
	// Other bussiness method
	protected ModelAndView createEditModelAndView(Comment comment) {
		assert comment != null;

		ModelAndView result;

		result = createEditModelAndView(comment, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(Comment comment,
			String message) {
		assert comment != null;

		ModelAndView result;

		result = new ModelAndView("comment/edit");
		result.addObject("comment", comment);
		result.addObject("message", message);

		return result;
	}

	protected ModelAndView createListModelAndView(String requestURI,
			Collection<Comment> comments, String uri, Idea idea) {
		ModelAndView result;

		result = new ModelAndView(uri);
		result.addObject("comments", comments);
		result.addObject("idea", idea);
		result.addObject("requestURI", requestURI);

		return result;
	}

}
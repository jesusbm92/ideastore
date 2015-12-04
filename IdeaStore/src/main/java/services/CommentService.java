package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.CommentRepository;
import domain.Comment;
import domain.Idea;

@Transactional
@Service
public class CommentService {

	// Managed repository-----------------------

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private IdeaService ideaService;
	
	//@Autowired
	//private UserService userService;

	
	// Constructors --------------------------
	public CommentService() {
		super();
	}

	// Simple CRUD methods -----------------
	
	public Comment create(int idIdea) {
		Comment comment = new Comment();
		comment.setDate(new Date());
		Idea idea = ideaService.findOne(idIdea);
		comment.setIdea(idea);
		//comment.setUser(userService.findByPrincipal());
		return comment;
	}

	
	public Collection<Comment> findAll() {
		return commentRepository.findAll();
	}


	public Comment findOne(int commentId) {
		return commentRepository.findOne(commentId);
	}
	
	
	public void save(Comment comment) {
		
		Assert.notNull(comment);
		
		commentRepository.save(comment);
	}

	public void delete(Comment comment) {
		
		Assert.notNull(comment);

		commentRepository.delete(comment);
	}
	
	// Other business methods ----------------

		public Collection<Comment> findCommentByComment(int commentId) {

			return commentRepository.findCommentByComment(commentId);
		}
		
		public Collection<Comment> findCommentByIdea(int ideaId) {

			return commentRepository.findCommentByIdea(ideaId);
		}


}

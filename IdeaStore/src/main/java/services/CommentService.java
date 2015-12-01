package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.CommentRepository;
import domain.Comment;

@Transactional
@Service
public class CommentService {

	// Managed repository-----------------------

	@Autowired
	private CommentRepository commentRepository;

	
	// Constructors --------------------------
	public CommentService() {
		super();
	}

	// Simple CRUD methods -----------------
	
	public Comment create(int idPlan) {
		Comment comment = new Comment();
		comment.setDate(new Date());
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


}

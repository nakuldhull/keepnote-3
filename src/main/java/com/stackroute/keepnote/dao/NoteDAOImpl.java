package com.stackroute.keepnote.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.keepnote.exception.NoteNotFoundException;
import com.stackroute.keepnote.model.Note;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with 
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, 
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	private SessionFactory sessionFactory;
	
	@Autowired
	public NoteDAOImpl(SessionFactory sessionFactory) {

		this.sessionFactory=sessionFactory;
	}

	/*
	 * Create a new note
	 */
	
	public boolean createNote(Note note) {
		sessionFactory.getCurrentSession().save(note);
		return true;

	}

	/*
	 * Remove an existing note
	 */
	
	public boolean deleteNote(int noteId) {
		boolean flag = true;
		try {
			if(getNoteById(noteId)==null) {
				flag = false;
			}else {
				sessionFactory.getCurrentSession().delete(getNoteById(noteId));
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (NoteNotFoundException e) {
			e.printStackTrace();
		}
		return flag;
		
	}

	/*
	 * Retrieve details of all notes by userId
	 */
	
	public List<Note> getAllNotesByUserId(String userId) {
		String string = "from Note  where createdBy = :userId ";
        Query query = sessionFactory.getCurrentSession().createQuery(string).setParameter("userId", userId);
		List result = query.getResultList();
		return result;

	}

	/*
	 * Retrieve details of a specific note
	 */
	
	public Note getNoteById(int noteId) throws NoteNotFoundException {
		Session session = sessionFactory.getCurrentSession();
		Note note =session.get(Note.class, noteId);
		if(note==null)
			throw new NoteNotFoundException("NoteNotFoundException");
		else {
			return note;
		}

	}

	/*
	 * Update an existing note
	 */

	public boolean UpdateNote(Note note) {
		boolean flag=true;
		try {
			if(getNoteById(note.getNoteId())==null) {
				flag=false;
			}else {
				sessionFactory.getCurrentSession().update(note);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (NoteNotFoundException e) {
			e.printStackTrace();
		}
		return flag;

	}

}

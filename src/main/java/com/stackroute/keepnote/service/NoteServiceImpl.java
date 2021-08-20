package com.stackroute.keepnote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.keepnote.dao.*;
import com.stackroute.keepnote.exception.CategoryNotFoundException;
import com.stackroute.keepnote.exception.NoteNotFoundException;
import com.stackroute.keepnote.exception.ReminderNotFoundException;
import com.stackroute.keepnote.model.*;
import com.stackroute.keepnote.model.Reminder;


@Service
public class NoteServiceImpl implements NoteService {

	/*
	 * Autowiring should be implemented for the NoteDAO,CategoryDAO,ReminderDAO.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
    private NoteDAO noteDAO;
	private CategoryDAO categoryDAO;
	private ReminderDAO reminderDAO;
	@Autowired
	public NoteServiceImpl(NoteDAO noteDAO, CategoryDAO categoryDAO, ReminderDAO reminderDAO) {
		super();
		this.noteDAO = noteDAO;
		this.categoryDAO = categoryDAO;
		this.reminderDAO = reminderDAO;
	}
	/*
	 * This method should be used to save a new note.
	 */

	public boolean createNote(Note note) throws ReminderNotFoundException, CategoryNotFoundException {
//		Reminder reminder = note.getReminder();
//		Category category = note.getCategory();
//		try {
//			if(reminder!=null) 
//				reminderDAO.getReminderById(reminder.getReminderId());
//		}catch(ReminderNotFoundException rnf) {
//			throw new ReminderNotFoundException("ReminderNotFoundException");
//		}
//		try {
//			if(category!=null)
//				categoryDAO.getCategoryById(category.getCategoryId());
//		}catch(CategoryNotFoundException cnf) {
//			throw new  CategoryNotFoundException("CategoryNotFoundException");
//		}
//		
//		return noteDAO.createNote(note);
		Reminder reminder = note.getReminder();
		
		Category category = note.getCategory();
		
		try {
			if(reminder!=null) 
				reminderDAO.getReminderById(reminder.getReminderId());
			
		}catch(ReminderNotFoundException rnf) {
			
			throw new ReminderNotFoundException("ReminderNotFoundException");
			
		}
		
		try {
			if(category!=null)
				categoryDAO.getCategoryById(category.getCategoryId());
			
		}catch(CategoryNotFoundException cnf) {
			
			throw new  CategoryNotFoundException("CategoryNotFoundException");
			
		}
		
		return noteDAO.createNote(note);
		

	}

	/* This method should be used to delete an existing note. */

	

	public boolean deleteNote(int noteId) throws NoteNotFoundException{
//		try {
//			if(getNoteById(noteId)!=null) {
//				noteDAO.deleteNote(noteId);
//				return true;
//			}
//		} catch (NoteNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
		boolean deletedNote = noteDAO.deleteNote(noteId);
		if(!deletedNote)
			return false;
		else
			return true;
	}
	/*
	 * This method should be used to get a note by userId.
	 */

	public List<Note> getAllNotesByUserId(String userId) {
		return noteDAO.getAllNotesByUserId(userId);

	}

	/*
	 * This method should be used to get a note by noteId.
	 */
	public Note getNoteById(int noteId) throws NoteNotFoundException {
		Note note = noteDAO.getNoteById(noteId);
		if(note==null)
			throw new NoteNotFoundException("NoteNotFoundException");
		else
			return note;
	}

	/*
	 * This method should be used to update a existing note.
	 */

	public Note updateNote(Note note, int id)
			throws ReminderNotFoundException, NoteNotFoundException, CategoryNotFoundException {
//		Note noteFound = noteDAO.getNoteById(id);
//		Reminder reminder = note.getReminder();
//		Category category = note.getCategory();
//		try {
//			if(reminder!=null) {
//				noteFound.setReminder(reminderDAO.getReminderById(id));
//			}
//				
//		}catch(ReminderNotFoundException rnf) {
//			rnf.printStackTrace();
//		}
//		try {
//			if(category!=null)
//				noteFound.setCategory(categoryDAO.getCategoryById(id));
//		}catch(CategoryNotFoundException cnf) {
//			cnf.printStackTrace();
//		}
//		
//		if(noteFound==null) {
//			throw new NoteNotFoundException("NoteNotFoundException");
//		}else {
//			noteDAO.UpdateNote(noteFound);
//		}
//		return noteFound;
		Note noteFound = noteDAO.getNoteById(id);
		Reminder reminder = note.getReminder();
		Category category = note.getCategory();
		if(noteFound!=null) {
			noteDAO.UpdateNote(noteFound);
		}else {
			throw new NoteNotFoundException("NoteNotFoundException");
			
		}
		try {
			if(reminder!=null) 
				reminderDAO.getReminderById(reminder.getReminderId());
		}catch(ReminderNotFoundException e) {
			e.printStackTrace();
		}
		try {
			if(category!=null)
				categoryDAO.getCategoryById(category.getCategoryId());
		}catch(CategoryNotFoundException e) {
			e.printStackTrace();
		}
		
		return note;

	}

	}



package com.stackroute.keepnote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.keepnote.dao.ReminderDAO;
import com.stackroute.keepnote.dao.ReminderDAOImpl;
import com.stackroute.keepnote.exception.ReminderNotFoundException;
import com.stackroute.keepnote.model.Reminder;


@Service
public class ReminderServiceImpl implements ReminderService {

	/*
	 * Autowiring should be implemented for the ReminderDAO. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword.
	 */
	private ReminderDAO reminderDAO;
	@Autowired
	public ReminderServiceImpl(ReminderDAO reminderDAO) {
		super();
		this.reminderDAO = reminderDAO;
	}
	/*
	 * This method should be used to save a new reminder.
	 */

	public boolean createReminder(Reminder reminder) {
		 if(reminderDAO.createReminder(reminder))
				return true;
			else
			return false;

	}

	

	/*
	 * This method should be used to update a existing reminder.
	 */

	public Reminder updateReminder(Reminder reminder, int id) throws ReminderNotFoundException {
		Reminder updatedReminder =getReminderById(id);
		if(updatedReminder==null)
			throw new ReminderNotFoundException("ReminderNotFoundException");
		else
			reminderDAO.updateReminder(reminder);
		return reminder;
	}

	/* This method should be used to delete an existing reminder. */
	
	public boolean deleteReminder(int reminderId) {
		if(reminderDAO.deleteReminder(reminderId))
			return true;
		else
		return false;
	}

	/*
	 * This method should be used to get a reminder by reminderId.
	 */
	
	public Reminder getReminderById(int reminderId) throws ReminderNotFoundException {
//		return reminderDAO.getReminderById(reminderId);
		Reminder reminder = reminderDAO.getReminderById(reminderId);
		if(reminder==null)
			throw new ReminderNotFoundException("ReminderNotFoundException");
		else
			return reminder;

	}

	/*
	 * This method should be used to get a reminder by userId.
	 */

	public List<Reminder> getAllReminderByUserId(String userId) {
		return reminderDAO.getAllReminderByUserId(userId);

	}
}

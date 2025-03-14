package com.example.medinfo.model

import androidx.lifecycle.LiveData

class ReminderRepository(private val reminderDao: ReminderDao) {

    val allReminders: LiveData<List<Reminder>> = reminderDao.getAllReminders()

    suspend fun insert(reminder: Reminder) {
        reminderDao.insert(reminder)
    }

    suspend fun delete(reminder: Reminder) {
        reminderDao.delete(reminder) // Call the delete method in the DAO
    }
}
package com.example.medinfo.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReminderDao {
    @Insert
    suspend fun insert(reminder: Reminder)

    @Delete
    suspend fun delete(reminder: Reminder) // Add delete method

    @Query("SELECT * FROM reminders")
    fun getAllReminders(): LiveData<List<Reminder>>
}
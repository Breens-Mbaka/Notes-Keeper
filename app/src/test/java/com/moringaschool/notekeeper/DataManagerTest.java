package com.moringaschool.notekeeper;

import org.junit.Assert;
import org.junit.Test;

public class DataManagerTest {
    @Test
    public void testCreateNewNote() {
        DataManager dataManager = DataManager.getInstance();
        final CourseInfo course = dataManager.getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        int noteIndex = dataManager.createNewNote();
        NoteInfo newNote = dataManager.getNotes().get(noteIndex);
        newNote.setCourse(course);
        newNote.setTitle(noteTitle);
        newNote.setText(noteText);

        NoteInfo compareNote = dataManager.getNotes().get(noteIndex);
        Assert.assertEquals(course, compareNote.getCourse());
        Assert.assertEquals(noteTitle, compareNote.getTitle());
        Assert.assertEquals(noteText, compareNote.getText());
    }

    @Test
    public void createNewNoteStepCreation() {
        final CourseInfo course = DataManager.getInstance().getCourse("android_async");
        final String noteTitle = "Test note title";
        final String noteText = "This is the body text of my test note";

        int noteIndex = DataManager.getInstance().createNewNote(course,noteTitle,noteText);
        NoteInfo compareNotes = DataManager.getInstance().getNotes().get(noteIndex);
        Assert.assertEquals(course, compareNotes.getCourse());
        Assert.assertEquals(noteTitle, compareNotes.getTitle());
        Assert.assertEquals(noteText, compareNotes.getText());
    }
}
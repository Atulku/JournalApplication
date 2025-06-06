package com.SpringBootTutorial.journalApplication.service;

import com.SpringBootTutorial.journalApplication.entity.JournalEntryV2;
import com.SpringBootTutorial.journalApplication.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntryV2 journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntryV2> getAllJournalEntries() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntryV2> getJournalEntryById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public boolean deleteJournalEntryById(ObjectId id) {
        journalEntryRepository.deleteById(id);
        return true;
    }
}

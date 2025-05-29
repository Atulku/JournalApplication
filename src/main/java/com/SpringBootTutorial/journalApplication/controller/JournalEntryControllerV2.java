package com.SpringBootTutorial.journalApplication.controller;

import com.SpringBootTutorial.journalApplication.entity.JournalEntryV2;
import com.SpringBootTutorial.journalApplication.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping
    public JournalEntryV2 createJournalEntry(@RequestBody JournalEntryV2 journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(journalEntry);
        return journalEntry;
    }

    @GetMapping
    public List<JournalEntryV2> getAllJournalEntries() {
        return journalEntryService.getAllJournalEntries();
    }

    @GetMapping("id/{myId}")
    public JournalEntryV2 getJournalEntryById(@PathVariable ObjectId myId) {
        return journalEntryService.getJournalEntryById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteJournalEntryById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntryV2 updateJournalEntryById(@PathVariable ObjectId myId, @RequestBody JournalEntryV2 newJournalEntry) {
        JournalEntryV2 currentJournalEntry = journalEntryService.getJournalEntryById(myId).orElse(null);
        if (currentJournalEntry != null) {
            currentJournalEntry.setTitle(newJournalEntry.getTitle() != null && !newJournalEntry.getTitle().isEmpty() ? newJournalEntry.getTitle() : currentJournalEntry.getTitle());
            currentJournalEntry.setContent(newJournalEntry.getContent() != null && !newJournalEntry.getContent().isEmpty() ? newJournalEntry.getContent() : currentJournalEntry.getContent());
        }
        journalEntryService.saveEntry(currentJournalEntry);
        return currentJournalEntry;
    }
}


/*
package com.SpringBootTutorial.journalApplication.controller;

import com.SpringBootTutorial.journalApplication.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntryMap = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return new ArrayList<>(journalEntryMap.values());
    }

    @PostMapping
    public boolean addJournalEntry(@RequestBody JournalEntry journalEntry) {
        journalEntryMap.put(journalEntry.getId(), journalEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable long myId) {
        return journalEntryMap.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long myId) {
        return journalEntryMap.remove(myId);
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable long myId, @RequestBody JournalEntry journalEntry) {
        return journalEntryMap.put(myId, journalEntry);
    }
}

*/

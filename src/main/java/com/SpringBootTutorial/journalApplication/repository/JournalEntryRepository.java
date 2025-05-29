package com.SpringBootTutorial.journalApplication.repository;

import com.SpringBootTutorial.journalApplication.entity.JournalEntryV2;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntryV2, ObjectId> {

}


// Controller --> service --> repository

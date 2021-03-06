package com.example.demo.Repositories;


import com.example.demo.Class.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<Journal, Long>{
    Journal findJournalById(long id);
 //   Iterable <Journal> findAllByArtistNameIgnoreCase(String artistName);

    String getArtistName();
}

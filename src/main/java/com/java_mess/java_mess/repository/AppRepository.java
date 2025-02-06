package com.java_mess.java_mess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java_mess.java_mess.model.App;

@Repository
public interface AppRepository extends JpaRepository<App, String>{
    App findByApiClientKey(String apiClientKey);
    
}

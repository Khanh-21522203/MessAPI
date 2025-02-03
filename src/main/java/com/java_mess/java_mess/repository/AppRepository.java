package com.java_mess.java_mess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java_mess.java_mess.model.App;

public interface AppRepository extends JpaRepository<App, String>{
    App findByApiClient(String apiClientKey);
    
}

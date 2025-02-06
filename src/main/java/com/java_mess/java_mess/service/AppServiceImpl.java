package com.java_mess.java_mess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.java_mess.java_mess.model.App;
import com.java_mess.java_mess.repository.AppRepository;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private AppRepository appRepository;

    @Override
    @Cacheable("getAppByClientKey")
    public App getAppByClientKey(String apiClientKey) {
        return appRepository.findByApiClientKey(apiClientKey);
    }
}

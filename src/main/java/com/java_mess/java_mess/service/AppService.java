package com.java_mess.java_mess.service;

import org.springframework.stereotype.Service;

import com.java_mess.java_mess.model.App;

@Service
public interface AppService {
    App getAppByClientKey(String apiClientKey);
}

package com.java_mess.java_mess.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.java_mess.java_mess.model.App;

import jakarta.servlet.http.HttpServletRequest;

public abstract class BaseController {

    @Autowired
    protected HttpServletRequest request;
  
    protected App getAuthenticatedApp() {
      return (App) request.getAttribute("authenticatedApp");
    }
}

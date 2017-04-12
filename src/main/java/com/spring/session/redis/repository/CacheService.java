package com.spring.session.redis.repository;

import java.util.List;

public interface CacheService {
    public void addMessage(String user,String message);
    public List<String> listMessages(String user);
}
package com.lyj.e3manager.search.service;

import com.lyj.e3common.pojo.SearchResult;

public interface SearchService {
    SearchResult search(String keyword,int page,int rows) throws Exception;
}

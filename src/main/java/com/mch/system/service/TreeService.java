package com.mch.system.service;

import java.util.Map;

public interface TreeService {

    Map<String,Object> loadRelTree(int parentId);
}

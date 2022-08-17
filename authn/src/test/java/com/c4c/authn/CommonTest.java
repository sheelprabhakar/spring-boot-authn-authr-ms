package com.c4c.authn;

import java.util.HashMap;
import java.util.Map;

public class CommonTest {
    public static Map<String, Object> getClaims(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "sheel");
        map.put("role", "ADMIN");
        return map;
    }
}

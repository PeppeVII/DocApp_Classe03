package it.unisa.progettois.docapp.utils;

import java.util.HashMap;
import java.util.Map;

public class StaticUrls {

    private static final HashMap<String, String> URLS = new HashMap<>();

    public static void init(String protocol,String ipHostname,String port){

        if (protocol == null || ipHostname == null || port == null) {
            throw new RuntimeException("Missing variables: PROTOCOL, IP_HOSTNAME, or PORT");
        }
        String baseUrl = protocol + ipHostname + ":" + port;

        URLS.put("url_register", baseUrl + "/api/auth/signup");
        URLS.put("url_login", baseUrl + "/api/auth/signin");
        URLS.put("url_login_token", baseUrl + "/api/auth/signin_token");
    }

    public static Map<String, String> getUrls() {
        return new HashMap<>(URLS);
    }

    public static String getUrl(String key) {
        return URLS.get(key);
    }
}

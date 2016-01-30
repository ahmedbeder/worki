/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necho;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author ahmed
 */
@ManagedBean
@SessionScoped
public class Fblogin {

    public static final String FB_APP_ID = "730823040356147";
    public static final String FB_APP_SECRET = "287e85ff4d2795de1446a81087902dad";
    public static final String REDIRECT_URI = "http://localhost:8080/Yah-Rab/index.html";

    static String accessToken = "";
    String a="false";

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getFBAuthUrl() {
        try {
            //        String fbLoginUrl = "";
//        try {
//            fbLoginUrl = "http://www.facebook.com/dialog/oauth?" + "client_id="
//                    + Fblogin.FB_APP_ID + "&redirect_uri="
//                    + URLEncoder.encode(Fblogin.REDIRECT_URI, "UTF-8")
//                    + "scope=publish_stream ";
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return fbLoginUrl;
      
            Facebook facebook = new FacebookFactory().getInstance();
            facebook.setOAuthAppId(FB_APP_ID, FB_APP_SECRET);
            facebook.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
            AccessToken oAuthAppAccessToken = facebook.getOAuthAppAccessToken();
            facebook.setOAuthAccessToken(oAuthAppAccessToken);
            facebook.postStatusMessage("Hello World from Facebook4J.");
           
            return "index.html";
            
          
        } catch (FacebookException ex) {
            Logger.getLogger(Fblogin.class.getName()).log(Level.SEVERE, null, ex);
        }
          return "templates/master-layout.xhtml";

    }

    public String postinf() {
        try {
            Facebook facebook = new FacebookFactory().getInstance();
            facebook.setOAuthAppId(FB_APP_ID, FB_APP_SECRET);
            facebook.setOAuthPermissions("");
            AccessToken oAuthAppAccessToken = facebook.getOAuthAppAccessToken();
            facebook.setOAuthAccessToken(oAuthAppAccessToken);
            facebook.postStatusMessage("Hello World from Facebook4J.");
            return null;
        } catch (FacebookException ex) {
            Logger.getLogger(Fblogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

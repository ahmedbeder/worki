package com.necho;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class FacebookImpl {
     public static final String FB_APP_ID = "730823040356147";

    public static String getFB_APP_ID() {
        return FB_APP_ID;
    }

    public static String getFB_APP_SECRET() {
        return FB_APP_SECRET;
    }
    public static final String FB_APP_SECRET = "287e85ff4d2795de1446a81087902dad";

    /**
     *
     * @param args
     * @throws FacebookException
     */
   

    public  String getFacebookPostes(Facebook facebook) throws FacebookException {
// Make the configuration builder
        ConfigurationBuilder confBuilder = new ConfigurationBuilder();
        confBuilder.setDebugEnabled(true);
// Set application id, secret key and access token 
        confBuilder.setOAuthAppId(FB_APP_ID);
        confBuilder.setOAuthAppSecret(FB_APP_SECRET);
        
        
// Set permission
        confBuilder.setOAuthPermissions("email,publish_stream, id, name, first_name, last_name, generic");
        confBuilder.setUseSSL(true);
        confBuilder.setJSONStoreEnabled(true);
// Create configuration object
        Configuration configuration = confBuilder.build();
        // Create facebook instance 
        FacebookFactory ff = new FacebookFactory(configuration);
        Facebook facebook2 = ff.getInstance();
         AccessToken oAuthAppAccessToken = facebook2.getOAuthAppAccessToken();
            facebook2.setOAuthAccessToken(oAuthAppAccessToken);
        try {
            // Get facebook posts
            String results = getFacebookPostes(facebook2);
            String responce = stringToJson(results);
// Create file and write to the file
            File file = new File("C:\\Facebook\\File\\test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(results);
            bw.close();
            System.out.println("Writing complete");
        } catch (IOException ex) {
            Logger.getLogger(FacebookImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
// Get posts for a particular search
        ResponseList<Post> results = facebook.getPosts("Reebok");
        return results.toString();
    }

    public  String stringToJson(String data) {
// Create JSON object 
        JSONObject jsonObject = JSONObject.fromObject(data);
        JSONArray message = (JSONArray) jsonObject.get("message");
        System.out.println("Message : " + message);
        return "Done";
    }
}

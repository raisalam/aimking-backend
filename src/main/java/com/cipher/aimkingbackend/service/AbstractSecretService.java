package com.cipher.aimkingbackend.service;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class AbstractSecretService {

  private static String REQUEST_KEY = "t8V0x5z6c7f2j4a8s7d6h3k1m9p0q2r5";

  public JSONObject decryptRequest(String request){

    try{
      /**
       *  "a" = "userName"
       *  "b" = "password"
       *  "c" = "androidId"
       *  "e" = "storage information"
       *  "f" = "Device build combination"
       *  "g" = "Device MediaDrm uniqueId"
       */


      JSONObject jsonObject = new JSONObject(request);

      HashMap<String, String> hashMap = new HashMap<>();


      Iterator<String> keys =jsonObject.keys();

      while (keys.hasNext()) {

        String key = keys.next();
        String value = jsonObject.getString(key);
        if(key.equals("a") || key.equals("b") || key.equals("c")){
          hashMap.put(key, decrypt(value));
        } else if( key.equals("e")|| key.equals("f")|| key.equals("g")|| key.equals("h")){
          hashMap.put(key, decrypt(value));
        }
        else {
          hashMap.put(key, value);
        }

      }
      // System.out.println(hashMap);
      return new JSONObject(hashMap);


    }catch (Exception e){
      e.printStackTrace();
      return new JSONObject();
    }
  }

  public static String decrypt(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char charAt = str.charAt(i);
      sb.append((char) (charAt ^ REQUEST_KEY.charAt(i % REQUEST_KEY.length())));
    }
    return sb.toString();
  }
}

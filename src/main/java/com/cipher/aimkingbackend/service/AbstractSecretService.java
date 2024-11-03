package com.cipher.aimkingbackend.service;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AbstractSecretService {

  private static String REQUEST_KEY = "t8V0x5z6c7f2j4a8s7d6h3k1m9p0q2r5";
  protected static String RESPONSE_KEY = "v0x5d5c7f2j4a8s7d6h3k1m9p0q2r5";

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

  private String decrypt(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char charAt = str.charAt(i);
      sb.append((char) (charAt ^ REQUEST_KEY.charAt(i % REQUEST_KEY.length())));
    }
    return sb.toString();
  }


  protected String Il1i(String str) {
    if (str == null) {
      return null;
    }
    return oOOOOOO0oO0(str.getBytes());
  }
  protected static String O0oo0o0Oo(String str, String str2) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sb.append((char) (str.charAt(i) ^ str2.charAt(i % str2.length())));
    }
    return sb.toString();
  }

  private String oOOOOOO0oO0(byte[] bArr) {
    if (bArr == null) {
      return null;
    }
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(bArr);
      return o0o(messageDigest.digest());
    } catch (Throwable th) {
      th.printStackTrace();
      return null;
    }
  }


  private String o0o(byte[] bArr) {
    if (bArr == null) {
      return null;
    }
    return oO0Oo0o0(bArr, 0, bArr.length);
  }

  private String oO0Oo0o0(byte[] bArr, int i, int i2) {
    if (bArr == null || i < 0 || i2 < 0) {
      return null;
    }
    StringBuilder sb = new StringBuilder(i2 * 2);
    int i3 = i2 + i;
    while (i < i3) {
      String hexString = Integer.toHexString(bArr[i] & 255);
      if (hexString.length() == 1) {
        hexString = "0" + hexString;
      }
      sb.append(hexString);
      i++;
    }
    return sb.toString();
  }
  protected Map<String, String> jsonToMap(JSONObject jsonObject) {
    Map<String, String> map = new HashMap<>();
    Iterator<String> keys = jsonObject.keys();
    while (keys.hasNext()) {
      String key = keys.next();
      map.put(key, jsonObject.getString(key));
    }
    return map;
  }
  public JSONObject decryptSecondRequest(String request){

    try{

      JSONObject jsonObject = new JSONObject(request);

      HashMap<String, String>   hashMap = new HashMap<>();


      Iterator<String> keys =jsonObject.keys();

      while (keys.hasNext()) {

        String key = keys.next();
        String value = jsonObject.getString(key);
        hashMap.put(key, secondRequestXor(value));
      }
      // System.out.println(hashMap);
      return new JSONObject(hashMap);


    }catch (Exception e){
      e.printStackTrace();
      return new JSONObject();
    }
  }
  public static String secondRequestXor(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      char charAt = str.charAt(i);

      sb.append((char) (charAt ^ RESPONSE_KEY.charAt(i % RESPONSE_KEY.length())));
    }
    return sb.toString();
  }
}



package com.cipher.aimkingbackend.controller;


import com.cipher.aimkingbackend.entity.User;
import com.cipher.aimkingbackend.service.AkLoader331SecretService;
import com.cipher.aimkingbackend.service.EncryptionDecryption;
import com.cipher.aimkingbackend.service.UserService;
import com.cipher.aimkingbackend.utill.Utill;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class MainController {

  private final AkLoader331SecretService akLoader331SecretService;
  private final UserService userService;

  @PostMapping(value = "/functions/xxxxx6xxxxx", produces = "application/json")
  public ResponseEntity<String> login330(@RequestBody String body, HttpServletRequest request) {
    System.out.println("=========First Call Start ==============");
    // Print headers
    Enumeration<String> headerNames = request.getHeaderNames();
    //  System.out.println("Headers:");

    JSONObject jsonObject = EncryptionDecryption.firstRequest(body);
    String userName = jsonObject.getString("a");
    String password = jsonObject.getString("b");
    String androidId = jsonObject.getString("c");
    String deviceBuild = jsonObject.getString("f");
    String deviceMedia = jsonObject.getString("g");
    String ipAddress = "";
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      if (headerName != null && headerName.equals("cf-connecting-ip")) {
        ipAddress = request.getHeader(headerName);
      }
    }


    User user = userService.findUser(userName, password, androidId, deviceBuild, deviceMedia, ipAddress);
    System.out.println("User " + user.getUserName() + " is authenticated successfully");

    System.out.println(jsonObject);
    System.out.println("User "+user.getUserName()+" is authenticated successfully");
    System.out.println("=========First Call end ==============");
    Map<String, String> map;
    if(jsonObject.getString("d").equalsIgnoreCase("3582_64bit")){
      map = EncryptionDecryption.getHashMap();
      map.put("expiryTime", Utill.getFormattedDate(user.getEndDate()));
    } else {
      map = EncryptionDecryption.getHashMapEightBallPool10();
      map.put("expiryTime", Utill.getFormattedDateEightballpool10(user.getEndDate()));
      map.put("isenable_autoqueue", "3");
      map.put("message", "1");
    }
    JSONObject finalJson = new JSONObject();
    finalJson.put("result",
        new JSONObject(EncryptionDecryption.OO00o0(jsonObject.getString("c"), map)));
    return ResponseEntity.ok(finalJson.toString());

  }



  //@PostMapping(value = "/functions/xxxxx7xxxxx", produces = "application/json")
  public ResponseEntity<String> login(@RequestBody String body, HttpServletRequest request) {
    System.out.println("=========Login Start==============");
    // Print headers
    Enumeration<String> headerNames = request.getHeaderNames();
    //  System.out.println("Headers:");

    JSONObject jsonObject = akLoader331SecretService.decryptRequest(body);

    String userName = jsonObject.getString("a");
    String password = jsonObject.getString("b");
    String androidId = jsonObject.getString("c");
    String deviceBuild = jsonObject.getString("f");
    String deviceMedia = jsonObject.getString("g");

    String ipAddress = "";
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      if (headerName != null && headerName.equals("cf-connecting-ip")) {
        ipAddress = request.getHeader(headerName);
      }
    }
    System.out.println(String.format(
        "User Information:\n" + "-----------------\n" + "Username     : %s\n"
            + "Password     : %s\n" + "Android ID   : %s\n" + "Device Build : %s\n"
            + "Device Media : %s\n" + "IP Address   : %s\n", userName, password, androidId,
        deviceBuild, deviceMedia, ipAddress));
    System.out.println();

    User user = userService.findUser(userName, password, androidId, deviceBuild, deviceMedia, ipAddress);
    System.out.println("User " + user.getUserName() + " is authenticated successfully");
    Map<String, String> map;
    if (jsonObject.getString("d").equalsIgnoreCase("3582_64bit")) {
      map = akLoader331SecretService.getHashMapEightBallPool55_9();
      map.put("expiryTime", Utill.getFormattedDate(user.getEndDate()));
    } else {
      map = akLoader331SecretService.getHashMapEightBallPool55_10();
      map.put("expiryTime", Utill.getFormattedDateEightballpool10(user.getEndDate()));
      // map.put("isenable_autoqueue", "3");
      //  map.put("message", "1");
    }
    JSONObject finalJson = new JSONObject();
    finalJson.put("result", new JSONObject(
        akLoader331SecretService.populateHashMapForResponse(jsonObject.getString("c"), map)));
    System.out.println("=========Login End==============");
    System.out.println();

    return ResponseEntity.ok(finalJson.toString());

  }


  @PostMapping(value = "/functions/oOooOHID", produces = "application/json")
  public ResponseEntity<String> authenticate(@RequestBody(required = false) String body,
      HttpServletRequest request) {
    System.out.println("========Second request call :oOooOHID: ======");
    try{
      Enumeration<String> headerNames = request.getHeaderNames();
      System.out.println("Body :"+body);

      JSONObject jsonObject = akLoader331SecretService.decryptSecondRequest(body);
      System.out.println(jsonObject);
      while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        if(headerName != null && (headerName.equals("cf-ipcity")|| headerName.equals("cf-connecting-ip"))) {
          String headerValue = request.getHeader(headerName);
          System.out.println(headerName + ": " + headerValue + " : android id = "+jsonObject.getString("AID"));
        }
      }
    }catch (Exception e){
      System.out.println("Second request decrypt error : "+e.getMessage());
    }

    System.out.println("========Second request end======");
    return ResponseEntity.ok(
        "{\"result\":{\"\\u001bU\\u000bF\\u0005R\\u0006\":\"\\u0005E\\u001bV\\u0001F\\u0010\",\"\\u0005D\\u0019A\\u0011F\":\"D\\u0000H\"}}");
    //  return ResponseEntity.badRequest().body("{\"error\":\"VIP expired\"}");

  }

  @PostMapping(value = "/functions/oOooOTME", produces = "application/json")
  public ResponseEntity<String> authenticate2(@RequestBody(required = false) String body,
      HttpServletRequest request) {
    System.out.println("========Second request call======oOooOTME");
    try{
      Enumeration<String> headerNames = request.getHeaderNames();
      System.out.println("Body :"+body);
      JSONObject jsonObject = akLoader331SecretService.decryptSecondRequest(body);
      System.out.println(jsonObject);
      while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        if(headerName != null && (headerName.equals("cf-ipcity")|| headerName.equals("cf-connecting-ip"))) {
          String headerValue = request.getHeader(headerName);
          System.out.println(headerName + ": " + headerValue + " : android id = "+jsonObject.getString("AID"));
        }
      }
    }catch (Exception e){
      System.out.println("Second request decrypt error : "+e.getMessage());
    }
    System.out.println("========Second request end======");
    System.out.println();
    return ResponseEntity.ok(
        "{\"result\":{\"\\u001bU\\u000bF\\u0005R\\u0006\":\"\\u0005E\\u001bV\\u0001F\\u0010\",\"\\u0005D\\u0019A\\u0011F\":\"D\\u0000H\"}}");
    //  return ResponseEntity.badRequest().body("{\"error\":\"VIP expired\"}");

  }

}

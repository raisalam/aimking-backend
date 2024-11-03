package com.cipher.aimkingbackend.controller;


import com.cipher.aimkingbackend.entity.User;
import com.cipher.aimkingbackend.service.AkLoader331SecretService;
import com.cipher.aimkingbackend.service.UserService;
import com.cipher.aimkingbackend.utill.EncryptionDecryption331;
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

 private final  AkLoader331SecretService akLoader331SecretService;
 private final UserService userService;
   @PostMapping(value = "/functions/xxxxx7xxxxx", produces = "application/json")
  public ResponseEntity<String> login(@RequestBody String body, HttpServletRequest request) {
    System.out.println("=========First Call Start ==============");
    // Print headers
    Enumeration<String> headerNames = request.getHeaderNames();
    //  System.out.println("Headers:");

    JSONObject jsonObject = akLoader331SecretService.decryptRequest(body);

    String userName = jsonObject.getString("a");
     String password = jsonObject.getString("b");
     String androidId = jsonObject.getString("c");
     String deviceBuild = jsonObject.getString("f");
     String deviceMedia = jsonObject.getString("g");

    User user = userService.findUser(userName, password, androidId, deviceBuild, deviceMedia);
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      if(headerName != null && (headerName.equals("cf-ipcity")|| headerName.equals("cf-connecting-ip"))) {
        String headerValue = request.getHeader(headerName);
        System.out.println(headerName + ": " + headerValue + " : android id [" + jsonObject.getString("c") + "], user ["+user.getUserName()+"]");
      }
    }
    System.out.println(jsonObject);
    System.out.println("User "+user.getUserName()+" is authenticated successfully");
    System.out.println("=========First Call end ==============");
    Map<String, String> map;
    if(jsonObject.getString("d").equalsIgnoreCase("3582_64bit")){
      map = EncryptionDecryption331.getHashMapEightBallPool55_9();
      map.put("expiryTime", Utill.getFormattedDate(user.getEndDate()));
    } else {
      map = EncryptionDecryption331.getHashMapEightBallPool55_10();
      map.put("expiryTime", Utill.getFormattedDateEightballpool10(user.getEndDate()));
      // map.put("isenable_autoqueue", "3");
      //  map.put("message", "1");
    }
    JSONObject finalJson = new JSONObject();
    finalJson.put("result",
        new JSONObject(EncryptionDecryption331.OO00o0New(jsonObject.getString("c"), map)));
    System.out.println(" === "+finalJson.toString());
    return ResponseEntity.ok(finalJson.toString());

  }
}

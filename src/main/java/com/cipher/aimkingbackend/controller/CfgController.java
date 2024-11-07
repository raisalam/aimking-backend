package com.cipher.aimkingbackend.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequiredArgsConstructor
public class CfgController {

 // @PostMapping("/functions/queryCfg")
  public ResponseEntity<String> getCustomResponse() {
    System.out.println("Going to return response from cfG");

    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    if (requestAttributes != null) {
      HttpServletRequest request = requestAttributes.getRequest();

      // Print request headers
      System.out.println("Request Headers:");
      request.getHeaderNames().asIterator().forEachRemaining(headerName ->
          System.out.println(headerName + ": " + request.getHeader(headerName))
      );

      // Print request body
      System.out.println("Request Body: =====");
      try (BufferedReader reader = request.getReader()) {
        StringBuilder body = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          body.append(line).append("\n");
        }
        System.out.println(body.toString());
        System.out.println("Request body end =======");
      } catch (IOException e) {
        System.out.println("Error reading request body: " + e.getMessage());
      }
    }



    HttpHeaders headers = new HttpHeaders();


    headers.add("Access-Control-Allow-Credentials", "true");
    headers.add("Access-Control-Allow-Headers", "DNT, Keep-Alive, User-Agent, X-Requested-With, If-Modified-Since, Cache-Control, Content-Type, X-Application-ID, X-Access-Token, X-Parse-Master-Key, X-Parse-REST-API-Key, X-Parse-Javascript-Key, X-Parse-Application-Id, X-Parse-Client-Version, X-Parse-Session-Token, X-Requested-With, X-Parse-Revocable-Session, X-CSRF-Token, X-Parse-Client-Key, X-Parse-Request-Id");
    headers.add("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE, OPTIONS");
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Expose-Headers", "X-Parse-Job-Status-Id, X-Parse-Push-Status-Id");
    //   headers.add("Accept-Encoding", "gzip");

    headers.add("Date", ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));



    headers.add("ETag", "W/\"20b-L3DP8doN3WqHJOD0yKGA0M+bma4\"");
    headers.add("Server", "nginx");
    headers.add("Vary", "Accept-Encoding");
    headers.add("X-Content-Type-Options", "nosniff");
    headers.add("X-Frame-Options", "SAMEORIGIN");
    headers.add("X-Powered-By", "Express");
    headers.add("X-XSS-Protection", "1; mode=block");
    headers.add("X-Cache", "Miss from cloudfront");
    headers.add("Via", "1.1 bd3f8a07a0dda8b80498a0b92378cd90.cloudfront.net (CloudFront)");
    headers.add("X-Amz-Cf-Pop", "MRS52-P3");
    headers.add("X-Amz-Cf-Id", "8lSs7y66f6JVb6dIhtyypCxq2VmG0Zdb_dIfev4A0OVosei3mf8dHg==");

    // JSON response body
    String responseBody = "{\"result\":\"{\\\"CFG\\\":{\\\"e\\\":20,\\\"e1\\\":17,\\\"f\\\":0,\\\"i\\\":176,\\\"j\\\":325,\\\"k\\\":2,\\\"x\\\":0,\\\"y\\\":1,\\\"y2\\\":1,\\\"l\\\":1,\\\"r\\\":1,\\\"s\\\":1,\\\"t\\\":0,\\\"z11\\\":3,\\\"z2\\\":7,\\\"z3\\\":0,\\\"z4\\\":13,\\\"o2\\\":\\\"v0_3561-320\\\",\\\"o3\\\":\\\"\\\",\\\"w1\\\":3,\\\"w2\\\":3,\\\"w3\\\":4},\\\"UPDATE\\\":{\\\"a\\\":\\\"https://raw.githubusercontent.com/gpList/picList-up1/master/aimking/king-mc-3.2.6.png\\\",\\\"b\\\":\\\"3.2.6\\\",\\\"c\\\":326,\\\"d\\\":\\\"32F614560159E8A9B0968280BA6EB8A5\\\",\\\"e\\\":\\\"com.code.seconding\\\",\\\"f\\\":\\\"https://www.mediafire.com/file/lo99tldz79sdgxq/king-mc-3.2.6.apk/file\\\"}}\"}";
    System.out.println("Response returned "+responseBody);
    headers.setContentLength(responseBody.length());
    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .headers(headers)
        .body(responseBody);


    // return new ResponseEntity<>(responseBody, headers, HttpStatus.OK);
  }
}

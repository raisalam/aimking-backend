package com.cipher.aimkingbackend.service;


import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AkLoader331SecretService extends AbstractSecretService {

  static String eightBallpool10Response =
      "{\"result\":{\"\\u0006\\u0007A\\u0002\":\"3616-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEEBgZoVwdRDERAGQ==\",\"\\u000f\\u0003F\\u0010Q\\u0001V\":\"S\",\"\\u0011\\u0012T\\u0017E\\u0015\":\"PV\\u0005\",\"\\t\\u0003L\":\"[R\\u0000T\\u0002\\u0002\\u0005WWQQ\\u0004\\u0007\\tWWTSSSV]\\u0000\\u0002\\u0001\\u0006\\u0004\\u000fQ\\bTR\",\"\\u0007\\u001eE\\nB\\u001fg\\u000b\\f\\u0003\":\"1\\u0007AC\u007F\\u0005GBSPB\\u0002T\\u000b\\u0002FS\\u0007\\fUS\\u0002\\t\\t\\u0012t/m\\u0019\\t\\u0002VRF\\u001d _\\tA\\u0006\\b\\b\\u0003D\\u0001]\\u00163\\fX@\\u0003\\u0013KY\\\\\\u0012g\\u000bTW\\u0010\",\"\\u000e\\u0005j\\u0017I\\u0016V\":\"Q\",\"\\u000e\\u0005j\\u0014X\\u000fG\\u0007\":\"\\u0012\\tZ\\u000f\\u001e\\bG\\u0012O\\t\\u0010WKZ[H\\u0011TD\\u0003\\u000f_\\u0016][]\\u000bZ^PB\\u0016\\u0016HV\\f]\\u0014V\\u0016N\\n\\u000bF\\u0001\\u0014U\\t\\fW_\\u0001OHW_^\\u001d\\u000fP\\\\PQ\\n\\u000b\\u0016E\\u0017\\u001f\\u000b\\\\\\u0000\\b\\n\\u0007\\u001d\\bP@\\u0003LAY\\t\\r\\u0016UY\\\\Z\\u0001U[IB\\u0012M\\u0000T\\u0000U\\u0004\\\\\\r\\n\",\"\\u0017\\u0016j\\u0015S\\tW\\u0007\":\"QS\\rQ\",\"\\u0017\\u0016j\\u0015^\\u0007^\\u0007\":\"WS\\u001bZ\\u001eV\",\"\\u0001\\u0010Q\\u0006\\\\\\u0012R\":\"UT\\u0005S\"}}";
  private static Map<String, String> gameDataEightBallPool9;
  private static Map<String, String> gameDataEightBallPool10;
  private static String eightBallpool9Response =
      "{\"result\":{\"\\u0006\\u0007A\\u0002\":\"3582-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEHDwJoVwdRDERAGQ==\",\"\\u000f\\u0003F\\u0010Q\\u0001V\":\"S\",\"\\u0011\\u0012T\\u0017E\\u0015\":\"PV\\u0005\",\"\\t\\u0003L\":\"[R\\u0000T\\u0002\\u0002\\u0005WWQQ\\u0004\\u0007\\tWWTSSSV]\\u0000\\u0002\\u0001\\u0006\\u0004\\u000fQ\\bTR\",\"\\u0007\\u001eE\\nB\\u001fg\\u000b\\f\\u0003\":\"1\\u0007AC\u007F\\u0005GBSPB\\u0002T\\u000b\\u0002FS\\u0007\\fUS\\u0002\\t\\t\\u0012t/m\\u0019\\t\\u0002VRF\\u001d _\\tA\\u0006\\b\\b\\u0003D\\u0001]\\u00163\\fX@\\u0003\\u0013KY\\\\\\u0012g\\u000bTW\\u0010\",\"\\u000e\\u0005j\\u0017I\\u0016V\":\"Q\",\"\\u000e\\u0005j\\u0014X\\u000fG\\u0007\":\"\\u0012\\tZ\\u000f\\u001e\\bG\\u0012O\\t\\u0010WKZ[H\\u0011TD\\u0003\\u000f_\\u0016][]\\u000bZ^PB\\u0016\\u0016HV\\f]\\u0014V\\u0016N\\n\\u000bF\\u0001\\u0014U\\t\\fW_\\u0001OHW_^\\u001d\\u000fP\\\\PQ\\n\\u000b\\u0016E\\u0017\\u001f\\u000b\\\\\\u0000\\b\\n\\u0007\\u001d\\bP@\\u0003LAY\\t\\r\\u0016UY\\\\Z\\u0001U[IB\\u0012M\\u0000T\\u0000U\\u0004\\\\\\r\\n\",\"\\u0017\\u0016j\\u0015S\\tW\\u0007\":\"QS\\rQ\",\"\\u0017\\u0016j\\u0015^\\u0007^\\u0007\":\"WS\\u001bZ\\u001eV\",\"\\u0001\\u0010Q\\u0006\\\\\\u0012R\":\"UT\\u0005S\"}}";

  public Map<String, String> getHashMapEightBallPool55_10() {
    if (gameDataEightBallPool10 != null) {
      return gameDataEightBallPool10;
    }

    try {
      // First HashMap initialization from `eightBallpool10Response`
      Map<String, String> hashMap =
          jsonToMap(new JSONObject(eightBallpool10Response).getJSONObject("result"));

      // Reinitialize `hashMap` with data from `populateHashMap`
      JSONObject additionalData = new JSONObject(populateHashMap("b4bf77661d68531f", hashMap));
      hashMap = jsonToMap(additionalData);

      // Add static data
      hashMap.put("data",
          "3616-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEEBgZoVwdRDERAGQ==");

      // Cache the result
      gameDataEightBallPool10 = hashMap;
    } catch (Exception e) {
      System.err.println("Error processing JSON data: " + e.getMessage());
    }

    return gameDataEightBallPool10;
  }

  public Map<String, String> getHashMapEightBallPool55_9() {
    if (gameDataEightBallPool9 != null) {
      return gameDataEightBallPool9;
    }

    try {
      // First HashMap initialization from `eightBallpool9Response`
      Map<String, String> hashMap =
          jsonToMap(new JSONObject(eightBallpool9Response).getJSONObject("result"));

      // Reinitialize `hashMap` with data from `populateHashMap`
      JSONObject additionalData = new JSONObject(populateHashMap("b4bf77661d68531f", hashMap));
      hashMap = jsonToMap(additionalData);

      // Add static data
      hashMap.put("data",
          "3582-SBEEElhGA1IBUARHG0oXURJfE1RSDQVbAgYAABUcFQIRCUdSVgYHVgRVAgRdUA0GA1RXFBVHABcJFQEHDwJoVwdRDERAGQ==");

      // Cache the result
      gameDataEightBallPool9 = hashMap;
    } catch (Exception e) {
      System.err.println("Error processing JSON data: " + e.getMessage());
    }

    return gameDataEightBallPool9;
  }

  public HashMap populateHashMap(String str, Map<String, String> hashMap) {
    HashMap hashMap2 = new HashMap();
    try {
      for (Map.Entry entry : hashMap.entrySet()) {
        hashMap2.put(O0oo0o0Oo((String) entry.getKey(), Il1i(str)),
            O0oo0o0Oo((String) entry.getValue(), Il1i(str)));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return hashMap2;
  }

  public HashMap populateHashMapForResponse(String str, Map<String, String> hashMap) {

    HashMap hashMap2 = new HashMap();
    try {
      for (Map.Entry<String, String> entry : hashMap.entrySet()) {
        if (entry.getKey().equalsIgnoreCase("data")) {
          hashMap2.put(O0oo0o0Oo(entry.getKey(), Il1i(str)), entry.getValue());
        } else {
          hashMap2.put(O0oo0o0Oo( entry.getKey(), Il1i(str)),
              O0oo0o0Oo( entry.getValue(), Il1i(str)));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return hashMap2;
  }

}

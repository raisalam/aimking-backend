package com.cipher.aimkingbackend.utill;

import java.nio.charset.StandardCharsets;

public class Liii11I {

  public static String nativeMark21(String input) {
    String xorKeyHex = "A62E8CBCC53EDCEF695518445D140190758185E6A4B4869221E6625E6134DC47BFAF413D3E2EF4562E794A";
    // Convert hex key to byte array
    int len = xorKeyHex.length();
    byte[] xorKeyBytes = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
      xorKeyBytes[i / 2] = (byte) ((Character.digit(xorKeyHex.charAt(i), 16) << 4)
          + Character.digit(xorKeyHex.charAt(i + 1), 16));
    }

    // Determine if input is raw JSON or hex-encoded encrypted text
    boolean isHex = input.matches("[0-9A-Fa-f]+");
    System.out.println("Input == "+input);
    System.out.println("IsHax == "+isHex);

    byte[] inputBytes;
    if (isHex) {
      // If input is hex string, convert to byte array for decryption
      inputBytes = new byte[input.length() / 2];
      for (int i = 0; i < input.length(); i += 2) {
        inputBytes[i / 2] = (byte) ((Character.digit(input.charAt(i), 16) << 4)
            + Character.digit(input.charAt(i + 1), 16));
      }
    } else {
      // Input is raw JSON, convert it to byte array for encryption
      inputBytes = input.getBytes(StandardCharsets.UTF_8);
    }
    // XOR encryption/decryption
    byte[] outputBytes = new byte[inputBytes.length];
    for (int i = 0; i < inputBytes.length; i++) {
      outputBytes[i] = (byte) (inputBytes[i] ^ xorKeyBytes[i % xorKeyBytes.length]);
    }

    if (isHex) {
      // If input was hex, convert the output back to original string (decrypted)
      System.out.println("Output = "+new String(outputBytes, StandardCharsets.UTF_8));
      return new String(outputBytes, StandardCharsets.UTF_8);
    } else {
      // Otherwise, convert encrypted bytes to hex string
      StringBuilder sb = new StringBuilder();
      for (byte b : outputBytes) {
        sb.append(String.format("%02X", b));
      }
      System.out.println("Generate FLOGIN ====="+sb.toString());
      return sb.toString();
    }
  }

  public static void main(String[] args) {
    try{

    //  System.out.println(nativeMark21("FCODE00000080b7fb83a6d24e0d7a207edb33babd93953EF434B6CE5A3D7C2380618F53258BCCD481B99C49667E72917261C52D4235A46DB03941EAF310B669B2EDDA4C22F5B5"));
      System.out.println(nativeMark21("3EF434B6CE5A3D7C2380618F53258BCCD481B99C49667E72917261C52D4235A46DB03941EAF310B669B2EDDA4C22F5B5"));

    }catch (Exception e){
      e.printStackTrace();
    }
  }
}

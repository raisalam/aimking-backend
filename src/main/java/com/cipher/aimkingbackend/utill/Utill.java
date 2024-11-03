package com.cipher.aimkingbackend.utill;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * (C) [YEAR] Cloud Eagle. All rights reserved.
 *
 * This file is the property of Cloud Eagle and may not be copied or distributed without permission.
 * Unauthorised access to this file is prohibited.
 */
public class Utill {

  public static String getFormattedDate(LocalDateTime dateTime) {

    ZonedDateTime kolkataZonedDateTime = dateTime.atZone(ZoneId.of("UTC"));

    // Now convert to the target timezone
    ZonedDateTime bangkokZonedDateTime =
        kolkataZonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Bangkok"));

    // Format the date
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)");
    String formattedDate = bangkokZonedDateTime.format(formatter);
    return formattedDate;
  }

  public static String getFormattedDateEightballpool10(LocalDateTime dateTime) {

    ZonedDateTime kolkataZonedDateTime = dateTime.atZone(ZoneId.of("UTC"));

    // Format the date
    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("EEE MMM dd yyyy HH:mm:ss 'GMT'Z (zzzz)");
    String formattedDate = kolkataZonedDateTime.format(formatter);
    return formattedDate;
  }
}

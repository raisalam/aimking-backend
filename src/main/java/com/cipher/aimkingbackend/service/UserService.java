package com.cipher.aimkingbackend.service;

import com.cipher.aimkingbackend.entity.SystemSetting;
import com.cipher.aimkingbackend.entity.User;
import com.cipher.aimkingbackend.exception.ApplicationException;
import com.cipher.aimkingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private static final String CONTACT = "@cipher_39";
  private final UserRepository userRepository;
  private final SystemSettingService systemSettingService;
  private final CacheManager cacheManager;
  private User freeUser;

  @Transactional
  public User findUser(String userName, String password, String androidId, String deviceBuild,
      String deviceMedia, String ipAddress) {
    Optional<User> freeUserOpt = findUserFree(userName, password);
    if (freeUserOpt.isPresent()) {
      return freeUserOpt.get();
    }

    Optional<User> userOpt = userRepository.findByUserNameAndPassword(userName, password);
    if (!userOpt.isPresent()) {
      throw new ApplicationException("Invalid username or password contact " + CONTACT,
          "[" + userName + "] with password [" + password + "] is invalid");
    }
    System.out.println("User is found " + userOpt.get().getUserName());
    User user = userOpt.get();
    if (!StringUtils.hasText(user.getAndroidId()) && StringUtils.hasText(androidId)) {
      user.setAndroidId(androidId.trim());
    } else if (!user.getAndroidId().equals(androidId)) {
      throw new ApplicationException("Invalid device contact " + CONTACT,
          "[" + userName + "] with password [" + password
              + "] entered invalid androidId original is " + user.getAndroidId() + " new is ["
              + androidId + "]");
    }
    if (!user.getActive()) {
      throw new ApplicationException("Login failed: User blocked", userName + " is blocked ");
    }
    if (!StringUtils.hasText(user.getIpAddresses()) && StringUtils.hasText(ipAddress)) {
      user.setIpAddresses(ipAddress.trim());
    }
    if (!StringUtils.hasText(user.getDeviceBuildId()) && StringUtils.hasText(deviceBuild)) {
      user.setDeviceBuildId(deviceBuild.trim());
    } else if (!user.getDeviceBuildId().equals(deviceBuild.trim())) {
      throw new ApplicationException("Invalid device contact " + CONTACT,
          "[" + userName + "] with password [" + password
              + "] entered invalid deviceBuildId original is " + user.getDeviceBuildId()
              + " new is [" + deviceBuild + "]");
    }

    if (!StringUtils.hasText(user.getDeviceMediaId()) && StringUtils.hasText(deviceMedia)) {
      user.setDeviceMediaId(deviceMedia.trim());
    } else if (StringUtils.hasText(user.getDeviceMediaId()) && (!StringUtils.hasText(deviceMedia) || !user.getDeviceMediaId().equals(deviceMedia.trim()))) {
      throw new ApplicationException("Invalid device contact " + CONTACT,
          "[" + userName + "] with password [" + password
              + "] entered invalid deviceMediaId original is [" + user.getDeviceMediaId()
              + "] new is [" + deviceMedia + "]");
    }

    LocalDateTime currentDate = LocalDateTime.now();
    if (user.getStartDate() == null) {
      user.setStartDate(currentDate);
    }

    LocalDateTime endDate = user.getEndDate();

    if (endDate == null) {
      user.setEndDate(currentDate.plusMinutes(user.getPlan().getDuration()));
    } else if (currentDate.isAfter(endDate)) {
      throw new ApplicationException("Subscription expired on " + endDate,
          "Subscription expired for user " + userName + " on " + endDate);
    }
    return user;
  }

  @Transactional
  public Optional<User> findUserFree(String userName, String password) {
    if (!isFreeEnabled()) {
      return Optional.empty();
    }

    String freeUserName = getSystemSettingValue("free_userName");
    String freeUserPassword = getSystemSettingValue("free_password");

    if (!userName.equalsIgnoreCase(freeUserName) || !password.equalsIgnoreCase(freeUserPassword)) {
      return Optional.empty();
    }

    if (freeUser == null) {
      freeUser = createFreeUser();
    }

    if (freeUser.getEndDate().isBefore(LocalDateTime.now())) {
      disableFreeAccess();
      return Optional.empty();
    }

    return Optional.of(freeUser);
  }

  private boolean isFreeEnabled() {
    String isFreeEnabled = getSystemSettingValue("free_enabled");
    return "true".equalsIgnoreCase(isFreeEnabled);
  }

  private String getSystemSettingValue(String key) {
    return systemSettingService.getSystemSetting(key)
        .orElseThrow(() -> new ApplicationException("Key does not exist", "Key [" + key + "] does not exist"))
        .getValue();
  }

  private User createFreeUser() {
    LocalDateTime endDate = parseEndDate();
    return User.builder().endDate(endDate).build();
  }

  private LocalDateTime parseEndDate() {
    try {
      String endDateString = getSystemSettingValue("free_endDate");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime endDate = LocalDateTime.parse(endDateString, formatter);

      if (endDate.isBefore(LocalDateTime.now())) {
        disableFreeAccess();
      }

      return endDate;
    } catch (DateTimeParseException e) {
      System.err.println("Error parsing date: " + e.getMessage());
      return LocalDateTime.now().plusDays(1); // Default value in case of parse failure
    }
  }

  private void disableFreeAccess() {
    SystemSetting freeSetting = systemSettingService.getSystemSetting("free_enabled")
        .orElseThrow(() -> new ApplicationException("Key does not exist", "Key [free_enabled] does not exist"));
    freeSetting.setValue("false");
    systemSettingService.saveSystemSetting(freeSetting);
    clearCache();
  }

  private void clearCache() {
    cacheManager.getCacheNames().forEach(cacheName -> {
      if (cacheManager.getCache(cacheName) != null) {
        cacheManager.getCache(cacheName).clear();
      }
    });
  }
}

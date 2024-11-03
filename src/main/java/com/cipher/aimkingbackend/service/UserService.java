package com.cipher.aimkingbackend.service;

import com.cipher.aimkingbackend.entity.User;
import com.cipher.aimkingbackend.exception.ApplicationException;
import com.cipher.aimkingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

  private static final String CONTACT = "@contact";
  private final UserRepository userRepository;

  @Transactional
  public User findUser(String userName, String password, String androidId,
      String deviceBuild,String deviceMedia, String ipAddress) {
    Optional<User> userOpt = userRepository.findByUserNameAndPassword(userName, password);
    if (!userOpt.isPresent()) {
      throw new ApplicationException("Invalid username or password contact " + CONTACT,
          userName + " with password" + password + " is invalid");
    }
    System.out.println("User is found " + userOpt.get().getUserName());
    User user = userOpt.get();
    if (!StringUtils.hasText(user.getAndroidId()) && StringUtils.hasText(androidId)) {
      user.setAndroidId(androidId.trim());
    } else if (!user.getAndroidId().equals(androidId)) {
      throw new ApplicationException("Invalid device contact " + CONTACT,
          userName + " with password" + password + " entered invalid androidId original is "
              + user.getAndroidId() + " new is " + androidId);
    }
    if (!user.getActive()) {
      throw new ApplicationException("Login failed: User blocked", userName +" is blocked ");
    }
    if (!StringUtils.hasText(user.getIpAddresses()) && StringUtils.hasText(ipAddress)) {
      user.setIpAddresses(ipAddress.trim());
    }
    if (!StringUtils.hasText(user.getDeviceBuildId()) && StringUtils.hasText(deviceBuild)) {
      user.setDeviceBuildId(deviceBuild.trim());
    } else if (!user.getDeviceBuildId().equals(deviceBuild.trim())) {
      throw new ApplicationException("Invalid device contact " + CONTACT,
          userName + " with password" + password + " entered invalid devicebuildId original is "
              + user.getDeviceBuildId() + " new is " + deviceBuild);
    }

    if (!StringUtils.hasText(user.getDeviceMediaId()) && StringUtils.hasText(deviceMedia)) {
      user.setDeviceMediaId(deviceMedia.trim());
    } else if (!user.getDeviceMediaId().equals(deviceMedia.trim())) {
      throw new ApplicationException("Invalid device contact " + CONTACT,
          userName + " with password" + password + " entered invalid devicemediaid original is "
              + user.getDeviceMediaId() + " new is " + deviceMedia);
    }

    LocalDateTime currentDate = LocalDateTime.now();
    if (user.getStartDate() == null) {
      user.setStartDate(currentDate);
    }

    LocalDateTime endDate = user.getEndDate();

    if (endDate == null) {
      user.setEndDate(currentDate.plusMinutes(user.getPlan().getDuration()));
    } else if (currentDate.isAfter(endDate)) {
      throw new ApplicationException("Subscription expired on " + endDate, "Subscription expired for user "+userName+" on "+endDate);
    }
    return user;
  }
}

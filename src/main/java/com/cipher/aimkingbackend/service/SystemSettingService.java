package com.cipher.aimkingbackend.service;

import com.cipher.aimkingbackend.entity.SystemSetting;
import com.cipher.aimkingbackend.repository.SystemSettingRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemSettingService {

  private final SystemSettingRepository systemSettingRepository;


  // Caches the result of this method for 1 hour
  @Cacheable(value = "systemSettings", key = "#key", unless = "#result == null")
  public Optional<SystemSetting> getSystemSetting(String key) {
    return systemSettingRepository.findByKey(key);
  }

  public SystemSetting saveSystemSetting(SystemSetting setting) {
    return systemSettingRepository.save(setting);
  }
}

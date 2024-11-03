package com.cipher.aimkingbackend.repository;

import com.cipher.aimkingbackend.entity.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemSettingRepository extends JpaRepository<SystemSetting, String> {
  Optional<SystemSetting> findByKey(String key);
}

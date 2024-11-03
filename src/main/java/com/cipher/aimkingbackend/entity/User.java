package com.cipher.aimkingbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "game_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_name", nullable = false, length = 100)
  private String userName;

  @Column(name = "password", nullable = false, length = 100)
  private String password;

  @Column(name = "android_id", length = 50)
  private String androidId;

  @Column(name = "client_storage", length = 16)
  private String clientStorage;

  @Column(name = "device_build_id", length = 16)
  private String deviceBuildId;

  @Column(name = "device_media_id", length = 16)
  private String deviceMediaId;

  @Column(name = "device_model", length = 16)
  private String deviceModel;

  @Column(name = "created_date", nullable = false)
  private LocalDateTime createdDate;

  @Column(name = "modified_date", nullable = false)
  private LocalDateTime modifiedDate;

  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  @Column(name = "last_login")
  private LocalDateTime lastLogin;

  @Column(name = "active", columnDefinition = "tinyint(1) default 1")
  private Boolean active;

  @Column(name = "additional_data", columnDefinition = "text")
  private String additionalData;

  @Column(name = "reset_count", columnDefinition = "int default 0")
  private Integer resetCount;

  @Column(name = "ip_addresses", columnDefinition = "text")
  private String ipAddresses;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "plan_id", nullable = false)
  private Plan plan;


}

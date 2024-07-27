package com.alexandevcwa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class Client implements Serializable {
    
    @Id
    @Column(name = "cli_id")
    @Setter(value = AccessLevel.PRIVATE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "cli_nam", nullable = false, length = 75)
    private String name;
    
    @Column(name = "cli_add", nullable = false, length = 150)
    private String address;
    
    @Column(name = "cli_nit", nullable = false, unique = true, length = 12)
    private String nit;
    
    @Column(name = "cli_ema", nullable = false, unique = true, length = 45)
    private String email;
    
    @Column(name = "cli_pws", nullable = false , length = 100)
    private String password;
    
    @Column(name = "cli_pho", nullable = false, length = 10, unique = true)
    private String phone;
    
    @Setter(value = AccessLevel.PRIVATE)
    @Column(name = "cli_sys", insertable = false, updatable = false)
    private LocalDateTime systemDate;
    
    @Setter(value = AccessLevel.PRIVATE)
    @Column(name = "cli_upd", insertable = false, updatable = false)
    private LocalDateTime updateDate;
    
}

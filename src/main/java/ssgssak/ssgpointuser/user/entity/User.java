package ssgssak.ssgpointuser.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.el.stream.Stream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 20)
    private String userId;
    @Column(unique = true, nullable = false, length = 100)
    private String userUUID;
    @Column(nullable = false, length = 20)
    private String userName;
    @Column(nullable = false, length = 300)
    private String userPassword;
    @Column(unique = true, nullable = false, length = 11)
    private String phoneNumber;
    @Column(nullable = false, length = 300)
    private String address;
    @Column(unique = true, length = 30)
    private String email;
    @Column(nullable = false)
    private LocalDateTime regDate;
    @Column
    private LocalDateTime updateDate;
    @Column(length = 100)
    private String pointPassword;
    @Column(unique = true, nullable = false, length = 16)
    private String barcodeNumber;
    @Column
    private LocalDateTime softDelete;



    /**
     * 회원가입시 UUID 적용
     */
    @PrePersist
    private void initializeFields(){
        String newUUID = UUID.randomUUID().toString();
        this.userUUID = newUUID;
    }

}

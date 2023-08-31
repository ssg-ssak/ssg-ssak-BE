package ssgssak.ssgpointuser.domain.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.user.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserUUID(String UUID);

    Optional<User> findUserByBarcodeNumber(String barcodeNumber);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByUserId(String userId);

}
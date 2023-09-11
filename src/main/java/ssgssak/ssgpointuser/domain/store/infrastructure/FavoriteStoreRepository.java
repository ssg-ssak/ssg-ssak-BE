package ssgssak.ssgpointuser.domain.store.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.store.entity.FavoriteStore;

import java.util.Optional;

@Repository
public interface FavoriteStoreRepository extends JpaRepository<FavoriteStore, Long> {
    /**
     * 즐겨찾는 매장
     * 1. uuid로 조회
     */

    // 1. uuid로 조회
    Optional<FavoriteStore> findByUserUUID(String userUUID);

}

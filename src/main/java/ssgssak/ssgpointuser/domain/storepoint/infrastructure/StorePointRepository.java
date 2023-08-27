package ssgssak.ssgpointuser.domain.storepoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.storepoint.entity.StorePoint;

@Repository
public interface StorePointRepository extends JpaRepository<StorePoint, Long> {
}

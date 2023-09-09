package ssgssak.ssgpointuser.domain.store.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.store.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}

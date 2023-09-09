package ssgssak.ssgpointuser.domain.store.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.franchise.entity.Franchise;

@Repository
public interface FranchiseeRepository extends JpaRepository<Franchise, Long> {
}

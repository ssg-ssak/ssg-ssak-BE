package ssgssak.ssgpointuser.domain.franchise.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.franchise.entity.Franchise;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Long> {
}

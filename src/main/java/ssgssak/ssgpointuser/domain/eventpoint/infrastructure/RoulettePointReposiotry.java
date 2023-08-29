package ssgssak.ssgpointuser.domain.eventpoint.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.eventpoint.entity.RoulettePoint;

@Repository
public interface RoulettePointReposiotry extends JpaRepository<RoulettePoint, Long> {
}

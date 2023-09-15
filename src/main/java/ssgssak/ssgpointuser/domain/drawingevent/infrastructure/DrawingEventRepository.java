package ssgssak.ssgpointuser.domain.drawingevent.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.drawingevent.entity.DrawingEvent;

@Repository
public interface DrawingEventRepository extends JpaRepository<DrawingEvent, Long> {
}

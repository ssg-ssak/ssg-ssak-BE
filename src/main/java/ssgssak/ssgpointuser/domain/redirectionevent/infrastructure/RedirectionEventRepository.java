package ssgssak.ssgpointuser.domain.redirectionevent.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.redirectionevent.entity.RedirectionEvent;

@Repository
public interface RedirectionEventRepository extends JpaRepository<RedirectionEvent, Long> {
    RedirectionEvent findByEventListId(Long eventListId);
}

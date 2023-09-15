package ssgssak.ssgpointuser.domain.informationtypeevent.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.informationtypeevent.entity.InformationTypeEvent;

@Repository
public interface InformationTypeEventRepository extends JpaRepository<InformationTypeEvent, Long> {
    InformationTypeEvent findByEventListId(Long eventListId);
}

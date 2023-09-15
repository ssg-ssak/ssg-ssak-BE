package ssgssak.ssgpointuser.domain.drawingevent.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.drawingevent.entity.Applicant;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
    Applicant findByDrawingEventIdAndUuid(Long drawingEventId, String uuid);
    List<Applicant> findAllByDrawingEventId(Long drawingEventId);
    List<Long> findAllByUuid(String uuid);
}

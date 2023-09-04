package ssgssak.ssgpointuser.domain.receipt.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.receipt.entity.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    /**
     * 영수증
     */

}

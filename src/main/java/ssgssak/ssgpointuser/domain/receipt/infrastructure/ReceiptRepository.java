package ssgssak.ssgpointuser.domain.receipt.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.receipt.entity.Receipt;

import java.util.Optional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    /**
     * 영수증
     * <p>
     * 1. 영수증번호로 검색
     */

    Optional<Receipt> findByReceiptNumber(String receiptNumber);
}

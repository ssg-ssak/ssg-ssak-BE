package ssgssak.ssgpointuser.domain.store.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ssgssak.ssgpointuser.domain.store.entity.Store;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

    /** 제휴 매장
     * 1. 매장 지도로 검색하기
     * 2. 매장 지역으로 검색하기
     */

    // 1. 매장 지도로 검색하기 : 지도에 표시되는 위-경도의 경곗값을 전달받아서, 그 사이에 존재하는 매장만 넘겨줌

    // 2. 매장 지역으로 검색하기 : 제휴사,시,군(구)를 넘겨받아서, 그 사이에 존재하는 매장만 넘겨줌
    @Query(value = "select s.* from store s inner join franchise f on s.franchise_id = f.id WHERE f.name =:franchiseName and s.city =:city and s.district =:district" ,nativeQuery = true)
    List<Store> findByRegion(String franchiseName, String city, String district);
}

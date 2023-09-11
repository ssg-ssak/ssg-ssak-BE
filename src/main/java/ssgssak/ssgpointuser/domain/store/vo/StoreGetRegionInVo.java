package ssgssak.ssgpointuser.domain.store.vo;

import lombok.Getter;

@Getter
public class StoreGetRegionInVo {
    private String franchiseName;
    private String city;
    private String district;

    public StoreGetRegionInVo(String franchiseName, String city, String district) {
        this.franchiseName = franchiseName;
        this.city = city;
        this.district = district;
    }
}

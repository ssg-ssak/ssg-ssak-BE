package ssgssak.ssgpointuser.domain.store.vo;

import lombok.Getter;
@Getter
public class StoreGetMapInVo {
    private Double upLatitude;
    private Double downLatitude;
    private Double leftLongitude;
    private Double rightLongitude;

    public StoreGetMapInVo(Double upLatitude, Double downLatitude, Double leftLongitude, Double rightLongitude) {
        this.upLatitude = upLatitude;
        this.downLatitude = downLatitude;
        this.leftLongitude = leftLongitude;
        this.rightLongitude = rightLongitude;
    }
}

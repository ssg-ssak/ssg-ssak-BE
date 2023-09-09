package ssgssak.ssgpointuser.domain.store.presentation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ssgssak.ssgpointuser.domain.store.application.StoreServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    private final StoreServiceImpl storeService;
    private final ModelMapper modelMapper;

    /**
     * 제휴 매장 & 단골매장
     *
     *
     */



}

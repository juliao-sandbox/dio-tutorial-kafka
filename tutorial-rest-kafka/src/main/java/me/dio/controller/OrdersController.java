package me.dio.controller;

import me.dio.data.OrderData;
import me.dio.services.EventRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final EventRegisterService eventService;

    @PostMapping(path = "/api/save-order")
    public ResponseEntity<String> saveOrder(@RequestBody OrderData order) {
        eventService.addEvent("SaveOrder", order);
        return ResponseEntity.ok("Success");
    }
}

package me.wook.springboot.web.api.controller;

import me.wook.springboot.movie.service.ReserveManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

  @Autowired
  private ReserveManager reserveManager;
}

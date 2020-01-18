package me.wook.springboot.web.controller;

import static me.wook.springboot.web.util.ResponseUtils.of;
import static me.wook.springboot.web.util.ResponseUtils.responseEntity;

import io.swagger.annotations.Api;
import me.wook.springboot.data.entity.Screen;
import me.wook.springboot.data.service.ScreenService;
import me.wook.springboot.web.dto.ResponseVO;
import me.wook.springboot.web.dto.ScreenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Screen")
@RestController
@RequestMapping("/screen")
public class ScreenController {

  private ScreenService screenService;

  @Autowired
  public ScreenController(ScreenService screenService) {
    this.screenService = screenService;
  }

  @GetMapping("")
  ResponseEntity<Page<Screen>> list(@RequestParam(defaultValue = "1") final int page,
      @RequestParam(defaultValue = "10") final int pageSize) {
    return responseEntity(screenService.list(PageRequest.of(page - 1, pageSize)));
  }

  @PostMapping("")
  ResponseEntity<ResponseVO> add(@RequestParam final long id, final ScreenDTO screenDTO) {
    return responseEntity(of(screenService.save(id, screenDTO)));
  }
}

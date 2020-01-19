package me.wook.springboot.web.api.controller;

import static me.wook.springboot.web.util.ResponseUtils.of;
import static me.wook.springboot.web.util.ResponseUtils.responseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;
import me.wook.springboot.movie.entity.Screen;
import me.wook.springboot.movie.service.ScreenService;
import me.wook.springboot.web.dto.ResponseVO;
import me.wook.springboot.web.dto.ScreenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "ScreenController")
@RestController
@RequestMapping("/screen")
public class ScreenController {

  private ScreenService screenService;

  @Autowired
  public ScreenController(ScreenService screenService) {
    this.screenService = screenService;
  }

  @ApiOperation("스크린 목록 조회")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "page",
          value = "현재 페이지",
          defaultValue = "1",
          dataType = "int",
          paramType = "query",
          required = true
      ),
      @ApiImplicitParam(
          name = "pageSize",
          value = "한 페이지 출력 될 로우 개수",
          defaultValue = "10",
          dataType = "int",
          paramType = "query",
          required = true
      )
  })
  @GetMapping("")
  ResponseEntity<Page<Screen>> list(@RequestParam(defaultValue = "1") final int page,
      @RequestParam(defaultValue = "10") final int pageSize) {
    return responseEntity(screenService.list(PageRequest.of(page - 1, pageSize)));
  }

  @ApiOperation("스크린 상세 정보")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "id",
          value = "스크린 아이디",
          dataType = "long",
          paramType = "path",
          required = true
      )
  })
  @GetMapping("/{id}")
  ResponseEntity<Screen> detail(@PathVariable final long id) {
    return responseEntity(screenService.detail(id));
  }

  @ApiOperation("스크린 추가")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "id",
          value = "영화 아이디",
          dataType = "long",
          paramType = "query",
          required = true
      ),
      @ApiImplicitParam(
          name = "name",
          value = "스크린 이름",
          dataType = "string",
          paramType = "query",
          required = true
      )
  })
  @PostMapping("")
  ResponseEntity<ResponseVO> add(final long id, final ScreenDTO screenDTO) {
    return responseEntity(of(screenService.save(id, screenDTO)));
  }

  @ApiOperation("스크린 정보 수정")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "id",
          value = "스크린 아이디",
          dataType = "long",
          paramType = "path",
          required = true
      ),
      @ApiImplicitParam(
          name = "name",
          value = "스크린 이름",
          dataType = "string",
          paramType = "query",
          required = true
      )
  })
  @PutMapping("/{id}")
  ResponseEntity<ResponseVO> update(@PathVariable final long id, final ScreenDTO screenDTO) {
    return responseEntity(of(screenService.update(id, screenDTO)));
  }

  @ApiOperation("스크린 삭제")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "id",
          value = "스크린 아이디",
          dataType = "long",
          paramType = "path",
          required = true
      )
  })
  @DeleteMapping("/{id}")
  ResponseEntity<ResponseVO> delete(@PathVariable final long id) {
    return responseEntity(of(screenService.delete(id)));
  }
}
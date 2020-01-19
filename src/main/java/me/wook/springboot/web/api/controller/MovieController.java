package me.wook.springboot.web.api.controller;

import static me.wook.springboot.web.util.ResponseUtils.of;
import static me.wook.springboot.web.util.ResponseUtils.responseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.wook.springboot.movie.entity.Movie;
import me.wook.springboot.movie.service.MovieService;
import me.wook.springboot.web.dto.MovieDTO;
import me.wook.springboot.web.dto.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "MovieController")
@RestController
@RequestMapping("/movie")
public class MovieController {

  private MovieService movieService;

  @Autowired
  MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @ApiOperation("영화 목록 조회")
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
          value = "한 페이지당 출력 될 로우 개수",
          defaultValue = "10",
          dataType = "int",
          paramType = "query"
      )
  })
  @GetMapping("")
  ResponseEntity<Page<Movie>> list(@RequestParam(defaultValue = "1") final int page,
      @RequestParam(defaultValue = "10") final int pageSize) throws Exception {
    return responseEntity(movieService.list(PageRequest.of(page - 1, pageSize)));
  }

  @ApiOperation("영화 상세 조회")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "id",
          value = "영화 아이디",
          dataType = "long",
          paramType = "path",
          required = true
      )
  })
  @GetMapping("/{id}")
  ResponseEntity<Movie> detail(@PathVariable final long id) {
    return responseEntity(movieService.detail(id));
  }

  @ApiOperation("영화 추가")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "name",
          value = "영화 이름",
          dataType = "string",
          paramType = "query",
          required = true
      ),
      @ApiImplicitParam(
          name = "description",
          value = "영화 상세 정보",
          dataType = "string",
          paramType = "query",
          required = true
      )
  })
  @PostMapping("")
  ResponseEntity<ResponseVO> add(@RequestBody final MovieDTO movieDto) {
    return responseEntity(of(movieService.add(movieDto)));
  }

  @ApiOperation("영화 수정")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "id",
          value = "영화 아이디",
          dataType = "long",
          paramType = "path",
          required = true
      )
  })
  @PutMapping("/{id}")
  ResponseEntity<ResponseVO> update(@PathVariable final long id, @RequestBody final MovieDTO movieDTO) {
    return responseEntity(of(movieService.update(id, movieDTO)));
  }

  @ApiOperation("영화 삭제")
  @ApiImplicitParams({
      @ApiImplicitParam(
          name = "id",
          value = "영화 아이디",
          dataType = "string",
          paramType = "path",
          required = true
      )
  })
  @DeleteMapping("/{id}")
  ResponseEntity<ResponseVO> delete(@PathVariable final long id) {
    return responseEntity(of(movieService.delete(id)));
  }
}
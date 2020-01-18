package me.wook.springboot.web.controller;

import io.swagger.annotations.Api;
import java.util.Optional;
import java.util.function.Function;
import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.service.MovieService;
import me.wook.springboot.movie.exception.MovieException;
import me.wook.springboot.web.dto.MovieDTO;
import me.wook.springboot.web.dto.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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

@Api(value = "Movie")
@RestController
@RequestMapping("/movie")
public class MovieController {

  private MovieService movieService;

  @Autowired
  MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("")
  ResponseEntity<Page<Movie>> list(@RequestParam(defaultValue = "1") final int page,
      @RequestParam(defaultValue = "10") final int pageSize) throws Exception {
    return Optional
        .of(ResponseEntity.ok(movieService.list(PageRequest.of(page - 1, pageSize))))
        .orElseThrow(MovieException::new);
  }

  @PostMapping("")
  ResponseEntity<ResponseVO> add(@RequestBody final MovieDTO movieDto) {
    return Optional
        .of(ResponseEntity.ok(doProcess(movieService.add(movieDto))))
        .orElseThrow(MovieException::new);
  }

  @PutMapping("/{id}")
  ResponseEntity<ResponseVO> update(@RequestBody final MovieDTO movieDTO) {
    return Optional
        .of(ResponseEntity.ok(doProcess(movieService.update(movieDTO))))
        .orElseThrow(MovieException::new);
  }

  @DeleteMapping("/{id}")
  ResponseEntity<ResponseVO> delete(@PathVariable final int id) {
    return Optional
        .of(ResponseEntity.ok(doProcess(movieService.delete(MovieDTO.builder().id(id).build()))))
        .orElseThrow(MovieException::new);
  }

  private ResponseVO doProcess(final boolean result) {
    Function<Boolean, ResponseVO> function = bool -> {
      if (bool) {
        return null;
      } else {
        return ResponseVO
            .builder()
            .status(HttpStatus.OK.value())
            .message(HttpStatus.OK.getReasonPhrase())
            .build();
      }
    };
    return function.apply(result);
  }
}
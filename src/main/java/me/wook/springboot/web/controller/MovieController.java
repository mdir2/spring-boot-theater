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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping("")
  private ResponseEntity<Page<Movie>> list(@RequestParam(defaultValue = "1") final int page,
      @RequestParam(defaultValue = "10") final int pageSize) throws Exception {
    return Optional
        .of(new ResponseEntity(movieService.list(PageRequest.of(page - 1, pageSize)), HttpStatus.OK))
        .orElseThrow(MovieException::new);
  }

  @PostMapping("")
  private ResponseEntity<ResponseVO> add(@RequestBody MovieDTO movieDto) throws Exception {
    boolean result = movieService.add(movieDto);

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

    return Optional.of(new ResponseEntity<ResponseVO>(function.apply(result), HttpStatus.OK))
        .orElseThrow(MovieException::new);
  }
}
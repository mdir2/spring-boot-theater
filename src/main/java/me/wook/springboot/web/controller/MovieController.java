package me.wook.springboot.web.controller;

import io.swagger.annotations.Api;
import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.service.MovieService;
import me.wook.springboot.web.model.MovieDTO;
import me.wook.springboot.web.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@Api(value = "Movie")
@RestController
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    @GetMapping("")
    private ResponseEntity<Page<Movie>> list(Pageable pageable) throws Exception {
        return Optional.of(new ResponseEntity(movieService.list(pageable), HttpStatus.OK)).orElseThrow(Exception::new);
    }
    
    @PostMapping("")
    private ResponseEntity<ResponseVO> add(@RequestBody MovieDTO movieDto) throws Exception {
        boolean result = movieService.add(movieDto);
    
        Function<Boolean, ResponseVO> function = aBoolean -> {
            if (aBoolean) {
                return null;
            } else {
                return ResponseVO
                        .builder()
                        .status(HttpStatus.OK.value())
                        .message(HttpStatus.OK.getReasonPhrase())
                        .build();
            }
        };
    
        return Optional.of(new ResponseEntity<ResponseVO>(function.apply(result), HttpStatus.OK)).orElseThrow(Exception::new);
    }
}
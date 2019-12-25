package me.wook.springboot.web.controller;

import io.swagger.annotations.Api;
import me.wook.springboot.data.entity.Movie;
import me.wook.springboot.data.service.MovieService;
import me.wook.springboot.web.dto.MovieDto;
import me.wook.springboot.web.res.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@Api(value = "Movie for API")
@RestController
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/")
    private Page<Movie> list(final Pageable pageable) {
        return movieService.list(pageable);
    }
    
    @PostMapping("/")
    private ResponseEntity<ResponseMessage> add(@RequestBody MovieDto movieDto) {
        boolean result = movieService.add(movieDto);
        
        ResponseMessage message = ResponseMessage
                .builder()
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    
        
        
        if (result) {
            message = ResponseMessage
                    .builder()
                    .status(HttpStatus.OK.value())
                    .message(HttpStatus.OK.getReasonPhrase())
                    .build();
        } else {
        
        }
    
        
        return new ResponseEntity<ResponseMessage>(message, HttpStatus.OK);
    }
}

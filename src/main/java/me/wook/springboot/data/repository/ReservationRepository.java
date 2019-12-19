package me.wook.springboot.data.repository;

import me.wook.springboot.data.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Movie, Long> {
}

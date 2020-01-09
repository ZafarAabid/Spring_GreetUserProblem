package com.spring.repository;

import com.spring.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository  extends JpaRepository<Greeting,Long> {
}

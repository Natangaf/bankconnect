package com.bankconnect.bankconnect.repository;

import com.bankconnect.bankconnect.model.Transition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitionRepository extends JpaRepository<Transition,Long> {

}

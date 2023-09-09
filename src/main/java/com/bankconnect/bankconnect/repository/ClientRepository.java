package com.bankconnect.bankconnect.repository;

import com.bankconnect.bankconnect.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}

package com.zebbara.routerfullstack.repository;

import com.zebbara.routerfullstack.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ServerRepository extends JpaRepository<Server, Long> {
    Server findByIpAddress(String ipAddress);

}

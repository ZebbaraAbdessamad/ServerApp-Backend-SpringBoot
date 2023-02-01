package com.zebbara.routerfullstack.services.implementation;

import com.zebbara.routerfullstack.model.Server;
import com.zebbara.routerfullstack.repository.ServerRepository;
import com.zebbara.routerfullstack.services.ServerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import static com.zebbara.routerfullstack.enumeration.Status.SERVER_DOWN;
import static com.zebbara.routerfullstack.enumeration.Status.SERVER_UP;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j

public class ServerServiceImpl  implements ServerService {

   private  final ServerRepository serverRepo;

    @Override
    public Server create(Server server) {
        log.info("saving new server:{}",server.getName());
        server.setImgeUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP:{}",ipAddress );
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatue(address.isReachable(10000) ? SERVER_UP : SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }


    @Override
    public Collection<Server> list(int limit) {
        log.info("fetching all ser vers" );
        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server get(Long id) {
        log.info("fetching SERVER by id: {}",id );
        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating  SERVER by id: {}",server.getName() );
        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting  server by Id: {}",id );
        serverRepo.deleteById(id);
        return Boolean.TRUE;
    }


    private String setServerImageUrl() {
        String[] imagesNames = {"server1.png","server2.png","server3.png","server4.png","server5.png",};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/"+imagesNames[new Random().nextInt(5)]).toUriString();
    }
}

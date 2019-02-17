package com.xyh.webflux.controller;

import com.xyh.webflux.model.User;
import com.xyh.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

    @Autowired
    private UserService cityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Mono<User> findOneCity(@PathVariable("id") Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.findCityById(id)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Flux<User> findAllCity() {
        return Flux.create(cityFluxSink -> {
            cityService.findAllCity().forEach(user -> {
                cityFluxSink.next(user);
            });
            cityFluxSink.complete();
        });
    }

    @RequestMapping(method = RequestMethod.POST)
    public Mono<Long> createCity(@RequestBody User user) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.saveCity(user)));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Mono<Long> modifyCity(@RequestBody User user) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.updateCity(user)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Mono<Long> modifyCity(@PathVariable("id") Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityService.deleteCity(id)));
    }
}
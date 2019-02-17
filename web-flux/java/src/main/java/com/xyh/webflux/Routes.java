//package com.xyh.webflux;
//
//import com.xyh.webflux.service.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.server.RouterFunction;
//
//import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
//import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
//import static org.springframework.web.reactive.function.server.RouterFunctions.route;
//
//@Configuration
//public class Routes {
//    private UserService cityService;
//
//    public Routes(UserService cityService) {
//        this.cityService = cityService;
//    }
//
//    @Bean
//    public RouterFunction<?> routerFunction() {
//        return route(
//                       GET("/api/city").and(accept(MediaType.APPLICATION_JSON)), cityService:: findAllCity).and(route(
//                       GET("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)), cityService:: findCityById)
//                );
//    }
//}
package s6.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("moderator-service", r -> r.path("/api/moderator/**")
						.uri("http://moderator-service-container:8082"))      // Use container name instead of localhost
				.route("friend-service", r -> r.path("/ws/**")
						.uri("ws://friend-service-container:8083"))      // Use container name instead of localhost
				.route("friend-service", r -> r.path("/api/notifications/**")
						.uri("ws://friend-service-container:8083"))      // Use container name instead of localhost
				.route("post-service", r -> r.path("/api/posts/**")
						.uri("http://post-service-container:8084"))      // Use container name instead of localhost
				.route("search-service", r -> r.path("/api/users/**")
						.uri("http://user-service-container:8085"))      // Use container name instead of localhost
				.build();
	}

}

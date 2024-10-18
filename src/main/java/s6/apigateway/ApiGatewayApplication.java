package s6.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("follow-service", r -> r.path("/api/follow/**")
						.uri("http://localhost:8081"))
				.route("like-service", r -> r.path("/api/moderation/**")
						.uri("http://localhost:8082"))
				.route("moderation-service", r -> r.path("/api/notifications/**")
						.uri("http://localhost:8083"))
				.route("post-service", r -> r.path("/api/posts/**")
						.uri("http://localhost:8084"))
				.route("search-service", r -> r.path("/api/users/**")
						.uri("http://localhost:8085"))
				.build();
	}

}

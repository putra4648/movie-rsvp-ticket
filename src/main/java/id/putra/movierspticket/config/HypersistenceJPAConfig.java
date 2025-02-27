package id.putra.movierspticket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.hypersistence.utils.spring.repository.BaseJpaRepositoryImpl;

@Configuration
@EnableJpaRepositories(value = "id.putra.movierspticket.repository", repositoryBaseClass = BaseJpaRepositoryImpl.class)
public class HypersistenceJPAConfig {

}

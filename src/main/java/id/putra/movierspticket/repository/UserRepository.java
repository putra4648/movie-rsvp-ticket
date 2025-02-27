package id.putra.movierspticket.repository;

import org.springframework.stereotype.Repository;

import id.putra.movierspticket.entity.User;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;

@Repository
public interface UserRepository extends BaseJpaRepository<User, String> {

}

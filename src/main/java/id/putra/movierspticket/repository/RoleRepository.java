package id.putra.movierspticket.repository;

import org.springframework.stereotype.Repository;

import id.putra.movierspticket.entity.Role;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;

@Repository
public interface RoleRepository extends BaseJpaRepository<Role, Long> {

}

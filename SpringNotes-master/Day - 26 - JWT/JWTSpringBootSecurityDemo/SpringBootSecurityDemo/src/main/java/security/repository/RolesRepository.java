package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import security.entity.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, String> {

}

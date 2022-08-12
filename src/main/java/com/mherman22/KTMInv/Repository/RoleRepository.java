package com.mherman22.KTMInv.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mherman22.KTMInv.models.EnumRole;
import com.mherman22.KTMInv.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(EnumRole name);
}

package com.mherman22.KTMInv.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mherman22.KTMInv.models.EnumRole;
import com.mherman22.KTMInv.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByName(EnumRole name);
}

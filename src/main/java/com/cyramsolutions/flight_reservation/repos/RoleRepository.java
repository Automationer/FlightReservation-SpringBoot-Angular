package com.cyramsolutions.flight_reservation.repos;

import com.cyramsolutions.flight_reservation.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

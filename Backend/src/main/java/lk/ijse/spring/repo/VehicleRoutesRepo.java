package lk.ijse.spring.repo;


import lk.ijse.spring.entity.VehicleRoutes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRoutesRepo extends JpaRepository<VehicleRoutes, String> {
}

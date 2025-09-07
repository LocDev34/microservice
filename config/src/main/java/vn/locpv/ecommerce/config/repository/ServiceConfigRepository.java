package vn.locpv.ecommerce.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.locpv.ecommerce.config.model.ServiceConfig;

import java.util.List;

@Repository
public interface ServiceConfigRepository extends JpaRepository<ServiceConfig, Long> {

    List<ServiceConfig> findAllByApplicationAndProfileAndLabel(
            String application,
            String profile,
            String label
    );
}
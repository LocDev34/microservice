package vn.locpv.ecommerce.config.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.stereotype.Component;
import vn.locpv.ecommerce.config.model.ServiceConfig;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OracleEnvironmentRepository implements EnvironmentRepository {

    @Autowired
    private ServiceConfigRepository serviceConfigRepository;

    @Override
    public Environment findOne(String application, String profile, String label) {
        Environment environment = new Environment(application, profile);
        environment.setLabel(label);

        Map<String, String> map = serviceConfigRepository
                .findAllByApplicationAndProfileAndLabel(application, profile, label)
                .stream()
                .filter(ServiceConfig::isEnable)
                .collect(Collectors.toMap(ServiceConfig::getKey, ServiceConfig::getValue));

        environment.add(new PropertySource(application + "-" + profile, map));
        return environment;
    }
}

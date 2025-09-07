package vn.locpv.ecommerce.config.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HDDT_SERVICE_CONFIG")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // nếu có ID auto
    private Long id;

    @Column(nullable = false)
    private String application;

    @Column(nullable = false)
    private String profile;

    @Column(nullable = false)
    private String label;

    @Column(name = "config_key", nullable = false)
    private String key;

    @Column(name = "config_value")
    private String value;

    private boolean enable;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at")
    private Date modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Version
    private Long version;
}

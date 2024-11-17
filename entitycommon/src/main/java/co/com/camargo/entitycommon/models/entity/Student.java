package co.com.camargo.entitycommon.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String email;

    @Column(name = "created_at")
    private Date createdAt;

    @PrePersist
    private void prePersist() {
        this.createdAt = new Date();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student student)) {
            return false;
        }

        return this.id != null && this.id.equals(student.getId());
    }
}

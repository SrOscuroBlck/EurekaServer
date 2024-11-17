package co.com.camargo.coursesmicroservice.models.entity;

import co.com.camargo.entitycommon.models.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="created_at")
    private Date createdAt;

    @PrePersist
    private void prePersist() {
        this.createdAt = new Date();
    }

    @Getter
    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> students;

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }


}

package model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max=50)
    private String name;

    public Category() {
    }

    public Category(Long id, @Size(min = 2, max = 50) String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

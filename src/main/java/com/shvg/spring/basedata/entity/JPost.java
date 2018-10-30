package com.shvg.spring.basedata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
public class JPost {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private JEmployee jEmployee;

    /**
     * Default no-argument constructor is required for JPA
     */
    public JPost() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/* Having these getters creates recursion
    public JEmployee getEmployee() {
        return jEmployee;
    }
*/
    public void setEmployee(JEmployee employee) {
        this.jEmployee = employee;
    }


    @Override
    public String toString() {
        return "JPost{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}

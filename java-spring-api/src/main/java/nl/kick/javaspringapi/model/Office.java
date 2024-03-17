package nl.kick.javaspringapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column
    private int employeeAmount;

    public Office(final Long id, final String name, final int employeeAmount) {
        this.id = id;
        this.name = name;
        this.employeeAmount = employeeAmount;
    }

    public Office() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeAmount() {
        return employeeAmount;
    }



    public static class Builder {
        private Long id;
        private String name;
        private int employeeAmount;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder employeeAmount(int employeeAmount) {
            this.employeeAmount = employeeAmount;
            return this;
        }

        public Office build() {
            return new Office(id, name, employeeAmount);
        }
    }
}
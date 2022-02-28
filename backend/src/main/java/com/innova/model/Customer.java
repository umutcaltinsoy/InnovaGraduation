package com.innova.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "name")
    private String customerName;

    @Column(name = "surname")
    private String customerSurname;

    @Column(name = "salary")
    private Integer customerSalary;

    @Column(name = "phone_number")
    private String customerPhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_details", referencedColumnName = "id")
    private CreditResult creditResult;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return id != null && Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.bankconnect.bankconnect.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "transiton")
public class Transition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private TypeTransition typeTransition;

    @Column()
    private float value;

    @Column(updatable = false)
    private LocalDateTime date;

    @Column()
    private LocalTime hour;

    @ManyToOne()
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private Company companyTransition;

    @ManyToOne()
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private Client clientTransition;

    public Transition() {
    }

    public Transition(TypeTransition typeTransition, float value, LocalTime hour, Company companyTransition, Client clientTransition) {
        this.typeTransition = typeTransition;
        this.value = value;
        this.hour = hour;
        this.companyTransition = companyTransition;
        this.clientTransition = clientTransition;
    }

    public TypeTransition getTypeTransition() {
        return typeTransition;
    }

    public void setTypeTransition(TypeTransition typeTransition) {
        this.typeTransition = typeTransition;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Company getCompanyTransition() {
        return companyTransition;
    }

    public void setCompanyTransition(Company companyTransition) {
        this.companyTransition = companyTransition;
    }

    public Client getClientTransition() {
        return clientTransition;
    }

    public void setClientTransition(Client clientTransition) {
        this.clientTransition = clientTransition;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @PrePersist
    protected void onCreate() {
        date = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        date = LocalDateTime.now();
    }
}

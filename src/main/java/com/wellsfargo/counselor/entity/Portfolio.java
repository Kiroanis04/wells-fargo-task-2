package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(nullable = false)
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "portfolio")
    private List<Security> securities;

    protected Portfolio() {}

    public Portfolio(LocalDate creationDate, Client client) {
        this.creationDate = creationDate;
        this.client = client;
    }

    public Long getPortfolioId() { return portfolioId; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
}

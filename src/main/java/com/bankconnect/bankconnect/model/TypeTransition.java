package com.bankconnect.bankconnect.model;
public enum TypeTransition {
    DEPOSITO("Depósito"),
    SAQUE("Saque");

    private final String description;

    TypeTransition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

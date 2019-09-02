package com.example.webflux.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

/**
 * The type User key.
 */
@PrimaryKeyClass
public class UserKey {

    /**
     * User CPF.
     */
    @PrimaryKeyColumn(name = "cpf", type = PrimaryKeyType.PARTITIONED)
    private String cpf;

    /**
     * Instantiates a new User key.
     */
    public UserKey() {
        // Default constructor.
    }

    /**
     * Instantiates a new User key.
     *
     * @param cpf the cpf
     */
    public UserKey(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Gets cpf.
     *
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Sets cpf.
     *
     * @param cpf the cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

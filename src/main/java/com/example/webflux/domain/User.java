package com.example.webflux.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * The type User.
 */
@Table("user")
public class User {

    /**
     * User key.
     */
    @PrimaryKey
    private UserKey key;

    /**
     * User name.
     */
    @Column("name")
    private String name;

    /**
     * User domain
     */
    @Column("domain")
    private String domain;

    /**
     * Instantiates a new User.
     */
    public User() {
        // Default constructor.
    }

    /**
     * Instantiates a new User.
     *
     * @param key    the key
     * @param name   the name
     * @param domain the domain
     */
    public User(UserKey key, String name, String domain) {
        this.key = key;
        this.name = name;
        this.domain = domain;
    }

    /**
     * Gets key.
     *
     * @return the key
     */
    public UserKey getKey() {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(UserKey key) {
        this.key = key;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets domain.
     *
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets domain.
     *
     * @param domain the domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }
}

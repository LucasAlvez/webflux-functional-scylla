package com.example.webflux.repository;

import com.example.webflux.domain.User;
import com.example.webflux.domain.UserKey;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCassandraRepository<User, UserKey> {
}

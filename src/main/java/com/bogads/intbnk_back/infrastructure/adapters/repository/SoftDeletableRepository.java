package com.bogads.intbnk_back.infrastructure.adapters.repository;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SoftDeletableRepository<T extends SoftDeletableEntity> extends BaseRepository<T> {
}

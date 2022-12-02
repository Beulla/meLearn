package com.example.coursesManagement.repositories;

import com.example.coursesManagement.models.Department;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    @Override
    default <S extends Department> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Department> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Department> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Department> findAll() {
        return null;
    }

    @Override
    default Iterable<Department> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }


    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Department entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Department> entities) {

    }

    @Override
    default void deleteAll() {

    }
}

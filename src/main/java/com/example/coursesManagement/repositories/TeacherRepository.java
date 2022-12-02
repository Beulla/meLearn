package com.example.coursesManagement.repositories;

import com.example.coursesManagement.models.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher,Long> {
    @Override
    default <S extends Teacher> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Teacher> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Teacher> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Teacher> findAll() {
        return null;
    }

    @Override
    default Iterable<Teacher> findAllById(Iterable<Long> longs) {
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
    default void delete(Teacher entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Teacher> entities) {

    }

    @Override
    default void deleteAll() {

    }
}
package com.example.coursesManagement.repositories;

import com.example.coursesManagement.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CourseRepository extends CrudRepository<Course,Long>{
    @Override
    default <S extends Course> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Course> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default Optional<Course> findById(Long aLong) {
        return null;
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Course> findAll() {
        return null;
    }

    @Override
    default Iterable<Course> findAllById(Iterable<Long> longs) {
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
    default void delete(Course entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Course> entities) {

    }

    @Override
    default void deleteAll() {

    }
}

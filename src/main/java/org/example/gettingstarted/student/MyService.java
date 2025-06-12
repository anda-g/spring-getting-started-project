package org.example.gettingstarted.student;

import java.util.List;

public interface MyService<T, K> {
    void insert(T t);
    List<T> selectAll();
    T selectById(K id);
    boolean updateById(K id, T t);
    boolean deleteById(K id);
}
package service;

import model.Singer;

import java.util.List;

public interface IGeneric <T>{
    List<T> findAll();
    void save(T e);
    public void updateId(int id,String name,int age);
    public void deleteById(int id);
    T findById(int id);
    void sort();
}

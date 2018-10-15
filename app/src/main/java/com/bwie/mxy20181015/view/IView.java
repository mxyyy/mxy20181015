package com.bwie.mxy20181015.view;

public interface IView<T> {
    void success(T t);

    void failed(Exception e);

}

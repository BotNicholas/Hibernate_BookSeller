package org.nicholas.validation;

public interface Validator<T> {
    boolean validate(T obj);
}

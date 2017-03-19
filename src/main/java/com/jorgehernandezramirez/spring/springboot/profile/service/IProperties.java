package com.jorgehernandezramirez.spring.springboot.profile.service;

/*
  API de gestión de properties
*/
public interface IProperties {

    /**
     * Método que devuelve el valor de la url de mongodb definido en los
     * properties
     * @return
     */
    String getPropertyMongoDbUrl();

    /**
     * Método que devuelve el valor de la version de mongodb definido en los
     * properties
     * @return
     */
    String getPropertyMongoDbVersion();
}

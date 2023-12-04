# TEST INCLUSION
Proyecto para presentar prueba tecnica para Inlcusion

## TECNOLOGIAS USADAS EN EL PROYECTO
Las tecnologías son las siguientes:
* Spring Boot
* Java 11
* Maven
* JUnit 5
* Swagger 3

## ¿Cómo Ejecutar el proyecto?

* Se debe ejecutar en un IDE para desarrollo de Spring Boot. En este caso particular se usó [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/), pero puede usarse el IDE a gusto.
* El proyecto cuenta con los tests unitarios para el paquete de los controladores y de los servicios.
* Al ejecutar la aplicación de manera exitosa se podrá acceder a la API documentacón (Swagger) a través de la siguiente URL "http://localhost:8080/swagger-ui/index.html#/test-inclusion-controller".


## ¿QUÉ HACE EL PROYECTO?

El proyecto da solución a un problema planteado en CodeForces, especificamente el ejercicio es el siguiente: https://codeforces.com/problemset/problem/1374/A

You are given three integers x,y and n. Your task is to find the maximum integer k such that 0≤k≤n that k mod x = y, where mod is modulo operation. Many programming languages use percent operator % to implement it.
In other words, with given x,y and n you need to find the maximum possible integer from 0 to n that has the remainder y modulo x.
You have to answer t independent test cases. It is guaranteed that such k exists for each test case.

### Input
The first line of the input contains one integer t (1≤t≤5⋅104) — the number of test cases. The next t lines contain test cases.
The only line of the test case contains three integers x,y and n (2≤x≤109; 0≤y<x; y≤n≤109).
It can be shown that such k always exists under the given constraints.

### Output
For each test case, print the answer — maximum non-negative integer k such that 0≤k≤n and kmodx=y. It is guaranteed that the answer always exists.

## ¿Cómo se Desarrolló?

Lo primero es que se identificó como solucionar el problema, para lo cual se concluye con la siguiente formula matematica que lo resuelve:
### k = n - ((n - y) % x)

Esta función se implementó con un Controllador que contiene dos metodos(GET, POST). Estos dos métodos llaman la lógica de la implementación de la formula indicada anteriormente. Esto se hizo en un Service que posteriormente es Inyectado en el controlador.

Para cada uno de los metodos del controlador y del servicio se hicieron las coberturas del 100% de las pruebas unitarias con JUnit5










**saucedemo-web-acceptances-test**

---

1.- Instrucciones de configuración
---
Para el correcto funcionamiento del codigo, se recomienda realizar las siguientes instalaciones:

* JDK version jdk-8u171
* MVN version 3.6.3
* Ambientación de variables de ambiente:
+JAVA_HOME
+MAVEN_HOME

2.- Instrucciones de instalación
---
El proyecto fue construido con un arquetipo maven, la instalación de dependencias se realizan con el siguiente comando:

 * mvn install


3.- Instrucciones de operación
---

Para ejecutar la suite de pruebas contenidas en este proyecto se deben ejecutar los siguientes comandaos dependiendo de la situación deseada:

**Test Suite Completa**
* mvn test -Dselenide.baseUrl=https://www.saucedemo.com/ 
 
**Test Unit**
* mvn test -Dtest=HappyPathTest -Dselenide.baseUrl=https://www.saucedemo.com/ 
 
**Test Unit Method**
* mvn test -Dtest=HappyPathTest#happyPath -Dselenide.baseUrl=https://www.saucedemo.com/ 

---

4.- Comandos adicionales que se pueden utilizar al ejecutar el comando mvn test ...

-Dbrowser=chrome - para su ejecución con Chrome

-Dbrowser = firefox - para su ejecución con Firefox

-Dselenide.startMaximized=true - para su ejecución con la ventana maximizada

-Dselenide.browserSize=1024x768 - para definir el tamaño del navegador

**Nota.-** Es importante que el Browser Chrome este instalado fisicamente en la maquina donde se va a ejecutar el Script.
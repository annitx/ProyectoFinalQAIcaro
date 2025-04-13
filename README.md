# Proyecto Final Integrador - QA Automation con Java y Selenium

## Alumno: Anahi Marcel  
**Correo electrónico:** anahimarcel@gmail.com  
**Fecha de entrega:** 21/04/2025

---

## Descripción del Proyecto

Este proyecto consiste en la automatización de pruebas para el formulario de la web:  
[https://qa-practice.netlify.app/bugs-form](https://qa-practice.netlify.app/bugs-form)

La automatización se realizó siguiendo un enfoque BDD (Behavior Driven Development) usando:

- **Java 17** (Oracle OpenJDK 17)
- **Maven** como gestor de dependencias
- **Selenium** para la automatización del navegador
- **Cucumber** y **Gherkin** para la definición de escenarios
- **JUnit 4** para la verificación de resultados

Se implementó la automatización utilizando el patrón **Page Object Model (POM)**, con clases que encapsulan la interacción con el formulario y sus validaciones.

---

## Contenido del Proyecto

- **src/main/java/Página/**  
  - **BasePage.java:** Clase base con métodos auxiliares (clic, sendKeys, obtener texto, etc.).
  - **FormBugsPages/FormsPage.java:** Clase específica para interactuar con el formulario (envío de datos, clic en botones, recuperación de mensajes de validación).

- **src/test/java/com/qaautomation/stepdefinitions/BugsFormSteps.java:**  
  Definición de los pasos en Cucumber, que utilizan los métodos de la clase **FormsPage** para ejecutar los escenarios.

- **src/test/resources/features/BugsForm.feature:**  
  Archivo de escenarios en Gherkin que incluye:
  - Un **escenario positivo** para completar el formulario con datos válidos.
  - **Escenarios adicionales** para validar la visualización de mensajes de ayuda en los campos del formulario y la validación de un número de teléfono inválido.

- **pom.xml:**  
  Archivo de configuración de Maven con todas las dependencias necesarias para la automatización (Selenium, Cucumber, JUnit, entre otras).

---

## Ejecución del Proyecto

### Configuración:

1. Asegúrese de tener instalado **Java 17** y configurado correctamente en su entorno.
2. Verifique que el archivo **chromedriver.exe** se encuentre en **src/main/driver/** y que la versión de **ChromeDriver** coincida con la versión de **Google Chrome** instalada.

### Importar en IntelliJ IDEA:

1. Clonar o abrir el proyecto en IntelliJ y esperar la descarga de dependencias de Maven.

### Ejecutar Pruebas Automatizadas:

- Se pueden ejecutar las pruebas directamente desde la clase **TestRunner.java** o ejecutar el archivo **BugsForm.feature**.
- El proyecto utiliza **Scenario Outlines** para ejecutar múltiples casos (tanto válidos como negativos).

---

## Casos de Prueba

El proyecto final incluye los siguientes escenarios de prueba automatizados para el formulario:

- **El usuario completa los datos con valores correctos**
- **El usuario ingresa un número de teléfono inválido**
- **El usuario visualiza el mensaje de ayuda en el campo Password**
- **El usuario visualiza el mensaje de ayuda en el campo obligatorio**
- **El usuario visualiza el mensaje de ayuda en el campo Phone**

---

## Consideraciones Adicionales

### Validaciones

Además del caso de éxito en el que el formulario se registre correctamente, se incluye un escenario adicional para validar la visualización de los mensajes de ayuda en los campos y la validación de entradas incorrectas (por ejemplo, número de teléfono inválido).

### Entrega

Se solicita subir este proyecto a **GitHub**, y el repositorio se comparte con el profesor para la evaluación.

---

## Conclusión

Este proyecto demuestra el dominio de herramientas y conceptos básicos de **QA Automation** con **Java** y **Selenium**, aplicando buenas prácticas en la organización del código, manejo de excepciones y automatización de casos de prueba reales.

**¡Muchas gracias por la cursada y quedo a disposición para cualquier consulta!**

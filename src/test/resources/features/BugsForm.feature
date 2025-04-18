@BugsForm
Feature: Completar formulario

  Background:
    Given el usuario se encuentra en la home de BugsForm

  @BugsFormOk
  Scenario Outline: El usuario completa los datos con valores correctos
    When el usuario ingresa First Name "<FirstName>"
    And el usuario ingresa Last Name "<LastName>"
    And el usuario ingresa Phone number "<Phonenumber>"
    And el usuario ingresa Country "<Country>"
    And el usuario ingresa Email address "<EmailAddress>"
    And el usuario ingresa Password "<Password>"
    And el usuario hace clic boton Register
    Then el usuario visualiza el mensaje "<msjValidacion>"

    Examples:
      | FirstName | LastName | Phonenumber   | Country   | EmailAddress     | Password   | msjValidacion |
      | Clara      | Freire    | 3512323123    | Argentina | freire@gmail.com  | 123Usuario | Successfully registered the following information  |

  @BugsFormErrorTelefono
  Scenario Outline: El usuario ingresa un número de teléfono inválido
    When el usuario ingresa First Name "<FirstName>"
    And el usuario ingresa Last Name "<LastName>"
    And el usuario ingresa Phone number "<Phonenumber>"
    And el usuario ingresa Country "<Country>"
    And el usuario ingresa Email address "<EmailAddress>"
    And el usuario ingresa Password "<Password>"
    And el usuario hace clic boton Register
    Then el usuario visualiza el mensaje "<msjValidacion>"

    Examples:
      | FirstName | LastName | Phonenumber | Country   | EmailAddress  | Password | msjValidacion|
      | Anahi       | Marc     | 12345       | Argentina | ana@test.com  | pass123  | The phone number should contain at least 10 characters! |

  @BugsFormMensajePasswordLength
  Scenario Outline: El usuario visualiza mensaje de ayuda en campo Password
    Then el usuario visualiza el mensaje de ayuda de contraseña "<mensajeAyuda>"

    Examples:
    | mensajeAyuda                             |
    | Psw length validation: [6,20] characters  |

  @BugsFormMensajeMandatory
  Scenario Outline: El usuario visualiza el mensaje campo obligatorio
    Then el usuario visualiza el mensaje de ayuda obligatorio "<mensajeAyuda>"

    Examples:
      | mensajeAyuda                             |
      | Note: All the fields marked with * are mandatory |

  @BugsFormMensajePhone
  Scenario Outline: El usuario visualiza el mensaje de ayuda en el campo Phone
    Then el usuario visualiza el mensaje de ayuda de teléfono "<mensajeAyuda>"

    Examples:
      | mensajeAyuda                             |
      | Phone length validation: at least 10 digits|
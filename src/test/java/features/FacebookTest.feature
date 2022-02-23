Feature: Validacion Facebook

  Como usuario quiero leer chistes de Testers

  Scenario Outline: Ingresar a la app mobile de facebook y validar el titulo de la pagina de registro del email

    Given  El usuario puede acceder a pagina principal de facebook
    When   el usuario navega hasta la pagina de registro
    Then   diligencia formulario con valida letrero con "<Nombre>" , "<Apellido>" y "<FechaNacimiento>"
    Then   como no se pudo identificar el field de Email entonces vamos a hacer una assertion del texto "<TextoAValidar>"

    Examples:
      | Nombre | Apellido | FechaNacimiento | TextoAValidar            |
      | JUAN   | OCHOA    | Apr/01/1987     | Enter your email address |
      | PEDRO  | PEREZ    | Feb/12/1989     | Enter your email addres  |




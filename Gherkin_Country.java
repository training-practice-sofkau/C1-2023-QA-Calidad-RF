 Feature : Obtener código ISO de idioma por nombre

  Como usuario de la API de countryinfo 
  Quiero obtener el código ISO de un idioma por su nombre
  Para poder realizar operaciones en diferentes idiomas

  Scenario: Obtener código ISO de un idioma existente
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma existente "Spanish"
    Then el servicio devuelve el código ISO "es"

  
  Scenario: Obtener código ISO de un idioma con mayúsculas
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma con mayúsculas "ENGLISH"
    Then el servicio devuelve el código ISO "eng"

  Scenario: Obtener código ISO de un idioma inexistente
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma inexistente "Klingon"
    Then el servicio devuelve un mensaje de error "Language name not found!"

  Scenario: Obtener código ISO de un idioma con caracteres especiales
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma con caracteres especiales "Frençh"
    Then el servicio devuelve el código ISO "fr"

  Scenario: Obtener código ISO de un idioma en un idioma diferente
    Given que el usuario consulta el servicio LanguageISOCode en inglés
    When envía el nombre de un idioma en español "Español"
    Then el servicio devuelve el código ISO en inglés "es"




 Feature : Consultar nombre de moneda por código ISO

  Como usuario de la aplicación
  Quiero obtener el nombre de una moneda a partir de su código ISO
  Para poder hacer operaciones financieras precisas

  Scenario: Consultar nombre de una moneda existente
    Given que tengo el código ISO de la moneda "USD"
    When hago una solicitud al servicio CurrencyName
    Then el servicio devuelve el nombre "Dollars"

  Scenario: Consultar nombre de una moneda inexistente
    Given que tengo el código ISO de la moneda "XYZ"
    When hago una solicitud al servicio CurrencyName
    Then el servicio devuelve un mensaje de error "Currency code NOT found"

  Scenario: Consultar nombre de una moneda con código en minúsculas
    Given que tengo el código ISO de la moneda "eur"
    When hago una solicitud al servicio CurrencyName
    Then el servicio devuelve el nombre "Euro"

  Scenario: Consultar nombre de una moneda con código en mayúsculas
    Given que tengo el código ISO de la moneda "GBP"
    When hago una solicitud al servicio CurrencyName
    Then el servicio devuelve el nombre "Great Brittain Pounds"

  Scenario: Consultar nombre de una moneda con código en mayúsculas y minúsculas
    Given que tengo el código ISO de la moneda "jpy"
    When hago una solicitud al servicio CurrencyName
    Then el servicio devuelve el nombre "Japanese yen"


 Feature : Buscar persona por ID

     Como usuario
     Quiero buscar una persona por su ID
     Para poder obtener su información
    
  Scenario: Buscar persona con ID válido
    Dado que tengo el servicio FindPerson disponible
    Cuando envío una solicitud SOAP con el ID "2"
    Entonces debería recibir una respuesta con los detalles de la persona correspondiente.
    
  Scenario: Buscar persona con ID no existente
    Dado que tengo el servicio FindPerson disponible
    Cuando envío una solicitud SOAP con el ID "999"
    Entonces debería recibir una respuesta vacía o un mensaje de error indicando que no se encontró ninguna persona con ese ID.
    
  Scenario: ID de persona no especificado
    Dado que tengo el servicio FindPerson disponible
    Cuando envío una solicitud SOAP sin especificar un ID de persona
    Entonces debería recibir un mensaje de error que indica que se requiere un ID de persona válido.

  Scenario: Solicitud SOAP inválida
    Dado que tengo el servicio FindPerson disponible
    Cuando envío una solicitud SOAP con una estructura o sintaxis inválida
    Entonces debería recibir un mensaje de error que indica que la solicitud es inválida.


   Scenario: Enviar una solicitud SOAP con un ID inválido
    Dado que tengo el servicio FindPerson disponible
    Cuando envío una solicitud SOAP con un ID de persona inválido, como una cadena vacía, un valor no numérico, un valor negativo, etc.
    Entonces debería recibir un mensaje de error que indica que se requiere un ID de persona válido.



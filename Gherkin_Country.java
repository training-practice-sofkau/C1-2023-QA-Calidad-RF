 Feature : Obtener código ISO de idioma por nombre

  Como usuario de la API de countryinfo 
  Quiero obtener el código ISO de un idioma por su nombre
  Para poder realizar operaciones en diferentes idiomas

  1-Scenario: Obtener código ISO de un idioma existente
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma existente "Spanish"
    Then el servicio devuelve el código ISO "spa"

  
  Scenario: Obtener código ISO de un idioma con mayúsculas
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma con mayúsculas "ENGLISH"
    Then el servicio devuelve el código ISO "eng"

  Scenario: Obtener código ISO de un idioma inexistente
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma inexistente "Klingon"
    Then el servicio devuelve un mensaje de error "Language not found"

  Scenario: Obtener código ISO de un idioma con caracteres especiales
    Given que el usuario consulta el servicio LanguageISOCode
    When envía el nombre de un idioma con caracteres especiales "Français"
    Then el servicio devuelve el código ISO "fra"

  Scenario: Obtener código ISO de un idioma en un idioma diferente
    Given que el usuario consulta el servicio LanguageISOCode en inglés
    When envía el nombre de un idioma en español "Español"
    Then el servicio devuelve el código ISO en inglés "spa"

    
    
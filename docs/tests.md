# Diseño de Pruebas

## Pruebas Unitarias

### Clase SimpleCheckSumCalculator

#### Método calculateChecksum(String input)
- **Caso de prueba 1**: Entrada vacía
    - Entrada: `""`
    - Resultado esperado: `0` (o el valor de checksum correspondiente para una entrada vacía)
- **Caso de prueba 2**: Entrada con un solo carácter
    - Entrada: `"a"`
    - Resultado esperado: Valor de checksum correcto para la entrada "a"
- **Caso de prueba 3**: Entrada con una cadena corta
    - Entrada: `"hello"`
    - Resultado esperado: Valor de checksum correcto para la entrada "hello"
- **Caso de prueba 4**: Entrada con una cadena larga
    - Entrada: Una cadena de varios cientos o miles de caracteres
    - Resultado esperado: Valor de checksum correcto para la entrada
- **Caso de prueba 5**: Entrada con caracteres especiales
    - Entrada: Una cadena que contenga caracteres especiales como `!@#$%^&*()_+`
    - Resultado esperado: Valor de checksum correcto para la entrada
- **Caso de prueba 6**: Entrada con números
    - Entrada: Una cadena que contenga números, como `"123456789"`
    - Resultado esperado: Valor de checksum correcto para la entrada

### Clase CRCCalculator

#### Método calculateCRC(String input, int degree, int polynomial)
- **Caso de prueba 1**: Entrada vacía
    - Entrada: `""`
    - Polinomio generador: `x^3 + x + 1` (representado por 1011)
    - Resultado esperado: `0x0` (o el valor de CRC correspondiente para una entrada vacía)
- **Caso de prueba 2**: Entrada corta
    - Entrada: `"hello"`
    - Polinomio generador: `x^3 + x + 1` (representado por 1011)
    - Resultado esperado: Valor de CRC correcto para la entrada "hello" y el polinomio generador dado
- **Caso de prueba 3**: Entrada larga
    - Entrada: Una cadena de varios cientos o miles de caracteres
    - Polinomio generador: `x^4 + x^3 + 1` (representado por 10011)
    - Resultado esperado: Valor de CRC correcto para la entrada y el polinomio generador dado
- **Caso de prueba 4**: Polinomio generador de grado bajo
    - Entrada: `"123456789"`
    - Polinomio generador: `x^2 + 1` (representado por 101)
    - Resultado esperado: Valor de CRC correcto para la entrada y el polinomio generador dado
- **Caso de prueba 5**: Polinomio generador de grado alto
    - Entrada: Una cadena de varios cientos o miles de caracteres
    - Polinomio generador: `x^8 + x^7 + x^6 + x^4 + x^2 + 1` (representado por 100000111)
    - Resultado esperado: Valor de CRC correcto para la entrada y el polinomio generador dado

## Pruebas de Experimentación con Conjuntos Grandes de Datos

### Clase DataGenerator

#### Método generateData(int size)
- **Caso de prueba 1**: Generación de datos de categoría de tamaño "Toy"
    - Entrada: `category = "Toy"`
    - Resultado esperado: Una cadena de 99 caracteres generada aleatoriamente
- **Caso de prueba 2**: Generación de datos de categoría de tamaño "Pequeño"
    - Entrada: `category = "Small"`
    - Resultado esperado: Una cadena de 9999 caracteres generada aleatoriamente
- **Caso de prueba 3**: Generación de datos de categoría de tamaño "Mediano"
    - Entrada: `category = "Medium"`
    - Resultado esperado: Una cadena de 99999 caracteres generada aleatoriamente
- **Caso de prueba 4**: Generación de datos de categoría de tamaño "Grande"
    - Entrada: `category = "Large"`
    - Resultado esperado: Una cadena de 1000000 caracteres generada aleatoriamente
- **Caso de prueba 5**: Generación de datos de categoría de tamaño invalida
    - Entrada: `category = "Invalid"`
    - Resultado esperado: Una cadena vacía
- **Caso de prueba 6**: Generación de datos de tamaño negativo
    - Entrada: `size = -100`
    - Resultado esperado: Una cadena vacía
- **Caso de prueba 7**: Generación de datos de tamaño cero
    - Entrada: `size = 0`
    - Resultado esperado: Una cadena vacía
- **Caso de prueba 8**: Generación de datos de tamaño arbitrario
    - Entrada: `size = 12345`
    - Resultado esperado: Una cadena de 12345 caracteres generada aleatoriamente

### Pruebas de rendimiento

- **Caso de prueba 1**: Tiempo de ejecución de Checksum con datos de tamaño toy
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Toy")`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 2**: Tiempo de ejecución de Checksum con datos de tamaño pequeño
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Small")`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 3**: Tiempo de ejecución de Checksum con datos de tamaño mediano
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Medium")`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 4**: Tiempo de ejecución de Checksum con datos de tamaño grande
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Large")`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 5**: Tiempo de ejecución de Checksum con datos de tamaño arbitrario
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData(12345)`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 6**: Tiempo de ejecución de CRC con datos de tamaño toy
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Toy")`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 7**: Tiempo de ejecución de CRC con datos de tamaño pequeño
     - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Small")`
     - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 8**: Tiempo de ejecución de CRC con datos de tamaño mediano
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Medium")`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 9**: Tiempo de ejecución de CRC con datos de tamaño grande
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData("Large")`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 10**: Tiempo de ejecución de CRC con datos de tamaño arbitrario
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData(12345)`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada

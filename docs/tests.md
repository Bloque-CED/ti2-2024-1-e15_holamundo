# Diseño de Pruebas

## Pruebas Unitarias

### Clase Checksum

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

### Clase CRC

#### Método calculateCRC(String input, int polynomialDegree, int polynomialCoefficients)
- **Caso de prueba 1**: Entrada vacía
    - Entrada: `""`
    - Polinomio generador: `x^3 + x + 1` (representado por 1011)
    - Resultado esperado: `0` (o el valor de CRC correspondiente para una entrada vacía)
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
- **Caso de prueba 1**: Generación de datos de tamaño toy
    - Entrada: `size = 100`
    - Resultado esperado: Una cadena de 100 caracteres generada aleatoriamente
- **Caso de prueba 2**: Generación de datos de tamaño pequeño
    - Entrada: `size = 10000`
    - Resultado esperado: Una cadena de 10000 caracteres generada aleatoriamente
- **Caso de prueba 3**: Generación de datos de tamaño mediano
    - Entrada: `size = 500000`
    - Resultado esperado: Una cadena de 500000 caracteres generada aleatoriamente
- **Caso de prueba 4**: Generación de datos de tamaño grande
    - Entrada: `size = 10000000`
    - Resultado esperado: Una cadena de 10000000 caracteres generada aleatoriamente

### Pruebas de rendimiento

- **Caso de prueba 1**: Tiempo de ejecución de Checksum con datos de tamaño toy
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData(100)`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 2**: Tiempo de ejecución de Checksum con datos de tamaño pequeño
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData(10000)`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 3**: Tiempo de ejecución de Checksum con datos de tamaño mediano
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData(500000)`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada
- **Caso de prueba 4**: Tiempo de ejecución de Checksum con datos de tamaño grande
    - Entrada: Conjunto de datos generados con `DataGenerator.generateData(10000000)`
    - Resultado esperado: Tiempo de ejecución razonable para el tamaño de entrada

// Falta repetir los casos de prueba de rendimiento para el algoritmo CRC.
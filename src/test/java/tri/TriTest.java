package tri;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriTest {

	/*
	 * Particionamento em classes de equivalência:
	 * condições/variáves    |  Classes válidas   |  Classes inválidas  |
	 *     lados[3]          | lado[2] + lado[1] >|      lado[3] >      |
	 *     					 |       lado[3]      |   lado[2] + lado[1],|
	 *                       |lado[3] + lado[2] > |       lado[2] >     |
	 *     					 |       lado[1]      |   lado[3] + lado[1],|
	 *     					 |lado[3] + lado[1] > |     lado[1] >       |
	 *     					 |       lado[2]      |   lado[3] + lado[2],|
	 */
	@ParameterizedTest
    @CsvSource({
        "1,2,2",
        "5,7,5"
    })
    void testClasseValida1(Integer lado1, Integer lado2, Integer lado3) {
		Integer[] lados = {lado1, lado2, lado3};
		assertEquals("Isósceles", TRI.tipoTriangulo(lados));
	}
	@ParameterizedTest
    @CsvSource({
        "2,2,2",
        "3,3,3"
    })
    void testClasseValida2(Integer lado1, Integer lado2, Integer lado3) {
		Integer[] lados = {lado1, lado2, lado3};
		assertEquals("Equilátero", TRI.tipoTriangulo(lados));
	}
	@ParameterizedTest
    @CsvSource({
        "5,6,7",
        "7,8,9"
    })
    void testClasseValida3(Integer lado1, Integer lado2, Integer lado3) {
		Integer[] lados = {lado1, lado2, lado3};
		assertEquals("Escaleno", TRI.tipoTriangulo(lados));
	}
	
	@ParameterizedTest
    @CsvSource({
        "1,2,9",
        "3,4,7"
    })
    void testClasseInvalida1(Integer lado1, Integer lado2, Integer lado3) {
		Integer[] lados = {lado1, lado2, lado3};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> TRI.tipoTriangulo(lados));
		assertEquals("Lado 3 maior que a soma dos demais lados do triângulo", ex.getMessage());
	}
	@ParameterizedTest
    @CsvSource({
        "1,9,2",
        "3,7,4"
    })
    void testClasseInvalida2(Integer lado1, Integer lado2, Integer lado3) {
		Integer[] lados = {lado1, lado2, lado3};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> TRI.tipoTriangulo(lados));
		assertEquals("Lado 2 maior que a soma dos demais lados do triângulo", ex.getMessage());
	}
	@ParameterizedTest
    @CsvSource({
        "9,1,2",
        "7,3,4"
    })
    void testClasseInvalida3(Integer lado1, Integer lado2, Integer lado3) {
		Integer[] lados = {lado1, lado2, lado3};
		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> TRI.tipoTriangulo(lados));
		assertEquals("Lado 1 maior que a soma dos demais lados do triângulo", ex.getMessage());
	}
}

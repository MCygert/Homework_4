package com.infoshareacademy.homeworks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GradeServiceTest {

    private GradeService gradeService = new GradeService();

    @Test
    public void shouldReturnEmptyArrayWhenInputIsNull() {
        // GIVEN
        final String[][] input = null;

        final String[][] expectedResult = new String[][]{{}};

        // WHEN
        final String[][] result = gradeService.calculateAverage(input);

        // THEN
        assertThat(result).hasSize(expectedResult.length);
        assertThat(result[0]).hasSize(0);
    }

    @Test
    public void shouldReturnEmptyArrayWhenInputIsEmpty() {
        // GIVEN
        final String[][] input = new String[][]{};

        final String[][] expectedResult = new String[][]{{}};

        // WHEN
        final String[][] result = gradeService.calculateAverage(input);

        // THEN
        assertThat(result).hasSize(expectedResult.length);
        assertThat(result[0]).hasSize(0);
    }

    @Test
    public void shouldCalculateAverageGradesWhenNoDuplicates() {
        // GIVEN
        final String[][] input = new String[][]{
            {"Ania", "5"},
            {"Tomek", "6"},
            {"Kasia", "3"},
            {"Albert", "2"}
        };

        final String[][] expectedResult = new String[][]{
            {"Albert", "2.00"},
            {"Ania", "5.00"},
            {"Kasia", "3.00"},
            {"Tomek", "6.00"}
        };

        // WHEN
        final String[][] result = gradeService.calculateAverage(input);

        // THEN
        assertThat(result).hasSize(expectedResult.length);
        assertThat(result[0]).isEqualTo(expectedResult[0]);
        assertThat(result[1]).isEqualTo(expectedResult[1]);
        assertThat(result[2]).isEqualTo(expectedResult[2]);
        assertThat(result[3]).isEqualTo(expectedResult[3]);
    }

    @Test
    public void shouldCalculateAverageGradesWhenDuplicatesExist() {
        // GIVEN
        final String[][] input = new String[][]{
            {"Ania", "5"},
            {"Tomek", "6"},
            {"Kasia", "3"},
            {"Albert", "2"},
            {"Ania", "3"},
            {"Tomek", "1"},
            {"Tomek", "4"},
            {"Bartek", "2"}
        };

        final String[][] expectedResult = new String[][]{
            {"Albert", "2.00"},
            {"Ania", "4.00"},
            {"Bartek", "2.00"},
            {"Kasia", "3.00"},
            {"Tomek", "3.67"}
        };

        // WHEN
        final String[][] result = gradeService.calculateAverage(input);

        // THEN
        assertThat(result).hasSize(expectedResult.length);
        assertThat(result[0]).isEqualTo(expectedResult[0]);
        assertThat(result[1]).isEqualTo(expectedResult[1]);
        assertThat(result[2]).isEqualTo(expectedResult[2]);
        assertThat(result[3]).isEqualTo(expectedResult[3]);
        assertThat(result[4]).isEqualTo(expectedResult[4]);
    }
}

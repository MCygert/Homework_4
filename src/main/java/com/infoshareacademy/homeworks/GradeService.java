package com.infoshareacademy.homeworks;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

public class GradeService {

    public String[][] calculateAverage(String[][] data) {

        String[][] emptyArray1 = checkForEmptyandNullArray(data);
        if (emptyArray1 != null) return emptyArray1;

        DecimalFormat df = getDecimalFormat();

        List<String> students = new ArrayList<>();
        Map<String, Double> studentsToAmountOfGrades = new HashMap<>();

        creatingListorMapOfStudents(data, students, studentsToAmountOfGrades);
        Map<String, Double> studentsToGrades = new HashMap<>();

        for (String s : students) {
            studentsToGrades.put(s, 0.0);
        }

        for (String[] aData : data) {
            double grade = studentsToGrades.get(aData[0]);
            double grade2 = Double.parseDouble(aData[1]);
            studentsToGrades.put(aData[0], grade + (grade2));
        }

        String[][] array = new String[students.size()][2];

        Collections.sort(students);
        getProperGrade(df, students, studentsToAmountOfGrades, studentsToGrades, array);
        return array;

    }

    private void getProperGrade(DecimalFormat format, List<String> students, Map<String, Double> studentsToNumberOfGrades, Map<String, Double> studentsToGrades, String[][] array) {
        double division = 1.0;
        for (int i = 0; i < students.size(); i++) {
            array[i][0] = students.get(i);
            division = studentsToNumberOfGrades.get(array[i][0]);
            array[i][1] = format.format(studentsToGrades.get(array[i][0]) / division);
        }
    }

    private void creatingListorMapOfStudents(String[][] data, List<String> students, Map<String, Double> studentsToNumberOfGrades) {
        for (String[] aData : data) {
            if (!students.contains(aData[0])) {
                students.add(aData[0]);
                studentsToNumberOfGrades.put(aData[0], 1.0);
            } else {
                double amount = studentsToNumberOfGrades.get(aData[0]);
                amount = amount + 1.0;
                studentsToNumberOfGrades.put(aData[0], amount);
            }
        }
    }

    private DecimalFormat getDecimalFormat() {
        DecimalFormat format = new DecimalFormat("0.00");
        DecimalFormatSymbols sfs = new DecimalFormatSymbols();
        sfs.setDecimalSeparator('.');
        format.setDecimalFormatSymbols(sfs);
        return format;
    }

    private String[][] checkForEmptyandNullArray(String[][] data) {
        String[][] emptyArray = new String[][]{{}};
        if (data == null) {
            return emptyArray;
        }
        if (data.length == 0) {
            return emptyArray;
        }
        return null;
    }
}

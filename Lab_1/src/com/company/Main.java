package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int k;
        double x;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter k : ");
            k = scanner.nextInt();
            System.out.println("Enter x : ");
            x = scanner.nextDouble();
            double TaylorResult = TaylorRoadSum(x, k);
            double RealResult = Math.log1p(x);
            System.out.println("Expected result: " + ReductionNumber(RealResult));
            System.out.println("Actual result: " + ReductionNumber(TaylorResult));
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static double TaylorRoadSum(double x, int k) {
        double e = Math.pow(10, -k);
        double resultsum = 0.0;
        double AddTo = x;
        int temp = 1;
        while (Math.abs(AddTo) >= e) {
            resultsum += AddTo;
            temp += 1;
            AddTo = Math.pow(-1, temp + 1) * Math.pow(x, temp) / temp;
        }
        return resultsum;
    }

    private static String ReductionNumber(double value) {
        return String.format("%.4f", value);
    }

}
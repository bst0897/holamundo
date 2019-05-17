package edu.pucmm.hms;

import static spark.Spark.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hola mundo en spark");
        get("/hello", (req, res) -> "Hola Mundo Spark");
    }
}

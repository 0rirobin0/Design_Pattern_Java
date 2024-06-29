// package StructuralDP_CDPFBF;

// import java.util.HashMap;
// import java.util.Map;

// // The FlyWeight Design Pattern is a structural pattern used to minimize
// memory
// // usage
// // or computational expenses by sharing as much as possible with related
// objects

// interface CharObject {
// void display(int row, int col);
// }

// class Character implements CharObject {
// private char symbol;

// public Character(char symbol) {
// this.symbol = symbol;
// }

// @Override
// public void display(int row, int col) {
// System.out.println("Character: " + symbol + " at (" + row + ", " + col +
// ")");
// }
// }

// class CharObjectFactory {
// private Map<Character, CharObject> CharObjects = new HashMap<>();

// public CharObject getCharObject(char symbol) {
// Character key = symbol; // Autobox char to Character
// if (!CharObjects.containsKey(key)) {
// CharObjects.put(key, new Character(symbol));
// }
// return CharObjects.get(key);
// }
// }
// public class FlyWeight {
// public static void main(String[] args) {
// CharObjectFactory factory = new CharObjectFactory();

// String document = "Hello World";
// int row = 1;

// for (int col = 0; col < document.length(); col++) {
// char symbol = document.charAt(col);
// CharObject CharObject = factory.getCharObject(symbol);
// CharObject.display(row, col);
// }
// }
// }

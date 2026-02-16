package ht4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Crea un stack según lo que elija el usuario (SIN factory)
    private static <T> MyStack<T> buildStack(String stackType, String listType) {
        String t = stackType.trim().toLowerCase();

        if (t.equals("arraylist") || t.equals("a")) {
            return new ArrayListStack<>();
        }
        if (t.equals("vector") || t.equals("v")) {
            return new VectorStack<>();
        }
        if (t.equals("lista") || t.equals("list") || t.equals("l")) {
            // Aquí armamos la lista según el usuario
            String lt = listType.trim().toLowerCase();

            MyList<T> list;
            if (lt.equals("doble") || lt.equals("d")) {
                list = new DoublyLinkedList<>();
            } else {
                // default simple
                list = new SinglyLinkedList<>();
            }
            return new ListStack<>(list);
        }

        // default
        return new ArrayListStack<>();
    }

    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Ingrese implementación de Stack: arrayList / vector / lista");
            String stackType = sc.nextLine();

            String listType = "";
            if (stackType.trim().equalsIgnoreCase("lista") || stackType.trim().equalsIgnoreCase("list")) {
                System.out.println("Ingrese implementación de Lista: simple / doble");
                listType = sc.nextLine();
            }

            // En tu PC: poné el archivo como datos.txt en el folder del proyecto (donde corre el programa)
            String path = "datos.txt";

            List<String> lines = Files.readAllLines(Paths.get(path));

            System.out.println("\n=== RESULTADOS ===");
            for (int i = 0; i < lines.size(); i++) {
                String expr = lines.get(i).trim();
                if (expr.isEmpty()) continue;

                // stack nuevo por cada expresión
                MyStack<Integer> stack = buildStack(stackType, listType);
                Integer res = PostfixCalculator.evaluate(expr, stack);

                if (res == null) {
                    System.out.println("Linea " + (i + 1) + ": " + expr + "  -> ERROR (inválida o /0 o %0)");
                } else {
                    System.out.println("Linea " + (i + 1) + ": " + expr + "  -> " + res);
                }
            }
        }
    }
}
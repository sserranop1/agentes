import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Agent agent = new Agent(
                "AgenteJava",
                "Eres un agente básico creado en Java."
        );

        agent.addTool(new CalculatorTool());
        agent.addTool(new MemoryTool());
        agent.addTool(new SearchTool());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Agente listo.");
        System.out.println("Puedes escribir cosas como:");
        System.out.println("- calcula 25 * 8");
        System.out.println("- busca memoria");
        System.out.println("- recuerda que mi nombre es Santiago");
        System.out.println("- muestra memoria");
        System.out.println("- explícame qué es un agente");
        System.out.println("- salir");
        System.out.println();

        while (true) {
            System.out.print("Tú: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Agente: Hasta luego.");
                break;
            }

            String response = agent.run(input);

            System.out.println("Agente: " + response);
            System.out.println();
        }

        scanner.close();
    }
}
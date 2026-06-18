import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agent {

    private String name;
    private String instructions;
    private Map<String, Tool> tools;
    private List<String> memory;

    public Agent(String name, String instructions) {
        this.name = name;
        this.instructions = instructions;
        this.tools = new HashMap<>();
        this.memory = new ArrayList<>();
    }

    public void addTool(Tool tool) {
        this.tools.put(tool.getName(), tool);
    }

    public void remember(String message) {
        this.memory.add(message);
    }

    public String decideTool(String userInput) {
        String text = userInput.toLowerCase();

        if (text.contains("calcula")
                || text.contains("+")
                || text.contains("-")
                || text.contains("*")
                || text.contains("/")) {
            return "calculator";
        }

        if (text.contains("recuerda") || text.contains("guardar")) {
            return "memory";
        }

        if (text.contains("busca") || text.contains("buscar")) {
            return "search";
        }

        return null;
    }

    public String run(String userInput) {
        remember("Usuario: " + userInput);

        if (userInput.equalsIgnoreCase("muestra memoria")) {
            String response = showMemory();
            remember("Agente: " + response);
            return response;
        }

        String selectedTool = decideTool(userInput);

        if (selectedTool == null) {
            String response = "No necesito herramientas. Respondo directamente: " + userInput;
            remember("Agente: " + response);
            return response;
        }

        Tool tool = tools.get(selectedTool);

        if (tool == null) {
            String response = "Quise usar la herramienta '" + selectedTool + "', pero no existe.";
            remember("Agente: " + response);
            return response;
        }

        String result = tool.execute(userInput);

        String response = "Usé la herramienta '" + tool.getName() + "'. Resultado: " + result;

        remember("Agente: " + response);

        return response;
    }

    public String showMemory() {
        if (memory.isEmpty()) {
            return "La memoria está vacía.";
        }

        return String.join("\n", memory);
    }

    public String getName() {
        return name;
    }

    public String getInstructions() {
        return instructions;
    }
}
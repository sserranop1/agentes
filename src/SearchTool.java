import java.util.ArrayList;
import java.util.List;

public class SearchTool implements Tool {

    private final List<String> documents;

    public SearchTool() {
        this.documents = new ArrayList<>();

        documents.add("Un agente es un programa que puede decidir qué hacer y usar herramientas.");
        documents.add("Una herramienta es una función que el agente puede ejecutar.");
        documents.add("La memoria permite que el agente recuerde mensajes anteriores.");
        documents.add("Java permite crear agentes usando clases, interfaces, listas y mapas.");
        documents.add("Un agente con inteligencia artificial puede usar un modelo de lenguaje para decidir.");
    }

    @Override
    public String getName() {
        return "search";
    }

    @Override
    public String getDescription() {
        return "Sirve para buscar información en documentos internos.";
    }

    @Override
    public String execute(String input) {
        String query = input.toLowerCase()
                .replace("busca", "")
                .replace("buscar", "")
                .trim();

        List<String> results = new ArrayList<>();

        for (String document : documents) {
            if (document.toLowerCase().contains(query)) {
                results.add(document);
            }
        }

        if (results.isEmpty()) {
            return "No encontré información relacionada.";
        }

        return String.join(" | ", results);
    }
}
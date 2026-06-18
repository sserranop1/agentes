public class MemoryTool implements Tool {

    @Override
    public String getName() {
        return "memory";
    }

    @Override
    public String getDescription() {
        return "Sirve para registrar información enviada por el usuario.";
    }

    @Override
    public String execute(String input) {
        return "He recibido algo para guardar: " + input;
    }
}
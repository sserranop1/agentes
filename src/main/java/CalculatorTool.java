public class CalculatorTool implements Tool {

    @Override
    public String getName() {
        return "calculator";
    }

    @Override
    public String getDescription() {
        return "Sirve para hacer cálculos matemáticos simples.";
    }

    @Override
    public String execute(String input) {
        try {
            String expression = input.toLowerCase()
                    .replace("calcula", "")
                    .trim();

            if (expression.contains("*")) {
                String[] parts = expression.split("\\*");
                double a = Double.parseDouble(parts[0].trim());
                double b = Double.parseDouble(parts[1].trim());
                return String.valueOf(a * b);
            }

            if (expression.contains("+")) {
                String[] parts = expression.split("\\+");
                double a = Double.parseDouble(parts[0].trim());
                double b = Double.parseDouble(parts[1].trim());
                return String.valueOf(a + b);
            }

            if (expression.contains("-")) {
                String[] parts = expression.split("-");
                double a = Double.parseDouble(parts[0].trim());
                double b = Double.parseDouble(parts[1].trim());
                return String.valueOf(a - b);
            }

            if (expression.contains("/")) {
                String[] parts = expression.split("/");
                double a = Double.parseDouble(parts[0].trim());
                double b = Double.parseDouble(parts[1].trim());

                if (b == 0) {
                    return "No se puede dividir entre cero.";
                }

                return String.valueOf(a / b);
            }

            return "No reconocí la operación matemática.";

        } catch (Exception e) {
            return "No pude calcular eso. Error: " + e.getMessage();
        }
    }
}
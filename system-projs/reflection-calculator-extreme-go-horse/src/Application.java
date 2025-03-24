import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import model.exception.InvalidOperationException;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.show();  
        try {
            System.out.println(application.run());
        } catch (Exception e ) {
            System.out.println("Erro ao tentar calcular: " + e);
        } 
    }

    public static String getOperationType(int option) throws InvalidOperationException{
        if (option == 1) return "Add";
        if (option == 2) return "Subtract";
        if (option == 3) return "Multiply";
        if (option == 4) return "Divide";
        throw new InvalidOperationException();
    }

    public void show() {
        System.out.println("Escolha uma opcao:\n1 - Adicao\n2 - Subtracao\n3 - Multiplicacao\n4 - Divisao");
    }

    public float run() throws InvalidOperationException, ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option < 1 && option > 4) throw new InvalidOperationException();

        System.out.println("1º operador: ");
        float value1 = scanner.nextFloat();
        System.out.println("2º operador: ");
        float value2 = scanner.nextFloat();

        Object instantiatedClass = null;
        try {
            String rootOperationType = Application.getOperationType(option);
            instantiatedClass = Class.forName(rootOperationType).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        IOperation operation = (IOperation) instantiatedClass;
        return operation.operate(value1, value2);
    }
}

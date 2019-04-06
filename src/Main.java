import Domain.Factura;
import Domain.FacturaValidator;
import Repository.FacturaRepository;
import Service.FacturaService;
import UI.Console;

public class Main {
    public static void main(String[] args) {

        FacturaValidator facturaValidator = new FacturaValidator();

        FacturaRepository facturaRepository = new FacturaRepository(facturaValidator);

        FacturaService facturaService = new FacturaService(facturaRepository);

        Console console = new Console(facturaService);
        console.run();
    }
}

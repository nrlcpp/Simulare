package Domain;


import java.text.ParseException;
import java.text.SimpleDateFormat;


public class FacturaValidator {
public void validate (Factura factura) {
    SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
    try {
        format.parse(factura.getDate());
    } catch (ParseException pe){
        throw new RuntimeException("The date is not in the correct format!");
    }
}
}

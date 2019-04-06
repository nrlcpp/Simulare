package Repository;

import Domain.Factura;
import Domain.FacturaValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacturaRepository {
    private Map<String, Factura> storage = new HashMap<>();
    private FacturaValidator validator;

    public FacturaRepository(FacturaValidator validator) {
        this.validator = validator;
    }

    public Factura findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a factura if it already exists.
     * @param factura the factura to add or update
     */
    public void upsert(Factura factura) {
        validator.validate(factura);
        storage.put(factura.getId(), factura);
    }

    /**
     * Removes a cake with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no cake with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no object with the given id to remove.");
        }

        storage.remove(id);
    }
    public List<Factura> getAll() {
        return new ArrayList<>(storage.values());
    }

    public List<Factura> getSum() { return new ArrayList<>(getSum());
    }
}

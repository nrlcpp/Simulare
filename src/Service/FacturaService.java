package Service;

import Domain.Factura;
import Repository.FacturaRepository;

import java.util.List;

public class FacturaService {
    private FacturaRepository repository;

    public FacturaService(FacturaRepository repository) {
        this.repository = repository;
    }

    public Factura addOrUpdate(String id, String sum, String description, String date) {
        Factura existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (id.isEmpty()) {
                id = existing.getId();
            }
            if (sum.isEmpty()) {
                sum = existing.getSum();
            }
            if (description.isEmpty()) {
                description = existing.getDescription();
            }
           if (date.isEmpty()) {
               date = existing.getDate();
           }
        }
        Factura factura = new Factura(id, sum, description, date);
        repository.upsert(factura);
        return existing;
    }

    public void remove(String id) {
        repository.remove(id);
    }
    public List<Factura> getAll() {
        return repository.getAll();
    }

    public List<Factura> getSum() { return repository.getSum();
    }
}

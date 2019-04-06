package Domain;

import java.util.Objects;

public class Factura {

    private String id, sum, description, date;

    public Factura(String id, String sum, String description, String date){
      this.id = id;
      this.sum = sum;
      this.description = description;
      this.date = date;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id='" + id+ '\'' +
                ", sum='" + sum + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sum, description, date);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

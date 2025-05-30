package cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Repository.Entity;

import cl.duoc.evaluacion.cparra.hohidalgo.Evaluacio_2_Fullstackl.Service.Domain.InventoryManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartManagerEntity {
    private int cartId;
    private int clientId;
    // private List<InventoryManager> products; el Listado se implementara con el MicroServicio de Pagos.
    private String cartName;
    private String cartDescription;

    /* El carrito podra tener mediante otro micro servicio a futuro
    la posibilidad de agregar productos,
    por ahora como ejemplo tendra su lista con la que a futuro se usara para guardar productos

    Y con el microservicio de pagos, se espera implementar totales y descuentos.
     */
}

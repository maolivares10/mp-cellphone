/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpcellphone.ejbs;

import co.edu.uniandes.csw.mpcellphone.api.IOrderLogic;
import co.edu.uniandes.csw.mpcellphone.converters.OrderConverter;
import co.edu.uniandes.csw.mpcellphone.dtos.OrderDTO;
import co.edu.uniandes.csw.mpcellphone.entities.OrderEntity;
import co.edu.uniandes.csw.mpcellphone.persistence.OrderPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * EJB relacionado con el comportamiento de una orden
 * @author Cindy Hern�ndez - cv.hernandez10
 */
@Stateless
public class OrderLogic implements IOrderLogic {
 
    @Inject
    private OrderPersistence persistence; 
    
    public int countOrder() {
        return persistence.count();
    }

    /**
     * Metodo encargado de obtener las �rdenes de un cliente
     * @param page
     * @param maxRecords
     * @return 
     */
    public List<OrderDTO> getOrders(Integer page, Integer maxRecords) {
        return OrderConverter.listEntity2DTO(persistence.findAll(page, maxRecords));
    }

    /**
     * Metodo encargado de obtener una orden solicitada a traves del id de esta
     * @param id
     * @return 
     */
    public OrderDTO getOrder(Long id) {
        return OrderConverter.fullEntity2DTO(persistence.find(id));
    }

    /**
     * Metodo que permite realizar la creaci�n de una orden
     * @param dto
     * @return 
     */
    public OrderDTO createOrder(OrderDTO dto) {
        OrderEntity entity = OrderConverter.fullDTO2Entity(dto);
        persistence.create(entity);
        return OrderConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite actualizar la informaci�n de una orden
     * @param dto
     * @return 
     */
    public OrderDTO updateOrder(OrderDTO dto) {
        OrderEntity entity = persistence.update(OrderConverter.fullDTO2Entity(dto));
        return OrderConverter.fullEntity2DTO(entity);
    }

    /**
     * Metodo que permite eliminar una orden
     * @param id 
     */
    public void deleteOrder(Long id) {
        persistence.delete(id);
    }
}
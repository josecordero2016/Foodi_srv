/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javarest.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author im_jo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Javarest.service.CalificacionFacadeREST.class);
        resources.add(Javarest.service.CategoriaEstablecimientoFacadeREST.class);
        resources.add(Javarest.service.CategoriaFacadeREST.class);
        resources.add(Javarest.service.ChefFacadeREST.class);
        resources.add(Javarest.service.ComboFacadeREST.class);
        resources.add(Javarest.service.ComplementosFacadeREST.class);
        resources.add(Javarest.service.DetalleComboFacadeREST.class);
        resources.add(Javarest.service.DetallePedidoFacadeREST.class);
        resources.add(Javarest.service.DisponibilidadMesasFacadeREST.class);
        resources.add(Javarest.service.EstablecimientoFacadeREST.class);
        resources.add(Javarest.service.HistorialFacadeREST.class);
        resources.add(Javarest.service.HorarioAtencionFacadeREST.class);
        resources.add(Javarest.service.IngredientesFacadeREST.class);
        resources.add(Javarest.service.IngredientesProductoFacadeREST.class);
        resources.add(Javarest.service.PedidoFacadeREST.class);
        resources.add(Javarest.service.PersonaFacadeREST.class);
        resources.add(Javarest.service.ProductoFacadeREST.class);
        resources.add(Javarest.service.ProductoFinalComplementosFacadeREST.class);
        resources.add(Javarest.service.ProductoFinalFacadeREST.class);
        resources.add(Javarest.service.PruebaFacadeREST.class);
        resources.add(Javarest.service.TipoProductoFacadeREST.class);
        resources.add(Javarest.service.UsuarioFacadeREST.class);
    }
    
}

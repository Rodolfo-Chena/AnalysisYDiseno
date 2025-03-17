package mx.uam.ayd.proyecto.presentacion.agregarGrupo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioGrupo;

@Component
public class ControlAgregarGrupo {

    @Autowired
    private VentanaAgregarGrupo ventana;

    @Autowired
    private ServicioGrupo servicioGrupo;

    public void inicia() {
        ventana.muestra(this);
    }

    public void agregarGrupo(String nombreGrupo) {
        try {
            // Guardar el grupo usando el servicio
            servicioGrupo.guardarGrupo(nombreGrupo);

            // Mostrar mensaje de éxito
            ventana.muestraDialogoConMensaje("Grupo agregado exitosamente");

            // Cerrar la ventana
            ventana.cierra();
        } catch (Exception ex) {
            ventana.muestraDialogoConMensaje("Error al agregar grupo: " + ex.getMessage());
        }
    }
}
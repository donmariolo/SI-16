package es.deusto.ingenieria.si.sbc.seguros;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import es.deusto.ingenieria.si.sbc.seguros.Vivienda.CalidadConstruccion;
import es.deusto.ingenieria.si.sbc.seguros.Vivienda.Tipo;

public class MecanismoInferencia {

	public static void main(String[] args) {
		try {
			//Funciona todo bien
			Vivienda vivienda1 = new Vivienda();
			vivienda1.setDireccion("20 Ingram St. Forest Hills, NY (Queens)");
			vivienda1.setPropietario("Peter Parker");
			vivienda1.setEdad(20);
			vivienda1.setPresupuesto(300);
			vivienda1.setTipo(Tipo.CASA_UNIFAMILIAR);
			vivienda1.setMejoras(true);
			vivienda1.setCalidad(CalidadConstruccion.EXCELENTE);
			vivienda1.setPertenenciasValiosas(false);

			Vivienda vivienda2 = new Vivienda();
			vivienda2.setDireccion("Metropolis, Illinois");
			vivienda2.setPropietario("Clark Kent");
			vivienda2.setEdad(6);
			vivienda2.setPresupuesto(200);
			vivienda2.setTipo(Tipo.PISO);
			vivienda2.setMejoras(true);
			vivienda2.setCalidad(CalidadConstruccion.MEDIA);
			vivienda2.setPertenenciasValiosas(false);
			
			Vivienda vivienda3 = new Vivienda();
			vivienda3.setDireccion("Wayne Manor - Bristol Hills, Gotham City");
			vivienda3.setPropietario("Bruce Wayne");
			vivienda3.setEdad(40);
			vivienda3.setPresupuesto(300);
			vivienda3.setPertenenciasValiosas(false);
			
			//Antes del proceso de inferencia
			System.out.println("ANTES DEL PROCESO DE INFERENCIA");
			System.out.println("----- --- ------- -- ----------");
			System.out.println(vivienda1);
			System.out.println("\n" + vivienda2);
			System.out.println("\n" + vivienda3);
				
	        // KieServices es la factoría para crear servicios KIE 
	        KieServices kServices = KieServices.Factory.get();
	        
	        // Se crea un contenedor para la base de conocimiento a partir del KieServices
	        KieContainer kContainer = kServices.getKieClasspathContainer();
	        
	        // Se crea una sesión KIE en el contenedor a partir del fichero de configuración  
	        // META-INF/kmodule.xml.
	        KieSession kSession = kContainer.newKieSession("seguros-session");
	        
	        // Se configura el log del proceso de inferencia
	        KieRuntimeLogger logger = kServices.getLoggers().newFileLogger(kSession, "./log/seguros");			

	        //Se insertan los objetos en la KIE Session (Memoria de trabajo)
			kSession.insert(vivienda1);
			kSession.insert(vivienda2);
			kSession.insert(vivienda3);

			System.out.println("\nDURANTE EL PROCESO DE INFERENCIA");
			System.out.println("------- -- ------- -- ----------");
			
			//Se invoca al proceso de inferencia
			kSession.fireAllRules();
			
			//Se cierra el log
			logger.close();

			//After inference process
			System.out.println("\nDESPUES DEL PROCESO DE INFERENCIA");
			System.out.println("------- --- ------- -- ----------");			
			System.out.println(vivienda1);
			System.out.println("\n" + vivienda2);
			System.out.println("\n" + vivienda3);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.err.println("MainProgram: " + ex.getMessage());
		}
	}
}
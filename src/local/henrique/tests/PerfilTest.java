package local.henrique.tests;

import junit.framework.TestCase;
import local.henrique.model.Perfil;

public class PerfilTest extends TestCase{
	
	public void testGetName() {
		Perfil perfil =  new Perfil("Admin");
		
		String resultado_esperado = "Admin";
		
		String resultado_recebido = perfil.getName();
		
		assertEquals(resultado_esperado, resultado_recebido);
	}
	
}

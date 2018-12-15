package local.henrique.tests;

import junit.framework.TestCase;
import local.henrique.model.Usuario;

public class UsuarioTest extends TestCase{
	
	public void testGetLogin() {
		Usuario usuario = new Usuario();
		
		usuario.setLogin("henrique");
		
		String resultado_esperado = "henrique";
		
		String resultado_recebido = usuario.getLogin();
		
		assertEquals(resultado_esperado, resultado_recebido);
	}

}

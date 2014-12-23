package br.com.java8.test;


import static br.com.java8.support.UsuarioSupport.getListaDeUsuarios;
import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;

import br.com.java8.Fibonacci;
import br.com.java8.Usuario;

public class StreamsECollectorsTest {
	
	@Test
	public void tornandoModeradoresOsDoisUsuariosComMaisPontos(){
		List<Usuario> usuarios = getListaDeUsuarios();
		Collections.sort(usuarios, new Comparator<Usuario>() {
			@Override
			public int compare(Usuario u1, Usuario u2) {
				return u1.getPontos() - u2.getPontos();
			}
			
		});
		
		Collections.reverse(usuarios);
		
		for (Usuario usuario : usuarios.subList(0, 2)) {
			usuario.tornaModerador();
		}
		
		assertTrue(usuarios.get(0).isModerador());
		assertTrue(usuarios.get(1).isModerador());
		assertFalse(usuarios.get(2).isModerador());
	}	

	@Test
	public void tornandoModeradoresOsDoisUsuariosComMaisPontos_Java8(){
		List<Usuario> usuarios = getListaDeUsuarios();
		usuarios.sort(comparingInt(Usuario::getPontos).reversed());
		usuarios.subList(0, 2).forEach(u -> u.tornaModerador());
		
		assertTrue(usuarios.get(0).isModerador());
		assertTrue(usuarios.get(1).isModerador());
		assertFalse(usuarios.get(2).isModerador());
	}

	@Test
	public void tornandoModeradoresOsDoisUsuariosComMaisPontos_Java8_ComStream(){
		List<Usuario> usuarios = getListaDeUsuarios();
		usuarios.stream()
	        .filter(u -> u.getPontos() < 15)
	        .forEach(u -> u.tornaModerador());;
		
		assertFalse(usuarios.get(0).isModerador());
		assertFalse(usuarios.get(1).isModerador());
		assertTrue(usuarios.get(2).isModerador());
	}
	
	@Test
	public void filtraListaDeUsuariosUtilizandoStream_RetornandoListaManualmente(){
		List<Usuario> resultado = new ArrayList<Usuario>();
		
		getListaDeUsuarios().stream()
			.filter(u -> u.getPontos() < 15)
			.forEach(resultado::add);
		
		assertEquals("[[Noah Gabriel, 10]]", resultado.toString());
	}
	
	@Test
	public void filtraListaDeUsuariosUtilizandoStream_RetornandoListaComCollector(){
		List<Usuario> resultado = getListaDeUsuarios().stream()
			.filter(u -> u.getPontos() < 15)
			.collect(toList());
		
		assertEquals("[[Noah Gabriel, 10]]", resultado.toString());
	}
	
	@Test
	public void filtrandoApenasOsPontosDaListaDeUsuarios_UtilizandoMap(){
		List<Integer> pontos = getListaDeUsuarios().stream()
			.map(Usuario::getPontos)
			.collect(toList());
		
		assertEquals("[15, 20, 10]", pontos.toString());
	}
	
	@Test
	public void calculandoAPontuacaoMedia_UtilizandoMapToDouble(){
		double pontuacaoMedia = getListaDeUsuarios().stream()
			.mapToDouble(Usuario::getPontos)
			.average()
			.orElse(0);
		
		assertEquals(15, pontuacaoMedia, 0);
	}
	
	@Test
	public void filtraListaDeUsuariosUtilizandoStream_OrdenandoPorNome(){
		List<Usuario> usuarios = getListaDeUsuarios();
		assertEquals("[[Guilherme Silva, 15], [Alana Pereira, 20], [Noah Gabriel, 10]]", usuarios.toString());
		
		List<Usuario> resultado = usuarios.stream()
			.filter(u -> u.getPontos() > 10)
			.sorted(comparing(Usuario::getNome))
			.collect(toList());
		
		assertEquals("[[Guilherme Silva, 15], [Alana Pereira, 20], [Noah Gabriel, 10]]", usuarios.toString());
		assertEquals("[[Alana Pereira, 20], [Guilherme Silva, 15]]", resultado.toString());
	}
	
	@Test
	public void filtraListaDeUsuariosUtilizandoStream_EUtilizaPeek(){
		List<Usuario> usuarios = getListaDeUsuarios();
		assertEquals("[[Guilherme Silva, 15], [Alana Pereira, 20], [Noah Gabriel, 10]]", usuarios.toString());
		
		StringBuilder builder = new StringBuilder();
		Usuario alana = usuarios.stream()
			.filter(u -> u.getPontos() == 20)
			.peek(builder::append)
			.findAny()
			.orElse(null);
				
		assertEquals("[[Guilherme Silva, 15], [Alana Pereira, 20], [Noah Gabriel, 10]]", usuarios.toString());
		assertEquals("[Alana Pereira, 20]", builder.toString());
		assertEquals("[Alana Pereira, 20]", alana.toString());
	}
	
	@Test
	public void operacoesDeReducao_BuscandoOUsuarioComAMaiorPontuacao(){
		Usuario max = getListaDeUsuarios().stream()
			.max(comparingInt(Usuario::getPontos))
			.orElse(null);

		assertEquals("[Alana Pereira, 20]", max.toString());
	}
	
	@Test
	public void operacoesDeReducao_somandoAsPontuacoes(){
		int soma = getListaDeUsuarios().stream()
			.mapToInt(Usuario::getPontos)
			.sum();
		
		assertEquals(45, soma);
	}
	
	@Test
	public void operacoesDeReducao_multiplicandoAsPontuacoes(){
		int multiplicacao = getListaDeUsuarios().stream()
			.mapToInt(Usuario::getPontos)
			.reduce(1, (a,b) -> a * b);
		
		assertEquals(3000, multiplicacao);
	}

	@Test
	public void percorrendoStreamsUtilizandoIterator(){
		StringBuilder build = new StringBuilder();
		getListaDeUsuarios().stream()
			.filter(u -> u.getNome().contains("G"))
			.sorted(comparing(Usuario::getNome))
			.iterator()
			.forEachRemaining(build ::append);

		assertEquals("[Guilherme Silva, 15][Noah Gabriel, 10]", build.toString());
	}

	@Test
	public void verificaSeAlgumUsuarioIsModerador(){
		boolean temModerador = getListaDeUsuarios().stream().anyMatch(Usuario::isModerador);
		assertFalse(temModerador);
	}
	
	@Test
	public void verificaSeTodosOsUsuariosNaoSaoModeradores(){
		List<Usuario> usuarios = getListaDeUsuarios();
		boolean todosNaoSaoModeradores = usuarios.stream().allMatch(u -> !u.isModerador());
		assertTrue(todosNaoSaoModeradores);
		
		usuarios.stream().findAny().get().tornaModerador();
		todosNaoSaoModeradores = usuarios.stream().allMatch(u -> !u.isModerador());
		assertFalse(todosNaoSaoModeradores);
	}
	
	@Test
	public void gerandoASequenciaDeFibonacci_RecuperandoOsCincoPrimeirosNumeros(){
		List<Integer> sequencia = new ArrayList<Integer>();
		IntStream.generate(new Fibonacci())
			.limit(5)
			.forEach(sequencia::add);
				
		assertEquals("[0, 1, 1, 2, 3]", sequencia.toString());
	}
	
	@Test
	public void gerandoASequenciaDeFibonacci_RecuperandoOPrimeiroMaiorOuIgualA100(){
		int fibonacci = IntStream.generate(new Fibonacci())
			.filter(f -> f >= 100)
			.findFirst()
			.getAsInt();
		
		assertEquals(144, fibonacci);
	}
	
	@Test
	public void listaTodosOsArquivosDoDiretorio(){
		List<Path> paths = null;
		try {
			paths = Files.list(Paths.get("./src/main/java/br/com/java8"))
				.map(Path::getFileName)
				.sorted(comparing(Path::getFileName))
				.collect(toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		assertEquals("[Capitulo2.java, Fibonacci.java, Usuario.java, Validador.java]", paths.toString());
	}
}

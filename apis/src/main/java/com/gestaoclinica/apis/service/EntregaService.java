package com.gestaoclinica.apis.service;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gestaoclinica.apis.entities.Entrega;
import com.gestaoclinica.apis.entities.matrix.MatrixDistanciaGoogle;
import com.gestaoclinica.apis.entities.matrix.MenorCaminhoRequest;
import com.gestaoclinica.apis.entities.matrix.MenorCaminhoResponse;
import com.gestaoclinica.apis.entities.matrix.Nota;
import com.gestaoclinica.apis.entities.matrix.NotaRequest;
import com.gestaoclinica.apis.repositories.EntregaRepository;
import com.gestaoclinica.apis.service.exceptions.ConexaoComPortalException;
import com.gestaoclinica.apis.service.exceptions.RecursoJaCadastradoException;
import com.gestaoclinica.apis.service.exceptions.ErroDePermissaoException;
import com.gestaoclinica.apis.service.exceptions.ErroDePermissaoNotaException;
import com.gestaoclinica.apis.service.exceptions.ErroNaoMapeadoException;
import com.gestaoclinica.apis.service.exceptions.RecursoNaoEncontradoException;
import com.gestaoclinica.apis.service.exceptions.TamanhoMaximoException;
import com.gestaoclinica.apis.service.exceptions.ViolacaoDeChaveException;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository repository;

	public List<Entrega> findAll() {
		return repository.findAll();
	}

	public Entrega findById(Long id) {
		Optional<Entrega> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id,1));
	}

	public Entrega delete(Entrega obj) {
		try {
			repository.deleteById(obj.getId());
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new ViolacaoDeChaveException("Esse recurso esta sendo utilizado!");

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			throw new RecursoJaCadastradoException("N�o existe esse registro.",1);

		} catch (RuntimeException e) {

			e.printStackTrace();
			throw new ErroNaoMapeadoException("");
		}
		return obj;

	}

	public Nota consultarNota(NotaRequest nota) throws IOException {
		apiConsultaNota(nota);
		return null;
	}

	public Nota apiConsultaNota(NotaRequest objConsulta) throws IOException {
		try{
			System.out.println("okkkkkne");
	
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		MediaType mediaType = MediaType.parse("text/plain");
		RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
				.addFormDataPart("nota", objConsulta.getNota()).addFormDataPart("serie", objConsulta.getSerie())
				.addFormDataPart("centro", objConsulta.getCentro()).build();
		Request request = new Request.Builder()
				.url("https://leroymerlin.portaldotransportador.com/externo/api/ws/alocaja/get_nota_data/post")
				.method("POST", body)
				.addHeader("apiKey", "78asd4546d4sa687e1d1xzlcknhwyhuWMKPSJDpox8213njdOWnxxipW58547")
				.addHeader("Cookie", "ci_session=d368l16aajra539qfabu25l5qirmjtl1").build();
		Response response = client.newCall(request).execute();
		String responseBody = response.body().string();
		Gson gson = new Gson();
		Nota nota = new Nota();

		nota = gson.fromJson(responseBody, Nota.class);
		System.out.println("okkkkkne2");

		if (nota.getExist() == "true") {

			if (nota.getData().getCnpj_transportadora().toString()
					.compareTo(objConsulta.getCnpjTransportadora().toString()) != 0) {

				throw new ErroDePermissaoException("Essa nota n�o � da sua transportadora!");
			}
			return nota;
		} else {
			throw new ErroDePermissaoNotaException("Essa nota n�o existe!");
	
		}
		} catch (SocketTimeoutException e) {
			throw new ConexaoComPortalException("A conex�o com o portal do transportador falhou. Favor contatar equipe de TI.");
		}
	

	}



	public MenorCaminhoResponse calcularMenorDistancia(MenorCaminhoRequest objEnderecos) {
		try {
			total = 0;
			String origem = "";
				System.out.println(objEnderecos.toString());
				System.out.println("tamanho"+ objEnderecos.getEnderecos().length);
			for (int i = 0; i < objEnderecos.getEnderecos().length; i++) {
				if(i == 0) {
					System.out.println("endereco =0"+ objEnderecos.getEnderecos()[i]);
			
					origem= origem + objEnderecos.getEnderecos()[i]+"|";
					System.out.println("origem"+ origem);

				} else if (i == objEnderecos.getEnderecos().length-1) {
					System.out.println("endereco -1"+ objEnderecos.getEnderecos()[i]);
					origem= origem + objEnderecos.getEnderecos()[i];
					System.out.println("origem"+ origem);
					
				} else {
					System.out.println("else"+ objEnderecos.getEnderecos()[i]);

					origem= origem + objEnderecos.getEnderecos()[i]+"|";
					System.out.println("origem"+ origem);

				}
			}
			System.out.println("string final:"+ origem);
			
			String urlFinal = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins="+origem+"&destinations="+origem+"&key=AIzaSyDMXEvPsNDfZbDXlP7K0kug3Eh6KdXIPEE";	
			
			System.out.println("url final"+ urlFinal);
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					Request request = new Request.Builder()
					.url(urlFinal)

					  //.url("https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=RUA LUIS G�IS, 1787 - MIRAND�POLIS, S�O PAULO CEP:04043500|RUA IBIUNA, 352 - BOSQUE DOS EUCALIPTOS, S�O JOS� DOS CAMPOS CEP:12233500|R. Ol�vio Vi�ira da Rosa, 180 - Jardim Santa Maria jacarei  CEP:12328-100&destinations=RUA LUIS G�IS, 1787 - MIRAND�POLIS, S�O PAULO CEP:04043500|RUA IBIUNA, 352 - BOSQUE DOS EUCALIPTOS, S�O JOS� DOS CAMPOS CEP:12233500|R. Ol�vio Vi�ira da Rosa, 180 - Jardim Santa Maria jacarei  CEP:12328-100&key=AIzaSyDMXEvPsNDfZbDXlP7K0kug3Eh6KdXIPEE")
					  .method("GET", null)
					  .build();
					Response response2 = client.newCall(request).execute();
					
					String response = response2.body().string();

					System.out.println("response"+response);
					MatrixDistanciaGoogle matrixDistanciaResponse = null;

					Gson gson = new Gson();
					String jsonString = gson.toJson(response);
					matrixDistanciaResponse = gson.fromJson(response.toString(), MatrixDistanciaGoogle.class);
					
					if (matrixDistanciaResponse.getStatus().equalsIgnoreCase("MAX_ELEMENTS_EXCEEDED")) {
						throw new TamanhoMaximoException();
						
					}
					
					System.out.println("hahaa:" + matrixDistanciaResponse.getRows().size());

			//conn.disconnect();
			long[][] adj = new long[matrixDistanciaResponse.getRows().size()][matrixDistanciaResponse.getRows().size()];

			int tamanho = matrixDistanciaResponse.getRows().size();
			for (int i = 0; i < tamanho; i++) {
				for (int j = 0; j < tamanho; j++) {
								adj[i][j] = matrixDistanciaResponse.getRows().get(i).getElements()[j].getDistance().getValue();

				}
			}

			System.out.println("inicio da matriz");
			for (int i = 0; i < tamanho; i++) {

				for (int j = 0; j < tamanho; j++) {

					System.out.println(adj[j][i]);
				}
				System.out.println("oiiii\n");
			}
			MenorCaminhoResponse objResposta = new MenorCaminhoResponse();
			objResposta.setIndex(encontrarMenorCaminho(adj, 0));
			objResposta.setEnderecos(matrixDistanciaResponse.getDestination_addresses());
			objResposta.setKm(total);
			return objResposta;

			
		} catch (IOException e) {
			// Logger.getLogger(APIRest.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}




	public int[] encontrarMenorCaminho(long adj[][], int origem) {
		int tamanho = adj.length;
		boolean visitados[] = new boolean[tamanho];
		int ordem[] = new int[tamanho];
		int proximoIndex = 0;

		for (int i = 0; i < tamanho; i++) {
			System.out.println("menor v�rtice do index" + i + ":" + proximoIndex);
			ordem[i] = proximoIndex;

			proximoIndex = encontrarVerticeMinimo(adj, visitados, proximoIndex);

		}
		System.out.println("o menor caminho final: " + total);
		return ordem;
	}

	long total = 0;

	public int encontrarVerticeMinimo(long adj[][], boolean visitados[], int indexColuna) {
		int max = adj.length;
		int indexMenorValor = 0;
		long menorValor = Long.MAX_VALUE;
		boolean passou = false;
		visitados[0]=true;

		for (int i = 0; i < max; i++) {
			if (!visitados[i] && (adj[i][indexColuna] <= menorValor) && (adj[i][indexColuna] != 0)) {
				
				System.out.println("QUANTO ESTA SENDO A COLUNA adj[i][indexColuna]");
				menorValor = adj[i][indexColuna];
				indexMenorValor = i;
				passou = true;
			}

		}
		if (passou) {
			System.out.println("MENOR VALOR" + menorValor);
			total = total + menorValor;
			System.out.println("TOTAL" + total);
			visitados[indexMenorValor] = true;
			
				System.out.println("VISITADOS");
			for (int i=0;i<visitados.length ;i++) {
				System.out.println(" "+ visitados[i] +" ");
			}
		}

		return indexMenorValor;
	}

}

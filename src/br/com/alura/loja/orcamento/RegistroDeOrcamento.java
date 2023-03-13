package br.com.alura.loja.orcamento;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.loja.DomainException;
import br.com.alura.loja.http.HttpAdapter;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {
        // chamada HTTP para a API externa
        // URL Connection
        //HTTP Cliente
        //lib Rest
        if(!orcamento.isFinalizado()) {
            throw new DomainException("Orcamento não finalizado");
        }

        String url = "http://api.external/orcamento";
        Map<String, Object> dados = new HashMap<>();
        dados.put("valor", orcamento.getValor());
        dados.put("quantidadeDeItens", orcamento.getQuantidadeItens());
        http.post(url, dados);
    }
}

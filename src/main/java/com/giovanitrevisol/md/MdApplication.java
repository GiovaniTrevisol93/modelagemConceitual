package com.giovanitrevisol.md;

import com.giovanitrevisol.md.domain.Categoria;
import com.giovanitrevisol.md.domain.Cidade;
import com.giovanitrevisol.md.domain.Cliente;
import com.giovanitrevisol.md.domain.Endereco;
import com.giovanitrevisol.md.domain.Estado;
import com.giovanitrevisol.md.domain.ItemPedido;
import com.giovanitrevisol.md.domain.Pagamento;
import com.giovanitrevisol.md.domain.PagamentoComBoleto;
import com.giovanitrevisol.md.domain.PagamentoComCartao;
import com.giovanitrevisol.md.domain.Pedido;
import com.giovanitrevisol.md.domain.Produto;
import com.giovanitrevisol.md.domain.enums.EstadoPagamento;
import com.giovanitrevisol.md.domain.enums.TipoCliente;
import com.giovanitrevisol.md.repositories.CategoriaRepository;
import com.giovanitrevisol.md.repositories.CidadeRepository;
import com.giovanitrevisol.md.repositories.ClienteRepository;
import com.giovanitrevisol.md.repositories.EstadoRepository;
import com.giovanitrevisol.md.repositories.ProdutoRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.giovanitrevisol.md.repositories.EnderecoRepository;
import com.giovanitrevisol.md.repositories.PagamentoRepository;
import com.giovanitrevisol.md.repositories.PedidoRepository;
import com.giovanitrevisol.md.repositories.itemPedidoRepository;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class MdApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagamentoRepository pagamentoRepository;
    @Autowired
    private itemPedidoRepository itemPedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "computador", 2000.00);
        Produto p2 = new Produto(null, "Impressora", 800.00);
        Produto p3 = new Produto(null, "mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlandia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria", "Maria@gmail.com", "11122233399", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("99999999", "5555555"));

        Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 110", "Jardin", "5515161", cli1, c1);
        Endereco e2 = new Endereco(null, "Av Matos", "100", "Ap 510", "Jardin", "5515161", cli1, c2);

        cli1.getEndereco().addAll(Arrays.asList(e1, e2));

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd,MM,yyyy hh:mm");
        System.out.println(sdf);

        // teste
        Date d = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        // teste acima

        Pedido ped1 = new Pedido(null, d, cli1, e1);
        Pedido ped2 = new Pedido(null, d, cli1, e2);

        Pagamento pagto1 = new PagamentoComCartao(6, null, EstadoPagamento.QUITADO, ped1);
        ped1.setPagamento(pagto1);

        Pagamento pagto2 = new PagamentoComBoleto(d, null, Integer.SIZE, EstadoPagamento.PENDENTE, ped2);
        ped2.setPagamento(pagto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
        pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

        ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
        ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
        ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

        ped1.getItens().addAll(Arrays.asList(ip1, ip2));
        ped2.getItens().addAll(Arrays.asList(ip3));

        p1.getItens().addAll(Arrays.asList(ip1));
        p2.getItens().addAll(Arrays.asList(ip3));
        p3.getItens().addAll(Arrays.asList(ip2));

        itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }

}

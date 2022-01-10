package com.github.lf2a.services;

import com.github.lf2a.domain.Cliente;
import com.github.lf2a.domain.ItemPedido;
import com.github.lf2a.domain.PagamentoComBoleto;
import com.github.lf2a.domain.Pedido;
import com.github.lf2a.domain.enums.EstadoPagamento;
import com.github.lf2a.repositories.ItemPedidoRepository;
import com.github.lf2a.repositories.PagamentoRepository;
import com.github.lf2a.repositories.PedidoRepository;
import com.github.lf2a.security.UserSS;
import com.github.lf2a.services.exceptions.AuthorizationException;
import com.github.lf2a.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <h1>PedidoService.java</h1>
 * ---
 *
 * @author Luiz Filipy
 * @version 1.0
 * @since 17/03/2021
 */
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private EmailService emailService;

    public Pedido find(Integer id) {
        return repo.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Objeto não encontrado! Id:" + id + ", Tipo:" + Pedido.class.getName());
        });
    }

    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            var pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setProduto(produtoService.find(ip.getProduto().getId()));
            ip.setPreco(ip.getProduto().getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        emailService.sendOrderConfirmationHtmlEmail(obj);
        return obj;
    }

    public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        UserSS user = UserService.authenticated();

        if (user == null) {
            throw new AuthorizationException("Acesso negado");
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Cliente cliente = clienteService.find(user.getId());

        return repo.findByCliente(cliente, pageRequest);
    }
}

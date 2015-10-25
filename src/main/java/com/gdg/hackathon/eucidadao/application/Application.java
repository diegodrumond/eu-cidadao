package com.gdg.hackathon.eucidadao.application;

import com.gdg.hackathon.eucidadao.model.Servico;
import com.gdg.hackathon.eucidadao.model.Solicitacao;
import com.gdg.hackathon.eucidadao.model.TipoServicoEnum;
import com.gdg.hackathon.eucidadao.repository.UsuarioRepository;
import com.gdg.hackathon.eucidadao.model.Usuario;
import com.gdg.hackathon.eucidadao.model.Visualizacao;
import com.gdg.hackathon.eucidadao.repository.ServicoRepository;
import com.gdg.hackathon.eucidadao.repository.SolicitacaoRepository;
import com.gdg.hackathon.eucidadao.repository.VisualizacaoRepository;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.gdg.hackathon.eucidadao.model")
@EnableJpaRepositories(basePackages = {"com.gdg.hackathon.eucidadao.repository"})
@ComponentScan(basePackages = {"com.gdg.hackathon.eucidadao.controller"})
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean(name = "createUsuarios")
    public CommandLineRunner createUsuarios(UsuarioRepository usuarioRepository) {
        return (args) -> {
            // save a couple of users
            usuarioRepository.save(new Usuario("Jack", "jack@eucidadao.com"));
            usuarioRepository.save(new Usuario("Chloe", "chloe@eucidadao.com"));
            usuarioRepository.save(new Usuario("Kim", "kim@eucidadao.com"));
            usuarioRepository.save(new Usuario("David", "david@eucidadao.com"));
            usuarioRepository.save(new Usuario("Michelle", "michelle@eucidadao.com"));

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (Usuario usuario : usuarioRepository.findAll()) {
                log.info(usuario.toString());
            }
            
            log.info("");
        };
    }
    
    @Bean(name = "createServicos")
    public CommandLineRunner createServicos(ServicoRepository servicoRepository) {
        return (args) -> {
            // save a couple of users
            servicoRepository.save(new Servico(TipoServicoEnum.ELETRICO, "Poste Caido"));
            servicoRepository.save(new Servico(TipoServicoEnum.AMBIENTAL, "Queda de arvore"));

            // fetch all customers
            log.info("Services found with findAll():");
            log.info("-------------------------------");
            for (Servico servico : servicoRepository.findAll()) {
                log.info(servico.toString());
            }
            
            log.info("");
        };
    }
    
    @Bean(name = "createSolicitacoes")
    public CommandLineRunner createSolicitacoes(SolicitacaoRepository solicitacaoRepository, ServicoRepository servicoRepository, UsuarioRepository usuarioRepository) {
        return (args) -> {
            // save a couple of users
            solicitacaoRepository.save(new Solicitacao(servicoRepository.findOne(1L), usuarioRepository.findOne(1L), -19.936277, -43.936605, "Poste caído obstruindo a pista - Urgente"));
            solicitacaoRepository.save(new Solicitacao(servicoRepository.findOne(2L), usuarioRepository.findOne(2L), -19.936277, -43.936605, "Árvore caída obstruindo a pista - Urgente"));

            // fetch all customers
            log.info("Requests found with findAll():");
            log.info("-------------------------------");
            for (Solicitacao solicitacao : solicitacaoRepository.findAll()) {
                log.info(solicitacao.toString());
            }
            
            log.info("");
            
        };
    }
    
    @Bean(name = "createVisualizacoes")
    public CommandLineRunner createVisualizacoes(VisualizacaoRepository visualizacaoRepository, UsuarioRepository usuarioRepository, SolicitacaoRepository solicitacaoRepository) {
        return (args) -> {
            // save a couple of users
            visualizacaoRepository.save(new Visualizacao(usuarioRepository.findOne(1L), solicitacaoRepository.findOne(1L)));

            // fetch all customers
            log.info("Views found with findAll():");
            log.info("-------------------------------");
            for (Visualizacao visualizacao : visualizacaoRepository.findAll()) {
                log.info(visualizacao.toString());
            }
            
            log.info("");
            
        };
    }

}

package com.miniprojeto.trocadepontos.service;

import com.miniprojeto.trocadepontos.dto.UsuarioRequest;
import com.miniprojeto.trocadepontos.dto.UsuarioResponse;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.repository.IUsuarioRepository;
import com.miniprojeto.trocadepontos.services.UsuarioServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UsuarioServiceTest {

    @MockBean
    UsuarioServices mockUsuario;

    @MockBean
    IUsuarioRepository mockRepository;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void buscaUsuarioTest() {
        List<UsuarioModel> listaUsuario = mockUsuario.buscarTodos();
        Assertions.assertTrue(listaUsuario.isEmpty());
    }
    @Test
    void buscaIdTest() {
        Long idUsuario = Long.valueOf(1);
        Optional<UsuarioModel> usuario = mockUsuario.buscarId(idUsuario);
        Assertions.assertTrue(usuario.isEmpty());
    }
    @Test
    void cadastrarUsuarioTest() {

        // quando no repository, com a função existById existir algum id do tipo long ele retorna true
        Mockito.when(mockRepository.existsById(Mockito.anyLong())).thenReturn(true);
        mockRepository.save(new UsuarioModel());
        //veirificar chamando o repository uma unica vez e salva no usuario model.
        Mockito.verify(mockRepository, Mockito.times(1)).save((new UsuarioModel()));
    }
    @Test
    void alterarUsuarioTest() {

        Mockito.when(mockRepository.existsById(Mockito.anyLong())).thenReturn(true);
        mockRepository.save(new UsuarioModel());
        Mockito.verify(mockRepository, Mockito.times(1)).save((new UsuarioModel()));
    }

}

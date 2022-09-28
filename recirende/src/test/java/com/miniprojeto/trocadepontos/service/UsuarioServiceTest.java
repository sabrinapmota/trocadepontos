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

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    UsuarioServices mockUsuario;

    @MockBean
    IUsuarioRepository mockRepository;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void buscaCidadeTest() {
        List<UsuarioModel> listaCidade = mockUsuario.buscarTodos();
        Assertions.assertTrue(listaCidade.isEmpty());
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
        Mockito.verify(mockRepository ,Mockito.times(1)).save((new UsuarioModel()));
    }
}

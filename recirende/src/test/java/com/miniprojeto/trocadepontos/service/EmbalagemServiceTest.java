package com.miniprojeto.trocadepontos.service;

import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.repository.IEmbalagemRepository;
import com.miniprojeto.trocadepontos.services.EmbalagemService;
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
public class EmbalagemServiceTest {

    @Mock
    EmbalagemService mockEmbalagem;

    @MockBean
    IEmbalagemRepository mockRepository;

    @BeforeEach
    private void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void buscaEmbalagemTest() {
        List<EmbalagemModel> listaEmbalagens = mockEmbalagem.mostrarEmbalagens();
        Assertions.assertTrue(listaEmbalagens.isEmpty());
    }

    @Test
    void buscaIdTest() {
        Long idEmbalagem = Long.valueOf(1);
        Optional<EmbalagemModel> embalagem  = mockEmbalagem.buscarId(idEmbalagem);
        Assertions.assertTrue(embalagem.isEmpty());
    }

    @Test
    void cadastrarEmbalagemTest() {

        Mockito.when(mockRepository.existsById(Mockito.anyLong())).thenReturn(true);
        mockRepository.save(new EmbalagemModel());
        Mockito.verify(mockRepository ,Mockito.times(1)).save(new EmbalagemModel());
    }

    @Test
    void alterarEmbalagemTest() {

        Mockito.when(mockRepository.existsById(Mockito.anyLong())).thenReturn(true);
        mockRepository.save(new EmbalagemModel());
        Mockito.verify(mockRepository ,Mockito.times(1)).save(new EmbalagemModel());
    }
}

package com.miniprojeto.trocadepontos.controller;

import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.services.EmbalagemService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class EmbalagemControllerTest {

    @Autowired
    private EmbalagemController embalagemController;

    @MockBean
    private EmbalagemService embalagemService;

    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.standaloneSetup(this.embalagemController);
    }

    @Test
    public void buscarEmbalagemIdTest() {

        UsuarioModel usuarioModel = new UsuarioModel();
        EmbalagemModel embalagemModel = new EmbalagemModel(1L, "Doritos", 123456 , LocalDate.now(), BigDecimal.valueOf(10.00),usuarioModel);

        when(this.embalagemService.buscarId(1L))
                .thenReturn(Optional.of(embalagemModel));

        RestAssuredMockMvc
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/embalagens/{idEmbalagem}",1L)
                .then()
                    .statusCode(HttpStatus.OK.value());
    }

}

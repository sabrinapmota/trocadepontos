package com.miniprojeto.trocadepontos.controller;

import com.miniprojeto.trocadepontos.model.EmbalagemModel;
import com.miniprojeto.trocadepontos.model.UsuarioModel;
import com.miniprojeto.trocadepontos.services.EmbalagemService;
import com.miniprojeto.trocadepontos.services.UsuarioServices;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioControllerTest {

    @Autowired
    private UsuarioController usuarioController;

    @MockBean
    private UsuarioServices usuarioServices;

    @BeforeEach
    public void setUp(){
        RestAssuredMockMvc.standaloneSetup(this.usuarioController);
    }

    @Test
    void buscarUsuarioTest() {
        List<UsuarioModel> lista = new ArrayList<>();

        when(this.usuarioServices.buscarTodos())
                .thenReturn(lista);

        RestAssuredMockMvc
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/usuarios")
                .then()
                    .statusCode(HttpStatus.OK.value());
    }

    @Test
    void buscarUserIdTest() {
        UsuarioModel usuarioModel = new UsuarioModel();

        when(this.usuarioServices.buscarId(1L))
                .thenReturn(Optional.of(usuarioModel));

        RestAssuredMockMvc
                .given()
                    .accept(ContentType.JSON)
                .when()
                    .get("/usuarios/{idUsuario}",1L)
                .then()
                    .statusCode(HttpStatus.OK.value());
    }
}
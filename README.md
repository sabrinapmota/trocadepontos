mini projeto Recirend

	Esse projeto visa incentivar a coleta de embalagens de salgadinhos para reciclagem através de uma API onde o usuário obtêm pontuação a cada embalagem registrada. Esses pontos obtidos, poderão ser trocados por : Descontos, benefícios ou produtos.
Para realizar o cadastro o usuário deve informar os dados requisitados: Nome, CPF, e-mail, endereço, estado.
Depois do cadastro concluído, ele deverá cadastrar a embalagem inserindo o número de série que consta atrás da embalagem e a marca do mesmo. Cada embalagem cadastrada recebe 1500 pontos.
Com estes pontos acumulados, o usuário poderá solicitar a troca por: Ingressos de cinema, descontos de 50 reais ou um celular.
 (produtos fictícios)
Ingressos de cinema = 5000 pontos.
Desconto de 50 R$= 6000.
Celular = 20000 pontos.
Para realizar o cadastro do usuário, execute a seguinte requisição Json:

{
    "cpf": "168.157.240-00",
    "email": "charles@gmail.com",
    "endereco": "Rua S Q90 Bairro Três",
    "estado": "Rio de Janeiro",
    "nome": "carlos savio"
}
O retorno dessa requisição será:

{
    "id": 2,
    "nome": "carlos savio",
    "pontuacao": 0
}

Para realizar o cadastro da embalagem execute a seguinte requisição Json:
{
"nomeMarca":"Chilitos@",
    "numeroSerie": 12345,
    "usuario":{
        "idUsuario":2
    }

O retorno dessa requisição será:

{
    "idEmbalagem": 4,
    "nomeMarca": "xzPipos",
    "numeroSerie": 12345,
    "dataCadastro": "2022-09-28",
    "pontoEmbalagem": 1500,
    "usuario": {
        "idUsuario": 2,
        "nome": null,
        "email": null,
        "endereco": null,
        "estado": null,
        "pontuacao": null,
        "troca": null,
        "embalagemModels": null
    }

Para efetuar a troca de pontos realize a seguinte requisição Json através do método patch:
Exemplo de troca de pontos por ingresso de cinema:
{
"idUsuario":4,
"troca":"INGRESSO_CINEMA"
}
 
O retorno dessa requisição será:

{
    "idUsuario": 1,
    "nome": "carlos savio",
    "email": "crispim@gmail.com",
    "endereco": "Rua S Q90 Bairro Três",
    "estado": "Rio de Janeiro",
    "pontuacao": 2500.00,
    "troca": "INGRESSO_CINEMA",
    "embalagemModels": [
        {
            "idEmbalagem": 1,
            "nomeMarca": "vzPipos",
            "numeroSerie": 123,
            "dataCadastro": "2022-09-28",
            "pontoEmbalagem": 1500.00,
            "usuario": 1
        },
        {
            "idEmbalagem": 2,
            "nomeMarca": "vzPipos",
            "numeroSerie": 123,
            "dataCadastro": "2022-09-28",
            "pontoEmbalagem": 1500.00,
            "usuario": 1
        }
    ]
}



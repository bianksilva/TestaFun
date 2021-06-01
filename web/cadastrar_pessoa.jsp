<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/249b1afbd0.js" crossorigin="anonymous"></script>

        <title>Cadastrar Pessoa</title>
    </head>
    <body>
        <div class=" container ">
            <form action="PessoaController" method="POST">
                <fieldset>
                    <legend><h3>CADASTRO DE PESSOA ${pessoa.nome} </h3></legend>
                    <div class="form-horizontal col">
                        <input type="hidden" name="cod" value="${pessoa.cod}">

                        <div class="row">
                            <div class="col-6">
                                <label for="nome">Nome Completo</label>
                                <input type="text" name="nome" value="${pessoa.nome}" class="form-control" id="nome" >
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-3">
                                <label for="nome">CPF</label>
                                <input type="text" name="cpf" value="${pessoa.cpf}" class="form-control" id="cpf" >
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-3">
                                <label  for="nascimento">Nascimento</label>
                                <input type="date" name="nascimento" value="${pessoa.nascimento}" class="form-control">
                            </div>
                        </div>

                </fieldset> <br>
                <div class="botoes col">
                    <button type="submit" value="gravar" class="btn btn-success col-md-2" >Cadastrar</button>
                    
                    <a class="btn btn-danger col-md-2" href="index.jsp" >Voltar</a>
                </div>
            </form>
        </div>
    </body>
    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pessoa" %>
<%@page import="persistencia.PessoaDAO" %>
<%@page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/249b1afbd0.js" crossorigin="anonymous"></script>

        <script>
            function confirmarExclusao(cod) {
                if (confirm('Deseja realmente excluir esta pessoa?')) {
                    location.href = "./PessoaController?acao=excluir&cod=" + cod;
                }
            }
        </script> 

        <title>Testa Funcionalidade</title>
    </head>
    <body>

        <div align="center"><h3></h3></div>

        <table class="table table-bordered">
            <tr> 
                <th> Código </th> <!-- Coluna -->
                <th> Nome </th> 
                <th> CPF </th>
                <th> Data de Nascimento </th>
                <th> Opções </th>
            </tr>

            <jsp:useBean id="dao" class="persistencia.PessoaDAO"/>
            <c:forEach  var="pessoa" items="${dao.listar_Pessoa}">
                <tr>
                    <td>${pessoa.cod}</td>  <!-- linha por coluna -->
                    <td>${pessoa.nome}</td>
                    <td>${pessoa.cpf}</td>
                    <td>${pessoa.nascimento}</td>
                    <td>
                        <a id="al" style="text-decoration: none;color:yellowgreen; margin-right: 5px;"  text-align="center" class="op" href="./PessoaController?acao=alterar&cod=${pessoa.cod}"><i class="fa fa-edit fa-lg"></i></a>
                        <a id="ex" style="text-decoration: none; color:red; margin-right: 5px;" text-align="center" classe="op"href="javascript:confirmarExclusao(${pessoa.cod});"><i class="fa fa-trash fa-lg"></i></a> 
                        <a class="op" style="text-decoration: none; color:blue;" href="./PessoaController?acao=exibir&cod=${pessoa.cod}"><i class="fa fa-eye fa-lg"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a class="btn btn-info" href="cadastrar_pessoa.jsp"> Cadastrar Pessoa </a>
    </body>
    <!-- JavaScript (Opcional) -->
    <!-- jQuery primeiro, depois Popper.js, depois Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</html>


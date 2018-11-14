<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: hadji
  Date: 19/03/2018
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Public-Library - Biblioteque municipale de la ville | Liste des livres disponible </title>

    <!-- Standard Meta -->

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link href='//fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

    <!-- Stylesheets -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ"
          crossorigin="anonymous">

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
        @media(min-width: 768px) {
            .field-label-responsive {
                padding-top: .5rem;
                text-align: right;
            }
        }

        .welcome {
            background-color:#DDFFDD;
            border:1px solid #009900;
            width:500px;
        }
        .welcome li{
            list-style: none;
        }


    </style>

</head>
<body>

<!-- Menu bar -->
<div class="btm_border">
    <div class="h_bg">
        <div class="wrap">
            <div class="header">
                <div class="logo">
                    <h1><a href="<s:url namespace="/" action="home"/>"><img src="images/logo.png"></a></h1>
                </div>
                <div class="clear"></div>
            </div>

            <div class='h_btm'>
                <div class='cssmenu'>
                    <ul>
                        <li class='has-sub'><a href="<s:url namespace="/" action="home"/>"><span>Acceuil</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/" action="signUp"/>"><span>S'inscrire</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="bookList"/>"><span>Consulter Livres</span></a></li>
                        <li class='last'><a href="<s:url namespace="/" action="contact"/>"><span>Contact</span></a></li>
                    </ul>
                </div>

                <div class="search">
                    <s:form action="search" namespace="/membre">

                        <div class="input-group">
                            <input type="text" name="jspName" class="form-control" placeholder="Search for..."/>
                            <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="submit">Allez!</button>
                                </span>
                        </div>

                    </s:form>
                </div>

                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <s:if test="%{bookName!=null && bookName.size()!=0}">
        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th style="width:20%;">Titre</th>
                <th style="width:20%;">Auteur</th>
                <th style="width:20%;">Maison d'edition</th>
                <th style="width:20%;">Année d'edition</th>
                <th style="width:20%;">Disponibilité</th>
                <th style="width:20%;">Action</th>


            </tr>
            </thead>
            <tbody>
            <s:iterator value="bookName">
                <tr>
                    <td><s:property value="title"/></td>
                    <td><s:property value="author.firstName"/> <s:property value="author.lastName"/></td>
                    <td><s:property value="editor.name"/></td>
                    <td><s:property value="year"/></td>
                    <s:if test="%{nbOfCopy>0}">
                        <td>Disponible</td>
                    </s:if>
                    <s:else>
                        <s:url var="url" action="resaBook" namespace="/membre">
                            <s:param name="ISBN"><s:property value="ISBN"/></s:param>
                        </s:url>
                        <td>Non disponible.</td>
                        <td><a href="${url}">Reserver</a></td>
                    </s:else>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <s:if test="hasActionMessages()">
            <div class="welcome">
                <s:actionmessage/>
            </div>
        </s:if>

    </s:if>

    <s:if test="%{authorName!=null && authorName.size()!=0}">
        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>Prenom de l'auteur</th>
                <th>Nom de l'auteur</th>
                <th>Nombre de livres ecrits</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="authorName">
                <tr>
                    <td><s:property value="firstName"/></td>
                    <td><s:property value="lastName"/></td>
                    <td><s:property value="NbOfBooks"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </s:if>

    <s:if test="hasActionMessages()">
        <div class="welcome">
            <s:actionmessage/>
        </div>
    </s:if>



</div>


<!--footer1-->
<div class="footer fixed-bottom">
    <div class="copy">
        <p class="w3-link">© 2018 Public-Library. All Rights Reserved | Design by Ben Hadji</p>
    </div>
    <div class="clear"></div>
</div>


</body>
</html>

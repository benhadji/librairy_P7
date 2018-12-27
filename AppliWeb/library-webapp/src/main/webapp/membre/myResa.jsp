<%--
  Created by IntelliJ IDEA.
  User: hadji
  Date: 19/03/2018
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Public-Library - Biblioteque municipale de la ville | Acceuil </title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link href='//fonts.googleapis.com/css?family=Quattrocento+Sans' rel='stylesheet' type='text/css'>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!--slider-->
    <link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
    <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
    <script type="text/javascript">
        $(window).load(function() {
            $('#slider').nivoSlider();
        });
    </script>


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
                    <h1><a href="<s:url namespace="/membre" action="home"/>"><img src="images/logo.png"></a></h1>
                </div>
                <div class="clear"></div>
            </div>

            <div class='h_btm'>
                <div class='cssmenu'>
                    <ul>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="home"/>"><span>Acceuil</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="myBorrows"/>"><span>Mes emprunts</span></a></li>
                        <li class='active'><a href="<s:url namespace="/membre" action="myResa"/>"><span>Mes Reservations</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="bookList"/>"><span>Consulter Livres</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="logout"/>"><span>Se deconnecter</span></a></li>
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
    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th style="width:20%;">Livres emprunté</th>
            <th style="width:20%;">Date de reservation</th>
            <th style="width:20%;">Prochain retour</th>
            <th style="width:20%;">Position dans la liste d'attente</th>
            <th style="width:20%;">Action</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="reservationList">
            <tr>
                <td><s:property value="book.title"/></td>
                <td><s:property value="reservationDate.toGregorianCalendar().getTime()"/></td>
                <td><s:property value="closest.toGregorianCalendar().getTime()"/></td>
                <td><s:property value="position"/></td>
                <s:url var="url" action="deleteResa" namespace="/membre">
                    <s:param name="id"><s:property value="id"/></s:param>
                </s:url>
                <td><a href="${url}">Annuler</a></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

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

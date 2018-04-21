<%--
  Created by IntelliJ IDEA.
  User: hadji
  Date: 16/03/2018
  Time: 16:31
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
                        <li class='active'><a href="<s:url namespace="/membre" action="home"/>"><span>Acceuil</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="myAccount"/>"><span>Mon Compte</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/" action="bookList"/>"><span>Consulter Livres</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="logout"/>"><span>Se deconnecter</span></a></li>

                    </ul>
                </div>

                <div class="search">
                    <s:form action="search" namespace="/">

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


<!-- Contenu web -->

<!------ Slider_bg ------------>
<div class="slider_bg">
    <div class="wrap">
        <!------ Slider------------>
        <div class="slider">
            <div class="slider-wrapper theme-default">
                <div id="slider" class="nivoSlider">
                    <img src="images/banner1.jpg" data-thumb="images/1.jpg" alt="" />
                    <img src="images/banner2.jpg" data-thumb="images/2.jpg" alt="" />
                    <img src="images/banner3.jpg" data-thumb="images/3.jpg" alt="" />
                </div>
            </div>
        </div>
        <!------End Slider ------------>
        <div class="grids_1_of_3">
            <div class="grid_1_of_3 images_1_of_3">
                <img src="images/icon1.jpg">
                <h3>Evenements</h3>
                <p>Venez decouvrir nos derniers evenements et ateliers qui ont lieu pour (re)decrouvrir le plaisir de lire</p>
            </div>
            <div class="grid_1_of_3 images_1_of_3">
                <s:if test="%{#session.sessionUserAccount!=null}">
                    <h3>Bonjour <s:property value="#session.sessionUtilisateur.prenom"/>, vous etes deja connecté !</h3>
                </s:if>
            </div>
            <div class="grid_1_of_3 images_1_of_3">
                <img src="images/icon3.jpg">
                <h3>Mes prets en cours</h3>
                <p>Retrouvez dans votre espace personnel la liste de vos prets en cours, avec la date de retour pour ne pas oublier. Vous avez la possibilité d'etendre vos prets, si vous le souhaitez</p>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>


<!--main-->
<div class="main_bg">

    <!--footer-->
    <div class="footer-bg">
        <div class="wrap">
            <div class="footer">
                <div class="box1">
                    <h4 class="btm">Histoire</h4>
                    <p>La première pierre de la biblioteque a été posée le 19 juin 2010. La création a été rendue possible à la suite du départ d'usines, à la fin des années 1990. Lors de la signature de l’accord, il était prévu de réserver un espace, pour un équipement public, qui a pris la forme, d’une médiathèque.</p>
                    <p>Il a fallu débuter par des forages, afin notamment de pouvoir utiliser la géothermie pour chauffer le bâtiment. Les travaux ont débuté fin 2009, et se sont terminés en septembre 2011. L’inauguration officielle a eu lieu le 30 novembre 2012, pour une ouverture au public le 5 décembre 2012.</p>
                </div>

                <div class="box1">
                    <h4 class="btm">Horaires d'ouverture</h4>
                    <p>Mardi, Jeudi et Vendredi : 12h - 19h</p>
                    <p>Mercredi et Samedi : 10h - 19h</p>
                    <p>Dimanche, Lundi : Fermé</p>
                </div>


                <div class="box1">
                    <h4 class="btm">Situez nous</h4>
                    <div class="box1_address">
                        <p>7, Rue du Paradis</p>
                        <p>75010 Paris</p>
                        <p>Phone: +33 1 23 45 67 89 </p>
                        <p>Fax: +33 1 98 76 54 32</p>
                        <p>Email: <a href="mailto:hadjiben@gmail.com">hadjiben@gmail.com</a></p>
                        <p>Follow on: <a href="https://www.facebook.com/openclassroomsfr/?brand_redir=154457951791730">Facebook</a>, <a href="https://twitter.com/openclassrooms">Twitter</a></p>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <!--footer1-->
    <div class="ftr-bg">
        <div class="wrap">
            <div class="footer">
                <div class="copy">
                    <p class="w3-link">© 2018 Public-Library. All Rights Reserved | Design by Ben Hadji</p>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>
</div>


</body>
</html>

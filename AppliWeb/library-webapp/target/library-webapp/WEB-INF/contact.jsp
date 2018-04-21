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
                    <h1><a href="<s:url namespace="/" action="home"/>"><img src="images/logo.png"></a></h1>
                </div>
                <div class="clear"></div>
            </div>

            <div class='h_btm'>
                <div class='cssmenu'>
                    <ul>
                        <li class='has-sub'><a href="<s:url namespace="/" action="home"/>"><span>Acceuil</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/" action="signUp"/>"><span>S'inscrire</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/" action="bookList"/>"><span>Consulter Livres</span></a></li>
                        <li class='active'><a href="<s:url namespace="/" action="contact"/>"><span>Contact</span></a></li>
                    </ul>
                </div>

                <div class="search">
                    <s:form action="search" namespace="/">

                        <div class="input-group">
                            <input type="text" name="nom" class="form-control" placeholder="Search for..."/>
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

<!--main-->
<div class="main_btm">
    <div class="wrap">
        <div class="main">
            <div class="contact">
                <div class="section group">
                    <div class="col span_1_of_2">
                        <div class="contact_info">
                            <h2>Nous sommes ici !</h2>
                            <div class="map">
                                <iframe width="600" height="450" frameborder="0" style="border:0" src="https://www.google.com/maps/embed/v1/place?q=OpenClassrooms%2C%20Cit%C3%A9%20Paradis%2C%20Paris%2C%20France&key=AIzaSyDdC0PvfN0ameQg52cEA6ys35Hg9TgskkI" allowfullscreen></iframe><br>
                            </div>
                        </div>
                        <div class="company_address">
                            <h2>Public Library</h2>
                            <p>7, rue du Paradis</p>
                            <p>75010 Paris</p>
                            <p>Phone:+33 1 80 88 80 30</p>
                            <p>Follow on: <a href="https://www.facebook.com/openclassroomsfr/?brand_redir=154457951791730">Facebook</a>, <a href="https://twitter.com/ocfrance">Twitter</a></p>

                        </div>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
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


</body>
</html>



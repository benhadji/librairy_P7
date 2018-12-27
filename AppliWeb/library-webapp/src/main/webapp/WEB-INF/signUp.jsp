<%--
  Created by IntelliJ IDEA.
  User: hadji
  Date: 12/03/2018
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>

    <title>Public-Library - Biblioteque municipale de la ville | Nouveau membre </title>

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
                        <li class='has-hub'><a href="<s:url namespace="/" action="home"/>"><span>Acceuil</span></a></li>
                        <li class='active'><a href="<s:url namespace="/" action="signUp"/>"><span>S'inscrire</span></a></li>
                        <li class='has-sub'><a href="<s:url namespace="/membre" action="bookList"/>"><span>Consulter Livres</span></a></li>
                        <li class='last'><a href="<s:url namespace="/" action="contact"/>"><span>Contact</span></a></li>
                    </ul>
                </div>

                <div class="search">
                    <s:form action="search" namespace="/membre">

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

<div class="container">
    <s:form class="form-horizontal" role="form" method="POST" action="signUp">
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6 text-center">
                <h2>Nouvel utilisateur</h2>
                <hr>
            </div>
        </div>

        <!-- Prenom -->

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="firstName">Prenom</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <s:textfield name="userAccount.firstName" class="form-control" id="firstName"
                               placeholder="Victor" required="true" autofocus="true"/>
                    </div>
                </div>
            </div>
        </div>

        <!-- Nom -->

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="lastName">Nom</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <s:textfield name="userAccount.lastName" class="form-control" id="lastName"
                               placeholder="Hugo" required="true"/>
                    </div>
                </div>
            </div>
        </div>

        <!-- Adresse -->

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="Adresse">Adresse</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <s:textfield name="userAccount.address" class="form-control" id="Adresse"
                               placeholder="1 bis, rue verte" required="true" />
                    </div>
                </div>
            </div>
        </div>

        <!-- City -->

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="City">Ville</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <s:textfield name="userAccount.city" class="form-control" id="City"
                               placeholder="Paris" required="true"/>
                    </div>
                </div>
            </div>
        </div>

        <!-- Postcode -->

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="postCode">Code postal</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <s:textfield name="userAccount.postCode" class="form-control" id="postCode"
                               placeholder="75016" required="true"/>
                    </div>
                </div>
            </div>
        </div>

        <!-- phoneNumber -->

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="phoneNumber">Telephone</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-user"></i></div>
                        <s:textfield name="userAccount.phoneNumber" class="form-control" id="phoneNumber"
                               placeholder="0612345678" required="true" />
                    </div>
                </div>
            </div>
        </div>

        <!-- Email -->

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="email">E-Mail Address</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-at"></i></div>
                        <s:textfield type="text" name="userAccount.email" class="form-control" id="email"
                               placeholder="you@example.com" required="true"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="password">Password</label>
            </div>
            <div class="col-md-6">
                <div class="form-group has-danger">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem"><i class="fa fa-key"></i></div>
                        <s:password type="password" name="userAccount.password" class="form-control" id="password"
                               placeholder="Password"  data-minlength="6"
                               data-error="Le mot de passe doit faire au minimum 6 caractères" required="true"/>
                    </div>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-md-3 field-label-responsive">
                <label for="password">Confirmez Mot de Passe</label>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                        <div class="input-group-addon" style="width: 2.6rem">
                            <i class="fa fa-repeat"></i>
                        </div>
                        <input type="password" name="passwordConfirmation" class="form-control"
                               data-match="#password" id="password-confirm" placeholder="Password"
                               data-error="Les deux mots de passes sont différents" required>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                <button type="submit" class="btn btn-success"><i class="fa fa-user-plus"></i>Valider</button><br><br>
            </div>
        </div>
    </s:form>
</div>

<s:if test="hasActionMessages()">
    <div class="welcome">
        <s:actionmessage/>
    </div>
</s:if>
<div class="text-center">
    <a href="<s:url namespace="/" action="home"/>"  class="btn btn-lg btn-primary">Retour Acceuil</a>
</div>


<!--footer1-->
<div class="footer">
    <div class="copy">
        <p class="w3-link">© 2018 Public-Library. All Rights Reserved | Design by Ben Hadji</p>
    </div>
    <div class="clear"></div>
</div>


<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>




</body>
</html>

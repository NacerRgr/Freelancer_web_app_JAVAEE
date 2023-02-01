<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

/* j'ai fait un CSS basique, le but étant de montrer la technique pour colorer le fond de l'étoile 1 si on est sur la 1ère étoile, les étoiles 1 et 2 si on est sur la 2ème étoile, etc */
.C2etoiles{
    background: red;
    display: inline-block;
    cursor: pointer;
}
.C2etoiles:hover{
    background: green;
}
.C2etoiles div{
    display: inline-block;
    padding: 5px;
}
.C2etoiles div::after{
    content:"\002605"; /* une étoile en Unicode */
}
</style>
</head>
<body>
<span class="C2etoiles"><div></div>
    
    <span class="C2etoiles"><div></div>
        
        <span class="C2etoiles"><div></div>
            
            <span class="C2etoiles"><div></div>
                
                <span class="C2etoiles"><div></div> <!-- les div ici permettent l'affichage de l'étoile via la propriété "content", avec le sélecteur ".C2etoiles div::after" -->
                </span>
            </span>
        </span>
    </span>
</span>
</body>
</html>
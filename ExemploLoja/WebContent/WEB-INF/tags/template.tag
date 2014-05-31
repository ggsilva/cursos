<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@attribute name="title" fragment="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="/ExemploLoja/css/Site.css" />
		<title><jsp:invoke fragment="title"></jsp:invoke></title>
	</head>
	<body>
		<header>
			<div class="content-wrapper">
				<div class="float-left">
					<p class="site-title"><a href="/ExemploLoja/" >TreinaWeb Loja</a></p>
				</div>
				<div class="float-right">
					<nav>
						<ul id="menu">
							<li><a href="/ExemploLoja/">Home</a></li>
							<li><a href="/ExemploLoja/Produto">Produtos</a></li>
							<li><a href="/ExemploLoja/Categoria">Categorias</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<div id="body">
			<section class="content-wrapper main-content clear-fix">
				<jsp:doBody/>
			</section>
		</div>
		<footer>
			<div class="content-wrapper">
				<div class="float-left">
					<p>&copy; Treinaweb Cursos</p>
				</div>
			</div>
		</footer>
	</body>
</html>

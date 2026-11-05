<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Bricolage+Grotesque:wght@600;800&family=IBM+Plex+Sans:wght@400;600&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/estilos.css">
<title>Taller de celulares | Mi reparación</title>
</head>
<body>
	<header class="barra">
		<div>
			<strong>Taller de celulares</strong>
			<nav>
				<a href="index.html">Nueva consulta</a><a href="consultar.html"
					aria-current="page">Ver mi reparación</a>
			</nav>
		</div>
	</header>
	<main>
		<h1 data-entrada>Estado de tu reparación</h1>
		<section class="panel" data-entrada>
			<form id="form-buscar" action="SvListarConsulta" method="get">
				<label for="telefono">Teléfono con el que te registraste</label> <input
					id="telefono" name="telefono" type="tel" inputmode="tel"
					maxlength="25" required>

				<button class="boton" type="submit">Buscar</button>
			</form>
		</section>


		<c:forEach var="c" items="${consulta}">
			<article class="panel">
				<div class="consulta-cabecera">
					<h2><c:out value="${c.modelo_Celular}"/></h2>
					<span class="estado pendiente"><c:out value="${c.estado}"/></span>
				</div>
				<dl class="datos">
					<div>
						<dt>Fecha de registro</dt>
						<dd><c:out value="${c.fecha_registro}"/></dd>
					</div>
					<div>
						<dt>Problema que informaste</dt>
						<dd><c:out value="${c.descripcion_Problema}"/></dd>
					</div>
				</dl>
				<div class="candado">
					<svg width="28" height="28" viewBox="0 0 24 24" fill="none"
						stroke="#9A6A00" stroke-width="2" aria-hidden="true">
					<rect x="5" y="11" width="14" height="10" rx="2" />
					<path d="M8 11V7a4 4 0 0 1 8 0v4" /></svg>
					<p style="margin: 0">Para saber a detalle preséntese
						presencialmente en nuestro local con el equipo.</p>
				</div>
				<div class="acciones">
					<form action="eliminar-consulta" method="post">
						<input type="hidden" name="id_consulta" value="1">
						<!-- ${c.ID_Consulta} -->
						<button class="boton peligro" type="submit">Eliminar
							consulta</button>
					</form>
				</div>
			</article>
		</c:forEach>
		<p class="vacio" hidden>
			No encontramos consultas con ese teléfono. Revisá el número o <a
				href="index.html">creá una nueva consulta</a>.
		</p>
	</main>
	<script src="js/animaciones.js"></script>
</body>
</html>
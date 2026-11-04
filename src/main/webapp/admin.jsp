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
<title>Panel técnico | Taller de celulares</title>
</head>
<body>
	<header class="barra">
		<div>
			<strong>Panel técnico</strong>
			<nav>
				<a href="admin.html" aria-current="page">Consultas</a>
			</nav>
		</div>
	</header>
	<main>
		<h1 data-entrada>Consultas recibidas</h1>

		<section class="panel tabla-scroll" data-entrada>
			<table>
				<thead>
					<tr>
						<th>Fecha</th>
						<th>Cliente</th>
						<th>Teléfono</th>
						<th>Modelo</th>
						<th>Estado</th>
						<th>Detalle visible</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>03/11/2026</td>
						<td>Lucía Gómez</td>
						<td>11-5555-1234</td>
						<td>Samsung Galaxy A32</td>
						<td><span class="estado pendiente">Pendiente</span></td>
						<td>No</td>
						<td><a href="admin.html?id=1#diagnostico">Revisar</a></td>
					</tr>
					<tr>
						<td>28/10/2026</td>
						<td>Martín Pérez</td>
						<td>011-4444-9876</td>
						<td>iPhone 12</td>
						<td><span class="estado listo">Listo para retirar</span></td>
						<td>Sí</td>
						<td><a href="admin.html?id=2#diagnostico">Revisar</a></td>
					</tr>
				</tbody>
			</table>
		</section>

		<section class="panel" id="diagnostico">
			<form id="form-diagnostico" action="actualizar-consulta"
				method="post">
				<input type="hidden" name="id_consulta" value="1">
				<h2>Diagnóstico: Samsung Galaxy A32</h2>
				<p>Problema informado: La pantalla quedó negra después de una
					caída</p>

				<div class="fila-form">
					<div>
						<label for="estado">Estado de la reparación</label> <select
							id="estado" name="estado">
							<option>Pendiente</option>
							<option>En revisión</option>
							<option>En reparación</option>
							<option>Listo para retirar</option>
							<option>Entregado</option>
						</select>
					</div>

					<div>
						<label for="costo">Costo ($)</label> <input id="costo"
							name="costo" type="number" min="0" step="0.01">
					</div>

					<div>
						<label for="tiempo_estimado">Tiempo estimado de entrega</label> <input
							id="tiempo_estimado" name="tiempo_estimado" type="text"
							maxlength="50" placeholder="Ej.: 3 días">
					</div>

					<div>
						<label for="repuestos">Repuestos utilizados</label> <input
							id="repuestos" name="repuestos" type="text" maxlength="200">
					</div>

					<div class="ancho">
						<label for="diagnostico_real">Problema real encontrado</label>
						<textarea id="diagnostico_real" name="diagnostico_real"
							maxlength="500"></textarea>
					</div>
				</div>

				<div class="interruptor">
					<input type="checkbox" id="mostrar_detalle" name="mostrar_detalle"
						value="true"> <span class="pista" aria-hidden="true"></span>
					<svg class="icono-candado" width="26" height="26"
						viewBox="0 0 24 24" fill="none" stroke="currentColor"
						stroke-width="2" aria-hidden="true">
						<rect x="5" y="11" width="14" height="10" rx="2" />
						<path class="arco" d="M8 11V7a4 4 0 0 1 8 0v4" /></svg>
					<label for="mostrar_detalle"><strong>Mostrar
							detalle al cliente</strong><br> <span id="texto-candado"
						class="ayuda"></span></label>
				</div>

				<div class="acciones">
					<button class="boton" type="submit">Guardar cambios</button>
					<a class="boton secundario" href="admin.html">Cancelar</a>
				</div>
			</form>
		</section>
	</main>
	<script src="js/animaciones.js"></script>
</body>
</html>
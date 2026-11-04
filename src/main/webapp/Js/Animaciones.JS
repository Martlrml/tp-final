// Solo efectos visuales. Sin validaciones ni lógica de negocio.
(function () {
  "use strict";

  const reducir = window.matchMedia("(prefers-reduced-motion: reduce)").matches;
  document.documentElement.classList.add("js");

  // 1. Entrada de la página: los elementos con data-entrada aparecen escalonados
  document.querySelectorAll("[data-entrada]").forEach(function (el, i) {
    el.style.setProperty("--retardo", Math.min(i, 6) * 0.09 + "s");
    requestAnimationFrame(function () { el.classList.add("visible"); });
  });

  // 2. Efectos que se activan al llegar a la zona visible de la pantalla
  function revelar(el) {
    if (el.matches(".detalle-abierto")) el.classList.add("abierto");

    if (el.matches(".candado")) {
      setTimeout(function () { el.classList.add("sacudir"); }, reducir ? 0 : 500);
    }

    if (el.matches(".progreso")) {
      const paso = parseInt(el.dataset.paso, 10) || 1;
      Array.prototype.slice.call(el.children, 0, paso).forEach(function (li, i) {
        setTimeout(function () {
          li.classList.add("hecho");
          if (i === paso - 1) li.classList.add("actual");
        }, reducir ? 0 : 400 + i * 260);
      });
    }
  }

  const observador = new IntersectionObserver(function (entradas) {
    entradas.forEach(function (e) {
      if (!e.isIntersecting) return;
      observador.unobserve(e.target);
      revelar(e.target);
    });
  }, { threshold: 0.35 });

  document.querySelectorAll(".detalle-abierto, .progreso, .candado")
    .forEach(function (el) { observador.observe(el); });

  // 3. El candado cerrado se sacude al tocarlo
  document.querySelectorAll(".candado").forEach(function (c) {
    c.addEventListener("click", function () {
      c.classList.remove("sacudir");
      void c.offsetWidth; // reinicia la animación
      c.classList.add("sacudir");
    });
    c.addEventListener("animationend", function () { c.classList.remove("sacudir"); });
  });

  // 4. Botones: estado "cargando" al enviar un formulario (no frena el envío)
  document.querySelectorAll("form").forEach(function (f) {
    const boton = f.querySelector("button[type=submit]");
    if (!boton) return;
    f.addEventListener("submit", function () {
      setTimeout(function () { boton.classList.add("cargando"); boton.disabled = true; }, 0);
    });
  });
  window.addEventListener("pageshow", function () {
    document.querySelectorAll("button.cargando").forEach(function (b) {
      b.classList.remove("cargando");
      b.disabled = false;
    });
  });

  // 5. Panel técnico: el texto junto al interruptor cambia con su posición
  const interruptor = document.getElementById("mostrar_detalle");
  const texto = document.getElementById("texto-candado");
  if (interruptor && texto) {
    const actualizar = function () {
      texto.textContent = interruptor.checked
        ? "Detalle visible: el cliente ve el diagnóstico, costo, repuestos y tiempo."
        : "Detalle oculto: el cliente debe presentarse en el local.";
    };
    interruptor.addEventListener("change", actualizar);
    actualizar();
  }
})();
# Sistema de Ventas (Aplicacion de Escritorio)

Proyecto academico para el Taller de Programacion (Semestre II - 2026). Sistema modular de gestion comercial y control de inventario desarrollado en Java Swing con persistencia en MariaDB bajo el patron arquitectonico MVC/DAO.

---

## 1. Stack Tecnologico

- Lenguaje: Java 17 (JDK)
- Interfaz Grafica: Java Swing / NetBeans GUI Builder (Matisse)
- Entorno de Desarrollo: Apache NetBeans IDE (Apache Ant)
- Base de Datos: MariaDB (gestionada localmente con HeidiSQL / DBngin)
- Driver JDBC: mariadb-java-client-3.3.3.jar
- Control de Versiones: Git y GitHub

---

## 2. Arquitectura de Paquetes

El codigo fuente esta organizado dentro del directorio `src/` respetando una separacion estricta de responsabilidades:

- `proyecto.conexion`: Centraliza la clase `ConexionBD.java` para abrir y gestionar la sesion JDBC con MariaDB.
- `proyecto.modelos`: Clases entidad (POJO) que representan las tablas de la base de datos en memoria (atributos privados, constructores y getters/setters).
- `proyecto.dao`: Clases de acceso a datos (Data Access Object) donde se aislaran las consultas SQL mediante PreparedStatement.
- `proyecto.vistas`: Subpaquetes independientes para aislar los archivos `.java` y `.form` de cada integrante:
  - `proyecto.vistas.inventario`: Formularios del Modulo I.
  - `proyecto.vistas.en_vivo`: Formularios del Modulo II.
  - `proyecto.vistas.tienda`: Formularios del Modulo III.
  - `proyecto.vistas.promociones`: Formularios del Modulo IV.

---

## 3. Estado Actual del Proyecto (Semana 1)

En esta primera etapa se completaron los cimientos operativos del sistema:

1. Estructuracion del proyecto en NetBeans con sistema de compilacion Ant.
2. Incorporacion de la libreria `mariadb-java-client-3.3.3.jar` en la carpeta `lib/` y vinculacion a las dependencias del proyecto.
3. Configuracion de `.gitignore` para omitir binarios y configuraciones locales (`build/`, `dist/`, `nbproject/private/`).
4. Implementacion de `ConexionBD.java` con el metodo estatico de conexion contra `127.0.0.1:3306/sistema_ventas`.
5. Creacion de la base de datos base `sistema_ventas` en MariaDB.
6. Construccion de la primera interfaz visual `RecepcionCajasForm.java` en NetBeans Matisse con prueba de conexion exitosa mediante `JOptionPane`.
7. Inicializacion y publicacion del repositorio base en GitHub.

---

## 4. Planificacion y Fases Futuras

El proyecto se dividira en desarrollo individual por modulos y una posterior integracion general:

### Modulo I: Inventario y Logistica
- Recepcion de cajas con registro de remision y control de discrepancias (faltante, danado, sobrante).
- Control secuencial de estados de caja (recibida -> en clasificacion -> clasificada).
- Catalogacion de productos con atributos completos, generacion de codigo unico y soporte de fotografias.
- Motor de Kardex: calculo inmutable del stock disponible mediante registro estricto de entradas, salidas y mermas.
- Alertas de stock minimo configurable por categoria y trazabilidad completa de lotes y proveedores.

### Modulo II: Ventas en Vivo (Live Streaming)
- Programacion de transmisiones validando cruce de horarios de anfitriones.
- Armado de catalogo exclusivo con productos disponibles en inventario.
- Venta rapida en tiempo real con descuento inmediato de existencias.
- Temporizador de apartado de productos por 15 minutos con liberacion automatica de stock.
- Panel dinamico de metricas en curso y resumen de cierre de live.

### Modulo III: Tienda Virtual, Clientes y Despacho
- Carrito de compras con validacion de existencias disponibles.
- Secuencia inmutable de estados de pedido: pendiente -> confirmado -> preparacion -> enviado -> entregado.
- Registro y validacion de comprobantes de pago simulados.
- Clasificacion periodica y automatica de clientes (VIP, frecuente, ocasional).
- Control logistico de 3 modalidades de entrega: recojo en tienda (con carnet de identidad), deposito y puntos de entrega fijos con horarios programados.

### Modulo IV: Promociones y Reporteria
- Motor de promociones con soporte para descuentos porcentuales, montos fijos, combos y ofertas 2x1.
- Administracion de cupones con codigo unico y limites de uso.
- Reglas de resolucion de conflictos entre promociones concurrentes.
- Tablero estadistico de ventas comparativas (Live vs. Tienda Virtual) por dia, semana y mes.
- Generacion de documentos y reportes de productos mas/menos vendidos y clientes top.

### Fase de Integracion y Administracion (Grupal)
- Modulo de administracion con login seguro, gestion de roles, parametros generales y bitacora de auditoria inmutable.
- Menu principal unificado que ensamble todas las pantallas individuales.
- Simulacion masiva de datos: carga de operaciones de los ultimos 2 meses (al menos 3 proveedores, 10 cajas provistas por proveedor y minimo 20 productos por caja, sumando mas de 600 productos reales en la base de datos).

---

## 5. Instrucciones para Ejecutar el Proyecto Localmente

1. Clonar el repositorio:
   `git clone https://github.com/Jh0eL001/sistema-ventas.git`
2. Abrir Apache NetBeans y cargar el proyecto desde `File -> Open Project`.
3. Iniciar el servidor local de MariaDB en el puerto `3306` (usuario `root`, sin contrasena).
4. Crear la base de datos ejecutando en HeidiSQL:
   `CREATE DATABASE IF NOT EXISTS sistema_ventas;`
5. Ejecutar la vista de prueba `RecepcionCajasForm.java` en NetBeans para validar la comunicacion con la base de datos.

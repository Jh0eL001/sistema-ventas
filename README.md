# Sistema de Gestión de Ventas e Inventario

Sistema comercial modular de escritorio desarrollado en Java Swing con persistencia en MariaDB, estructurado bajo el patrón arquitectónico por capas MVC / DAO.

---

## 1. Stack Tecnológico

- **Lenguaje:** Java 17 (JDK)
- **GUI:** Java Swing / NetBeans GUI Builder (Matisse)
- **IDE & Build:** Apache NetBeans (Apache Ant)
- **Base de Datos:** MariaDB (Local, puerto 3306)
- **Driver JDBC:** `mariadb-java-client-3.3.3.jar`
- **Control de Versiones:** Git y GitHub

---

## 2. Arquitectura de Paquetes (`src/`)

- `proyecto.conexion`: Conexión centralizada JDBC mediante `ConexionBD.java`.
- `proyecto.modelos`: Clases de dominio POJO (atributos privados, constructores y getters/setters).
- `proyecto.dao`: Operaciones CRUD aisladas con `PreparedStatement` seguro.
- `proyecto.vistas`: Subpaquetes modulares independientes para evitar colisiones en formularios (`inventario`, `en_vivo`, `tienda`, `promociones`).

---

## 3. Registro de Avance Semanal

### Semana 1: Configuración de Entorno y Conectividad
- Configuración del proyecto base en NetBeans (Java Ant) con exclusiones en `.gitignore`.
- Vinculación del driver `mariadb-java-client-3.3.3.jar` en la carpeta física `lib/`.
- Creación de la base de datos `sistema_ventas` en MariaDB local.
- Implementación de la clase `ConexionBD.java` con método de conexión estático.
- Diseño de maquetas visuales base por módulo en NetBeans Matisse con verificación interactiva de conexión (`JOptionPane`).

### Semana 2: Persistencia Inicial del Módulo de Inventario
- **Base de datos:** Creación de la tabla física `cajas` en MariaDB con clave primaria autoincremental, restricción `UNIQUE` en remisión y estado predeterminado `'recibida'`.
- **Capa Modelo:** Implementación de la entidad `Caja.java` (`proyecto.modelos`) con constructores para instanciación y carga de datos.
- **Capa DAO:** Creación de `CajaDAO.java` (`proyecto.dao`) con sentencias preparadas para inserción (`registrarCaja`) y lectura dinámica (`listarCajas`).
- **Capa Vista:** Actualización de `RecepcionCajasForm.java` (`proyecto.vistas.inventario`) con captura de datos, validación de obligatoriedad, parseo seguro a enteros y renderizado reactivo en un componente `JTable` mediante `DefaultTableModel`.

---

## 4. Hoja de Ruta de Módulos

- **Módulo I (Inventario):** Recepción de cajas, discrepancias físicas, catalogación de productos con fotografía y motor de Kardex.
- **Módulo II (Ventas en Vivo):** Programación de transmisiones, catálogo exclusivo, temporizador de apartado (15 min) y métricas de cierre.
- **Módulo III (Tienda y Despacho):** Carrito de compras, máquina de estados de pedidos y modalidades de entrega (recojo, depósito, punto fijo).
- **Módulo IV (Promociones y Reportes):** Motor de descuentos/cupones y tablero analítico comparativo (Live vs. Tienda).
- **Fase Grupal:** Menú principal unificado, control de accesos/roles y simulación de 600+ productos reales.

---

## 5. Instrucciones de Ejecución

1. Clonar el repositorio:
   ```bash
   git clone [https://github.com/Jh0eL001/sistema-ventas.git](https://github.com/Jh0eL001/sistema-ventas.git)
# myecommerce

Esta aplicación, desarrollada en Java 17 con Spring Boot 2.7.9, proporciona un servicio REST para consultar precios. Utiliza una base de datos H2 y acepta parámetros como fecha de aplicación, identificador de producto y cadena. Devuelve información detallada, incluyendo identificadores, fechas de aplicación y precios finales.

## Configuración del Proyecto

Los Requisitos Previos Son:
- Java JDK 17
- Gradle 8.4

# Endpoints REST

## Consulta de precios por id de cadena (brandId), id de producto (productId), y fecha de aplicacion (date)

URL http://localhost:8080

GET /api/prices

Parámetros de Entrada
- date (fecha de aplicación)
- productId (identificador de producto)
- brandId (identificador de cadena)
  
curl -X GET "http://localhost:8080/api/prices?brandId={BRAND_ID}&productId={PRODUCT_ID}&date={DATE}"

Datos de Salida
- PRODUCT_ID (identificador de producto)
- BRAND_ID (identificador de cadena)
- ID (tarifa a aplicar)
- START_DATE (fecha de inicio de aplicación)
- END_DATE (fecha de fin de aplicación)
- PRICE (precio final a aplicar)
- CURRENCY (moneda)
- PRIORITY (prioridad)
- LAST_UPDATE (Ultima actualizacion)
- LAST_UPDATE_BY (Usuario que realizo la ultima actualizacion)

## Consulta todos los precios

URL http://localhost:8080

GET /api/prices/all

curl -X GET "http://localhost:8080/api/prices/all"

Datos de Salida: Lista de precios, cada precio contiene los siguientes datos
- PRODUCT_ID (identificador de producto)
- BRAND_ID (identificador de cadena)
- ID (tarifa a aplicar)
- START_DATE (fecha de inicio de aplicación)
- END_DATE (fecha de fin de aplicación)
- PRICE (precio final a aplicar)
- CURRENCY (moneda)
- PRIORITY (prioridad)
- LAST_UPDATE (Ultima actualizacion)
- LAST_UPDATE_BY (Usuario que realizo la ultima actualizacion)

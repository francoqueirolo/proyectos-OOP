# Poyectos OOP

### Comandos Docker📋

```
docker-compose up -d
```

### Levatar BD 🔧

Comando docker para abrir psql:

```
psql -U devandre -d postgres
```

Crear base de datos

```
CREATE DATABASE dvdrental;
```

Comando para restaurar la base de datos:_

```
pg_restore -U devandre -d dvdrental /tmp/dvdrental.tar
```

from sys import stdin

# Leer todas las líneas de entrada estándar y almacenarlas en una lista
mensajes = [mensaje.strip() for mensaje in stdin]

# Imprimir cada mensaje con su índice
for index, mensaje in enumerate(mensajes):
    print(f'{index}. {mensaje}', end="")
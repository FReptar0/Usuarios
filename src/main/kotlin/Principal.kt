fun buscar(id: Int, listaUsuarios: MutableList<Usuarios>): Int {
    var rs = 0
    for (i in 0..listaUsuarios.size) {
        if (listaUsuarios[i].idUser == id) {
            rs = id
        } else {
            rs = -1
        }
    }
    return rs
}

fun main(args: Array<String>) {
    var listaUsuarios = mutableListOf<Usuarios>()
    var opc: Int = 0

    while (opc != 6) {
        println("1.- Iniciar sesion")
        println("2.- Registrarse")
        println("3.- Actualizar datos")
        println("4.- Eliminar")
        println("5.- Obtener usuario")
        println("6.- Salir")
        print("Opcion: ")
        opc = readLine()!!.toInt()

        when (opc) {
            1 -> {
                println("Iniciar sesion")
                print("Nombre de usuario: ")
                var user = readLine()!!.toString()
                print("Contraseña: ")
                var pass = readLine()!!.toString()

                for (i in 0..listaUsuarios.size) {
                    if (listaUsuarios[i].userName == user && listaUsuarios[i].password == pass) {
                        println("Bienvenido")
                    } else {
                        println("Usuario o contraseña incorrectos")
                    }
                }
            }
            2 -> {
                println("Registrarse")
                println("Ingrese:\nNombre de usuario: \nContraseña: \nNombre completo: \nFecha de nacimiento(DD/MM/AAAA):")
                var usuario = Usuarios(
                    listaUsuarios.size,
                    readLine()!!.toString(),
                    readLine()!!.toString(),
                    readLine()!!.toString(),
                    readLine()!!.toString()
                )
                listaUsuarios.add(usuario)
            }
            3 -> {
                println("Actualizar datos")
                println("Ingrese el ID del usuario a actualizar: ")
                var id = readLine()!!.toInt()
                var rs : Int = buscar(id, listaUsuarios)
                if (rs != -1) {
                    println("Ingrese los nuevos datos: \nNombre de usuario: \nContraseña: \nNombre completo: \nFecha de nacimiento(DD/MM/AAAA):")
                    var usuario = Usuarios(
                        id,
                        readLine()!!.toString(),
                        readLine()!!.toString(),
                        readLine()!!.toString(),
                        readLine()!!.toString()
                    )
                    listaUsuarios[id] = usuario
                } else {
                    println("ID no encontrado")
                }
            }
            4 -> {
                println("Eliminar")
                println("Ingrese el ID del usuario a eliminar: ")
                var id = readLine()!!.toInt()
                var rs : Int = buscar(id, listaUsuarios)
                if (rs != -1) {
                    listaUsuarios.removeAt(id)
                } else {
                    println("ID no encontrado")
                }
            }
            5 -> {
                println("Mostrar")
                println("Ingrese el ID del usuario a mostrar: ")
                var id = readLine()!!.toInt()
                var rs : Int = buscar(id, listaUsuarios)
                if (rs != -1) {
                    println("Nombre de usuario: ${listaUsuarios[id].userName}\n Contraseña: ${listaUsuarios[id].password}\n Nombre completo: ${listaUsuarios[id].fullName}\n Fecha de nacimiento: ${listaUsuarios[id].birthDay}")
                } else {
                    println("ID no encontrado")
                }
            }
            6 -> {
                println("Saliendo...")
            }
            else -> {
                println("Opcion no valida")
            }
        }
    }
}
